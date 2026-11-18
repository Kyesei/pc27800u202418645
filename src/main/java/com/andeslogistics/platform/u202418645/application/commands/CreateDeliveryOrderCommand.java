package com.andeslogistics.platform.u202418645.application.commands;

import com.andeslogistics.platform.u202418645.logistics.domain.model.enums.DeliveryStatus;
import java.time.LocalDate;
import java.util.UUID;

public record CreateDeliveryOrderCommand(
    String deliveryCode,
    UUID warehouseId,
    LocalDate deliveryWindowStartDate,
    LocalDate deliveryWindowEndDate,
    Integer packageLoadQuantity,
    String packageLoadUnit,
    Integer priorityLevel,
    DeliveryStatus status,
    String deliveryNotes
) {}