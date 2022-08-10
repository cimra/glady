package com.glady.service;

import com.glady.entity.Cheque;
import com.glady.entity.Gift;
import com.glady.entity.Meal;
import com.glady.entity.User;

import java.time.LocalDate;
import java.util.List;

public class UserActions {

    final ControlCheque service = new ControlCheque();

    public double getCurrentGiftBalance(final User user, final LocalDate controlDate) {
        updateGiftsValidityOfUser(user, controlDate);
        List<Gift> validGifts = user.getGifts().stream()
                .filter(Cheque::isValid)
                .filter(gift -> gift.getReceptionDate().isBefore(controlDate)).toList();
        return sumValidGiftAmounts(validGifts);
    }

    public double getCurrentMealBalance(final User user, final LocalDate controlDate) {
        updateMealsValidityOfUser(user, controlDate);
        List<Meal> validMeals = user.getMeals().stream()
                .filter(Cheque::isValid)
                .filter(meal -> meal.getReceptionDate().isBefore(controlDate)).toList();
        return sumValidMealAmounts(validMeals);
    }

    private double sumValidGiftAmounts(List<Gift> validGifts) {
        return validGifts.stream().mapToDouble(Cheque::getAmount).sum();
    }

    private double sumValidMealAmounts(List<Meal> validMeals) {
        return validMeals.stream().mapToDouble(Cheque::getAmount).sum();
    }

    private void updateGiftsValidityOfUser(User user, LocalDate controlDate) {
        for(Gift gift : user.getGifts()) service.updateChequeValidity(gift, controlDate);
    }

    private void updateMealsValidityOfUser(User user, LocalDate controlDate) {
        for(Meal meal : user.getMeals()) service.updateChequeValidity(meal, controlDate);
    }
}
