package com.glady.entity;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class User {

    final private ArrayList<Gift> gifts = new ArrayList<>();
    final private ArrayList<Meal> meals = new ArrayList<>();

    public void receiveNewGift(final Gift gift) {
        gifts.add(gift);
    }

    public void receiveNewMeal(final Meal meal) {
        meals.add(meal);
    }
}
