package com.glady.entity;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Meal extends Cheque {

    public Meal(final double amount, final LocalDate receptionDate) {
        super(amount,receptionDate);
        calculateExpirationDate();
    }

    private void calculateExpirationDate() {
        int currentYear = super.getReceptionDate().getYear();
        LocalDate lastDayOfNextFebruary;
        lastDayOfNextFebruary = LocalDate.of(currentYear + 1, 2, 1).with(TemporalAdjusters.lastDayOfMonth());
        super.expirationDate = lastDayOfNextFebruary;
    }
}
