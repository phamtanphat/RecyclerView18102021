package com.example.recyclerview18102021;

public enum BusinessType {
    SHOP_ONLINE("Shop Online"), BISTRO("Bistro"), RESTAURANT("Restaurant");

    private final String name;

    BusinessType(String text) {
        name = text;
    }

    public String toString() {
        return name;
    }
}
