package com.shashi.utility;

import javax.servlet.http.HttpServletRequest;

public class BookingValidator {

    public static void validateRequest(HttpServletRequest req) throws IllegalArgumentException {
        Object trainNumber = req.getAttribute("trainnumber");
        Object seats = req.getAttribute("seats");
        Object journeyDate = req.getAttribute("journeydate");
        Object seatClass = req.getAttribute("class");

        if (trainNumber == null || !(trainNumber instanceof String) || ((String) trainNumber).isEmpty()) {
            throw new IllegalArgumentException("Train number is required.");
        }

        if (seats == null || !(seats instanceof Integer) || (int) seats <= 0) {
            throw new IllegalArgumentException("Valid seat count is required.");
        }

        if (journeyDate == null || !(journeyDate instanceof String) || ((String) journeyDate).isEmpty()) {
            throw new IllegalArgumentException("Journey date is required.");
        }

        if (seatClass == null || !(seatClass instanceof String) || ((String) seatClass).isEmpty()) {
            throw new IllegalArgumentException("Seat class is required.");
        }
    }
}

