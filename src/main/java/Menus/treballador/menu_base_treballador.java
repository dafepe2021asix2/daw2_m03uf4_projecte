package Menus.treballador;

import Menus.Alta;
import Menus.Llistat;
import org.beryx.textio.TerminalProperties;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.io.IOException;

public class menu_base_treballador {

    static public void display_menu(TextTerminal<?> terminal, TextIO textIO) throws IOException {
        loop : while (true){

            TerminalProperties<?> props = terminal.getProperties();
            terminal.setBookmark("MENU");
            terminal.printf("////////////////////// Menu ////////////////////// \n");
            props.setPromptBold(false);
            props.setPromptUnderline(false);
            props.setPromptColor("white");
            String seleccio_menu = textIO.newStringInputReader()
                    .withNumberedPossibleValues("Alta", "modificacio", "Eliminacio","Llistat","Sortir")
                    .read("Opcions: ");

            terminal.printf("Seleecio opcio %s",seleccio_menu);
            terminal.resetToBookmark("MENU");

            switch(seleccio_menu) {
                case "Alta":
                    terminal.setBookmark("ALTA");
                    Alta.alta_menu(terminal,textIO);
                    // code block
                    break;
                case "modificacio":
                    // code block
                    break;
                case "Eliminacio":
                    // code block
                    break;
                case "Llistat":
                    terminal.setBookmark("LLISTAT");
                    Llistat.llistat_menu(terminal,textIO);
                    // code block
                    break;
                case "Sortir":
                    // code block
                    break loop ;
                default:
                    // code block
            }

        }





    }

}
