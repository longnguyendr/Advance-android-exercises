package com.example.lab4.Model;

public class Stock {
    private String name;
    private String price;
    private String id;

    public Stock (String name , String price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }
}
