/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_IntroProgra_Grupo2;

/**
 *
 * @author Erson Segura
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaDatos {

    public int contador;

    public void guardarPlaylists(Playlist[] pPlaylists, String pRutaArchivo) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(pRutaArchivo));
            for (int i = 0; i < pPlaylists.length; i++) {
                if (pPlaylists[i] != null) {
                    Playlist playlist = pPlaylists[i];
                    writer.write(playlist.getNombrePlaylist() + ",");
                    writer.write(playlist.getIndice() + ",");
                    writer.write(playlist.getContadorCanciones() + "\n");

                    for (int j = 0; j < playlist.getPlaylist().length; j++) {
                        Cancion cancion = playlist.getPlaylist()[j];
                        if (cancion != null) {
                            writer.write(cancion.getNombre() + ",");
                            writer.write(cancion.getArtista() + ",");
                            writer.write(cancion.getAlbum() + ",");
                            writer.write(cancion.getRutaCancion() + ",");
                            writer.write(cancion.getDuracion() + "\n");
                        }
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Playlist[] cargarPlaylists(String pRutaArchivo) {
        Playlist[] playlists = new Playlist[5];
        contador = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pRutaArchivo));
            String linea = reader.readLine();
            while (linea != null) {
                String[] infoPlaylist = linea.split(",");
                Playlist playlist = new Playlist(infoPlaylist[0], Integer.parseInt(infoPlaylist[1]), Integer.parseInt(infoPlaylist[2]), 3);
                int aux = playlist.getContadorCanciones();
                while ((linea = reader.readLine()) != null && !linea.isEmpty() && aux != 0) {

                    String[] infoCancion = linea.split(",");
                    Cancion cancion = new Cancion(infoCancion[0], infoCancion[1], infoCancion[2], infoCancion[3], Integer.parseInt(infoCancion[4]));

                    for (int i = 0; i < playlist.getContadorCanciones(); i++) {
                        if (playlist.getPlaylist()[i] == null) {
                            playlist.getPlaylist()[i] = cancion;
                            aux--;
                            break;
                        }
                    }
                }
                playlists[contador] = playlist;
                contador++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return playlists;
    }
}
