package Server;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Console extends javax.swing.JFrame {
    /* Variables */
    private final Leap leap = new Leap();
    private final File general_record = new File ("Records/General.txt");
    private final File suitcases_record = new File ("Records/Suitcases.txt");
    private final int max_Passengers = 40;
    private final int max_employees = 2;
    private final Color dark_Blue = new Color(0,0,51);
    private final Color dark_Pink = new Color(102,0,51);
    private boolean  bEmp1 , bEmp2, bEmpOpen, bEmpClose = false;
    Airplane airport = new Airplane();
    Belt belt = new Belt();

    /* Console */
    public Console() throws InterruptedException {
        initComponents(); 
        for(int i = 1; i <= max_Passengers; i++){
            /* 40 Passengers as Threads */
            Passenger pasajero = new Passenger("Passenger " + i, belt, jText_totalPassengers, dnum_passengers, dnum_casesBelt, 
                    leap, status_icon, jTextArea_completedPassengers, jText_totalCases, dnum_completed, beltStatus);
            pasajero.start();
            if(i<max_employees){
                /* 2 Employees as Threads */
                Employee empleado = new Employee(belt, airport, jTextArea_emp1, jTextArea_airportCases, dnum_passengers, 
                        dnum_casesBelt, dnum_pickUpCases, dnum_casesAirport, leap, status_icon, jText_totalCases, 
                        jTextArea_emp2, dnum_emp1, dnum_emp2, demp1, demp2, beltStatus);
                if(i==1){
                    empleado.setName_employee("Dani");
                }else{
                    empleado.setName_employee("Jorge");
                }
                empleado.start();   
            }   
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dtotal_passengers = new javax.swing.JButton();
        dtotal_pickUpCases = new javax.swing.JButton();
        dcases_airport = new javax.swing.JButton();
        dcompleted = new javax.swing.JButton();
        dtotal_casesBelt = new javax.swing.JButton();
        dnum_passengers = new javax.swing.JButton();
        dnum_casesBelt = new javax.swing.JButton();
        dnum_pickUpCases = new javax.swing.JButton();
        dnum_emp1 = new javax.swing.JButton();
        dnum_emp2 = new javax.swing.JButton();
        demp1 = new javax.swing.JButton();
        demp2 = new javax.swing.JButton();
        dnum_casesAirport = new javax.swing.JButton();
        dnum_completed = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_airportCases = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_totalPassengers = new javax.swing.JTextArea();
        emp1 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_emp1 = new javax.swing.JTextArea();
        emp2 = new javax.swing.JButton();
        status_icon = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_completedPassengers = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jText_totalCases = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea_emp2 = new javax.swing.JTextArea();
        openAll = new javax.swing.JButton();
        closeAll = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        b_generalRecord = new javax.swing.JButton();
        beltStatus = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        b_casesRecord = new javax.swing.JButton();
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

        dtotal_passengers.setBackground(new java.awt.Color(0, 0, 51));
        dtotal_passengers.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        dtotal_passengers.setForeground(new java.awt.Color(0, 255, 255));
        dtotal_passengers.setText("Total Passengers");
        dtotal_passengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtotal_passengersActionPerformed(evt);
            }
        });
        jPanel2.add(dtotal_passengers, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 250, 40));

        dtotal_pickUpCases.setBackground(new java.awt.Color(0, 0, 51));
        dtotal_pickUpCases.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        dtotal_pickUpCases.setForeground(new java.awt.Color(0, 255, 255));
        dtotal_pickUpCases.setText("Total Packed Cases");
        jPanel2.add(dtotal_pickUpCases, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 250, 40));

        dcases_airport.setBackground(new java.awt.Color(0, 0, 51));
        dcases_airport.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dcases_airport.setForeground(new java.awt.Color(0, 255, 255));
        dcases_airport.setText("Airport Cases");
        dcases_airport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcases_airportActionPerformed(evt);
            }
        });
        jPanel2.add(dcases_airport, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 140, 40));

        dcompleted.setBackground(new java.awt.Color(0, 0, 51));
        dcompleted.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dcompleted.setForeground(new java.awt.Color(0, 255, 255));
        dcompleted.setText("Completed");
        jPanel2.add(dcompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 120, 130, 40));

        dtotal_casesBelt.setBackground(new java.awt.Color(0, 0, 51));
        dtotal_casesBelt.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        dtotal_casesBelt.setForeground(new java.awt.Color(0, 255, 255));
        dtotal_casesBelt.setText("Total Cases on Belt");
        dtotal_casesBelt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtotal_casesBeltActionPerformed(evt);
            }
        });
        jPanel2.add(dtotal_casesBelt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 250, 40));

        dnum_passengers.setBackground(new java.awt.Color(0, 51, 51));
        dnum_passengers.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_passengers.setForeground(new java.awt.Color(0, 255, 255));
        dnum_passengers.setText("0");
        jPanel2.add(dnum_passengers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 60, 40));

        dnum_casesBelt.setBackground(new java.awt.Color(0, 51, 51));
        dnum_casesBelt.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_casesBelt.setForeground(new java.awt.Color(0, 255, 255));
        dnum_casesBelt.setText("0");
        jPanel2.add(dnum_casesBelt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 60, 40));

        dnum_pickUpCases.setBackground(new java.awt.Color(0, 51, 51));
        dnum_pickUpCases.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_pickUpCases.setForeground(new java.awt.Color(0, 255, 255));
        dnum_pickUpCases.setText("0");
        jPanel2.add(dnum_pickUpCases, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 60, 40));

        dnum_emp1.setBackground(new java.awt.Color(0, 51, 51));
        dnum_emp1.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_emp1.setForeground(new java.awt.Color(0, 255, 255));
        dnum_emp1.setText("0");
        jPanel2.add(dnum_emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 50, 40));

        dnum_emp2.setBackground(new java.awt.Color(0, 51, 51));
        dnum_emp2.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_emp2.setForeground(new java.awt.Color(0, 255, 255));
        dnum_emp2.setText("0");
        jPanel2.add(dnum_emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 50, 40));

        demp1.setBackground(new java.awt.Color(71, 75, 0));
        demp1.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        demp1.setForeground(new java.awt.Color(153, 255, 255));
        jPanel2.add(demp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 260, 40));

        demp2.setBackground(new java.awt.Color(71, 75, 0));
        demp2.setFont(new java.awt.Font("Sitka Display", 1, 16)); // NOI18N
        demp2.setForeground(new java.awt.Color(153, 255, 255));
        jPanel2.add(demp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 260, 40));

        dnum_casesAirport.setBackground(new java.awt.Color(0, 51, 51));
        dnum_casesAirport.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_casesAirport.setForeground(new java.awt.Color(0, 255, 255));
        dnum_casesAirport.setText("0");
        jPanel2.add(dnum_casesAirport, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 50, -1));

        dnum_completed.setBackground(new java.awt.Color(0, 51, 51));
        dnum_completed.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        dnum_completed.setForeground(new java.awt.Color(0, 255, 255));
        dnum_completed.setText("0");
        jPanel2.add(dnum_completed, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 50, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea_airportCases.setEditable(false);
        jTextArea_airportCases.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea_airportCases.setColumns(20);
        jTextArea_airportCases.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea_airportCases.setForeground(new java.awt.Color(153, 255, 51));
        jTextArea_airportCases.setTabSize(0);
        jScrollPane3.setViewportView(jTextArea_airportCases);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 200, 450));

        jText_totalPassengers.setEditable(false);
        jText_totalPassengers.setBackground(new java.awt.Color(0, 0, 0));
        jText_totalPassengers.setColumns(20);
        jText_totalPassengers.setForeground(new java.awt.Color(255, 255, 255));
        jText_totalPassengers.setRows(5);
        jScrollPane1.setViewportView(jText_totalPassengers);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 320, 239));

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
        jPanel2.add(emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 150, 40));

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 170, 60));

        jTextArea_emp1.setEditable(false);
        jTextArea_emp1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea_emp1.setColumns(20);
        jTextArea_emp1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextArea_emp1.setForeground(new java.awt.Color(51, 255, 255));
        jTextArea_emp1.setRows(5);
        jTextArea_emp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(jTextArea_emp1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 320, 140));

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
        jPanel2.add(emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 670, 150, 40));

        status_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status_icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(status_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 85, 100));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea_completedPassengers.setEditable(false);
        jTextArea_completedPassengers.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea_completedPassengers.setColumns(20);
        jTextArea_completedPassengers.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea_completedPassengers.setForeground(new java.awt.Color(153, 255, 51));
        jTextArea_completedPassengers.setRows(5);
        jScrollPane4.setViewportView(jTextArea_completedPassengers);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, 190, 450));

        jText_totalCases.setEditable(false);
        jText_totalCases.setBackground(new java.awt.Color(0, 0, 0));
        jText_totalCases.setColumns(20);
        jText_totalCases.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jText_totalCases.setForeground(new java.awt.Color(255, 255, 0));
        jText_totalCases.setTabSize(0);
        jScrollPane6.setViewportView(jText_totalCases);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 320, 169));

        jTextArea_emp2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea_emp2.setColumns(20);
        jTextArea_emp2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextArea_emp2.setForeground(new java.awt.Color(51, 255, 255));
        jTextArea_emp2.setRows(1);
        jTextArea_emp2.setTabSize(1);
        jScrollPane7.setViewportView(jTextArea_emp2);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 320, 140));

        openAll.setBackground(new java.awt.Color(0, 102, 102));
        openAll.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        openAll.setForeground(new java.awt.Color(255, 255, 255));
        openAll.setText("RESUME ALL");
        openAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAllActionPerformed(evt);
            }
        });
        jPanel2.add(openAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 670, 140, 40));

        closeAll.setBackground(new java.awt.Color(102, 0, 0));
        closeAll.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        closeAll.setForeground(new java.awt.Color(255, 255, 255));
        closeAll.setText("STOP ALL");
        closeAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeAllActionPerformed(evt);
            }
        });
        jPanel2.add(closeAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 140, 40));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 660, 160, 60));

        b_generalRecord.setBackground(new java.awt.Color(0, 51, 51));
        b_generalRecord.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        b_generalRecord.setForeground(new java.awt.Color(0, 255, 255));
        b_generalRecord.setText("General Record");
        b_generalRecord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_generalRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_generalRecordActionPerformed(evt);
            }
        });
        jPanel2.add(b_generalRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 650, 190, 60));

        beltStatus.setBackground(new java.awt.Color(0, 0, 0));
        beltStatus.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        beltStatus.setForeground(new java.awt.Color(255, 255, 0));
        beltStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beltStatusActionPerformed(evt);
            }
        });
        jPanel2.add(beltStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 670, 250, 40));

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 540));

        b_casesRecord.setBackground(new java.awt.Color(0, 51, 51));
        b_casesRecord.setFont(new java.awt.Font("Sitka Display", 1, 18)); // NOI18N
        b_casesRecord.setForeground(new java.awt.Color(0, 255, 255));
        b_casesRecord.setText("Cases Record");
        b_casesRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_casesRecordActionPerformed(evt);
            }
        });
        jPanel2.add(b_casesRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, 200, 60));

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 340, 460));

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 210, 540));

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 220, 540));

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 210, 60));

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 220, 60));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 660, 170, 60));

        jButton16.setBackground(new java.awt.Color(0, 0, 51));
        jButton16.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon("C:\\Users\\dani\\Downloads\\cooltext342023282149837.png")); // NOI18N
        jButton16.setOpaque(false);
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1190, 80));

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, 160, 60));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 1240, 740));

        jButton3.setBackground(new java.awt.Color(0, 0, 51));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1250, 750));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void beltStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beltStatusActionPerformed

    }//GEN-LAST:event_beltStatusActionPerformed

    private void b_generalRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_generalRecordActionPerformed
        if (!bEmpClose && (!bEmp2 || !bEmp1)){
            JOptionPane.showMessageDialog(null,"Stop both employees to continue!", "Problem!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(general_record);
            } catch (IOException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b_generalRecordActionPerformed

    private void closeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeAllActionPerformed
        if(!bEmpClose){
            bEmpOpen=false;
            bEmpClose=true;
            bEmp2=true;
            emp2.setText("STOPPED");
            emp2.setBackground(dark_Pink);
            leap.close("jorge");
            bEmp1=true;
            emp1.setText("STOPPED");
            emp1.setBackground(dark_Pink);
            leap.close("dani");
        }
    }//GEN-LAST:event_closeAllActionPerformed

    private void emp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp2ActionPerformed
        if(!bEmp2)
        {
            bEmp2=true;
            emp2.setText("STOPPED");
            emp2.setBackground(dark_Pink);
            leap.close("jorge");
            if(!bEmp1){
                bEmpOpen=false;
            }
        }
        else
        {
            bEmp2=false;
            emp2.setText("JORGE");
            emp2.setBackground(dark_Blue);
            leap.open("jorge");
            if(bEmp1){
                bEmpClose=false;
            }
        }
    }//GEN-LAST:event_emp2ActionPerformed

    private void emp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp1ActionPerformed
        if(!bEmp1)
        {
            bEmp1=true;
            emp1.setText("STOPPED");
            emp1.setBackground(dark_Pink);
            leap.close("dani");
            if(!bEmp2){
                bEmpOpen=false;
            }
        }
        else
        {
            bEmp1=false;
            emp1.setText("DANI");
            emp1.setBackground(dark_Blue);
            leap.open("dani");
            if(bEmp2){
                bEmpClose=false;
            }
        }
    }//GEN-LAST:event_emp1ActionPerformed

    private void dtotal_casesBeltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtotal_casesBeltActionPerformed

    }//GEN-LAST:event_dtotal_casesBeltActionPerformed

    private void dcases_airportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcases_airportActionPerformed

    }//GEN-LAST:event_dcases_airportActionPerformed

    private void dtotal_passengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtotal_passengersActionPerformed

    }//GEN-LAST:event_dtotal_passengersActionPerformed

    private void b_casesRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_casesRecordActionPerformed
        if (!bEmpClose && (!bEmp2 || !bEmp1)){
            JOptionPane.showMessageDialog(null,"Stop both employees to continue!", "Problem!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(suitcases_record);
            } catch (IOException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b_casesRecordActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void openAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAllActionPerformed
        if(!bEmpOpen){
            bEmpClose=false;
            bEmpOpen=true;
            bEmp2=false;
            emp2.setText("JORGE");
            emp2.setBackground(dark_Blue);
            leap.open("jorge");
            bEmp1=false;
            emp1.setText("DANI");
            emp1.setBackground(dark_Blue);
            leap.open("dani");
        }
    }//GEN-LAST:event_openAllActionPerformed

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
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Console().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_casesRecord;
    private javax.swing.JButton b_generalRecord;
    private javax.swing.JButton beltStatus;
    private javax.swing.JButton closeAll;
    private javax.swing.JButton dcases_airport;
    private javax.swing.JButton dcompleted;
    private javax.swing.JButton demp1;
    private javax.swing.JButton demp2;
    private javax.swing.JButton dnum_casesAirport;
    private javax.swing.JButton dnum_casesBelt;
    private javax.swing.JButton dnum_completed;
    private javax.swing.JButton dnum_emp1;
    private javax.swing.JButton dnum_emp2;
    private javax.swing.JButton dnum_passengers;
    private javax.swing.JButton dnum_pickUpCases;
    private javax.swing.JButton dtotal_casesBelt;
    private javax.swing.JButton dtotal_passengers;
    private javax.swing.JButton dtotal_pickUpCases;
    private javax.swing.JButton emp1;
    private javax.swing.JButton emp2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea_airportCases;
    private javax.swing.JTextArea jTextArea_completedPassengers;
    private javax.swing.JTextArea jTextArea_emp1;
    private javax.swing.JTextArea jTextArea_emp2;
    private javax.swing.JTextArea jText_totalCases;
    private javax.swing.JTextArea jText_totalPassengers;
    private javax.swing.JButton openAll;
    private javax.swing.JLabel status_icon;
    // End of variables declaration//GEN-END:variables
}
