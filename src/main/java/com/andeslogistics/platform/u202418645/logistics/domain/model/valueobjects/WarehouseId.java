package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

import java.util.UUID;

/**
 * Represents the identifier of a warehouse.
 *
 * @param value warehouse UUID
 * @author Kelber Yamir Sandoval Aiquipa
 */
public record WarehouseId(UUID value) {
    public WarehouseId {
        if (value == null) {
            throw new IllegalArgumentException("Warehouse ID is required");
        }
    }
}