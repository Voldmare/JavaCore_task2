package com.company.Managers;

import com.company.Menus.StartMenu;

import java.util.Scanner;

// клас для консольної взаємодії
public class ConsoleInterface {

    StartMenu startMenu = StartMenu.getInstance();
    WarehouseManager warehouseManager = WarehouseManager.getInstance();

    Scanner scanner = new Scanner(System.in);

    public void start(){
        startMenu.displayMenu();


    }


}
