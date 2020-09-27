package com.company.Menus;

import com.company.Managers.WarehouseManager;

import java.util.Scanner;

//абстрактний клас меню, на базі якого можемо створювати свої кастомні меню з ізними пунктами та поведінкою
public abstract class Menu {
    protected String[] menu; //для створення нового типу меню ініціалізувати змінну і заповнити пунктами меню
    protected Scanner scanner = new Scanner(System.in);
    protected WarehouseManager warehouseManager = WarehouseManager.getInstance();

    /*
        Shows menu items
    */
    public void displayMenu() {
        //виводимо пункти меню в консоль; метод працюватиме для нащадків незалежно від їх пунктів
        for(int i=0; i<menu.length; i++){
            System.out.println((i+1) + menu[i]);
        }
    }

    public void getUserInput(){
        String input = new Scanner(System.in).nextLine();
        if (checkInput(input)){ //if input is correct number - let user choose action
            chooseAction(Integer.parseInt(input));    //запускаємо перевизначений метод
        } else {
            displayMenu();  //if input is incorrect - display menu again
        }
    }

    public boolean checkInput(String input){
            if(input == null){
                System.out.println("Ви ввели невірні дані! Введіть ціле число!");   //виводимо інформацію про невірний формат вводу
                return false;
            }
            for(char ch : input.toCharArray()){
                if (!Character.isDigit(ch)){
                    System.out.println("Ви ввели невірні дані! Введіть ціле число!");   //виводимо інформацію про невірний формат вводу
                    return false;
                }
            }
            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > menu.length){
                System.out.println("Введіть число від 1 до " + menu.length + "!");
                return false;
            }
            return true;
    }

    public abstract void chooseAction(int input);   //метод для визначення поведінки пунктів меню - перевизначається в нащадках
}
