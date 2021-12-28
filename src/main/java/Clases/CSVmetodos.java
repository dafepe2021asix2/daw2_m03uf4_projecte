package Clases;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVmetodos  {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    public  CSVmetodos( String path)  {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(path));
        ){
            CsvToBean<Usuari_treballador> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Usuari_treballador.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        System.out.println("Llega");
        List<Employee> list = csvToBean.parse(strategy, csvReader);
        Iterator<Usuari_treballador> csvUserIterator = csvToBean.iterator();
        System.out.println(csvUserIterator.toString());
        while (csvUserIterator.hasNext()) {
            System.out.println("DNI");
            Usuari_treballador csvUser = csvUserIterator.next();
            System.out.println("DNI : " + csvUser.getDni());
            System.out.println("Name : " + csvUser.getNomCognom());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("PhoneNo : " + csvUser.getTelefon());
            System.out.println("Pass : " + csvUser.getPassword());
            System.out.println("==========================");
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    public void getInfo() {

        System.out.println("DNI");

        Iterator<Usuari_treballador> csvUserIterator = csvToBean.iterator();
        System.out.println(csvUserIterator.toString());
        while (csvUserIterator.hasNext()) {
            System.out.println("DNI");
            Usuari_treballador csvUser = csvUserIterator.next();
            System.out.println("DNI : " + csvUser.getDni());
            System.out.println("Name : " + csvUser.getNomCognom());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("PhoneNo : " + csvUser.getTelefon());
            System.out.println("Pass : " + csvUser.getPassword());
            System.out.println("==========================");
        }

    }
    public ArrayList<Usuari_treballador> getUsuarios(){

        ArrayList<Usuari_treballador> lista = new ArrayList<>();
        Iterator<Usuari_treballador> csvUserIterator = csvToBean.iterator();
        while (csvUserIterator.hasNext()) {
            Usuari_treballador csvUser = csvUserIterator.next();
            System.out.println(csvUser.toString());
            lista.add(csvUser);

        }
        return lista;
    }*/
}
