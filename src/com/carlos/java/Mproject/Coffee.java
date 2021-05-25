package com.carlos.java.Mproject;

public enum Coffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int WATER;
    private final int MILK;
    private final int COFFEE_BEANS;
    private final int COFFEE_PRICE;

    Coffee(int water, int milk, int coffeeBeans, int coffeePrice) {
        this.WATER = water;
        this.MILK = milk;
        this.COFFEE_BEANS = coffeeBeans;
        this.COFFEE_PRICE = coffeePrice;
    }

    public int getWater() {
        return WATER;
    }

    public int getMilk() {
        return MILK;
    }

    public int getCoffeeBeans() {
        return COFFEE_BEANS;
    }

    public int getCoffeePrice() {
        return COFFEE_PRICE;
    }
}
