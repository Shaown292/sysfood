package com.example.sysfood.model;

public class CardFood {
    Integer ImageURL;
    String name;
    String price;
    String restaurantName;
    String rating;
    String toppings;
    String save;
    String order;

    public CardFood(Integer imageURL, String name, String price, String restaurantName, String rating, String toppings, String save, String order) {
        ImageURL = imageURL;
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.toppings = toppings;
        this.save = save;
        this.order = order;
    }

    public Integer getImageURL() {
        return ImageURL;
    }

    public void setImageURL(Integer imageURL) {
        ImageURL = imageURL;
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
