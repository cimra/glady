package com.glady.service;

import com.glady.entity.Cheque;

import java.time.LocalDate;

public class ControlCheques {

    public void updateChequeValidity(final Cheque cheque, final LocalDate controlDate) {
        if(controlDate.isAfter(cheque.getExpirationDate())) {
            cheque.setValid(false);
        }
    }
}
