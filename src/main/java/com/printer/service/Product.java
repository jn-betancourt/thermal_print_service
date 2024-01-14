package com.printer.service;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

public class Product{
    private String title;
    private int quantity;
    private int price;

    @JsonCreator
    public Product(@JsonProperty("title") String title, @JsonProperty("quantity") int quantity, @JsonProperty("price") int price){
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @JsonCreator
    public Product(JsonNode json){
        this.title = json.get("title").asText();
        this.quantity = json.get("quantity").asInt();
        this.price = json.get("price").asInt();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.setLength(28);

        // Format the properties into a space of 28 characters
        result.append(String.format("%-15s", title.substring(0, Math.min(title.length(), 15))));
        result.append(" ");
        result.append(String.format("x%-4s", String.valueOf(quantity).substring(0, Math.min(String.valueOf(quantity).length(), 5))));
        result.append(" ");
        result.append(String.format("%-8s", String.valueOf(price).substring(0, Math.min(String.valueOf(price).length(), 8))));
        // Convert StringBuilder to String and return
        if(title.length() > 15){
            String tmp = title.substring(15, title.length());
            result.append("\n"+tmp);
        }
        return result.toString();
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    
}
