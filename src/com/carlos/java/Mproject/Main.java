package com.carlos.java.Mproject;

import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {
        Machine myMachine = new Machine(550, 400, 540, 120, 9);

        while (myMachine.getState() != MachineState.OFF) {
            myMachine.work(SCAN.next());
        }

        SCAN.close();
    }
}