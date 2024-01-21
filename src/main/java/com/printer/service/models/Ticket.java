package com.printer.service.models;

import java.time.LocalDate;
import java.util.Collection;

public class Ticket {
    
    private final LocalDate date;
    private final User client;
    private final Collection<Product> products;
    private final int total;

    public Ticket(Collection<Product> products) {
        this.date = LocalDate.now();
        this.products = products;
        this.total = calcularTotal();
        this.client = null;
    }

    public Ticket(User client, Collection<Product> products) {
        this.date = LocalDate.now();
        this.products = products;
        this.total = calcularTotal();
        this.client = client;
    }

    private int calcularTotal(){
        int total = 0;
        for (Product product : products) {
            total += product.getPrice()*product.getQuantity();
        }
        return total;
    }

    public LocalDate getDate() {
        return date;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.setLength(48);
        result.append("Fecha: "+date.toString()+"\n");

        if(client != null){
            result.append(client.toString()+"\n");
        }
        for(Product product : products){
            result.append(product.toString()+"\n");
        }
        int spaces = 41 - String.valueOf(this.total).length();
        result.append("total:"+" ".repeat(spaces)+this.total);
        return result.toString();
    }    
    
}
