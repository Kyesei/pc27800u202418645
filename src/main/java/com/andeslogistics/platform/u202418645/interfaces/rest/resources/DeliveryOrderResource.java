package com.andeslogistics.platform.u202418645.interfaces.rest.resources;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record DeliveryOrderResource(
    Long id,
    String deliveryCode,
    UUID warehouseId,
    LocalDate deliveryWindowStartDate,
    LocalDate deliveryWindowEndDate,
    Integer packageLoadQuantity,
    String packageLoadUnit,
    Integer priorityLevel,
    String status,
    String deliveryNotes,
    Instant createdAt,
    Instant updatedAt
) {}