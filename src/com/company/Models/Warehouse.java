package com.company.Models;

import com.company.Models.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {

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
        Scanner scanner = new Scanner(System.in);
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
        Product product = getProductsList().get(id);
    }

    //отримати список товарів на складі
    public ArrayList<Product> getProductsList(){
        return productsInWarehouse;
    }

    //отримати інформацію про товар за ID
    public String getProductInfoByID(int id){
        return getProductsList().get(id-1).getInfo();
    }

}
