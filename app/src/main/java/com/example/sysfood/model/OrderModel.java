package com.example.sysfood.model;

public class OrderModel {
    Integer ImageURL;
    String soldItemName, price, orderNumber;

    public OrderModel() {

    }

    public OrderModel(Integer imageURL, String soldItemName, String price, String orderNumber) {
        ImageURL = imageURL;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }




    public Integer getImageURL() {
        return ImageURL;
    }

    public void setImageURL(Integer imageURL) {
        ImageURL = imageURL;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
