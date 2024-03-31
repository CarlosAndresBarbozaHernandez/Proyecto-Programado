/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_IntroProgra_Grupo2;

public class Cancion {

    // Atributos
    private String nombre, artista, album, rutaCancion;
    private int duracion;

    // Constructor
    public Cancion(String nombre, String artista, String album, String rutaCancion, int duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.rutaCancion = rutaCancion;
        this.duracion = duracion;
    }

    // Setters and Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getRutaCancion() {
        return rutaCancion;
    }

    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }
    
    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
