package com.codewithmosh.abstractFactory;

public class WeightLossPlan implements Plan {

    @Override
    public void workoutPlan() {
        System.out.println("Workout plan: weight loss");
    }

    @Override
    public void mealPlan() {
        System.out.println("Meal plan: weight loss");
    }
}
