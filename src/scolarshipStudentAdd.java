
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC Master Race
 */
public class scolarshipStudentAdd extends javax.swing.JFrame {

    public java.sql.Connection veza;
    database db;
    String imagePath = null;
    private static int cap;
    private static int id;
    
    /**
     * Creates new form scolarshipStudentAdd
     */
    public scolarshipStudentAdd() {
        initComponents();
        if(jComboBox1.getSelectedIndex()== 0){
            jButton4.setEnabled(false);
        }
    }
    
    public scolarshipStudentAdd(int id1,int cap){
         initComponents();     
        this.id = id1;
        this.cap = cap;
        this.setLocationRelativeTo(null);
        if(jComboBox1.getSelectedIndex()== 0){
            jButton4.setEnabled(false);
        }
        db = new database();
        db.initConnection_MySQL();
        populateJTable();
        Color greenish = new Color(111,255,233);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(greenish);
        jTable1.setSelectionBackground(Color.lightGray);
        
        
        JTableHeader th = jTable1.getTableHeader();       
        th.setForeground(Color.BLACK);  
        
        th.setFont(new Font("Tahoma",Font.PLAIN,16) {
        });
    }
    
    
     // Students table
    public void populateJTable(){
        int sId = Integer.valueOf(id);
        ArrayList<student> stuList = new ArrayList<student>();
        stuList = db.studentList3(sId);
        String[] colNames = {"ID","Ime","Prezime","Adresa","Godina","Datum Rođenja","Fakultet","Slika"};
        Object[][] rows = new Object[stuList.size()][8];
        
        for(int i = 0; i< stuList.size();i++){
            rows[i][0] = stuList.get(i).getId();
            rows[i][1] = stuList.get(i).getIme();
            rows[i][2] = stuList.get(i).getPrezime();
            rows[i][3] = stuList.get(i).getAdresa();
            rows[i][4] = stuList.get(i).getGodina();
            rows[i][5] = stuList.get(i).getDat_rod();
            rows[i][6] = stuList.get(i).getFakultet();
            
            
            ImageIcon pic = new ImageIcon(new ImageIcon(stuList.get(i).getSlika()).
                    getImage()
                    .getScaledInstance(120,80,Image.SCALE_SMOOTH));
            rows[i][7] = pic;
        }
        Images imgs = new Images(rows,colNames);
        jTable1.setModel(imgs);
        jTable1.setRowHeight(80);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
    }
    
    
    
    
    
    
   void searchTableNotConnected(){
       
         String send;
         int nId = Integer.valueOf(scolarshipStudentAdd.id);
         if(jComboBox1.getSelectedIndex() == 1){
             send = jTextFieldSearchName.getText();
         }
         else if(jComboBox1.getSelectedIndex() == 2){
             send = jTextFieldSearchSurname.getText();
         }
         else{
             send = jTextFieldSearchName.getText() +","+ jTextFieldSearchSurname.getText();
         }
        ArrayList<student> stuList = new ArrayList<student>();
        stuList = db.studentListNotConnectedSearch(nId,send,jComboBox1.getSelectedIndex());
        String[] colNames = {"ID","Ime","Prezime","Adresa","Godina","Datum Rođenja","Fakultet","Slika"};
        Object[][] rows = new Object[stuList.size()][8];
        
        for(int i = 0; i< stuList.size();i++){
            rows[i][0] = stuList.get(i).getId();
            rows[i][1] = stuList.get(i).getIme();
            rows[i][2] = stuList.get(i).getPrezime();
            rows[i][3] = stuList.get(i).getAdresa();
            rows[i][4] = stuList.get(i).getGodina();
            rows[i][5] = stuList.get(i).getDat_rod();
            rows[i][6] = stuList.get(i).getFakultet();
            
            
            ImageIcon pic = new ImageIcon(new ImageIcon(stuList.get(i).getSlika()).
                    getImage()
                    .getScaledInstance(120,80,Image.SCALE_SMOOTH));
            rows[i][7] = pic;
        }
        Images imgs = new Images(rows,colNames);
        jTable1.setModel(imgs);
        jTable1.setRowHeight(80);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
    }
    
    
    
