package com.printer.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class User {
    private String name;
    private String phone;
    private String address;
    private String sendCost;
    
    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("phone") String phone, @JsonProperty("address") String address, @JsonProperty("sendCost") String cost) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.sendCost = cost;
    }
    @JsonCreator
    public User(JsonNode json) {
        this.name = json.get("name").asText();
        this.phone = json.get("phone").asText();
        this.address = json.get("address").asText();
        this.sendCost = json.get("sendCost").asText();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        user.append("numero: "+this.phone);
        user.append("\n");
        user.append("Direccion: "+String.format("%-37s", this.address.substring(0, Math.min(address.length(), 37))));
        user.append("costo de envio: "+this.sendCost);
        if (this.address.length() > 37){
            user.append("\n"+this.address.substring(37, this.address.length()));
        }
        return user.toString();
    }

    

}
