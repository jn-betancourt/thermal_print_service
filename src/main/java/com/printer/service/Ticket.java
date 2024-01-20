package com.printer.service;

import java.time.LocalDate;
import java.util.Collection;

public class Ticket {
    
    private final LocalDate date;
    private final Collection<Product> products;
    private final int total;

    public Ticket(Collection<Product> products) {
        this.date = LocalDate.now();
        this.products = products;
        this.total = calcularTotal();
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

        result.append("Date: "+this.date.toString()+"\n");
        for(Product product : products){
            result.append(product.toString()+"\n");
        }
        int spaces = 41 - String.valueOf(this.total).length();
        result.append("total:"+" ".repeat(spaces)+this.total);
        return result.toString();
    }    
    
}
