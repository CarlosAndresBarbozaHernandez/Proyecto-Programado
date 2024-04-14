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
    private int contadorCanciones;

    // Constructor de la clase Playlist
    public Playlist(String name, int maxSize) {
        nombrePlaylist = name;
        playlist = new Cancion[maxSize];
        indice = 0;
        this.contadorCanciones = 0;
    }

    // Getters and Setters
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

    public int getContadorCanciones() {
        return this.contadorCanciones;
    }

    public void setContadorCanciones(int contador) {
        this.contadorCanciones = contador;
    }

    // Método para agregar una canción a la playlist
    public void agregarCancion(Cancion cancion, int i) {

        playlist[i] = cancion;
        contadorCanciones++;

    }

    // Método para obtener la ruta de una canción por índice
    public String getRutaCancion(int indice) {
        if (indice >= 0 && indice < this.contadorCanciones) {
            return playlist[indice].getRutaCancion();
        } else {
            //JOptionPane.showMessageDialog(null, "Índice de canción inválido.");
            return null;
        }
    }

    public void intercambiarCanciones(int indiceCancion1, int indiceCancion2) {

        // Verificar que los índices estén dentro del rango válido
        if (indiceCancion1 >= 0 && indiceCancion1 < contadorCanciones && indiceCancion2 >= 0 && indiceCancion2 < contadorCanciones) {
            // Intercambiar las canciones de posición en el array
            Cancion temp = playlist[indiceCancion1];

            playlist[indiceCancion1] = playlist[indiceCancion2];

            playlist[indiceCancion2] = temp;

        } else {
            
            // Mostrar un mensaje de error si los índices son inválidos
            System.err.println("Índices de canción inválidos.");
            
        }
    }

}
