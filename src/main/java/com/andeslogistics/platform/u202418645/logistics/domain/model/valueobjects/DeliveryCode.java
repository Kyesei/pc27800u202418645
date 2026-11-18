package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

/**
 * Represents a unique delivery code.
 *
 * @param code the delivery code
 * @author Kelber Yamir Sandoval Aiquipa
 */
public record DeliveryCode(String code) {
    public DeliveryCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Delivery code is required");
        }
        code = code.trim();
    }
}