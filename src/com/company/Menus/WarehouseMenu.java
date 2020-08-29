package com.company.Menus;

import com.company.Models.Product;
import com.company.Models.Warehouse;

import java.util.ArrayList;

public class WarehouseMenu extends Menu {

    //нам потрібен тільки один екземпляр стартового меню
    private static WarehouseMenu instance;
    private Warehouse currentWarehouse;

    private WarehouseMenu(){
        menu = new String[2];
        menu[0] = ": переглянути інформацію про всі товари на складі";
        menu[1] = ": переглянути інформацію про товар за ID";
    }

    public static WarehouseMenu getInstance() {
        if (instance == null) {
            instance = new WarehouseMenu();
        }
        return instance;
    }

    @Override
    public void displayMenu() {
        currentWarehouse = warehouseManager.chooseWarehouse();
        super.displayMenu();
        instance.chooseAction(scanner.nextInt());
        StartMenu.getInstance().displayMenu();
    }

    @Override
    public void chooseAction(int input) {
        switch(input){
            case 1:
                ArrayList<Product> productsInWarehouse = currentWarehouse.getProductsList();
                System.out.println("Товари на складі №" + currentWarehouse.getWarehouseNumber() + ":");
                for(Product product : productsInWarehouse){
                    System.out.println(product.getInfo());
                }
                break;
            case 2:
                System.out.println("Введіть ID товару.");
                System.out.println(currentWarehouse.getProductInfoByID(scanner.nextInt()));
                break;
        }
    }
}
