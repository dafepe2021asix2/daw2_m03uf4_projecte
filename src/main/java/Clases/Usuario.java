package Clases;

import java.util.Objects;

 abstract public class Usuario extends Persona {
     protected boolean es_cap;
     protected String password;


     public Usuario(String dni, String password) {
         super(dni);
         this.password = password;
     }


     public Usuario(String dni, String nomCognom, int telefon, String email, String password, boolean es_cap) {
         super(dni, nomCognom, telefon, email);
         this.es_cap = es_cap;
         this.password = password;
     }


     public boolean isEs_cap() {
         return es_cap;
     }

     public void setEs_cap(boolean es_cap) {
         this.es_cap = es_cap;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

 }



