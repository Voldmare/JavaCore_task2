package com.company.Models;

//PARENT CLASS
public class Product {
    private int productID;
    private String nameOfProduct;
    private String category;
    private String dateOfProduction;
    private String expireTime;
    private int amountOfProduct;
    private float pricePerOne;
    private String description;

    public static int counter = 0;



    public Product(){
        Product.counter++;
        productID = counter;
    }
//comment
    //геттери/сеттери
    public int getProductID(){return productID;}
    public void setNameOfProduct(String nameOfProduct){
        this.nameOfProduct = nameOfProduct;
    }
    public String getNameOfProduct(){
        return nameOfProduct;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public void setDateOfProduction(String dateOfProduction){
        this.dateOfProduction = dateOfProduction;
    }
    public String getDateOfProduction(){
        return dateOfProduction;
    }
    public void setExpireTime(String expireTime){
        this.expireTime = expireTime;
    }
    public String getExpireTime(){
        return expireTime;
    }
    public void setAmountOfProduct(int amountOfProduct){
        this.amountOfProduct = amountOfProduct;
    }
    public int getAmountOfProduct(){
        return amountOfProduct;
    }
    public void setPricePerOne(float pricePerOne){
        this.pricePerOne = pricePerOne;
    }
    public float getPricePerOne(){
        return pricePerOne;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", category='" + category + '\'' +
                ", dateOfProduction='" + dateOfProduction + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", amountOfProduct=" + amountOfProduct +
                ", pricePerOne=" + pricePerOne +
                ", description='" + description + '\'' +
                '}';
    }

    public String getInfo(){    //представляє інформацію про товар
        return getProductID() + "; " +
                getNameOfProduct() + "; " +
                getCategory() + "; " +
                getDateOfProduction() + "; " +
                getExpireTime() + "; " +
                getAmountOfProduct() + "; " +
                getPricePerOne() + "; " +
                getDescription() + ".";
    }

}