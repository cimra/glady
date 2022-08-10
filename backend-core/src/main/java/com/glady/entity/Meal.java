package com.glady.entity;

import java.time.LocalDate;

public class Meal extends Cheque {

    public Meal(final double amount, final LocalDate receptionDate) {
        super(amount,receptionDate);
    }
}
