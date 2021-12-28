package Clases;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ratpack.util.internal.PropertiesUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CSVmetodos  {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public  CSVmetodos( String path) throws FileNotFoundException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            List<String[]> records = (List<String[]>) csvReader.readAll();
            for (String[] record : records) {
                if(Boolean.parseBoolean(record[5])){
                    Usuari_admin usuario =  new Usuari_admin( record[0], record[1], Integer.parseInt(record[2]), record[3], record[4], Boolean.parseBoolean(record[5]));
                    usuarios.add(usuario);
                }
                else{
                    Usuari_treballador usuario =  new Usuari_treballador( record[0], record[1], Integer.parseInt(record[2]), record[3], record[4], Boolean.parseBoolean(record[5]));
                    usuarios.add(usuario);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
