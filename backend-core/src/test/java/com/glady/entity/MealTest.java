package com.glady.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTest {

    @Test
    void meal_is_valid_when_received_now() {
        //given
        LocalDate now = LocalDate.now();
        Meal meal = new Meal(100, now);
        //then
        assertThat(meal.isValid()).isTrue();
    }

    @Test
    void meal_expiration_date_is_28th_when_non_leap_year_following_the_reception_date() {
        //given
        LocalDate receptionDate = LocalDate.of(2022, 8, 10);
        Meal meal = new Meal(100, receptionDate);

        //when
        LocalDate expectedExpirationDate = LocalDate.of(2023,2,28);

        //then
        assertThat(meal.getExpirationDate().equals(expectedExpirationDate)).isTrue();
    }

    @Test
    void meal_expiration_date_is_29th_when_leap_year_following_the_reception_date() {
        //given
        LocalDate receptionDate = LocalDate.of(2023, 8, 10);
        Meal meal = new Meal(100, receptionDate);

        //when
        LocalDate expectedExpirationDate = LocalDate.of(2024,2,29);

        //then
        assertThat(meal.getExpirationDate().equals(expectedExpirationDate)).isTrue();
    }
}
