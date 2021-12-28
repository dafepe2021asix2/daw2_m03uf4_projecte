package Clases;

import java.util.Objects;

public class Usuario {
    private String nombre,pass;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(pass, usuario.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pass);
    }

    @Override
    public String toString() {
        return "usuarios{" +
                "nombre='" + nombre + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
