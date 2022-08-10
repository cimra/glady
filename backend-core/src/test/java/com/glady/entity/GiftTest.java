package com.glady.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftTest {

    @Test
    void gift_is_valid_when_received_now() {
        //given
        LocalDate now = LocalDate.now();
        Gift gift = new Gift(100, now);
        //then
        assertThat(gift.isValid()).isTrue();
    }
}
