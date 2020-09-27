package com.company.Managers;

import com.company.Menus.StartMenu;

import java.util.Scanner;

// клас для консольної взаємодії
public class ConsoleInterface {

    StartMenu startMenu = StartMenu.getInstance();      //створюємо стартове меню

    /*
        starts interface for acting with User
     */
    public void start(){
        startMenu.displayMenu();    //виводимо меню в консоль
    }
}
