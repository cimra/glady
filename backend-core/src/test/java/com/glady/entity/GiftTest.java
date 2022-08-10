package com.glady.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftTest {

    @Test
    void gift_is_valid_when_received_now() {
        //given
        final LocalDate now = LocalDate.now();
        final Gift gift = new Gift(100, now);
        //then
        assertThat(gift.isValid()).isTrue();
    }

    @Test
    void gift_expiration_date_is_364_days_after_reception_date() {
        //given
        final LocalDate receptionDate = LocalDate.of(2022, 8, 10);
        final Gift gift = new Gift(100, receptionDate);

        //when
        final LocalDate receptionDatePlus364Days = receptionDate.plusDays(364);
        final LocalDate expectedExpirationDate = LocalDate.of(2023, 8, 9);

        //then
        assertThat(receptionDatePlus364Days.equals(expectedExpirationDate)).isTrue();
        assertThat(gift.getExpirationDate().equals(expectedExpirationDate)).isTrue();
    }
}
