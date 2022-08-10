package com.glady.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
abstract public class Cheque {

    private final double amount;
    private final LocalDate receptionDate;
    private boolean isValid = true;

    public Cheque (final double amount, final LocalDate receptionDate) {
        this.amount = amount;
        this.receptionDate = receptionDate;
    }
}
