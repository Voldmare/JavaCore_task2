package com.company.Managers;

import com.company.Menus.StartMenu;

import java.util.Scanner;

// клас для консольної взаємодії
public class ConsoleInterface {

    StartMenu startMenu = StartMenu.getInstance();      //створюємо стартове меню

    public void start(){
        startMenu.displayMenu();    //виводимо меню в консоль
    }


}
