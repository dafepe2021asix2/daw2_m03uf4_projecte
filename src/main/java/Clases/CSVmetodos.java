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
    private ArrayList<Persona> usuarios = new ArrayList<>();
    public  CSVmetodos( String path) throws FileNotFoundException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            List<String[]> records = (List<String[]>) csvReader.readAll();
            for (String[] record : records) {
                usuarios.add(new Usuari_treballador( record[0], record[1], Integer.parseInt(record[2]), record[3], record[4], Boolean.parseBoolean(record[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Persona> getUsuarios() {
        return usuarios;
    }
}
