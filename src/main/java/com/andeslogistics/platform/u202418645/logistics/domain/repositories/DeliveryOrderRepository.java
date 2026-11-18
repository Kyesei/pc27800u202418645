package com.andeslogistics.platform.u202418645.logistics.domain.repositories;

import com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates.DeliveryOrder;

/**
 * Domain repository contract for delivery orders.
 *
 * @author Kelber Yamir Sandoval Aiquipa
 */
public interface DeliveryOrderRepository {
    boolean existsByDeliveryCode(String deliveryCode);
    DeliveryOrder save(DeliveryOrder deliveryOrder);
}