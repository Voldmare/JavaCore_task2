package com.company.Menus;

import com.company.Models.Warehouse;

import java.util.Scanner;

public class StartMenu extends Menu {

    //нам потрібен тільки один екземпляр стартового меню
    private static StartMenu instance;

    private StartMenu(){
        menu = new String[5];
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
        super.displayMenu();
        instance.chooseAction(new Scanner(System.in).nextInt());
    }

    @Override
    public void chooseAction(int input) {
        switch(input){
            case 1:
                warehouseManager.chooseWarehouse().addProduct();
                instance.displayMenu();
                break;
            case 2:
                WarehouseMenu.getInstance().displayMenu();
                instance.displayMenu();
                break;
            case 3:
                Warehouse currentWarehouse = warehouseManager.chooseWarehouse();
                System.out.println("Введіть ID товару.");
                currentWarehouse.editProductInfoByID(scanner.nextInt());
                break;
        }
        //scanner.nextInt();
    }
}
