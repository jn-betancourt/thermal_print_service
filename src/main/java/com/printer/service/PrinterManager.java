package com.printer.service;

import java.io.IOException;

import javax.print.PrintService;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.output.PrinterOutputStream;

public class PrinterManager {

    public static PrintService getPrinter(){
        return PrinterOutputStream.getDefaultPrintService();
    }

    public static void printTicket(PrintService printer, Ticket ticket){
        try{
            PrinterOutputStream stream = new PrinterOutputStream(printer);
            EscPos escpos = new EscPos(stream);

            escpos.writeLF(ticket.toString());
            escpos.feed(4).cut(EscPos.CutMode.FULL);
            escpos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
