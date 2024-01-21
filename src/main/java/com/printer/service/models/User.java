package com.printer.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class User {
    private String name;
    private String number;
    private String address;
    
    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("number") String number, @JsonProperty("address") String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }
    @JsonCreator
    public User(JsonNode json) {
        this.name = json.get("name").asText();
        this.number = json.get("number").asText();
        this.address = json.get("address").asText();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder user = new StringBuilder();
        user.setLength(48);
        
        user.append("nombre: "+this.name);
        user.append("\n");
        user.append("numero: "+this.number);
        user.append("\n");
        user.append("Direccion: "+String.format("%-37s", this.address.substring(0, Math.min(address.length(), 37))));
        if (this.address.length() > 37){
            user.append("\n"+this.address.substring(37, this.address.length()));
        }
        return user.toString();
    }

    

}
