package com.printer.service;

import java.io.IOException;

import javax.print.PrintService;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.printer.service.models.Ticket;
import com.github.anastaciocintra.escpos.Style;

public class PrinterManager {

    public static PrintService getPrinter(){
        return PrinterOutputStream.getDefaultPrintService();
    }

    public static void printTicket(PrintService printer, Ticket ticket){
        try{
            PrinterOutputStream stream = new PrinterOutputStream(printer);
            EscPos escpos = new EscPos(stream);

            escpos.writeLF(ticket.toString());
            escpos.feed(5).cut(EscPos.CutMode.FULL);
            escpos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void printTicket(PrintService printer, Ticket ticket, Style style){
        try{
            PrinterOutputStream stream = new PrinterOutputStream(printer);
            EscPos escpos = new EscPos(stream);

            escpos.writeLF(style, ticket.toString());
            escpos.feed(5).cut(EscPos.CutMode.FULL);
            escpos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void printTicket(PrintService printer, String mensaje){
        try{
            PrinterOutputStream stream = new PrinterOutputStream(printer);
            EscPos escpos = new EscPos(stream);
            escpos.writeLF(mensaje);
            escpos.feed(5).cut(EscPos.CutMode.FULL);
            escpos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
