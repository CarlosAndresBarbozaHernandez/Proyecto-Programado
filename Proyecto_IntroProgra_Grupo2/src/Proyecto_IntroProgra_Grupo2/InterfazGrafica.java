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

/**
 *
 * @author charlie
 */
public class InterfazGrafica extends javax.swing.JFrame {

    private int contadorPlaylists = 0; // Contador de playlists creadas
    private Playlist[] playlists = new Playlist[3]; // Array para almacenar las playlists creadas

    public InterfazGrafica() {
        initComponents();

        //Comando para centrar la interfaz cuando se ejecute el programa
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
        actualizarJListPlaylistCreadas();
    }

    private void actualizarJListPlaylistCreadas() {

        String[] nombresPlaylists = new String[3];

        for (int i = 0; i < 3; i++) {

            if (playlists[i] != null) {
                nombresPlaylists[i] = playlists[i].getNombrePlaylist();
            }
        }
        jListPlaylistCreadas.setListData(nombresPlaylists);
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
        textoPlaylist.setText("Playlist");

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

        jListPlaylistCreadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPlaylistCreadasMouseClicked(evt);
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

        botonAgregarCancion.setText("Agregar");

        botonEliminarPlaylist.setText("Eliminar");

        botonAgregarPlaylist.setText("Agregar");
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
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                    .addComponent(botonEliminarCancion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAgregarCancion))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonSiguienteCancion)
                            .addComponent(textoPlaylistCreadas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                    .addComponent(botonEliminarPlaylist)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAgregarPlaylist))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jTextFieldBarraDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
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
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPausarReproducirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarReproducirCancionActionPerformed
        // TODO add your handling code here:
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
            Playlist nuevaPlaylist = new Playlist(nombrePlaylist, 4);
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

    private void jListPlaylistCreadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPlaylistCreadasMouseClicked

        // Verificar si el evento es un doble clic
        if (evt.getClickCount() == 2) {
            // Obtener el índice del elemento seleccionado
            int index = jListPlaylistCreadas.getSelectedIndex();
            // Verificar si el índice es válido y reproducir la playlist correspondiente
            if (index != -1 && playlists[index] != null) {
                reproducirPlaylist(playlists[index]);
            }
        }


    }//GEN-LAST:event_jListPlaylistCreadasMouseClicked

    private void reproducirPlaylist(Playlist playlist) {
        // Obtener la lista de canciones de la playlist
        Cancion[] canciones = playlist.getPlaylist();
        // Recorrer la lista de canciones y reproducirlas una por una
        for (Cancion cancion : canciones) {
            if (cancion != null) {
                // Aquí debes implementar el código para reproducir la canción utilizando la librería jlayer
                // player.play(cancion.getRutaCancion()); // Suponiendo que player es una instancia de Player
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
