package Menus;

import Clases.CSVmetodos;
import Reserva_llibre_client.Llibre;
import org.beryx.textio.PropertiesConstants;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Modificacio {

    public static void modificacio_menu(TextTerminal<?> terminal, TextIO textIO) throws IOException {
        String path = "src/main/resources/Llibres.csv";
        CSVmetodos csv = null;
        try {
            csv = new CSVmetodos(path,"llibre");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        terminal.getProperties().put(PropertiesConstants.PROP_PROMPT_STYLE_CLASS, "textterm-white-space-pre");
        CSVmetodos finalCsv = csv;
        terminal.setBookmark("MODIFICACIO");
        terminal.executeWithPropertiesPrefix("pre", t -> {
            t.println("----------------------------------------------------------------------------------------------------");
            t.println(String.format("%-10s %-40s %-13s %-10s %-15s %-10s","Posicio","Titol","Any publicacio","ISBN","Genere","Disponobilitat"));
            //t.println("  Titol              Any publicacio              ISBN");
            t.println("---------------------------------------------------------------------------------------------------");

            for (int i=0; i<finalCsv.getLlibre().size();i++) {

                terminal.printf("%-10s %s \n",i,finalCsv.getLlibre().get(i).toString());

            }
            textIO.newStringInputReader().withMinLength(0).read("\n Prem qualsevol tecla per tornar");

        });
        terminal.resetToBookmark("MODIFICACIO");
    }
}