    void connectStudent() {
        int sId = Integer.valueOf(jTextFieldId.getText());
        int nId = Integer.valueOf(scolarshipStudentAdd.id);
        if (db.connectStudent(sId,nId)) {
                jTextArea1.setText("Student dodan u natječaj");
                populateJTable();
                } else {
                jTextArea1.setText("Pogreška kod upisa podataka!");
        }

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelUserPic = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabelSName1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextFieldSearchSurname = new javax.swing.JTextField();
        jLabelSName5 = new javax.swing.JLabel();
        jLabelSName = new javax.swing.JLabel();
        jTextFieldSName = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jLabelSName3 = new javax.swing.JLabel();
        jLabelSName2 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextFieldSearchName = new javax.swing.JTextField();
        jLabelSName6 = new javax.swing.JLabel();
        jLabelSName7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(2147483647, 7000));
        setMinimumSize(new java.awt.Dimension(0, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1140, 900));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        jLabelClose1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelClose1.setForeground(new java.awt.Color(111, 255, 233));
        jLabelClose1.setText("X");
        jLabelClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClose1MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(111, 255, 233));
        jLabel4.setText("DODAVANJE STUDENTA U NATJEČAJ");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(111, 255, 233));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("-");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabelUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(111, 255, 233));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelUserPic, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsername)
                .addGap(247, 247, 247)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose1)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelClose1)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabelUsername)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelUserPic, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1140, 54);

        jPanel2.setBackground(new java.awt.Color(58, 80, 107));
        jPanel2.setForeground(new java.awt.Color(58, 80, 107));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(11, 19, 43));
        jTable1.setForeground(new java.awt.Color(111, 255, 233));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(111, 255, 233));
        jTable1.setSelectionForeground(java.awt.Color.black);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 283, 1116, 303));

        jButton3.setBackground(new java.awt.Color(111, 255, 233));
        jButton3.setForeground(new java.awt.Color(60, 63, 65));
        jButton3.setText("DODAJ STUDENTA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 249, -1, -1));

        jLabelSName1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName1.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName1.setText("Popis studenata:");
        jPanel2.add(jLabelSName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, -1, -1));

        jButton4.setBackground(new java.awt.Color(111, 255, 233));
        jButton4.setForeground(new java.awt.Color(60, 63, 65));
        jButton4.setText("PRETRAGA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 198, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(111, 255, 233));
        jComboBox1.setForeground(new java.awt.Color(11, 19, 43));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Svi studenti", "Ime", "Prezime", "Ime i Prezime" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 199, 128, -1));

        jTextFieldSearchSurname.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldSearchSurname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldSearchSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 191, 206, -1));

        jLabelSName5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName5.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName5.setText("Prezime:");
        jPanel2.add(jLabelSName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 201, -1, -1));

        jLabelSName.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSName.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName.setText("Ime natječaja:");
        jPanel2.add(jLabelSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 25, -1, -1));

        jTextFieldSName.setEditable(false);
        jTextFieldSName.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldSName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextFieldSName.setForeground(new java.awt.Color(111, 255, 233));
        jPanel2.add(jTextFieldSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 21, 206, -1));

        jTextFieldName.setEditable(false);
        jTextFieldName.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(111, 255, 233));
        jPanel2.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 21, 206, -1));

        jLabelSName3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSName3.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName3.setText("Ime:");
        jPanel2.add(jLabelSName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 25, -1, -1));

        jLabelSName2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSName2.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName2.setText("Id:");
        jPanel2.add(jLabelSName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 72, -1, -1));

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldId.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(111, 255, 233));
        jPanel2.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 66, 100, -1));

        jTextArea1.setBackground(new java.awt.Color(11, 19, 43));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(111, 255, 233));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 21, 364, -1));

        jButton5.setBackground(new java.awt.Color(111, 255, 233));
        jButton5.setForeground(new java.awt.Color(60, 63, 65));
        jButton5.setText("POVRATAK NA POPIS STUDENATA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        jButton6.setBackground(new java.awt.Color(111, 255, 233));
        jButton6.setForeground(new java.awt.Color(60, 63, 65));
        jButton6.setText("POVRATAK NA NATJEČAJ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 590, -1, -1));

        jTextFieldSearchName.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldSearchName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldSearchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 153, 206, -1));

        jLabelSName6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName6.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName6.setText("Pretraga:");
        jPanel2.add(jLabelSName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 128, -1, -1));

        jLabelSName7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName7.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName7.setText("Ime:");
        jPanel2.add(jLabelSName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 160, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(111, 255, 233));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 227, 582, 10));

        jSeparator2.setBackground(new java.awt.Color(111, 255, 233));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 104, 244, 10));

        jSeparator3.setBackground(new java.awt.Color(111, 255, 233));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 323, 10));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(6, 54, 1130, 620);

        jMenu1.setText("Odabir");

        jMenuItem1.setText("Studenti");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Dodaj studenta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Natječaji");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Dodaj Natječaj");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClose1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelClose1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        // Get selected row index
        int rowIndex = jTable1.getSelectedRow();
        jTextFieldName.setText(jTable1.getValueAt(rowIndex, 1).toString());
        jTextFieldId.setText(jTable1.getValueAt(rowIndex, 0).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectionModel().isSelectionEmpty()){
            jTextFieldName.setText("");
            jTextFieldId.setText("");
            error("Nije odabran ni jedan student");
            return;
        }
        if(jTextFieldName.getText().isEmpty()){
            error("Niste odabrali studenta za dodavanja u natječaj!");
            return;
        }
        try {
            if(db.scolarshipCapacity(id) == true){
                String ime = jTextFieldName.getText();
                String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
                connectStudent();
                populateJTable();
                jTextFieldId.setText("");
                jTextFieldName.setText("");
                jTextArea1.setText("Dodan je sljedeći student: " + ime + " ,vrijeme: "+ timestamp);
            }
            else{
                error("Kapacitet natječaja je ispunjen,daljnje dodavanje studenata nije moguće!");
            }
        
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        searchTableNotConnected();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:     
           allStudents as = new allStudents();
           as.setVisible(true);
           as.pack();
           as.setLocationRelativeTo(null);
           as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
           this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
           int id = scolarshipStudentAdd.id;
           String ime = jTextFieldSName.getText();   
           int cap = this.cap;
           String cap1 = String.valueOf(cap);
           connectStudents cnc = new connectStudents(id,this.cap);
           cnc.setVisible(true);
           cnc.pack();
           cnc.setLocationRelativeTo(null);
           cnc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
           cnc.jTextFieldSName.setText(ime);
           cnc.jTextFieldCap.setText(cap1);
           this.dispose();
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()== 0){
            jButton4.setEnabled(false);
            populateJTable();
            jTextFieldSearchSurname.setText("");
            jTextFieldSearchName.setText("");
        }
        if(jComboBox1.getSelectedIndex() == 1){
            jTextFieldSearchName.setEditable(true);
            jTextFieldSearchSurname.setEditable(false);
            jTextFieldSearchSurname.setText("");
            jButton4.setEnabled(true);
        }
        if(jComboBox1.getSelectedIndex() == 2){
            jTextFieldSearchName.setEditable(false);
            jTextFieldSearchSurname.setEditable(true);
            jTextFieldSearchName.setText("");
            jButton4.setEnabled(true);
        }
        if(jComboBox1.getSelectedIndex() == 3){
            jTextFieldSearchName.setEditable(true);
            jTextFieldSearchSurname.setEditable(true);
            jButton4.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        allStudents as = new allStudents();
        as.setVisible(true);
        as.pack();
        as.setLocationRelativeTo(null);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        addStudent as = new addStudent();
        as.setVisible(true);
        as.pack();
        as.setLocationRelativeTo(null);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        allScholarships as = new allScholarships();
        as.setVisible(true);
        as.pack();
        as.setLocationRelativeTo(null);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        addScolarship as = new addScolarship();
        as.setVisible(true);
        as.pack();
        as.setLocationRelativeTo(null);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
     void error(String msg) {
        Object[] options = {
            "U redu"};
        int i = JOptionPane.showOptionDialog(this, msg,
                "  - Upozorenje -  ",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);
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
            java.util.logging.Logger.getLogger(scolarshipStudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scolarshipStudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scolarshipStudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scolarshipStudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scolarshipStudentAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelClose1;
    private javax.swing.JLabel jLabelSName;
    private javax.swing.JLabel jLabelSName1;
    private javax.swing.JLabel jLabelSName2;
    private javax.swing.JLabel jLabelSName3;
    private javax.swing.JLabel jLabelSName5;
    private javax.swing.JLabel jLabelSName6;
    private javax.swing.JLabel jLabelSName7;
    private javax.swing.JLabel jLabelUserPic;
    public javax.swing.JLabel jLabelUsername;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextFieldId;
    public javax.swing.JTextField jTextFieldName;
    public javax.swing.JTextField jTextFieldSName;
    public javax.swing.JTextField jTextFieldSearchName;
    public javax.swing.JTextField jTextFieldSearchSurname;
    // End of variables declaration//GEN-END:variables
}
