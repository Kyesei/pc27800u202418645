package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

public record DeliveryCode(String deliveryCode) {
    public DeliveryCode {
        if(deliveryCode == null || deliveryCode.isBlank()) {
            throw new IllegalArgumentException("DeliveryCode must not be null or blank");
        }
    }
}