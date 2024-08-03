package com.codewithmosh;

import com.codewithmosh.abstractFactory.BuildMusclePlan;
import com.codewithmosh.abstractFactory.HomePage;
import com.codewithmosh.abstractFactory.WeightLossPlan;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var homePage = new HomePage();
        homePage.setGoal(new BuildMusclePlan());
        homePage.setGoal(new WeightLossPlan());
    }
}
