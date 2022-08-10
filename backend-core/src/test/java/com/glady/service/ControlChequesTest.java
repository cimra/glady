package com.glady.service;

import com.glady.entity.Gift;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlChequesTest {

    @Test
    void gift_becomes_invalid_after_expiration_date() {
        //given
        ControlCheques service = new ControlCheques();
        Gift gift = new Gift(100, LocalDate.of(2022, 8, 10));

        //when
        LocalDate dateAfterExpirationDate = LocalDate.of(2024, 8, 10);
        service.updateChequeValidity(gift, dateAfterExpirationDate);

        //then
        assertThat(gift.isValid()).isFalse();
    }

    @Test
    void gift_is_still_valid_before_expiration_date() {
        //given
        ControlCheques service = new ControlCheques();
        Gift gift = new Gift(100, LocalDate.of(2022, 8, 10));

        //when
        LocalDate dateBeforeExpirationDate = LocalDate.of(2023, 6, 10);
        service.updateChequeValidity(gift, dateBeforeExpirationDate);

        //then
        assertThat(gift.isValid()).isTrue();
    }

    @Test
    void gift_is_still_valid_the_day_of_the_expiration_date() {
        //given
        ControlCheques service = new ControlCheques();
        Gift gift = new Gift(100, LocalDate.of(2022, 8, 10));

        //when
        LocalDate expirationDate = LocalDate.of(2023, 8, 9);
        service.updateChequeValidity(gift, expirationDate);

        //then
        assertThat(gift.isValid()).isTrue();
    }
}
