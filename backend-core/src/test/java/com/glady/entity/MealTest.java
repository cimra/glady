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
}
