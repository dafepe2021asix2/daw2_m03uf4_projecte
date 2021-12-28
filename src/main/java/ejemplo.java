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

import Clases.CSVmetodos;
import Clases.Usuari_treballador;
import Clases.Usuario;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;

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

        String path = "C:\\Users\\Antiwen\\IdeaProjects\\java_biblioteca_M03\\src\\main\\resources\\CSVDEMO.csv";
        CSVmetodos csv = new CSVmetodos(path);


        do{
            String initData = (runnerData == null) ? null : runnerData.getInitData();
            AppUtil.printGsonMessage(terminal, initData);

            String dni = textIO.newStringInputReader()
                    .withDefaultValue("2132143d")
                    .read("Clases.Usuario");

            String password = textIO.newStringInputReader()
                    .withMinLength(3)
                    .withInputMasking(true)
                    .read("Contraseña");
            terminal.printf("\n Antes\n");
            //csv.getInfo();
            /*
            if(csv.getUsuarios().contains(new Usuari_treballador(dni,password))){
                terminal.printf("\n Clases.Usuario correcto .\n");
                //csv.getInfo();
                break;
            }*/

            terminal.printf("\n Clases.Usuario o contraseña in correctos\n");
            break;

        }while(true);


        textIO.newStringInputReader().withMinLength(0).read("\nPress enter to terminate...");
        textIO.dispose("User '"  + "' has left the building.");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": reading personal data.\n" +
                "(Properties are initialized at start-up.\n" +
                "Properties file: " + getClass().getSimpleName() + ".properties.)";
    }
}