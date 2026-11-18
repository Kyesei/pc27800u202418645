package com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates;

import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.DeliveryCode;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.DeliveryWindow;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.PackageLoad;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.WarehouseId;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.DeliveryStatus;

public class DeliveryOrder {
    private Long id;
    private DeliveryCode deliveryCode;
    private WarehouseId warehouseId;
    private DeliveryWindow deliveryWindow;
    private PackageLoad packageLoad;
    private Integer priorityLevel;
    private DeliveryStatus status;
    private String deliveryNotes;

    public DeliveryOrder(Long id, DeliveryCode deliveryCode, WarehouseId warehouseId, DeliveryWindow deliveryWindow, PackageLoad packageLoad, Integer priorityLevel, DeliveryStatus status, String deliveryNotes) {
        this.id = id;
        this.deliveryCode = deliveryCode;
        this.warehouseId = warehouseId;
        this.deliveryWindow = deliveryWindow;
        this.packageLoad = packageLoad;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.deliveryNotes = deliveryNotes;
    }

    public DeliveryCode getDeliveryCode() {
        return deliveryCode;
    }

    public Long getId() {
        return id;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public DeliveryWindow getDeliveryWindow() {
        return deliveryWindow;
    }

    public PackageLoad getPackageLoad() {
        return packageLoad;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public DeliveryStatus getStatus() {
        return status;
    }
}