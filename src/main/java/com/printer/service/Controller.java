package com.printer.service;

import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4040")
public class Controller {

    @PostMapping(path = "/ticket", consumes = "application/json")
    public void postTicket(@RequestBody List<Product> data){
        Ticket ticket = new Ticket(data);
        PrinterManager.printTicket(PrinterManager.getPrinter(), ticket);
    }

}
