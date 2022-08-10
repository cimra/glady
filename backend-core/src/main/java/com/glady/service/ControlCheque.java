package com.glady.service;

import com.glady.entity.Cheque;

import java.time.LocalDate;

public class ControlCheque {

    public void updateChequeValidity(final Cheque cheque, final LocalDate controlDate) {
        if(controlDate.isAfter(cheque.getExpirationDate())) {
            cheque.setValid(false);
        }
    }
}
