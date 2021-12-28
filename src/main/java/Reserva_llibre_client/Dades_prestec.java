package Reserva_llibre_client;

import java.time.LocalDateTime;

public class Dades_prestec {
    private LocalDateTime data_prestec;
    Llibre llibre;
    Client_privat client_privat;

    public Dades_prestec(LocalDateTime data_prestec, Llibre llibre, Client_privat client_privat) {
        this.data_prestec = data_prestec;
        this.llibre = llibre;
        this.client_privat = client_privat;
    }
}
