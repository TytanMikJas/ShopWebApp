package com.example.shopwebapp;

public class Product {
    private long id;
    private String productName;
    private double weight;
    private double price;


    public Product(){}

    public Product(long id, String productName, double weight, double price){
        this.id = id;
        this.productName = productName;
        this.weight = weight;
        this.price = price;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }


}
