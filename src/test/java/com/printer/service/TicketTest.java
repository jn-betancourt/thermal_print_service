package com.printer.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.printer.service.models.Product;
import com.printer.service.models.Ticket;

public class TicketTest {

    @Test
    void creationTest(){
        Product product = new Product("", 0, 0);
        List<Product> products = new ArrayList<Product>();
        products.add(product);
        Ticket ticket = new Ticket(products);
        assert(ticket != null);
    }
    @Test
    void toStringTest(){
        LocalDate date = LocalDate.now();
        Product product = new Product("arepa", 1, 15000);
        List<Product> products = new ArrayList<Product>();
        products.add(product);
        Ticket ticket = new Ticket(products);

        String expecetedString = "Date: " + date.toString() + "\n" +
                "arepa           x1     15000\n" +
                "total:                 15000";
        System.out.println(expecetedString);
        System.out.println(ticket);
        // assert(ticket == expecetedString);
    }
}
