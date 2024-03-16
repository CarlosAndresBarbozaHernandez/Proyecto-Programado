/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_IntroProgra_Grupo2;

public class Cancion {
      
    //Atributos
    private String nombre, artista, album;

    //Constructor

    public Cancion(String nombre, String artista, String album) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;        
    }
        
    //Setters and Getters

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
    
}
