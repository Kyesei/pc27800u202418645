package com.andeslogistics.platform.u202418645.interfaces.rest.transform;

import com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates.DeliveryOrder;
import com.andeslogistics.platform.u202418645.logistics.interfaces.rest.resources.DeliveryOrderResource;

public final class DeliveryOrderResourceAssembler {

    private DeliveryOrderResourceAssembler() {}

    public static DeliveryOrderResource toResource(DeliveryOrder order) {
        return new DeliveryOrderResource(
            order.getId(),
            order.getDeliveryCode().code(),
            order.getWarehouseId().value(),
            order.getDeliveryWindow().startDate(),
            order.getDeliveryWindow().endDate(),
            order.getPackageLoad().quantity(),
            order.getPackageLoad().unit(),
            order.getPriorityLevel(),
            order.getStatus().name(),
            order.getDeliveryNotes(),
            order.getCreatedAt(),
            order.getUpdatedAt()
        );
    }
}