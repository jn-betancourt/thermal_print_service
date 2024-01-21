package com.printer.service.models;

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
        result.setLength(48);

        // Format the properties into a space of 48 characters
        result.append(String.format("%-30s", title.substring(0, Math.min(title.length(), 30))));
        result.append(String.format("x%-8s", String.valueOf(quantity).substring(0, Math.min(String.valueOf(quantity).length(), 8))));
        result.append(String.format("%-10s", String.valueOf(price).substring(0, Math.min(String.valueOf(price).length(), 10))));
        // Convert StringBuilder to String and return
        if(title.length() > 30){
            String tmp = title.substring(30, title.length());
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
