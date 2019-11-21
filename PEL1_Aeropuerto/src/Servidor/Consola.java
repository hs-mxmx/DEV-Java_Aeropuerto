package Servidor;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Consola extends javax.swing.JFrame {

    private boolean  botonEmp1 , botonEmp2, botonEmpleados, informe_maletas, informe_historial = false;
    private Paso paso = new Paso();
    Cinta cinta = new Cinta();
    Avion avion = new Avion();
    private File historial_general = new File ("Historiales/Historial.txt");
    private File historial_maletas = new File ("Historiales/Maletas.txt");
    

    /* Consola */
    public Consola() throws InterruptedException {
        initComponents();
        
        for(int i = 0; i < 40; i++){
            Pasajero pasajero = new Pasajero("Pasajero " + i, cinta, jText_total_pasajeros, dnum_pasajeros, dnum_maletasCinta, 
                    paso, jLabel8, jTextArea4, jText_total_maletascinta, dnum_completos, estado_cinta);
            pasajero.start();
            if(i<2){
                Empleado empleado = new Empleado(cinta, avion, jTextArea2, jTextArea3, dnum_pasajeros, 
                        dnum_maletasCinta, dnum_maletasRecogidas, dnum_maletasAvion, paso, jLabel8, jText_total_maletascinta, 
                        jTextArea7, dnum_emp1, dnum_emp2, demp1, demp2, estado_cinta);
                if(i==1){
                    empleado.setNombre("Dani");
                }else{
                    empleado.setNombre("Jorge");
                }
                empleado.start();   
            }   
        }
    }
    
    public JButton getTotalPasajeros(){
        return dnum_pasajeros;
    }
    
    public void setTotalPasajeros(String texto){
        dnum_pasajeros.setText(texto);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dtotal_pasajeros = new javax.swing.JButton();
        dtotal_maletasRecogidas = new javax.swing.JButton();
        dmaletas_avion = new javax.swing.JButton();
        dcompletados = new javax.swing.JButton();
        dtotal_maletasCinta = new javax.swing.JButton();
        dnum_pasajeros = new javax.swing.JButton();
        dnum_maletasCinta = new javax.swing.JButton();
        dnum_maletasRecogidas = new javax.swing.JButton();
        dnum_emp1 = new javax.swing.JButton();
        dnum_emp2 = new javax.swing.JButton();
        demp1 = new javax.swing.JButton();
        demp2 = new javax.swing.JButton();
        dnum_maletasAvion = new javax.swing.JButton();
        dnum_completos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_total_pasajeros = new javax.swing.JTextArea();
        emp1 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        emp2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jText_total_maletascinta = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        empleados = new javax.swing.JButton();
        finformeGeneral = new javax.swing.JButton();
        estado_cinta = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        finformeMaletas = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dtotal_pasajeros.setBackground(new java.awt.Color(0, 0, 51));
        dtotal_pasajeros.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        dtotal_pasajeros.setForeground(new java.awt.Color(0, 255, 255));
        dtotal_pasajeros.setText("Total pasajeros");
        dtotal_pasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtotal_pasajerosActionPerformed(evt);
            }
        });
        jPanel2.add(dtotal_pasajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 230, 40));

        dtotal_maletasRecogidas.setBackground(new java.awt.Color(0, 0, 51));
        dtotal_maletasRecogidas.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        dtotal_maletasRecogidas.setForeground(new java.awt.Color(0, 255, 255));
        dtotal_maletasRecogidas.setText("Total Maletas Recogidas");
        jPanel2.add(dtotal_maletasRecogidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 240, 40));

        dmaletas_avion.setBackground(new java.awt.Color(0, 0, 51));
        dmaletas_avion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dmaletas_avion.setForeground(new java.awt.Color(0, 255, 255));
        dmaletas_avion.setText("Maletas Avion");
        dmaletas_avion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dmaletas_avionActionPerformed(evt);
            }
        });
        jPanel2.add(dmaletas_avion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, 40));

        dcompletados.setBackground(new java.awt.Color(0, 0, 51));
        dcompletados.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dcompletados.setForeground(new java.awt.Color(0, 255, 255));
        dcompletados.setText("Completos");
        jPanel2.add(dcompletados, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, 130, 40));

        dtotal_maletasCinta.setBackground(new java.awt.Color(0, 0, 51));
        dtotal_maletasCinta.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        dtotal_maletasCinta.setForeground(new java.awt.Color(0, 255, 255));
        dtotal_maletasCinta.setText("Total Maletas en Cinta");
        dtotal_maletasCinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtotal_maletasCintaActionPerformed(evt);
            }
        });
        jPanel2.add(dtotal_maletasCinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 230, 40));

        dnum_pasajeros.setBackground(new java.awt.Color(0, 51, 51));
        dnum_pasajeros.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_pasajeros.setForeground(new java.awt.Color(0, 255, 255));
        dnum_pasajeros.setText("0");
        jPanel2.add(dnum_pasajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 60, 40));

        dnum_maletasCinta.setBackground(new java.awt.Color(0, 51, 51));
        dnum_maletasCinta.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_maletasCinta.setForeground(new java.awt.Color(0, 255, 255));
        dnum_maletasCinta.setText("0");
        jPanel2.add(dnum_maletasCinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 60, 40));

        dnum_maletasRecogidas.setBackground(new java.awt.Color(0, 51, 51));
        dnum_maletasRecogidas.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_maletasRecogidas.setForeground(new java.awt.Color(0, 255, 255));
        dnum_maletasRecogidas.setText("0");
        jPanel2.add(dnum_maletasRecogidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 60, 40));

        dnum_emp1.setBackground(new java.awt.Color(0, 51, 51));
        dnum_emp1.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_emp1.setForeground(new java.awt.Color(0, 255, 255));
        dnum_emp1.setText("0");
        jPanel2.add(dnum_emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 50, 40));

        dnum_emp2.setBackground(new java.awt.Color(0, 51, 51));
        dnum_emp2.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_emp2.setForeground(new java.awt.Color(0, 255, 255));
        dnum_emp2.setText("0");
        jPanel2.add(dnum_emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 50, 40));

        demp1.setBackground(new java.awt.Color(71, 75, 0));
        demp1.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        demp1.setForeground(new java.awt.Color(153, 255, 255));
        jPanel2.add(demp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 260, 40));

        demp2.setBackground(new java.awt.Color(71, 75, 0));
        demp2.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        demp2.setForeground(new java.awt.Color(153, 255, 255));
        jPanel2.add(demp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 260, 40));

        dnum_maletasAvion.setBackground(new java.awt.Color(0, 51, 51));
        dnum_maletasAvion.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_maletasAvion.setForeground(new java.awt.Color(0, 255, 255));
        dnum_maletasAvion.setText("0");
        jPanel2.add(dnum_maletasAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 50, -1));

        dnum_completos.setBackground(new java.awt.Color(0, 51, 51));
        dnum_completos.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_completos.setForeground(new java.awt.Color(0, 255, 255));
        dnum_completos.setText("0");
        jPanel2.add(dnum_completos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 50, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(153, 255, 51));
        jTextArea3.setTabSize(0);
        jScrollPane3.setViewportView(jTextArea3);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 190, 450));

        jText_total_pasajeros.setEditable(false);
        jText_total_pasajeros.setBackground(new java.awt.Color(0, 0, 0));
        jText_total_pasajeros.setColumns(20);
        jText_total_pasajeros.setForeground(new java.awt.Color(255, 255, 255));
        jText_total_pasajeros.setRows(5);
        jScrollPane1.setViewportView(jText_total_pasajeros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 300, 239));

        emp1.setBackground(new java.awt.Color(0, 0, 51));
        emp1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emp1.setForeground(new java.awt.Color(255, 255, 255));
        emp1.setText("DANI");
        emp1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp1ActionPerformed(evt);
            }
        });
        jPanel2.add(emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 150, 40));

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 590, 170, 60));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(51, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 320, 140));

        emp2.setBackground(new java.awt.Color(0, 0, 51));
        emp2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emp2.setForeground(new java.awt.Color(255, 255, 255));
        emp2.setText("JORGE");
        emp2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp2ActionPerformed(evt);
            }
        });
        jPanel2.add(emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 150, 40));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 85, 100));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(153, 255, 51));
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 190, 190, 450));

        jText_total_maletascinta.setEditable(false);
        jText_total_maletascinta.setBackground(new java.awt.Color(0, 0, 0));
        jText_total_maletascinta.setColumns(20);
        jText_total_maletascinta.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jText_total_maletascinta.setForeground(new java.awt.Color(255, 255, 0));
        jText_total_maletascinta.setTabSize(0);
        jScrollPane6.setViewportView(jText_total_maletascinta);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 300, 169));

        jTextArea7.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextArea7.setForeground(new java.awt.Color(51, 255, 255));
        jTextArea7.setRows(1);
        jTextArea7.setTabSize(1);
        jScrollPane7.setViewportView(jTextArea7);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 320, 140));

        empleados.setBackground(new java.awt.Color(0, 0, 51));
        empleados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        empleados.setForeground(new java.awt.Color(255, 255, 255));
        empleados.setText("EMPLEADOS");
        empleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadosActionPerformed(evt);
            }
        });
        jPanel2.add(empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 140, 110));

        finformeGeneral.setBackground(new java.awt.Color(0, 51, 51));
        finformeGeneral.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        finformeGeneral.setForeground(new java.awt.Color(0, 255, 255));
        finformeGeneral.setText("Informe General");
        finformeGeneral.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finformeGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finformeGeneralActionPerformed(evt);
            }
        });
        jPanel2.add(finformeGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 650, 190, 60));

        estado_cinta.setBackground(new java.awt.Color(0, 0, 0));
        estado_cinta.setFont(new java.awt.Font("Sitka Display", 1, 14)); // NOI18N
        estado_cinta.setForeground(new java.awt.Color(255, 255, 0));
        estado_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado_cintaActionPerformed(evt);
            }
        });
        jPanel2.add(estado_cinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 670, 220, 40));

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 320, 540));

        finformeMaletas.setBackground(new java.awt.Color(0, 51, 51));
        finformeMaletas.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        finformeMaletas.setForeground(new java.awt.Color(0, 255, 255));
        finformeMaletas.setText("Informe Maletas");
        finformeMaletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finformeMaletasActionPerformed(evt);
            }
        });
        jPanel2.add(finformeMaletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, 190, 60));

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 340, 460));

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 180, 210, 540));

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 210, 540));

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 210, 60));

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 210, 60));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 660, 170, 60));

        jButton16.setBackground(new java.awt.Color(0, 0, 51));
        jButton16.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon("C:\\Users\\dani\\Downloads\\cooltext342023282149837.png")); // NOI18N
        jButton16.setOpaque(false);
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1170, 80));

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 590, 160, 130));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 1220, 740));

        jButton3.setBackground(new java.awt.Color(0, 0, 51));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1230, 750));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void estado_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado_cintaActionPerformed

    }//GEN-LAST:event_estado_cintaActionPerformed

    private void finformeGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finformeGeneralActionPerformed
        if (!botonEmpleados && (!botonEmp2 || !botonEmp1)){
            JOptionPane.showMessageDialog(null,"Deten ambos empleados antes de continuar!", "Problem!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(historial_general);
            } catch (IOException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_finformeGeneralActionPerformed

    private void empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadosActionPerformed
        if(!botonEmpleados)
        {
            botonEmpleados=true;
            empleados.setText("PARADO");
            empleados.setBackground(Color.red);
            paso.cerrar("jButton5");
        }
        else
        {
            botonEmpleados=false;
            empleados.setText("EMPLEADOS");
            empleados.setBackground(new Color(0,0,51));
            paso.abrir("jButton5");
        }
    }//GEN-LAST:event_empleadosActionPerformed

    private void emp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp2ActionPerformed
        if(!botonEmp2)
        {
            botonEmp2=true;
            emp2.setText("PARADO");
            emp2.setBackground(Color.red);
            paso.cerrar("jButton4");
        }
        else
        {
            botonEmp2=false;
            emp2.setText("JORGE");
            emp2.setBackground(new Color(0,0,51));
            paso.abrir("jButton4");
        }
    }//GEN-LAST:event_emp2ActionPerformed

    private void emp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp1ActionPerformed
        if(!botonEmp1)
        {
            botonEmp1=true;
            emp1.setText("PARADO");
            emp1.setBackground(Color.red);
            paso.cerrar("jButton2");
        }
        else
        {
            botonEmp1=false;
            emp1.setText("DANI");
            emp1.setBackground(new Color(0,0,51));
            paso.abrir("jButton2");
        }
    }//GEN-LAST:event_emp1ActionPerformed

    private void dtotal_maletasCintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtotal_maletasCintaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtotal_maletasCintaActionPerformed

    private void dmaletas_avionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dmaletas_avionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dmaletas_avionActionPerformed

    private void dtotal_pasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtotal_pasajerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtotal_pasajerosActionPerformed

    private void finformeMaletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finformeMaletasActionPerformed
        if (!botonEmpleados && (!botonEmp2 || !botonEmp1)){
            JOptionPane.showMessageDialog(null,"Deten ambos empleados antes de continuar!", "Problem!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(historial_maletas);
            } catch (IOException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_finformeMaletasActionPerformed

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
            java.util.logging.Logger.getLogger(Consola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Consola().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dcompletados;
    private javax.swing.JButton demp1;
    private javax.swing.JButton demp2;
    private javax.swing.JButton dmaletas_avion;
    private javax.swing.JButton dnum_completos;
    private javax.swing.JButton dnum_emp1;
    private javax.swing.JButton dnum_emp2;
    private javax.swing.JButton dnum_maletasAvion;
    private javax.swing.JButton dnum_maletasCinta;
    private javax.swing.JButton dnum_maletasRecogidas;
    private javax.swing.JButton dnum_pasajeros;
    private javax.swing.JButton dtotal_maletasCinta;
    private javax.swing.JButton dtotal_maletasRecogidas;
    private javax.swing.JButton dtotal_pasajeros;
    private javax.swing.JButton emp1;
    private javax.swing.JButton emp2;
    private javax.swing.JButton empleados;
    private javax.swing.JButton estado_cinta;
    private javax.swing.JButton finformeGeneral;
    private javax.swing.JButton finformeMaletas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jText_total_maletascinta;
    private javax.swing.JTextArea jText_total_pasajeros;
    // End of variables declaration//GEN-END:variables
}
