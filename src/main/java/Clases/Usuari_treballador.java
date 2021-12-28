package Clases;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.util.Objects;
public class Usuari_treballador extends Usuario{


    public Usuari_treballador(String dni,String password){
        super(dni,password);
    }

    public Usuari_treballador(String dni, String nomCognom, int telefon, String email, String password,boolean es_cap) {
        super(dni, nomCognom, telefon, email,password,es_cap);
    }
}
