package Servidor;

import java.awt.Color;
import java.awt.Font;
import Cliente.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Aeropuerto extends javax.swing.JFrame {
    private boolean remoto, local, ejecutado = false;
    private String puerto;
    private Consola_Cliente consola_cliente;
    private Consola consola_server;
    private Cliente cliente;
    private String local_host = "127.0.0.1";
    private Aeropuerto_Cliente aeropuerto_cliente;
    
    /* Aeropuerto */
    public Aeropuerto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ESPACIAL.png"))); // NOI18N
        jLabel19.setText("jLabel19");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 400, 330));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 420, 350));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SPACE-STATION.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 520, 70));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jButton1.setText("INICIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 260, 70));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 153, 255));
        jButton4.setText("REMOTO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 260, 50));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 255));
        jButton5.setText("LOCAL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 260, 50));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Es necesario un cliente");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 240, 60));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Se ejecuta via LocalHost");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 240, 60));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

        jLabel27.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("is still you get the wonderful sensation that you are");
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 75, 290, 60));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!remoto){
            remoto=true;
            local=false;
            jButton4.setBackground(Color.gray);
            jButton4.setForeground(Color.black);
            jButton5.setForeground(new Color(0,153,255));
            jButton5.setBackground(new Color(0,0,0));
            jTextField1.setText("'Introduce un puerto (5000)'");
            jTextField2.setText(("Se ejecuta via LocalHost"));
            jTextField1.setEditable(true);
            jTextField2.setEditable(false);
            jTextField1.setBackground(new Color(0,0,51));
            jTextField2.setBackground(new Color(51,51,51));
        }else{
            remoto=false;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(!local){
            local=true;
            remoto=false;
            jButton5.setBackground(Color.gray);
            jButton5.setForeground(Color.black);
            jButton4.setForeground(new Color(0,153,255));
            jButton4.setBackground(new Color(0,0,0));
            String cliente = ("Es necesario un cliente");
            jTextField1.setText(cliente);
            jTextField2.setText("'Introduce un puerto (5000)'");
            jTextField1.setEditable(false);
            jTextField2.setEditable(true);
            jTextField1.setBackground(new Color(51,51,51));
            jTextField2.setBackground(new Color(0,0,51));
        }else{
            local=false;
        }   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(remoto || local){
            Servidor servidor = new Servidor();
            if(remoto){
                 puerto = jTextField1.getText();
            }else{
                 puerto = jTextField2.getText();
            }
            if(puerto.contains("'Introduce un puerto (5000)'")){
                puerto = "5000";
                servidor.ejecutarConexion(Integer.parseInt(puerto), jButton1);
                jButton1.setForeground(new Color(255,255,255));
                jButton1.setBackground(new Color(0,0,51));
                jButton1.setFont(new Font("", Font.BOLD, 12));
                jButton1.setText("Esperando conexion en el puerto " + puerto);
                ejecutado = true;
            }
            int port = Integer.valueOf(puerto);
            if((port < 0 || port >= 65535)&& !ejecutado){
                if(puerto.length()<=0)puerto = "5000";
                servidor.ejecutarConexion(Integer.parseInt(puerto), jButton1);
                jButton1.setForeground(new Color(255,255,255));
                jButton1.setBackground(new Color(0,0,51));
                jButton1.setFont(new Font("", Font.BOLD, 12));
                jButton1.setText("Esperando conexion en el puerto " + puerto);
            }if(local){
                 Cliente client = new Cliente();
                 cliente = client;
                 Aeropuerto_Cliente aero_cliente = new Aeropuerto_Cliente();
                 aeropuerto_cliente = aero_cliente;
                 JButton boton_cliente = aeropuerto_cliente.botonInicio();
                 cliente.ejecutarConexion(local_host, Integer.valueOf(puerto), boton_cliente);
                 Consola_Cliente consola = new Consola_Cliente();
                 consola_cliente = consola;       
                 Consola consola_serv;
                try {
                    consola_serv = new Consola();
                    consola_server = consola_serv;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aeropuerto().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
