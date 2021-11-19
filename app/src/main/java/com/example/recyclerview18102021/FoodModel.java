package com.example.recyclerview18102021;

public class FoodModel {
    private String name;
    private String address;
    private BusinessType businessType;
    private float distance;
    private float rate;
    private int image;

    public FoodModel() {
    }

    public FoodModel(String name, String address, BusinessType businessType, float distance, float rate, int image) {
        this.name = name;
        this.address = address;
        this.businessType = businessType;
        this.distance = distance;
        this.rate = rate;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", businessType=" + businessType +
                ", distance=" + distance +
                ", rate=" + rate +
                ", image=" + image +
                '}';
    }
}
