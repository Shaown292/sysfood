package com.example.sysfood.model;

public class AsianFood {

    Integer ImageURL;
    String name;
    String price;
    String restaurantName;
    String rating;
    String toppings;

    public AsianFood(Integer imageURL, String name, String price, String restaurantName, String rating, String toppings) {
        ImageURL = imageURL;
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.toppings = toppings;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
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
}
