package com.carlos.java.Mproject;

enum MachineState {
    HOME, BUY, FILL_WATER, FILL_MILK, FILL_COFFEE, FILL_CUPS, OFF;
}

public class Machine {
    private int money;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private MachineState state;
    private Coffee coffeeOption;

    Machine(int money, int water, int milk, int coffeeBeans, int disposableCups) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;

        startMachine();
    }

    public void work(String str) {
        switch (state) {
            case HOME:
                setState(str);
                break;
            case BUY:
                if(str.equals("back")) {
                    startMachine();
                } else if(str.equals("1") || str.equals("2") || str.equals("3")) {
                    coffeeOption = str.equals("1") ? Coffee.ESPRESSO :
                            str.equals("2") ? Coffee.LATTE : Coffee.CAPPUCCINO;
                    buyCoffee();
                    startMachine();
                }
                break;
            case FILL_WATER:
                this.water += Integer.parseInt(str);
                System.out.println("Write how many ml of milk you want to add:");
                this.state = MachineState.FILL_MILK;
                break;
            case FILL_MILK:
                this.milk += Integer.parseInt(str);
                System.out.println("Write how many grams of coffee beans you want to add:");
                this.state = MachineState.FILL_COFFEE;
                break;
            case FILL_COFFEE:
                this.coffeeBeans += Integer.parseInt(str);
                System.out.println("Write how many disposable cups of coffee you want to add:");
                this.state = MachineState.FILL_CUPS;
                break;
            case FILL_CUPS:
                this.disposableCups += Integer.parseInt(str);
                startMachine();
                break;
        }
    }

    private void startMachine() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        this.state = MachineState.HOME;
    }

    private void setState(String str) {
        switch (str) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                this.state = MachineState.BUY;
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add: ");
                this.state = MachineState.FILL_WATER;
                break;
            case "take":
                takeMoney();
                startMachine();
                break;
            case "remaining":
                content();
                startMachine();
                break;
            case "exit":
                this.state = MachineState.OFF;
                break;
            default:
                System.out.println("Ingress a valid option!");
                startMachine();
                break;
        }
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void content() {
        System.out.printf("%nThe coffee machine has:%n" +
                        "%d ml of water%n" +
                        "%d ml of milk%n" +
                        "%d g of coffee beans%n" +
                        "%d disposable cups%n" +
                        "$%d of money%n",
                water, milk, coffeeBeans, disposableCups, money);
    }

    private void buyCoffee() {
        String enough = water - coffeeOption.getWater() < 0 ? "water" :
                milk - coffeeOption.getMilk() < 0 ? "milk":
                        coffeeBeans - coffeeOption.getCoffeeBeans() < 0 ? "coffee beans" :
                                disposableCups - 1 < 0 ? "disposable cups" :
                                        "enough";

        if(!enough.equals("enough")) {
            System.out.printf("Sorry, not enough %s!", enough);
        }else {
            System.out.println("I have enough resources, making you a coffee!");
            money += coffeeOption.getCoffeePrice();
            water -= coffeeOption.getWater();
            milk -= coffeeOption.getMilk();
            coffeeBeans -= coffeeOption.getCoffeeBeans();
            disposableCups--;
        }
    }

    public MachineState getState() {
        return state;
    }
}