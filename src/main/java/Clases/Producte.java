package Clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Objects;

abstract public class Producte implements Cloneable {



    protected String titol;
    protected LocalDate any_publicacio;
    protected boolean disponibilitat;

    public Producte(){};
    public Producte(String titol, LocalDate any_publicacio, boolean disponibilitat) {
        this.titol = titol;
        this.any_publicacio = any_publicacio;
        this.disponibilitat = disponibilitat;
    }
    protected boolean comprobar_disponibilitat(){
        return this.disponibilitat;
    }
    protected void cambiar_disponibilitat(){
        this.disponibilitat=!this.disponibilitat;
    }


    public String getTitol() {
        return titol;
    }

    public String getAny_publicacio() {
        System.out.println("Fecha: "+String.valueOf(any_publicacio));
        return String.valueOf(any_publicacio);
    }



    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAny_publicacio(String any_publicacio) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate  d1 = LocalDate.parse(any_publicacio, df);
        System.out.println("La fecha es"+ d1.toString());
        this.any_publicacio = d1;
    }

    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    @Override
    public String toString() {
        return "Clases.Producte{" +
                "titol='" + titol + '\'' +
                ", any_publicacio=" + any_publicacio +
                ", disponibilitat=" + disponibilitat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producte producte = (Producte) o;
        return Objects.equals(titol, producte.titol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titol);
    }
}
