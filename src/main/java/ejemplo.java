/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import Clases.*;
import Menus.treballador.menu_base_treballador;
import Menus.administrador.menu_base_admin;
import org.beryx.textio.TerminalProperties;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.BiConsumer;

/**
 * A simple application illustrating the use of TextIO.
 */
public class ejemplo implements BiConsumer<TextIO, RunnerData> {
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        new ejemplo().accept(textIO, null);

    }

    @Override
    public void accept(TextIO textIO, RunnerData runnerData) {

        TextTerminal<?> terminal = textIO.getTextTerminal();
        String initData = (runnerData == null) ? null : runnerData.getInitData();
        AppUtil.printGsonMessage(terminal, initData);

        String path = "src/main/resources/CSVDemo.csv";
        CSVmetodos csv = null;
        try {
            csv = new CSVmetodos(path,"usuari");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        TerminalProperties<?> props = terminal.getProperties();

        terminal.setBookmark("LOGIN");
        boolean es_cap_temp;
        do{

            props.setPromptBold(true);
            props.setPromptUnderline(true);
            props.setPromptColor("green");
            terminal.println("Login usuario");


            props.setPromptUnderline(false);
            props.setPromptBold(false);
            props.setInputColor("yellow");
            props.setInputItalic(true);


            String dni = textIO.newStringInputReader()
                    .withDefaultValue("2132143d")
                    .read("Usuario");

            String password = textIO.newStringInputReader()
                    .withMinLength(3)
                    .withInputMasking(true)
                    .read("Contraseña");

            Usuario usuario_temp = new Usuari_treballador(dni,password);
            Usuario usuario_cap_temp = new Usuari_admin(dni,password);

            usuario_temp =
                    (csv.getUsuarios().contains(usuario_temp)) ? usuario_temp :
                    (csv.getUsuarios().contains(usuario_cap_temp)) ? usuario_cap_temp :
                    null;

            if(usuario_temp != null){
                Usuario usuario_temp_vfinal = csv.getUsuarios().get(
                        csv.getUsuarios().indexOf(usuario_temp));
                String nom_temp = usuario_temp_vfinal.getNomCognom();

                es_cap_temp = usuario_temp_vfinal.isEs_cap();
                terminal.printf("Usuario y contraseña correcto \n Benvingut %s  %s.\n",nom_temp,es_cap_temp ? "administrador" : "" );
                textIO.newStringInputReader().withMinLength(0).read("\nEnter para continuar...");
                break;
            }

            else{
                props.setPromptBold(true);
                props.setPromptUnderline(true);
                props.setPromptColor("red");

                terminal.printf("Usuario o contraseña incorrectos\n");
            }



        }while(true);
        terminal.resetToBookmark("LOGIN");

        if(es_cap_temp){
            menu_base_admin.display_menu(terminal,textIO);

        }
        else{
            try {
                menu_base_treballador.display_menu(terminal,textIO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        textIO.dispose("User '"  + "' has left the building.");
    }
    public static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + ": reading personal data.\n" +
                "(Properties are initialized at start-up.\n" +
                "Properties file: " + getClass().getSimpleName() + ".properties.)";
    }
}