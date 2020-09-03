package com.company;

import com.company.Managers.ConsoleInterface;

public class Main {

    public static void main(String[] args) {
        ConsoleInterface consoleInterface = new ConsoleInterface();     //створюється інтерфейс
        consoleInterface.start();       //стартуємо інтерфейс
    }
}
