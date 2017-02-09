package com.jaxfire.james_ash_earthmiles;

public enum Categories {

    NUTRITION("Nutrition"), FITNESS("Fitness"), WELLNESS("Wellness"), WORKOUT_GEAR("Workout Gear");

    private final String text;

    Categories(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
