package com.glady.entity;

import java.time.LocalDate;

public class Gift extends Cheque {

    public Gift(final double amount, final LocalDate receptionDate) {
        super(amount,receptionDate);
    }
}
