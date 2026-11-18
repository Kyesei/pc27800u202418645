package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

public record DeliveryWindow(String deliveryWindow) {

    public DeliveryWindow {
        if (deliveryWindow == null || deliveryWindow.isBlank()) {
            throw new IllegalArgumentException("DeliveryWindow cannot be null");
        }
    }
}