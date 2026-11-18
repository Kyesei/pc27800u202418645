package com.andeslogistics.platform.u202418645.interfaces.rest;

import com.andeslogistics.platform.u202418645.logistics.application.commands.CreateDeliveryOrderCommand;
import com.andeslogistics.platform.u202418645.logistics.application.commandservices.DeliveryOrderCommandService;
import com.andeslogistics.platform.u202418645.logistics.interfaces.rest.resources.*;
import com.andeslogistics.platform.u202418645.logistics.interfaces.rest.transform.DeliveryOrderResourceAssembler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/delivery-orders")
public class DeliveryOrdersController {

    private final DeliveryOrderCommandService service;

    public DeliveryOrdersController(DeliveryOrderCommandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeliveryOrderResource> create(
            @Valid @RequestBody CreateDeliveryOrderResource resource) {

        var command = new CreateDeliveryOrderCommand(
            resource.deliveryCode(),
            resource.warehouseId(),
            resource.deliveryWindowStartDate(),
            resource.deliveryWindowEndDate(),
            resource.packageLoadQuantity(),
            resource.packageLoadUnit(),
            resource.priorityLevel(),
            resource.status(),
            resource.deliveryNotes()
        );

        var result = service.create(command);

        return ResponseEntity
            .created(URI.create("/api/v1/delivery-orders/" + result.getId()))
            .body(DeliveryOrderResourceAssembler.toResource(result));
    }
}