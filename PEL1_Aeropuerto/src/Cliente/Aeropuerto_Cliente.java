package Cliente;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Aeropuerto_Cliente extends javax.swing.JFrame {

    private boolean servidor, puerto = false;
    private String port,ip;
    
    /* Aeropuerto_Cliente */
    public Aeropuerto_Cliente() {
        initComponents();
        jText_server.setVisible(false);
        jText_puerto.setVisible(false);
    }
    
    /* Boton Inicio */
    public JButton botonInicio(){
        return diniciar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dlogo = new javax.swing.JButton();
        dservidor = new javax.swing.JButton();
        dpuerto = new javax.swing.JButton();
        diniciar = new javax.swing.JButton();
        dcohete = new javax.swing.JLabel();
        jText_server = new javax.swing.JTextField();
        jText_puerto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dlogo.setBackground(new java.awt.Color(0, 0, 0));
        dlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SpaceStation.png"))); // NOI18N
        jPanel1.add(dlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 580, -1));

        dservidor.setBackground(new java.awt.Color(0, 0, 0));
        dservidor.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        dservidor.setForeground(new java.awt.Color(0, 153, 255));
        dservidor.setText("SERVIDOR");
        dservidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dservidorActionPerformed(evt);
            }
        });
        jPanel1.add(dservidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 180, 60));

        dpuerto.setBackground(new java.awt.Color(0, 0, 0));
        dpuerto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        dpuerto.setForeground(new java.awt.Color(0, 153, 255));
        dpuerto.setText("PUERTO");
        dpuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpuertoActionPerformed(evt);
            }
        });
        jPanel1.add(dpuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 170, 60));

        diniciar.setBackground(new java.awt.Color(255, 0, 0));
        diniciar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        diniciar.setText("INICIAR");
        diniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diniciarActionPerformed(evt);
            }
        });
        jPanel1.add(diniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 280, 60));

        dcohete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cohete.png"))); // NOI18N
        jPanel1.add(dcohete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 260, 270));

        jText_server.setBackground(new java.awt.Color(51, 51, 51));
        jText_server.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jText_server.setForeground(new java.awt.Color(255, 255, 255));
        jText_server.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_server.setText("Introduce IP");
        jText_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_serverActionPerformed(evt);
            }
        });
        jPanel1.add(jText_server, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, 40));

        jText_puerto.setBackground(new java.awt.Color(51, 51, 51));
        jText_puerto.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jText_puerto.setForeground(new java.awt.Color(255, 255, 255));
        jText_puerto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_puerto.setText("Introduce Puerto");
        jText_puerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_puertoActionPerformed(evt);
            }
        });
        jPanel1.add(jText_puerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dservidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dservidorActionPerformed
        if(!servidor){
            servidor=true;
            puerto=false;
            dservidor.setBackground(Color.gray);
            dservidor.setForeground(Color.black);
            dpuerto.setForeground(new Color(0,153,255));
            dpuerto.setBackground(new Color(0,0,0));
            jText_server.setVisible(true);
            jText_puerto.setBackground(new Color(51,51,51));
            jText_server.setBackground(new Color(0,0,51));
        }else{
            servidor=false;
        }
    }//GEN-LAST:event_dservidorActionPerformed

    private void dpuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpuertoActionPerformed
        if(!puerto){
            puerto=true;
            servidor=false;
            dpuerto.setBackground(Color.gray);
            dpuerto.setForeground(Color.black);
            dservidor.setForeground(new Color(0,153,255));
            dservidor.setBackground(new Color(0,0,0));
            jText_puerto.setVisible(true);
            jText_server.setBackground(new Color(51,51,51));
            jText_puerto.setBackground(new Color(0,0,51));
        }else{
            puerto=false;
        }
    }//GEN-LAST:event_dpuertoActionPerformed

    private void diniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diniciarActionPerformed
        Cliente cliente = new Cliente();
        //System.out.print("Introduce IP del servidor: [192.168.1.106 por defecto]: ");
        //System.out.print("Introduce puerto: [5000 por defecto]: ");
        if(jText_server.getText().contains("Introduce IP")){
            ip = "127.0.0.1";
        }else{
            ip = jText_server.getText();
        }
        if(jText_puerto.getText().contains("Introduce Puerto")){
            port = "5000";
        }else{
            port = jText_puerto.getText();
        }
        diniciar.setFont(new Font("", Font.BOLD, 14));
        diniciar.setText("Esperando al host " + ip);
        cliente.ejecutarConexion(ip, Integer.valueOf(port), diniciar);
    }//GEN-LAST:event_diniciarActionPerformed

    private void jText_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_serverActionPerformed
    }//GEN-LAST:event_jText_serverActionPerformed

    private void jText_puertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_puertoActionPerformed
    }//GEN-LAST:event_jText_puertoActionPerformed

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
            java.util.logging.Logger.getLogger(Aeropuerto_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aeropuerto_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aeropuerto_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aeropuerto_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aeropuerto_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dcohete;
    private javax.swing.JButton diniciar;
    private javax.swing.JButton dlogo;
    private javax.swing.JButton dpuerto;
    private javax.swing.JButton dservidor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jText_puerto;
    private javax.swing.JTextField jText_server;
    // End of variables declaration//GEN-END:variables
}
