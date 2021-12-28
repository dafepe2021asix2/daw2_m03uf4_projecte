package Reserva_llibre_client;

import java.time.LocalDate;
import java.util.Objects;

import Clases.Producte;

public class Llibre extends Producte {
    private String isbn;
    private Genere tipus;
    private Dades_prestec dades_prestec;


    public Llibre(String titol, LocalDate any_publicacio, boolean disponibilitat, String isbn, Genere tipus) {
        super(titol, any_publicacio, disponibilitat);
        this.isbn = isbn;
        this.tipus = tipus;
    }

    public void setDades_prestec(Dades_prestec dades_prestec) {
        this.dades_prestec = dades_prestec;
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
}
