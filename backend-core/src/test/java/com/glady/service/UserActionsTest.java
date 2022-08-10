package com.glady.service;

import com.glady.entity.Gift;
import com.glady.entity.Meal;
import com.glady.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class UserActionsTest {

    @Test
    void get_current_gift_balance_is_equal_to_0_when_no_gift() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final LocalDate controlDate = LocalDate.of(2022, 12, 10);

        //when
        final double giftBalance = service.getCurrentGiftBalance(user, controlDate);
        final double expectedGiftBalance = 0;

        //then
        assertThat(giftBalance).isEqualTo(expectedGiftBalance);
    }

    @Test
    void get_current_gift_balance_is_equal_to_0_when_no_gift_received_yet() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final Gift first_gift = new Gift(100, LocalDate.of(2023, 1, 10));
        user.receiveNewGift(first_gift);
        final LocalDate controlDate = LocalDate.of(2022, 12, 10);

        //when
        final double giftBalance = service.getCurrentGiftBalance(user, controlDate);
        final double expectedGiftBalance = 0;

        //then
        assertThat(giftBalance).isEqualTo(expectedGiftBalance);
    }

    @Test
    void get_current_gift_balance_when_none_of_the_gifts_have_expired() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final Gift first_gift = new Gift(100, LocalDate.of(2022, 8, 10));
        final Gift second_gift = new Gift(100, LocalDate.of(2023, 1, 10));
        user.receiveNewGift(first_gift);
        user.receiveNewGift(second_gift);
        final LocalDate controlDate = LocalDate.of(2023, 7, 10);

        //when
        final double giftBalance = service.getCurrentGiftBalance(user, controlDate);
        final double expectedGiftBalance = 200;

        //then
        assertThat(giftBalance).isEqualTo(expectedGiftBalance);
    }

    @Test
    void get_current_gift_balance_when_one_of_the_gifts_have_expired() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final Gift first_gift = new Gift(100, LocalDate.of(2022, 8, 10));
        final Gift second_gift = new Gift(100, LocalDate.of(2023, 6, 10));
        user.receiveNewGift(first_gift);
        user.receiveNewGift(second_gift);
        final LocalDate controlDate = LocalDate.of(2023, 8, 12);

        //when
        final double giftBalance = service.getCurrentGiftBalance(user, controlDate);
        final double expectedGiftBalance = 100;

        //then
        assertThat(giftBalance).isEqualTo(expectedGiftBalance);
    }

    @Test
    void get_current_meal_balance_is_equal_to_0_when_no_meal() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final LocalDate controlDate = LocalDate.of(2022, 12, 10);

        //when
        final double mealBalance = service.getCurrentMealBalance(user, controlDate);
        final double expectedMealBalance = 0;

        //then
        assertThat(mealBalance).isEqualTo(expectedMealBalance);
    }

    @Test
    void get_current_meal_balance_is_equal_to_0_when_no_meal_received_yet() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final Meal first_meal = new Meal(100, LocalDate.of(2023, 1, 10));
        user.receiveNewMeal(first_meal);
        final LocalDate controlDate = LocalDate.of(2022, 12, 10);

        //when
        final double mealBalance = service.getCurrentMealBalance(user, controlDate);
        final double expectedMealBalance = 0;

        //then
        assertThat(mealBalance).isEqualTo(expectedMealBalance);
    }

    @Test
    void get_current_meal_balance_when_none_of_the_meals_have_expired() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final Meal first_meal = new Meal(100, LocalDate.of(2022, 8, 10));
        final Meal second_meal = new Meal(100, LocalDate.of(2023, 1, 10));
        user.receiveNewMeal(first_meal);
        user.receiveNewMeal(second_meal);
        final LocalDate controlDate = LocalDate.of(2023, 2, 28);

        //when
        final double mealBalance = service.getCurrentMealBalance(user, controlDate);
        final double expectedMealBalance = 200;

        //then
        assertThat(mealBalance).isEqualTo(expectedMealBalance);
    }

    @Test
    void get_current_meal_balance_when_one_of_the_meals_have_expired() {
        //given
        final User user = new User();
        final UserActions service = new UserActions();
        final Meal first_meal = new Meal(100, LocalDate.of(2022, 8, 10));
        final Meal second_meal = new Meal(100, LocalDate.of(2023, 6, 10));
        user.receiveNewMeal(first_meal);
        user.receiveNewMeal(second_meal);
        final LocalDate controlDate = LocalDate.of(2023, 8, 12);

        //when
        final double mealBalance = service.getCurrentMealBalance(user, controlDate);
        final double expectedMealBalance = 100;

        //then
        assertThat(mealBalance).isEqualTo(expectedMealBalance);
    }
}
