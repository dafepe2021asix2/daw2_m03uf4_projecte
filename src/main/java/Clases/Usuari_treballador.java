package Clases;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.util.Objects;
public class Usuari_treballador extends Persona{
    protected boolean es_cap;
    protected String password;

    public Usuari_treballador(String dni,String password){
        super();
        this.dni = dni;
        this.password = password;

    }


    public Usuari_treballador(String dni, String nomCognom, int telefon, String email, String password,boolean es_cap) {
        super(dni, nomCognom, telefon, email);
        this.password = password;
        this.es_cap = es_cap;
    }
    /*
    public Usuari_treballador(String dni,String password) {
        //super();
        this.dni = dni;
        this.password = password;
        //this.es_cap = es_cap;
    }
*/
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuari_treballador that = (Usuari_treballador) o;
        return Objects.equals(password, that.password) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), es_cap, password, dni);
    }
}
