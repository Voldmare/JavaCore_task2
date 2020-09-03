package com.company.Menus;

import com.company.Managers.WarehouseManager;

import java.util.Scanner;

//абстрактний клас меню, на базі якого можемо створювати свої кастомні меню з ізними пунктами та поведінкою
public abstract class Menu {
    protected String[] menu; //для створення нового типу меню ініціалізувати змінну і заповнити пунктами меню
    protected Scanner scanner = new Scanner(System.in);
    protected WarehouseManager warehouseManager = WarehouseManager.getInstance();

    public void displayMenu() {
        //виводимо пункти меню в консоль; методі працюватиме для нащадків незалежно від їх пунктів
        for(int i=0; i<menu.length; i++){
            System.out.println((i+1) + menu[i]);
        }
    }

    public abstract void chooseAction(int input);   //метод для визначення поведінки пунктів меню - перевизначається в нащадках
}
