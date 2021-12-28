package Clases;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

abstract public class Persona implements Cloneable {
    @CsvBindByName
    protected String dni;
    @CsvBindByName
    protected String NomCognom;
    @CsvBindByName
    protected int telefon;
    @CsvBindByName
    protected String email;


    public Persona(){

    }
    public Persona(String dni, String nomCognom, int telefon, String email) {
        this.dni = dni;
        NomCognom = nomCognom;
        this.telefon = telefon;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public String getDni() {
        return dni;
    }

    public String getNomCognom() {
        return NomCognom;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }
}
