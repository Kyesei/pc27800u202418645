package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

/**
 * Represents the quantity and unit of a delivery load.
 *
 * @param quantity package quantity
 * @param unit package unit
 * @author Kelber Yamir Sandoval Aiquipa
 */
public record PackageLoad(Integer quantity, String unit) {
    public PackageLoad {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Package quantity must be positive");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Package unit is required");
        }
        unit = unit.trim();
    }

    /**
     * Returns a new load with the specified quantity added.
     *
     * @param amount quantity to add
     * @return a new PackageLoad
     */
    public PackageLoad increaseBy(Integer amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Increase amount must be positive");
        }

        final int newQuantity;
        try {
            newQuantity = Math.addExact(quantity, amount);
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("Package quantity overflow", exception);
        }

        return new PackageLoad(newQuantity, unit);
    }
}