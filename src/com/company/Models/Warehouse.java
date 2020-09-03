package com.company.Models;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {

    private Scanner scanner = new Scanner(System.in);
    private int warehouseNumber;    //номер складу
    private ArrayList<Product> productsInWarehouse = new ArrayList<>(); //список товарів на складі

    //Constructor
    public Warehouse(int warehouseNumber){
        this.warehouseNumber = warehouseNumber;
    }

    //Getters
    public int getWarehouseNumber(){
        return  warehouseNumber;
    }

    //Методи складу
    //додати товар на склад
    public void addProduct(){
        Product product = new Product();    //створюємо порожній товар
        //і заповнюємо його даними
        System.out.println("Назва товару: ");
        product.setNameOfProduct(scanner.nextLine());

        System.out.println("Категорія товару: ");
        product.setCategory(scanner.nextLine());

        System.out.println("Дата виготовлення товару в форматі дд:мм:рррр: ");
        product.setDateOfProduction(scanner.nextLine());

        System.out.println("Термін придатності товару: ");
        product.setExpireTime(scanner.nextLine());

        System.out.println("Кількість одиниць товару: ");
        product.setAmountOfProduct(scanner.nextInt());

        System.out.println("Ціна за одиницю товару: ");
        product.setPricePerOne(scanner.nextFloat());
        scanner.nextLine();
        System.out.println("Опис товару: ");
        product.setDescription(scanner.nextLine());

        productsInWarehouse.add(product);   //додаємо товар у список товарів
        System.out.println("Товар було успішно додано!");
    }

    //
    public void editProductInfoByID(int id){
        System.out.println(getProductInfoByID(id));
        Product product = getProductsList().get(id-1);  //ІД на 1 більший за позицію в списку
        System.out.println("Ви хочете змінити дані товару " + id + ":");
        System.out.println(product.getInfo());
        String str;

        System.out.println("Введіть нову назву товару (Space - пропустити):");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setNameOfProduct(str);
        }

        System.out.println("Введіть нову категорію товару (Space - пропустити): ");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setCategory(str);
        }

        System.out.println("Введіть нову дату виготовлення товару в форматі дд:мм:рррр (Space - пропустити): ");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setDateOfProduction(str);
        }

        System.out.println("Введіть новий термін придатності товару (Space - пропустити): ");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setExpireTime(str);
        }

        System.out.println("Введіть нову кількість одиниць товару (Space - пропустити): ");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setAmountOfProduct(Integer.parseInt(str));
        }

        System.out.println("Введіть нову ціну за одиницю товару (Space - пропустити): ");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setPricePerOne(Float.parseFloat(str));
        }
        System.out.println("Введіть новий опис товару (Space - пропустити): ");
        if ((str = scanner.nextLine()).compareTo(" ") != 0){
            product.setDescription(str);
        }
    }

    //отримати список товарів на складі
    public ArrayList<Product> getProductsList(){
        return productsInWarehouse;
    }

    //отримати інформацію про товар за ID
    public String getProductInfoByID(int id){
        String result = "";
        int index = checkID(id);
        if(index != -1){
            result = productsInWarehouse.get(index).getInfo();
        } else {
            result = "There are no products with such ID!";
        }
        return result;
    }

    public void deleteProductByID(int id){
        int index = checkID(id);
        if(index != -1){
            if(confirmDelete(index)){
                productsInWarehouse.remove(index);
                System.out.println("Товар був успішно видалений!");
            } else{
                System.out.println("Видалення товару скасовано успішно!");
            }
        }
    }

    private boolean confirmDelete(int index){
        System.out.println("Ви дійсно хочете видалити товар:" + productsInWarehouse.get(index).getInfo() + "?");
        System.out.println("1: підтвердити видалення\n2: скасувати видалення");
        return scanner.nextInt() == 1;
    }

    private int checkID(int id){
        int result = -1;
        for(Product product : productsInWarehouse){
            if(product.getProductID() == id){
                result = productsInWarehouse.indexOf(product);
            }
        }
        return result;
    }



}
