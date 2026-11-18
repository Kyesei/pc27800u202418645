package com.andeslogistics.platform.u202418645.infrastructure.persistence.jpa.entities;

import com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates.DeliveryOrder;
import com.andeslogistics.platform.u202418645.logistics.domain.model.enums.DeliveryStatus;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.*;
import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "delivery_orders",
       uniqueConstraints = @UniqueConstraint(
           name = "uk_delivery_order_code", columnNames = "delivery_code"))
public class DeliveryOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_code", nullable = false, unique = true, length = 100)
    private String deliveryCode;

    @Column(name = "warehouse_id", nullable = false, length = 36)
    private String warehouseId;

    @Column(name = "delivery_window_start_date", nullable = false)
    private LocalDate deliveryWindowStartDate;

    @Column(name = "delivery_window_end_date", nullable = false)
    private LocalDate deliveryWindowEndDate;

    @Column(name = "package_load_quantity", nullable = false)
    private Integer packageLoadQuantity;

    @Column(name = "package_load_unit", nullable = false)
    private String packageLoadUnit;

    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @Column(name = "delivery_notes", length = 1000)
    private String deliveryNotes;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected DeliveryOrderEntity() {}

    public DeliveryOrderEntity(DeliveryOrder order) {
        deliveryCode = order.getDeliveryCode().code();
        warehouseId = order.getWarehouseId().value().toString();
        deliveryWindowStartDate = order.getDeliveryWindow().startDate();
        deliveryWindowEndDate = order.getDeliveryWindow().endDate();
        packageLoadQuantity = order.getPackageLoad().quantity();
        packageLoadUnit = order.getPackageLoad().unit();
        priorityLevel = order.getPriorityLevel();
        status = order.getStatus();
        deliveryNotes = order.getDeliveryNotes();
    }

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    public DeliveryOrder toDomain() {
        return DeliveryOrder.restore(
            id,
            new DeliveryCode(deliveryCode),
            new WarehouseId(UUID.fromString(warehouseId)),
            new DeliveryWindow(deliveryWindowStartDate, deliveryWindowEndDate),
            new PackageLoad(packageLoadQuantity, packageLoadUnit),
            priorityLevel, status, deliveryNotes, createdAt, updatedAt
        );
    }
}