package Proyecto_IntroProgra_Grupo2;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

//Nuevas librerias para que funcione basicplayer
import org.apache.commons.logging.LogFactory;
import org.tritonus.share.sampled.file.TAudioFileFormat;

public class InterfazGrafica extends javax.swing.JFrame {

    private int contadorPlaylists = 0; // Contador de playlists creadas
    private Playlist playlistGeneral = new Playlist("Playlist General", 100);
    private Playlist[] playlists; // Array para almacenar las playlists creadas
    private BasicPlayer player; // Cambio a BasicPlayer
    private boolean isPlaying = false;

    public InterfazGrafica() {
        initComponents();

        //Comando para centrar la interfaz cuando se ejecute el programa
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    /*
    // Este método establece las playlists en la interfaz y actualiza la lista de playlists creadas.
    private void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists; // Asigna el array de playlists recibido al atributo de la clase
        actualizarJListPlaylistCreadas(); // Llama al método para actualizar la lista de playlists en la interfaz
    }
    */

    //Este metodo carga los playlist previamente creados.
    private void CargarPlaylists() {
        PersistenciaDatos leer = new PersistenciaDatos();

        String rutaDefecto = System.getProperty("user.home") + File.separator + "playlists.txt";
        Playlist[] tempPlaylist = leer.cargarPlaylists(rutaDefecto);

        if (tempPlaylist != null) {
            this.playlists = tempPlaylist;
            this.contadorPlaylists = leer.contador;
            actualizarJListPlaylistCreadas();
        } else {
            this.playlists = new Playlist[3];
            actualizarJListPlaylistCreadas();
        }
    }

// Este método actualiza la lista de playlists creadas en la interfaz gráfica.
    private void actualizarJListPlaylistCreadas() {
        String[] nombresPlaylists = new String[3]; // Array para almacenar los nombres de las playlists

        // Recorre el array de playlists
        for (int i = 0; i < 3; i++) {
            // Verifica si la playlist en la posición actual no es nula
            if (playlists[i] != null) {
                nombresPlaylists[i] = playlists[i].getNombrePlaylist(); // Obtiene el nombre de la playlist y lo asigna al array
            }
        }
        jListPlaylistCreadas.setListData(nombresPlaylists); // Actualiza la lista de playlists en la interfaz con los nombres obtenidos
    }

    private void actualizarJListPlaylist() {
        String[] nombresCanciones = new String[playlistGeneral.getContadorCanciones()]; // Array para almacenar los nombres de las canciones

        // Recorre el array de canciones
        for (int i = 0; i < playlistGeneral.getPlaylist().length; i++) {
            // Verifica si la cancion en la posición actual no es nula
            if (playlistGeneral.getPlaylist()[i] != null) {
                nombresCanciones[i] = playlistGeneral.getPlaylist()[i].getNombre(); // Obtiene el nombre de la cancion y lo asigna al array
            }
        }
        jListPlaylist.setListData(nombresCanciones); // Actualiza la lista de canciones en la interfaz con los nombres obtenidos
    }

    private void actualizarJListCanciones(Playlist pPlaylist) {
        if (pPlaylist != null) { // Verifica si pPlaylist no es null
            String[] nombresCanciones = new String[pPlaylist.getContadorCanciones()]; // Array para almacenar los nombres de las canciones
            int auxContador = pPlaylist.getContadorCanciones();
            int i = 0;

            // Recorre el array de canciones
            for (Cancion cancion : pPlaylist.getPlaylist()) {
                if (cancion != null) {
                    nombresCanciones[i] = cancion.getNombre(); // Obtiene el nombre de la canción y lo asigna al array
                    auxContador--;
                }
                i++;
            }

            jListCanciones.setListData(nombresCanciones); // Actualiza la lista de canciones en la interfaz con los nombres obtenidos
        } else {
            // Si pPlaylist es null, muestra un mensaje de error o realiza otra acción adecuada
            System.err.println("Error: pPlaylist es null");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        textoPlaylist = new javax.swing.JLabel();
        botonRetrocederCancion = new javax.swing.JButton();
        botonPausarReproducirCancion = new javax.swing.JButton();
        botonSiguienteCancion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPlaylist = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPlaylistCreadas = new javax.swing.JList<>();
        textoPlaylistCreadas = new javax.swing.JLabel();
        jTextFieldBarraDeBusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonEliminarCancion = new javax.swing.JButton();
        botonAgregarCancion = new javax.swing.JButton();
        botonEliminarPlaylist = new javax.swing.JButton();
        botonAgregarPlaylist = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCanciones = new javax.swing.JList<>();
        botonEliminarCancion2 = new javax.swing.JButton();
        botonAgregarCancion2 = new javax.swing.JButton();
        textoListaCanciones = new javax.swing.JLabel();
        botonSubirCancion = new javax.swing.JButton();
        botonBajarCancion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        textoPlaylist.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        textoPlaylist.setText("Playlist General");

        botonRetrocederCancion.setText("Retroceder");
        botonRetrocederCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetrocederCancionActionPerformed(evt);
            }
        });

