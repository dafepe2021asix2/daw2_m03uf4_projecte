package Reserva_llibre_client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import Clases.Producte;

public class Llibre extends Producte {
    private String isbn;
    private Genere tipus;
    private Dades_prestec dades_prestec;

    public Llibre( Genere tipus, LocalDate any_publicacio){
        this.tipus=tipus;
        this.any_publicacio=any_publicacio;
    };
    public Llibre(String titol, LocalDate any_publicacio, boolean disponibilitat, String isbn, Genere tipus) throws ParseException {
        super(titol, any_publicacio, disponibilitat);
        this.isbn = isbn;
        this.tipus = tipus;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTipus(Genere tipus) {
        this.tipus = tipus;
    }

    public void setDades_prestec(Dades_prestec dades_prestec) {
        this.dades_prestec = dades_prestec;
    }

    public String getIsbn() {
        return isbn;
    }

    public Genere getTipus() {
        return tipus;
    }

    public Dades_prestec getDades_prestec() {
        return dades_prestec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Llibre llibre = (Llibre) o;
        return Objects.equals(isbn, llibre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn);
    }

    @Override
    public String toString() {
        return String.format("%-40s %-13s %-10s %-15s %-10s",titol,any_publicacio,isbn,tipus,disponibilitat);
    }
    public String [] adaptarCSV() {
        return new String[] {titol, any_publicacio.toString(), String.valueOf(disponibilitat), isbn, tipus.toString()};
    }


}
