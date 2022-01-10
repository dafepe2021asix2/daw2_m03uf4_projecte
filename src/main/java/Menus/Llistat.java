package Menus;

import Clases.CSVmetodos;
import Reserva_llibre_client.Llibre;
import org.beryx.textio.PropertiesConstants;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.io.FileNotFoundException;

public class Llistat {
    public static void llistat_menu(TextTerminal<?> terminal, TextIO textIO) {
        String path = "src/main/resources/Llibres.csv";
        CSVmetodos csv = null;
        try {
            csv = new CSVmetodos(path,"llibre");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        terminal.getProperties().put(PropertiesConstants.PROP_PROMPT_STYLE_CLASS, "textterm-white-space-pre");
        CSVmetodos finalCsv = csv;
        terminal.setBookmark("LLISTAT");
        terminal.executeWithPropertiesPrefix("pre", t -> {
            t.println("----------------------------------------------------------------------------------------------------");
            t.println(String.format("%-40s %-13s %-10s %-15s %-10s","Titol","Any publicacio","ISBN","Genere","Disponobilitat"));
            //t.println("  Titol              Any publicacio              ISBN");
            t.println("---------------------------------------------------------------------------------------------------");
            for (Llibre llibre: finalCsv.getLlibre()
            ) {

                terminal.printf("%s \n",llibre.toString());


            }
            textIO.newStringInputReader().withMinLength(0).read("\n Prem qualsevol tecla per tornar");

        });
        terminal.resetToBookmark("LLISTAT");



    }
}
