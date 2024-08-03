package com.codewithmosh.abstractFactory;

public class BuildMusclePlan implements Plan {

    @Override
    public void workoutPlan() {
        System.out.println("Workout plan: muscle");
    }

    @Override
    public void mealPlan() {
        System.out.println("Meal plan: muscle");
    }
}
