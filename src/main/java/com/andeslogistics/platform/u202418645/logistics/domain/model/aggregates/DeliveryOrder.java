package com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates;

import com.andeslogistics.platform.u202418645.logistics.domain.model.enums.DeliveryStatus;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.DeliveryCode;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.DeliveryWindow;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.PackageLoad;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.WarehouseId;
import com.andeslogistics.platform.u202418645.shared.domain.model.aggregates.AbstractDomainAggregateRoot;

import java.time.Instant;

/**
 * Aggregate root representing a delivery order.
 *
 * @author Kelber Yamir Sandoval Aiquipa
 */
public final class DeliveryOrder extends AbstractDomainAggregateRoot<DeliveryOrder> {
    private final Long id;
    private final DeliveryCode deliveryCode;
    private final WarehouseId warehouseId;
    private final DeliveryWindow deliveryWindow;
    private final PackageLoad packageLoad;
    private final Integer priorityLevel;
    private final DeliveryStatus status;
    private final String deliveryNotes;
    private final Instant createdAt;
    private final Instant updatedAt;

    private DeliveryOrder(
            Long id,
            DeliveryCode deliveryCode,
            WarehouseId warehouseId,
            DeliveryWindow deliveryWindow,
            PackageLoad packageLoad,
            Integer priorityLevel,
            DeliveryStatus status,
            String deliveryNotes,
            Instant createdAt,
            Instant updatedAt) {

        this.id = id;
        this.deliveryCode = deliveryCode;
        this.warehouseId = warehouseId;
        this.deliveryWindow = deliveryWindow;
        this.packageLoad = packageLoad;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.deliveryNotes = deliveryNotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Creates a new delivery order.
     */
    public static DeliveryOrder create(
            DeliveryCode deliveryCode,
            WarehouseId warehouseId,
            DeliveryWindow deliveryWindow,
            PackageLoad packageLoad,
            Integer priorityLevel,
            DeliveryStatus status,
            String deliveryNotes) {

        if (deliveryCode == null || warehouseId == null ||
                deliveryWindow == null || packageLoad == null) {
            throw new IllegalArgumentException("Delivery order fields are required");
        }
        if (priorityLevel == null || priorityLevel < 1 || priorityLevel > 5) {
            throw new IllegalArgumentException("Priority level must be between 1 and 5");
        }

        return new DeliveryOrder(
                null, deliveryCode, warehouseId, deliveryWindow, packageLoad,
                priorityLevel, status == null ? DeliveryStatus.PENDING : status,
                deliveryNotes, null, null);
    }

    /**
     * Reconstitutes a delivery order from persistence.
     */
    public static DeliveryOrder restore(
            Long id,
            DeliveryCode deliveryCode,
            WarehouseId warehouseId,
            DeliveryWindow deliveryWindow,
            PackageLoad packageLoad,
            Integer priorityLevel,
            DeliveryStatus status,
            String deliveryNotes,
            Instant createdAt,
            Instant updatedAt) {

        return new DeliveryOrder(
                id, deliveryCode, warehouseId, deliveryWindow, packageLoad,
                priorityLevel, status, deliveryNotes, createdAt, updatedAt);
    }

    public Long getId() { return id; }
    public DeliveryCode getDeliveryCode() { return deliveryCode; }
    public WarehouseId getWarehouseId() { return warehouseId; }
    public DeliveryWindow getDeliveryWindow() { return deliveryWindow; }
    public PackageLoad getPackageLoad() { return packageLoad; }
    public Integer getPriorityLevel() { return priorityLevel; }
    public DeliveryStatus getStatus() { return status; }
    public String getDeliveryNotes() { return deliveryNotes; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}