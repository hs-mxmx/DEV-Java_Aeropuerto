package Client;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Client_Launcher extends javax.swing.JFrame {
    /* Variables */
    private final int localPort = 5000;
    private final int max_Port = 65535;
    private final String localHost = "127.0.0.1";
    private final Color dark_Blue = new Color(0,153,255);
    private final Color dark_Gray = new Color(51,51,51);
    private final Color black = new Color(0,0,0);
    private final Color light_Gray = new Color(0,0,51);
    private boolean set_server, set_port, validIP = false;
    private String ip;
    private int port;

    /* Init jSwing Components */
    public Client_Launcher() {
        initComponents();
        jText_ip.setVisible(false);
        jText_port.setVisible(false);
    }
    
    /**
     * Method to return launchButton, to modify it in case we stablish connection
     * @return 
     */
    public JButton launchButton(){
        return dLaunch;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dSpaceStation = new javax.swing.JButton();
        dServer = new javax.swing.JButton();
        dPort = new javax.swing.JButton();
        dLaunch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jText_ip = new javax.swing.JTextField();
        jText_port = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dSpaceStation.setBackground(new java.awt.Color(0, 0, 0));
        dSpaceStation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SpaceStation.png"))); // NOI18N
        jPanel1.add(dSpaceStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 580, -1));

        dServer.setBackground(new java.awt.Color(0, 0, 0));
        dServer.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        dServer.setForeground(new java.awt.Color(0, 153, 255));
        dServer.setText("SERVER");
        dServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dServerActionPerformed(evt);
            }
        });
        jPanel1.add(dServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 180, 60));

        dPort.setBackground(new java.awt.Color(0, 0, 0));
        dPort.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        dPort.setForeground(new java.awt.Color(0, 153, 255));
        dPort.setText("PORT");
        dPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dPortActionPerformed(evt);
            }
        });
        jPanel1.add(dPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 170, 60));

        dLaunch.setBackground(new java.awt.Color(255, 0, 0));
        dLaunch.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        dLaunch.setText("LAUNCH");
        dLaunch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dLaunchActionPerformed(evt);
            }
        });
        jPanel1.add(dLaunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 280, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cohete.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 260, 270));

        jText_ip.setBackground(new java.awt.Color(51, 51, 51));
        jText_ip.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jText_ip.setForeground(new java.awt.Color(255, 255, 255));
        jText_ip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_ip.setText("Introduce IP");
        jText_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_ipActionPerformed(evt);
            }
        });
        jPanel1.add(jText_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, 40));

        jText_port.setBackground(new java.awt.Color(51, 51, 51));
        jText_port.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jText_port.setForeground(new java.awt.Color(255, 255, 255));
        jText_port.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_port.setText("Introduce Port");
        jText_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_portActionPerformed(evt);
            }
        });
        jPanel1.add(jText_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 150, 40));

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

    private void dServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dServerActionPerformed
        if(!set_server){
            set_server=true;
            set_port=false;
            dServer.setBackground(Color.gray);
            dServer.setForeground(Color.black);
            dPort.setForeground(dark_Blue);
            dPort.setBackground(black);
            jText_ip.setVisible(true);
            jText_port.setBackground(dark_Gray);
            jText_ip.setBackground(light_Gray);
        }else{
            set_server=false;
        }
    }//GEN-LAST:event_dServerActionPerformed

    private void dPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dPortActionPerformed
        if(!set_port){
            set_port=true;
            set_server=false;
            dPort.setBackground(Color.gray);
            dPort.setForeground(Color.black);
            dServer.setForeground(dark_Blue);
            dServer.setBackground(black);
            jText_port.setVisible(true);
            jText_ip.setBackground(dark_Gray);
            jText_port.setBackground(light_Gray);
        }else{
            set_port=false;
        }
    }//GEN-LAST:event_dPortActionPerformed

    private void dLaunchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dLaunchActionPerformed
        Client client = new Client();
        try{
            if(jText_ip.getText().contains("Introduce IP")){
                ip = localHost;
            }else{
                ip = jText_ip.getText();
            }
            if(jText_port.getText().contains("Introduce Port")){
                port = localPort;
            }else{
                port = Integer.parseInt(jText_port.getText());
            }
            if(port<0 || port >= max_Port) port = 5000;
            if(!validIP(ip)){
                JOptionPane.showMessageDialog(null,"Please, specify a valid data!", "Problem!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                validIP = true;
            }
            if(validIP){
                client.executeConnection(ip, port, dLaunch);
                dLaunch.setFont(new Font("", Font.BOLD, 14));
                dLaunch.setText("Waiting for connection... " + ip);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please, specify a valid data!", "Problem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_dLaunchActionPerformed

    private void jText_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_ipActionPerformed

    }//GEN-LAST:event_jText_ipActionPerformed

    private void jText_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_portActionPerformed

    }//GEN-LAST:event_jText_portActionPerformed

    /* Main */
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
            java.util.logging.Logger.getLogger(Client_Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_Launcher().setVisible(true);
            }
        });
    }
    
    /**
     * Method to validate introduced ip
     * @param ip String
     * @return 
     */
    public static boolean validIP (String ip) {
    try {
        if ( ip == null || ip.isEmpty() ) {
            return false;
        }
        String[] parts = ip.split( "\\." );
        if ( parts.length != 4 ) {
            return false;
        }
        for ( String s : parts ) {
            int i = Integer.parseInt( s );
            if ( (i < 0) || (i > 255) ) {
                return false;
            }
        }
        if ( ip.endsWith(".") ) {
            return false;
        }
        return true;
    } catch (NumberFormatException nfe) {
        return false;
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dLaunch;
    private javax.swing.JButton dPort;
    private javax.swing.JButton dServer;
    private javax.swing.JButton dSpaceStation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jText_ip;
    private javax.swing.JTextField jText_port;
    // End of variables declaration//GEN-END:variables
}
