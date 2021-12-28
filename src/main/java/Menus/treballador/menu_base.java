package Menus.treballador;

import org.beryx.textio.TerminalProperties;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public class menu_base {

    static public void display_menu(TextTerminal<?> terminal, TextIO textIO){
        TerminalProperties<?> props = terminal.getProperties();
        terminal.printf("////////////////////// Menu ////////////////////// \n");
        props.setPromptBold(false);
        props.setPromptUnderline(false);
        props.setPromptColor("white");
        String seleccio_menu = textIO.newStringInputReader()
                .withNumberedPossibleValues("Alta", "modificacio", "Eliminacio","Llistat")
                .read("Opcions: ");

        terminal.printf("Seleecio opcio %s",seleccio_menu);




    }

}
