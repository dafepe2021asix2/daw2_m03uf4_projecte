package Clases;

import Reserva_llibre_client.Genere;
import Reserva_llibre_client.Llibre;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ratpack.util.internal.PropertiesUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class CSVmetodos  {
    private ArrayList<Usuario> usuari = new ArrayList<>();

    private ArrayList<Llibre> llibre = new ArrayList<>();
    public  CSVmetodos( String path,String tipo) throws FileNotFoundException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            List<String[]> records = (List<String[]>) csvReader.readAll();
            for (String[] record : records) {
                switch (tipo){
                    case "usuari":

                        if(Boolean.parseBoolean(record[5])){
                            Usuari_admin usuario =  new Usuari_admin( record[0], record[1], Integer.parseInt(record[2]), record[3], record[4], Boolean.parseBoolean(record[5]));
                            usuari.add(usuario);
                        }
                        else{
                            Usuari_treballador usuario =  new Usuari_treballador( record[0], record[1], Integer.parseInt(record[2]), record[3], record[4], Boolean.parseBoolean(record[5]));
                            usuari.add(usuario);
                        }
                        break;
                    case "llibre":

                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date data = df.parse(record[1]);

                        LocalDate any_publicacio_localdate = LocalDate.ofInstant(data.toInstant(), ZoneId.systemDefault());

                        Genere genere = Genere.valueOf(record[4]);
                        llibre.add(new Llibre(record[0],any_publicacio_localdate,Boolean.parseBoolean(record[2]),record[3],genere ));
                        break;
                    default:
                        break;
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuari;
    }
}
