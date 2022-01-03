package Menus;

import Clases.CSVmetodos;
import Reserva_llibre_client.Llibre;
import java.io.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;
import javassist.expr.NewArray;
import org.beryx.textio.InputReader;
import org.beryx.textio.PropertiesConstants;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alta {
    public Alta() {
    }

    public static void alta_menu(TextTerminal<?> terminal, TextIO textIO) throws IOException {

        terminal.setBookmark("ALTA");
        String titol = textIO.newStringInputReader()
                .withMaxLength(35)
                .read("Titol: ");



        String data_publicacio;
        while(true){
            data_publicacio = textIO.newStringInputReader()
                    .withPattern("^(?:3[01]|[12][0-9]|0?[1-9])([/])(0?[1-9]|1[1-2])\\1\\d{4}$")
                    .read("Data de publicació (dd/mm/aaaa): ");


            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);
                format.parse(data_publicacio);
            }
            catch (Exception e){
                String linea = String.format("Date incorrecte: %s", e.getMessage());
                terminal.executeWithPropertiesConfigurator(
                        props -> props.setPromptColor("red"),
                        t -> t.println(linea));
                continue;
            }
            break;


        }

        String disponibilitat = textIO.newStringInputReader()
                .withNumberedPossibleValues("true", "false")
                .read("Disponibilitat: ");
        String isbn = textIO.newStringInputReader()
                .withMaxLength(13)
                .read("ISBN: ");
        String genere = textIO.newStringInputReader()
                .withNumberedPossibleValues("DRAMA", "TERROR","AVENTURA")
                .read("Gènere: ");

        String [] linea = {titol,data_publicacio,disponibilitat,isbn,genere};

        String path = "src/main/resources/Llibres.csv";
        CSVmetodos csv = null;
        try {
            csv = new CSVmetodos(path,linea);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        textIO.newStringInputReader().withMinLength(0).read("\n Prem qualsevol tecla per tornar");
        terminal.resetToBookmark("ALTA");

    }
}
