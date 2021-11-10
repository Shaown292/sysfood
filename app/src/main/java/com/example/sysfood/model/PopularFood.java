package com.example.sysfood.model;

public class PopularFood {

    String name;
    String price;
    Integer ImageURL;


    public PopularFood(String name, String price, Integer imageURL) {
        this.name = name;
        this.price = price;
        ImageURL = imageURL;
    }

    public PopularFood() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageURL() {
        return ImageURL;
    }

    public void setImageURL(Integer imageURL) {
        ImageURL = imageURL;
    }

}
