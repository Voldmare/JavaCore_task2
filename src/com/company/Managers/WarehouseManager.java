package com.company.Managers;

import com.company.Models.Warehouse;

import java.util.Scanner;

public class WarehouseManager {
    private static WarehouseManager instance;

    private int warehouseAmount = 3;    //дефолтна к-сть складів
    private Warehouse[] warehouses = new Warehouse[warehouseAmount];

    //Setter
    public void setWarehouseAmount(int warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }
    //Getters
    public Warehouse[] getWarehouses() {
        return warehouses;
    }
    //Setters
    public void setWarehouses(Warehouse[] warehouses) {
        this.warehouses = warehouses;
    }

    private WarehouseManager(){
        for(int i=0; i<warehouseAmount;i++){
            warehouses[i] = new Warehouse(i+1);
        }
    }

    //Singleton
    public static WarehouseManager getInstance() {
        if (instance == null) {
            instance = new WarehouseManager();
        }
        return instance;
    }
    // Methods
    public Warehouse chooseWarehouse(){
        System.out.println("Виберіть склад: ");
        for(Warehouse warehouse : warehouses){
            int n = warehouse.getWarehouseNumber();
            System.out.println(n + ": Склад №" + n);
        }
        return warehouses[new Scanner(System.in).nextInt()-1];
    }
}
