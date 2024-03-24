/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_IntroProgra_Grupo2;

import javax.swing.JOptionPane;

/**
 *
 * @author charlie
 */

public class Playlist {
    
    //se supone que aqui va el metodo para crear las playlist 
    private String nombrePlaylist;
    private Cancion[] playlist;
    private int indice;

    // Constructor de la clase Playlist
    public Playlist(String name, int maxSize) {
        nombrePlaylist = name;        
        playlist = new Cancion[2];
        indice = 0;
    }
    
    //Getters and Setters

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public Cancion[] getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Cancion[] playlist) {
        this.playlist = playlist;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    
    // Método para agregar una canción a la playlist
    public void agregarCancion(String nombre, String artista, String album, String rutaCancion) {
        
        if (indice < playlist.length) {
            
            playlist[indice] = new Cancion(nombre, artista, album, rutaCancion);
            indice++;
            JOptionPane.showMessageDialog(null, "La canción se agregó correctamente a la playlist.");
            
        } else {
            
            JOptionPane.showMessageDialog(null, "La playlist está llena. No se pueden agregar más canciones.");
            
        }
    }
   
}