        botonPausarReproducirCancion.setText("Pausar/Reproducir");
        botonPausarReproducirCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPausarReproducirCancionActionPerformed(evt);
            }
        });

        botonSiguienteCancion.setText("Siguiente");
        botonSiguienteCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteCancionActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListPlaylist);

        jListPlaylistCreadas.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jListPlaylistCreadasComponentAdded(evt);
            }
        });
        jListPlaylistCreadas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPlaylistCreadasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListPlaylistCreadas);

        textoPlaylistCreadas.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        textoPlaylistCreadas.setText("Playlist Creadas");

        jTextFieldBarraDeBusqueda.setText("Barra de busqueda");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonEliminarCancion.setText("Eliminar");
        botonEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCancionActionPerformed(evt);
            }
        });

        botonAgregarCancion.setText("Agregar Cancion");
        botonAgregarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCancionActionPerformed(evt);
            }
        });

        botonEliminarPlaylist.setText("Eliminar Playlist");
        botonEliminarPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPlaylistActionPerformed(evt);
            }
        });

        botonAgregarPlaylist.setText("Agregar Playlist");
        botonAgregarPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPlaylistActionPerformed(evt);
            }
        });

        jListCanciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jListCanciones);

        botonEliminarCancion2.setText("Eliminar Cancion");
        botonEliminarCancion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCancion2ActionPerformed(evt);
            }
        });

        botonAgregarCancion2.setText("Agregar Cancion");
        botonAgregarCancion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCancion2ActionPerformed(evt);
            }
        });

        textoListaCanciones.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        textoListaCanciones.setText("Lista Canciones");

        botonSubirCancion.setText("Subir Cancion");
        botonSubirCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSubirCancionActionPerformed(evt);
            }
        });

        botonBajarCancion.setText("Bajar Cancion");
        botonBajarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBajarCancionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jTextFieldBarraDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(botonRetrocederCancion)
                                .addGap(18, 18, 18)
                                .addComponent(botonPausarReproducirCancion))
                            .addComponent(textoPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                                    .addComponent(botonEliminarCancion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAgregarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botonSiguienteCancion)
                                .addContainerGap())
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(textoPlaylistCreadas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(205, 205, 205)
                                        .addComponent(textoListaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(150, 150, 150))
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(85, 85, 85)
                                                .addComponent(jScrollPane3))
                                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addComponent(botonEliminarPlaylist)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonAgregarPlaylist)
                                                .addGap(85, 85, 85)
                                                .addComponent(botonEliminarCancion2)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonAgregarCancion2)))
                                        .addGap(46, 46, 46)
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonSubirCancion)
                                            .addComponent(botonBajarCancion))
                                        .addGap(0, 20, Short.MAX_VALUE))))))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBarraDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoPlaylistCreadas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoListaCanciones))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(botonSubirCancion)
                        .addGap(32, 32, 32)
                        .addComponent(botonBajarCancion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonEliminarCancion)
                        .addComponent(botonEliminarPlaylist)
                        .addComponent(botonAgregarPlaylist)
                        .addComponent(botonEliminarCancion2)
                        .addComponent(botonAgregarCancion2))
                    .addComponent(botonAgregarCancion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRetrocederCancion)
                    .addComponent(botonPausarReproducirCancion)
                    .addComponent(botonSiguienteCancion))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPausarReproducirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarReproducirCancionActionPerformed

        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex();
        int indiceCancion = jListCanciones.getSelectedIndex();

        try {
            if (playlists != null && playlists[indicePlaylist] != null) {
                if (player != null) {
                    if (isPlaying) {
                        player.pause(); // Pausa la canción
                        isPlaying = false;
                    } else {
                        String rutaCancion = playlists[indicePlaylist].getRutaCancion(indiceCancion);
                        if (rutaCancion != null) {
                            // Inicia la reproducción de la canción
                            player.open(new File(rutaCancion));
                            player.play();
                            isPlaying = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay canción seleccionada.", "Seleccionar Cancion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    String rutaCancion = playlists[indicePlaylist].getRutaCancion(indiceCancion);
                    if (rutaCancion != null) {
                        player = new BasicPlayer();
                        player.open(new File(rutaCancion));
                        player.play();
                        isPlaying = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ninguna canción seleccionada.", "Seleccionar Cancion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay una playlist seleccionada.", "Seleccionar Playlist", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (BasicPlayerException ex) {
            // Maneja las excepciones de BasicPlayer
            Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al reproducir la canción: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonPausarReproducirCancionActionPerformed

    private void botonSiguienteCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteCancionActionPerformed
        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex(); // Get the index of the selected playlist
        int indiceCancionActual = jListCanciones.getSelectedIndex(); // Get the index of the currently selected song

        // Check if there is a selected playlist and a selected song
        if (indicePlaylist != -1 && indiceCancionActual != -1) {
            // Check if there is a next song in the playlist
            if (indiceCancionActual + 1 < playlists[indicePlaylist].getContadorCanciones()) {
                // Get the index of the next song
                int indiceSiguienteCancion = indiceCancionActual + 1;
                // Update the selected index in the song list
                jListCanciones.setSelectedIndex(indiceSiguienteCancion);

                try {
                    // Pause the current song if it's playing
                    if (isPlaying) {
                        player.pause();
                        isPlaying = false;
                    }
                    // Get the path of the next song
                    String rutaCancion = playlists[indicePlaylist].getRutaCancion(indiceSiguienteCancion);
                    // Open and play the next song
                    player.open(new File(rutaCancion));
                    player.play();
                    isPlaying = true;
                } catch (BasicPlayerException ex) {
                    // Handle BasicPlayerException
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al reproducir la siguiente canción: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // If there is no next song, show a message
                JOptionPane.showMessageDialog(null, "No hay más canciones en la lista.", "Fin de la lista", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // If no playlist or song is selected, show a message
            JOptionPane.showMessageDialog(null, "Por favor selecciona una playlist y una canción.", "Selección requerida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonSiguienteCancionActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String textoBusqueda = jTextFieldBarraDeBusqueda.getText();

        boolean encontrado = false;
        for (Playlist playlist : playlists) {
            if (playlist != null) {

                if (playlist.getNombrePlaylist().equalsIgnoreCase(textoBusqueda)) {
                    JOptionPane.showMessageDialog(null, "La lista de reproducción '" + playlist.getNombrePlaylist() + "' fue encontrada.");
                    encontrado = true;
                    break;
                }

                for (Cancion cancion : playlist.getPlaylist()) {
                    if (cancion != null) {

                        if (cancion.getNombre().equalsIgnoreCase(textoBusqueda) || cancion.getArtista().equalsIgnoreCase(textoBusqueda)) {
                            JOptionPane.showMessageDialog(null, "La canción '" + cancion.getNombre() + "' fue encontrada en la playlist '" + playlist.getNombrePlaylist() + "'.");
                            encontrado = true;
                            break;
                        }
                    }
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias para '" + textoBusqueda + "'.");
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPlaylistActionPerformed

        if (contadorPlaylists < 3) {// Verifica si ya se han creado tres playlists            

            String nombrePlaylist = JOptionPane.showInputDialog("Ingrese el nombre de la playlist:");

            Playlist nuevaPlaylist = new Playlist(nombrePlaylist, 3);

            int aux = JOptionPane.showConfirmDialog(null, "Desea Agregar Canciones al Playlist", "Agregar Cancion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            while (aux == 0) {

                this.AgregarCancion(nuevaPlaylist);
                this.actualizarJListCanciones(nuevaPlaylist);
                aux = JOptionPane.showConfirmDialog(null, "Desea Agregar otra Cancion al Playlist?", "Agregar Cancion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            }

            for (int i = 0; i < playlists.length; i++) {
                if (playlists[i] == null) {
                    playlists[i] = nuevaPlaylist; // Almacena la playlist en el array
                    break;
                }
            }
            contadorPlaylists++; // Incrementa el contador de playlists creadas

            actualizarJListPlaylistCreadas();

        } else {

            JOptionPane.showMessageDialog(null, "Ya se han creado tres playlists. No se pueden crear más.");

        }

    }//GEN-LAST:event_botonAgregarPlaylistActionPerformed

    private void botonEliminarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPlaylistActionPerformed

        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex();

        if (indicePlaylist != -1) {
            Playlist playlistEliminar = playlists[indicePlaylist];

            if (playlistEliminar != null) {
                playlists[indicePlaylist] = null;
                contadorPlaylists--; // Se disminuye el contador de playlists
                String[] listaVacia = new String[1];
                jListCanciones.setListData(listaVacia);
                JOptionPane.showMessageDialog(null, "La playlist se eliminó correctamente.");
                botonAgregarPlaylist.setEnabled(true);
                actualizarJListPlaylistCreadas();
            } else {

                JOptionPane.showMessageDialog(null, "La playlist seleccionada no existe.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una playlist para eliminar.");
        }
    }//GEN-LAST:event_botonEliminarPlaylistActionPerformed

    private void botonEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCancionActionPerformed
        // Obtener la playlist seleccionada
        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex();
        // Obtener la canción seleccionada
        int indiceCancion = jListCanciones.getSelectedIndex();
        // Verificar si se seleccionó una playlist y una canción
        if (indicePlaylist != -1 && indiceCancion != -1) {
            // Obtener la playlist correspondiente al índice seleccionado
            Playlist playlistSeleccionada = playlists[indicePlaylist];
            // Obtener la canción seleccionada en la playlist
            Cancion cancionEliminar = playlistSeleccionada.getPlaylist()[indiceCancion];
            int contador = playlistSeleccionada.getContadorCanciones();
            // Verificar si la canción existe en la playlist
            if (cancionEliminar != null) {
                // Eliminar la canción de la playlist
                playlistSeleccionada.getPlaylist()[indiceCancion] = null;
                // Actualizar la lista de canciones en la interfaz
                actualizarJListCanciones(playlistSeleccionada);
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(null, "La canción se eliminó correctamente de la playlist.");
                contador--;
                playlistSeleccionada.setContadorCanciones(contador);
            } else {
                // Mostrar un mensaje de error si no se encontró la canción
                JOptionPane.showMessageDialog(null, "La canción seleccionada no existe en la playlist.");
            }
        } else {
            // Mostrar un mensaje si no se seleccionó ninguna playlist o canción
            JOptionPane.showMessageDialog(null, "Por favor selecciona una playlist y una canción para eliminar.");
        }
    }//GEN-LAST:event_botonEliminarCancionActionPerformed

    private void botonAgregarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCancionActionPerformed

        this.AgregarCancion(this.playlistGeneral);
        this.actualizarJListPlaylist();

    }//GEN-LAST:event_botonAgregarCancionActionPerformed

    private void botonAgregarCancion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCancion2ActionPerformed

        int index = jListPlaylistCreadas.getSelectedIndex();
        this.AgregarCancion(playlists[index]);
        this.actualizarJListCanciones(playlists[index]);

    }//GEN-LAST:event_botonAgregarCancion2ActionPerformed

    private void botonEliminarCancion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCancion2ActionPerformed
        // Obtener la playlist seleccionada
        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex();
        // Obtener la canción seleccionada
        int indiceCancion = jListCanciones.getSelectedIndex();
        // Verificar si se seleccionó una playlist y una canción
        if (indicePlaylist != -1 && indiceCancion != -1) {
            // Obtener la playlist correspondiente al índice seleccionado
            Playlist playlistSeleccionada = playlists[indicePlaylist];
            // Obtener la canción seleccionada en la playlist
            Cancion cancionEliminar = playlistSeleccionada.getPlaylist()[indiceCancion];
            int contador = playlistSeleccionada.getContadorCanciones();
            // Verificar si la canción existe en la playlist
            if (cancionEliminar != null) {
                // Eliminar la canción de la playlist
                playlistSeleccionada.getPlaylist()[indiceCancion] = null;
                // Actualizar la lista de canciones en la interfaz
                actualizarJListCanciones(playlistSeleccionada);
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(null, "La canción se eliminó correctamente de la playlist.");
                contador--;
                playlistSeleccionada.setContadorCanciones(contador);
            } else {
                // Mostrar un mensaje de error si no se encontró la canción
                JOptionPane.showMessageDialog(null, "La canción seleccionada no existe en la playlist.");
            }
        } else {
            // Mostrar un mensaje si no se seleccionó ninguna playlist o canción
            JOptionPane.showMessageDialog(null, "Por favor selecciona una playlist y una canción para eliminar.");
        }
    }//GEN-LAST:event_botonEliminarCancion2ActionPerformed

    private void jListPlaylistCreadasComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jListPlaylistCreadasComponentAdded

        //Se actualiza el JListCanciones cuando se agrega un nuevo playlist.
        this.actualizarJListCanciones(playlists[jListPlaylistCreadas.getSelectedIndex()]);

    }//GEN-LAST:event_jListPlaylistCreadasComponentAdded

    private void jListPlaylistCreadasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPlaylistCreadasValueChanged

        int index = jListPlaylistCreadas.getSelectedIndex();
        this.actualizarJListCanciones(playlists[index]);
        jListCanciones.setSelectedIndex(0);

    }//GEN-LAST:event_jListPlaylistCreadasValueChanged

    private void botonRetrocederCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetrocederCancionActionPerformed
        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex(); // Obtener el índice de la playlist seleccionada
        int indiceCancionActual = jListCanciones.getSelectedIndex(); // Obtener el índice de la canción actualmente seleccionada

        // Verificar si hay una playlist seleccionada y una canción seleccionada
        if (indicePlaylist != -1 && indiceCancionActual != -1) {
            // Verificar si hay una canción anterior en la playlist
            if (indiceCancionActual - 1 >= 0) {
                // Obtener el índice de la canción anterior
                int indiceCancionAnterior = indiceCancionActual - 1;
                // Actualizar el índice seleccionado en la lista de canciones
                jListCanciones.setSelectedIndex(indiceCancionAnterior);

                try {
                    // Pausar la canción actual si se está reproduciendo
                    if (isPlaying) {
                        player.pause();
                        isPlaying = false;
                    }
                    // Obtener la ruta de la canción anterior
                    String rutaCancion = playlists[indicePlaylist].getRutaCancion(indiceCancionAnterior);
                    // Abrir y reproducir la canción anterior
                    player.open(new File(rutaCancion));
                    player.play();
                    isPlaying = true;
                } catch (BasicPlayerException ex) {
                    // Manejar BasicPlayerException
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al reproducir la canción anterior: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si no hay una canción anterior, mostrar un mensaje
                JOptionPane.showMessageDialog(null, "Ya estás en la primera canción de la lista.", "Inicio de la lista", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Si no hay playlist o canción seleccionada, mostrar un mensaje
            JOptionPane.showMessageDialog(null, "Por favor selecciona una playlist y una canción.", "Selección requerida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonRetrocederCancionActionPerformed

    private void botonSubirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSubirCancionActionPerformed

        // Obtener el índice de la canción seleccionada
        int indiceCancion = jListCanciones.getSelectedIndex();

        // Obtener la playlist seleccionada
        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex();

        if (indicePlaylist != -1 && indiceCancion != -1) {

            // Obtener la playlist correspondiente al índice seleccionado
            Playlist playlistSeleccionada = playlists[indicePlaylist];

            // Verificar si la canción seleccionada no es la primera en la lista
            if (indiceCancion > 0) {

                // Intercambiar la canción seleccionada con la anterior
                playlistSeleccionada.intercambiarCanciones(indiceCancion, indiceCancion - 1);

                // Actualizar la lista de canciones en la interfaz gráfica
                actualizarJListCanciones(playlistSeleccionada);

                // Seleccionar la canción que se movió
                jListCanciones.setSelectedIndex(indiceCancion - 1);

            } else {

                // Mostrar un mensaje si la canción ya está en la primera posición
                JOptionPane.showMessageDialog(null, "La canción ya está en la primera posición.");

            }
        }

    }//GEN-LAST:event_botonSubirCancionActionPerformed

    private void botonBajarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBajarCancionActionPerformed

        // Obtener el índice de la canción seleccionada
        int indiceCancion = jListCanciones.getSelectedIndex();

        // Obtener la playlist seleccionada
        int indicePlaylist = jListPlaylistCreadas.getSelectedIndex();

        if (indicePlaylist != -1 && indiceCancion != -1) {

            // Obtener la playlist correspondiente al índice seleccionado
            Playlist playlistSeleccionada = playlists[indicePlaylist];

            // Verificar si la canción seleccionada no es la última en la lista
            if (indiceCancion < playlistSeleccionada.getContadorCanciones() - 1) {

                // Intercambiar la canción seleccionada con la siguiente
                playlistSeleccionada.intercambiarCanciones(indiceCancion, indiceCancion + 1);

                // Actualizar la lista de canciones en la interfaz gráfica
                actualizarJListCanciones(playlistSeleccionada);

                // Seleccionar la canción que se movió
                jListCanciones.setSelectedIndex(indiceCancion + 1);

            } else {

                // Mostrar un mensaje si la canción ya está en la última posición
                JOptionPane.showMessageDialog(null, "La canción ya está en la última posición.");

            }
        }

    }//GEN-LAST:event_botonBajarCancionActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        PersistenciaDatos guardar = new PersistenciaDatos();
        String rutaDefecto = System.getProperty("user.home") + File.separator + "playlists.txt";
        guardar.guardarPlaylists(this.playlists, rutaDefecto);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void AgregarCancion(Playlist pPlaylist) {

        if (pPlaylist.getContadorCanciones() < pPlaylist.getPlaylist().length) {// Se valida si en el playlist hay espacios para nuevas canciones.

            //Logica para seleccionar el archivo de musica.
            JFileChooser seleccionarArchivo = new JFileChooser();

            int result = seleccionarArchivo.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {

                File cancionFile = seleccionarArchivo.getSelectedFile();

                //Se extraen los metadatos de la cancion
                String titulo = "";
                String artista = "";
                String album = "";
                String rutaCancion = cancionFile.getAbsolutePath();
                int duracion = 0;
                try {
                    AudioFile archivoCancion = AudioFileIO.read(cancionFile);
                    Tag tag = archivoCancion.getTag();
                    titulo = tag.getFirst(FieldKey.TITLE);
                    artista = tag.getFirst(FieldKey.ARTIST);
                    album = tag.getFirst(FieldKey.ALBUM);
                    duracion = archivoCancion.getAudioHeader().getTrackLength();

                } catch (Exception e) {
                    System.out.println(e);;
                }

                /*
                Hay canciones que no tienen nombre en los metadatos, 
                en estos casosutilizamos el nombre del archivo como nombre de la cancion.
                 */
                if (titulo.equals("")) {
                    titulo = cancionFile.getName();
                }

                //Logica para agregar la cancion a la playlist.
                for (int i = 0; i < pPlaylist.getPlaylist().length; i++) {

                    if (pPlaylist.getPlaylist()[i] == null) {
                        Cancion cancion = new Cancion(titulo, artista, album, rutaCancion, duracion);
                        pPlaylist.agregarCancion(cancion, i);
                        JOptionPane.showMessageDialog(null, "La canción se agregó correctamente a la playlist.");
                        break;
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "La playlist está llena. No se pueden agregar más canciones.");
        }

    }

    private void reproducirPlaylist(Playlist playlist) throws FileNotFoundException, JavaLayerException, BasicPlayerException {
        // Obtener la lista de canciones de la playlist
        Cancion[] canciones = playlist.getPlaylist();
        // Recorrer la lista de canciones y reproducirlas una por una
        for (Cancion cancion : canciones) {
            if (cancion != null) {
                // Crear una instancia de Player con la ruta de la canción actual
                //player = new Player(new FileInputStream(cancion.getRutaCancion()));
                player = new BasicPlayer();
                player.open(new File(cancion.getRutaCancion()));
                player.play(); // Reproducir la canción
                // Nota: Debes tener en cuenta cómo gestionar la reproducción de múltiples canciones de forma secuencial o simultánea según tu requerimiento.
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                InterfazGrafica interfaz = new InterfazGrafica();
                interfaz.CargarPlaylists(); // Se cargan los playlists del .txt
                interfaz.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCancion;
    private javax.swing.JButton botonAgregarCancion2;
    private javax.swing.JButton botonAgregarPlaylist;
    private javax.swing.JButton botonBajarCancion;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminarCancion;
    private javax.swing.JButton botonEliminarCancion2;
    private javax.swing.JButton botonEliminarPlaylist;
    private javax.swing.JButton botonPausarReproducirCancion;
    private javax.swing.JButton botonRetrocederCancion;
    private javax.swing.JButton botonSiguienteCancion;
    private javax.swing.JButton botonSubirCancion;
    private javax.swing.JList<String> jListCanciones;
    private javax.swing.JList<String> jListPlaylist;
    private javax.swing.JList<String> jListPlaylistCreadas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldBarraDeBusqueda;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel textoListaCanciones;
    private javax.swing.JLabel textoPlaylist;
    private javax.swing.JLabel textoPlaylistCreadas;
    // End of variables declaration//GEN-END:variables
}
