package com.company.Menus;

import com.company.Models.Warehouse;

import java.util.Scanner;

//наше кастомне стартове меню
public class StartMenu extends Menu {

    //нам потрібен тільки один екземпляр стартового меню
    //створюємо singleton меню
    private static StartMenu instance;

    private StartMenu(){
        menu = new String[5];
        //пункти меню
        menu[0] = ": додати новий товар";
        menu[1] = ": переглянути інформацію про товар";
        menu[2] = ": редагувати інформацію про товар";
        menu[3] = ": видалити існуючий товар";
        menu[4] = ": згенерувати звіт";
    }

    public static StartMenu getInstance() {
        if (instance == null) {
            instance = new StartMenu();
        }
        return instance;
    }

    @Override
    public void displayMenu() {
        super.displayMenu();    //виводимо пункти меню батьківським методом
        getUserInput();
    }

    //перевизначений метод обробки пунктів меню
    @Override
    public void chooseAction(int input) {
        switch(input){
            case 1:
                warehouseManager.chooseWarehouse().addProduct();    //викликаємо менеджер складу - в ньому знаходитимуться методи роботи з продуктами на складі
                break;
            case 2:
                WarehouseMenu.getInstance().displayMenu();  //виводимо наше інше кастомне меню - меню перегляду товару на складі
                break;
            case 3:
                Warehouse currentWarehouse = warehouseManager.chooseWarehouse();
                System.out.println("Введіть ID товару.");
                currentWarehouse.editProductInfoByID(scanner.nextInt());
                break;
            case 4:
                currentWarehouse = warehouseManager.chooseWarehouse();
                System.out.println("Введіть ID товару.");
                currentWarehouse.deleteProductByID(scanner.nextInt());
                break;
        }
        instance.displayMenu(); // в кінці виводимо меню знову
    }
}
