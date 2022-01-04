package Menus;

import Clases.CSVmetodos;
import Clases.Producte;
import Reserva_llibre_client.Genere;
import Reserva_llibre_client.Llibre;
import java.io.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;
import javassist.expr.NewArray;
import org.beryx.textio.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.time.*;

import static Reserva_llibre_client.Genere.SIN_CATEGORIA;
import static org.beryx.textio.ReadInterruptionStrategy.Action.ABORT;

public class Alta {

    private static final List<Runnable> operations = new ArrayList<>();

    private static void addTask(TextTerminal<?> terminal,TextIO textIO, String prompt, Supplier<String> defaultValueSupplier, Consumer<String> valueSetter) {
        if(prompt == "Data publicacio"){
            operations.add(() -> valueSetter.accept(fecha(terminal,textIO,defaultValueSupplier)));
        }
        else if(prompt == "GENERE"){
            operations.add(() -> valueSetter.accept(textIO.newStringInputReader()
                    .withNumberedPossibleValues( Arrays.stream(Genere.class.getEnumConstants()).map(Enum::name).toArray(String[]::new))
                    .withDefaultValue(defaultValueSupplier.get())
                    .read(prompt)));
        }
        else{
            operations.add(() -> valueSetter.accept(textIO.newStringInputReader()
                    .withDefaultValue(defaultValueSupplier.get())
                    .read(prompt)));

        }

    }

    private static String fecha(TextTerminal<?> terminal, TextIO textIO, Supplier<String> defaultValueSupplier)  {
        String data_publicacio;
        while(true){
            data_publicacio = textIO.newStringInputReader().withDefaultValue(defaultValueSupplier.get())
                    .withPattern("^\\d{4}-\\d{2}-\\d{2}$")
                    .read("Data de publicació (yyyy-mm-dd): ");


            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
        return data_publicacio;
    }


    public static void alta_menu(TextTerminal<?> terminal, TextIO textIO) throws IOException {

        terminal.setBookmark("ALTA");


        Llibre llibre = new Llibre(SIN_CATEGORIA,LocalDate.now());

        addTask(terminal,textIO, "Titol", () -> llibre.getTitol(), s -> llibre.setTitol(s));
        addTask(terminal,textIO, "Data publicacio", () -> llibre.getAny_publicacio(),
                s -> llibre.setAny_publicacio(s)
        );
        addTask(terminal,textIO, "Disponibilitat", () -> String.valueOf(llibre.isDisponibilitat()), s -> llibre.setDisponibilitat(Boolean.parseBoolean(s)));
        addTask(terminal,textIO, "ISBN", () -> llibre.getIsbn(), s -> llibre.setIsbn(s));
        addTask(terminal,textIO, "GENERE", () -> String.valueOf(llibre.getTipus()), s -> llibre.setTipus(Genere.valueOf(s)));


        /*
        String titol = textIO.newStringInputReader()
                .withMaxLength(35)
                .read("Titol: ");



        String fecha = fecha(terminal,textIO);
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

         */

        String backKeyStroke = "ctrl U";
        boolean registered = terminal.registerHandler(backKeyStroke, t -> new ReadHandlerData(ABORT));
        if(registered) {
            terminal.println("During data entry you can press '" + backKeyStroke + "' to go back to the previous field.\n");
        }
        int step = 0;
        while(step < operations.size()) {
            terminal.setBookmark("bookmark_" + step);
            try {
                operations.get(step).run();
            } catch (ReadAbortedException e) {
                if(step > 0) step--;
                terminal.resetToBookmark("bookmark_" + step);
                continue;
            }
            step++;
        }

        terminal.println("\nContact info: " + llibre.toString());

        String path = "src/main/resources/Llibres.csv";
        CSVmetodos csv = null;
        try {
            csv = new CSVmetodos(path,llibre.adaptarCSV());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        textIO.newStringInputReader().withMinLength(0).read("\n Prem qualsevol tecla per tornar");
        terminal.resetToBookmark("ALTA");



    }
}
