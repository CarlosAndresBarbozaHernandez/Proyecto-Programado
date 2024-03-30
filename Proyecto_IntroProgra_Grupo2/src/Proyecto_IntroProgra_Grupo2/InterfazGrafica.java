/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto_IntroProgra_Grupo2;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author charlie
 */
public class InterfazGrafica extends javax.swing.JFrame {

    private int contadorPlaylists = 0; // Contador de playlists creadas
    private Playlist[] playlists = new Playlist[3]; // Array para almacenar las playlists creadas
    private Player player;
    private boolean isPlaying = false;
    private int indice;

    public InterfazGrafica() {
        initComponents();

        //Comando para centrar la interfaz cuando se ejecute el programa
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    // Este método establece las playlists en la interfaz y actualiza la lista de playlists creadas.
    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists; // Asigna el array de playlists recibido al atributo de la clase
        actualizarJListPlaylistCreadas(); // Llama al método para actualizar la lista de playlists en la interfaz
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoPlaylist.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        textoPlaylist.setText("Playlist general");

        botonRetrocederCancion.setText("Retroceder");

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

        jListPlaylist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPlaylist);

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

        botonEliminarPlaylist.setText("Eliminar");
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

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addGap(18, 18, 18)
                                    .addComponent(botonAgregarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonAgregarPlaylist))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botonSiguienteCancion))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoPlaylistCreadas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonEliminarPlaylist)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jTextFieldBarraDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
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
                    .addComponent(textoPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarCancion)
                    .addComponent(botonAgregarCancion)
                    .addComponent(botonEliminarPlaylist)
                    .addComponent(botonAgregarPlaylist))
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
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPausarReproducirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarReproducirCancionActionPerformed
        try {
            // Verifica si hay una playlist seleccionada y si la canción actual en la playlist no es nula
            if (playlists != null && playlists[indice] != null) {
                // Verifica si el reproductor ya está inicializado
                if (player != null) {
                    // Si la canción está en reproducción, la pausa
                    if (isPlaying) {
                        player.close();
                        isPlaying = false;
                    } else {
                        // Si la canción no está en reproducción, la inicia
                        String rutaCancion = playlists[indice].getRutaCancion(indice);
                        if (rutaCancion != null) {
                            player = new Player(new FileInputStream(rutaCancion));
                            // Inicia un hilo para reproducir la canción
                            new Thread(() -> {
                                try {
                                    player.play();
                                } catch (JavaLayerException ex) {
                                    Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }).start();
                            isPlaying = true; // Actualiza el estado de reproducción
                        } else {
                            System.out.println("No hay canción seleccionada.");
                        }
                    }
                } else {
                    // Si el reproductor no está inicializado, lo inicializa y comienza la reproducción
                    String rutaCancion = playlists[indice].getRutaCancion(indice);
                    if (rutaCancion != null) {
                        player = new Player(new FileInputStream(rutaCancion));
                        // Inicia un hilo para reproducir la canción
                        new Thread(() -> {
                            try {
                                player.play();
                            } catch (JavaLayerException ex) {
                                Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }).start();
                        isPlaying = true; // Actualiza el estado de reproducción
                    } else {
                        System.out.println("Ninguna canción seleccionada.");
                    }
                }
            } else {
                System.out.println("No hay una playlist seleccionada.");
            }
        } catch (FileNotFoundException | JavaLayerException ex) {
            // Maneja las excepciones de archivo no encontrado y de JavaLayer
            Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al reproducir la canción: " + ex.getMessage());
        }


    }//GEN-LAST:event_botonPausarReproducirCancionActionPerformed

    private void botonSiguienteCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSiguienteCancionActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPlaylistActionPerformed

        if (contadorPlaylists < 3) {// Verifica si ya se han creado tres playlists            

            String nombrePlaylist = JOptionPane.showInputDialog("Ingrese el nombre de la playlist:");

            Playlist nuevaPlaylist = new Playlist(nombrePlaylist, 3);

            playlists[contadorPlaylists] = nuevaPlaylist; // Almacena la playlist en el array

            String titulo = JOptionPane.showInputDialog("Ingrese el título de la canción:");
            String artista = JOptionPane.showInputDialog("Ingrese el artista de la canción:");
            String album = JOptionPane.showInputDialog("Ingrese el álbum de la canción:");

            JFileChooser fileChooserAgregarPlaylist = new JFileChooser();

            int result = fileChooserAgregarPlaylist.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooserAgregarPlaylist.getSelectedFile();
                String rutaDeLaCancion = selectedFile.getAbsolutePath();

                // Llama al método agregarCancion con los detalles de la canción y la ruta
                nuevaPlaylist.agregarCancion(titulo, artista, album, rutaDeLaCancion);

                System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());

                contadorPlaylists++; // Incrementa el contador de playlists creadas

                actualizarJListPlaylistCreadas();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Ya se han creado tres playlists. No se pueden crear más.");

        }

    }//GEN-LAST:event_botonAgregarPlaylistActionPerformed

    private void botonEliminarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPlaylistActionPerformed
        // Obtener la playlist seleccionada
        String nombrePlaylist = jListPlaylistCreadas.getSelectedValue();
        
        //Verificar si se seleccionó
        if (nombrePlaylist != null){
            //buscar la playlist
            for (int i = 0; i < playlists.length; i++){
               if (playlists[i] != null && nombrePlaylist.equals(playlists[i].getNombrePlaylist())){
                   //Eliminar la playlist
                   playlists[i] = null;
                   //Actulizar la lista
                   actualizarJListPlaylistCreadas();
                   //Mostrar mensaje de eliminación
                   JOptionPane.showMessageDialog(null, "La playlist se eliminó correctamente");
                   return; //Salir del bucle 
               }
            }
            //Mostrar un error
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una playlist");
        }else{
            //Mostrar solución
            JOptionPane.showMessageDialog(null, "Por favor seleccione una playlist para eliminar");
        }
    }//GEN-LAST:event_botonEliminarPlaylistActionPerformed

    private void botonEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCancionActionPerformed
        // todavia no puedo programarlo
    }//GEN-LAST:event_botonEliminarCancionActionPerformed

    private void reproducirPlaylist(Playlist playlist) throws FileNotFoundException, JavaLayerException {
        // Obtener la lista de canciones de la playlist
        Cancion[] canciones = playlist.getPlaylist();
        // Recorrer la lista de canciones y reproducirlas una por una
        for (Cancion cancion : canciones) {
            if (cancion != null) {
                // Crear una instancia de Player con la ruta de la canción actual
                player = new Player(new FileInputStream(cancion.getRutaCancion()));
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
                // Crear las playlists que desees
                Playlist[] playlists = new Playlist[3];
                interfaz.setPlaylists(playlists); // Pasar el array de playlists a la interfaz
                interfaz.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCancion;
    private javax.swing.JButton botonAgregarPlaylist;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminarCancion;
    private javax.swing.JButton botonEliminarPlaylist;
    private javax.swing.JButton botonPausarReproducirCancion;
    private javax.swing.JButton botonRetrocederCancion;
    private javax.swing.JButton botonSiguienteCancion;
    private javax.swing.JList<String> jListPlaylist;
    private javax.swing.JList<String> jListPlaylistCreadas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldBarraDeBusqueda;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel textoPlaylist;
    private javax.swing.JLabel textoPlaylistCreadas;
    // End of variables declaration//GEN-END:variables
}
