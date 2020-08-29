package com.company.Menus;

import com.company.Managers.WarehouseManager;

import java.util.Scanner;

public abstract class Menu {
    protected String[] menu; //для створення нового типу меню ініціалізувати змінну і заповнити пунктами меню
    protected Scanner scanner = new Scanner(System.in);
    protected WarehouseManager warehouseManager = WarehouseManager.getInstance();

    public void displayMenu() {
        for(int i=0; i<menu.length; i++){
            System.out.println((i+1) + menu[i]);
        }
    }

    public abstract void chooseAction(int input);   //перевизначаємо метод для кожного типу меню
}
