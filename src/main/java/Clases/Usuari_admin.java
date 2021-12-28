package Clases;

import java.util.Objects;

public class Usuari_admin extends Usuario {

    public Usuari_admin(String dni,String password){
        super(dni,password);

    }

    public Usuari_admin(String dni, String nomCognom, int telefon, String email, String password , boolean es_cap) {
        super(dni, nomCognom, telefon, email,password,es_cap);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuari_admin that = (Usuari_admin) o;
        return Objects.equals(password, that.password) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password, dni);
    }
}
