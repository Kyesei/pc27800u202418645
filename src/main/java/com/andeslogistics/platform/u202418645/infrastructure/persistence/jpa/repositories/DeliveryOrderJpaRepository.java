package com.andeslogistics.platform.u202418645.infrastructure.persistence.jpa.repositories;

import com.andeslogistics.platform.u202418645.logistics.infrastructure.persistence.jpa.entities.DeliveryOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderJpaRepository extends JpaRepository<DeliveryOrderEntity, Long> {
    boolean existsByDeliveryCode(String deliveryCode);
}