package com.glady.entity;

import java.time.LocalDate;

public class Gift extends Cheque {

    public Gift(final double amount, final LocalDate receptionDate) {
        super(amount,receptionDate);
        calculateExpirationDate();
    }

    @Override
    void calculateExpirationDate() {
        super.expirationDate = super.getReceptionDate().plusDays(364);
    }
}
