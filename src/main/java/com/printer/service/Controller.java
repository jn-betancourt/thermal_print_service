package com.printer.service;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.printer.service.models.Product;
import com.printer.service.models.Ticket;
import com.printer.service.models.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4040")
public class Controller {

    @PostMapping(path = "/ticket", consumes = "application/json")
    public ResponseEntity postSimpleTicket(@RequestBody List<Product> data){
        Ticket ticket = new Ticket(data);
        PrinterManager.printTicket(PrinterManager.getPrinter(), ticket.toString());
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/ticketToGo", consumes = "application/json")
    public ResponseEntity postToGoTicket(@RequestBody JsonNode json){
        ArrayNode products = (ArrayNode)json.get("products");
        List<Product> list = new ArrayList();
        for (JsonNode product : products){
            Product tmp = new Product(product);
            list.add(tmp);
        }        
        User user = new User(json.get("user"));
        Ticket ticket = new Ticket(user, list);

        PrinterManager.printTicket(PrinterManager.getPrinter(), ticket);

        return ResponseEntity.ok().build();
    }

}
