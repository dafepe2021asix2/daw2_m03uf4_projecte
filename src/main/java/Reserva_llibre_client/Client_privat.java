package Reserva_llibre_client;

import Clases.Persona;

public class Client_privat extends Persona {
    private String id_centro;
    private Dades_prestec dades_prestec;

    public Client_privat(String dni, String nomCognom, int telefon, String email, String id_centro) {
        super(dni, nomCognom, telefon, email);
        this.id_centro = id_centro;
    }

    public void setDades_prestec(Dades_prestec dades_prestec) {
        this.dades_prestec = dades_prestec;
    }
}
