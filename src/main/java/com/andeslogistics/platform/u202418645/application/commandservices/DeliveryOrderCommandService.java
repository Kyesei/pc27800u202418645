package com.andeslogistics.platform.u202418645.application.commandservices;

import com.andeslogistics.platform.u202418645.logistics.application.commands.CreateDeliveryOrderCommand;
import com.andeslogistics.platform.u202418645.logistics.domain.model.aggregates.DeliveryOrder;
import com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects.*;
import com.andeslogistics.platform.u202418645.logistics.domain.repositories.DeliveryOrderRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveryOrderCommandService {

    private final DeliveryOrderRepository repository;

    public DeliveryOrderCommandService(DeliveryOrderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public DeliveryOrder create(CreateDeliveryOrderCommand command) {
        if (repository.existsByDeliveryCode(command.deliveryCode())) {
            throw new DuplicateKeyException("Delivery code already exists");
        }

        DeliveryOrder order = DeliveryOrder.create(
            new DeliveryCode(command.deliveryCode()),
            new WarehouseId(command.warehouseId()),
            new DeliveryWindow(
                command.deliveryWindowStartDate(),
                command.deliveryWindowEndDate()
            ),
            new PackageLoad(
                command.packageLoadQuantity(),
                command.packageLoadUnit()
            ),
            command.priorityLevel(),
            command.status(),
            command.deliveryNotes()
        );

        return repository.save(order);
    }
}