package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

import java.time.LocalDate;

/**
 * Represents the allowed date range for a delivery.
 *
 * @param startDate delivery start date
 * @param endDate delivery end date
 * @author Kelber Yamir Sandoval Aiquipa
 */
public record DeliveryWindow(LocalDate startDate, LocalDate endDate) {
    public DeliveryWindow {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Delivery dates are required");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }

    /**
     * Checks whether a date belongs to this delivery window, including both boundaries.
     *
     * @param date date to check
     * @return true when the date is within the window
     */
    public boolean includes(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date is required");
        }
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}