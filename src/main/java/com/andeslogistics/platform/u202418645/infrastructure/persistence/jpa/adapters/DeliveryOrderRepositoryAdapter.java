package com.andeslogistics.platform.u202418645.infrastructure.persistence.jpa.adapters;

import com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates.DeliveryOrder;
import com.andeslogistics.platform.u202418645.logistics.domain.repositories.DeliveryOrderRepository;
import com.andeslogistics.platform.u202418645.logistics.infrastructure.persistence.jpa.entities.DeliveryOrderEntity;
import com.andeslogistics.platform.u202418645.logistics.infrastructure.persistence.jpa.repositories.DeliveryOrderJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DeliveryOrderRepositoryAdapter implements DeliveryOrderRepository {

    private final DeliveryOrderJpaRepository repository;

    public DeliveryOrderRepositoryAdapter(DeliveryOrderJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByDeliveryCode(String deliveryCode) {
        return repository.existsByDeliveryCode(deliveryCode);
    }

    @Override
    public DeliveryOrder save(DeliveryOrder deliveryOrder) {
        DeliveryOrderEntity entity = new DeliveryOrderEntity(deliveryOrder);
        return repository.saveAndFlush(entity).toDomain();
    }
}