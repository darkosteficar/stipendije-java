
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
public class scolarshipStudentRemove extends javax.swing.JFrame {

    public java.sql.Connection veza;
    database db;
    String imagePath = null;
    private static int cap;
    private static int id;
    
    
    
    /**
     * Creates new form scolarshipStudentRemove
     */
    public scolarshipStudentRemove() {
        initComponents();
        if(jComboBox2.getSelectedIndex()== 0){
            jButton4.setEnabled(false);
        }
    }

    
    public scolarshipStudentRemove(int id1,int cap1){
        initComponents();
        this.id = id1;
        this.cap = cap1;
        this.setLocationRelativeTo(null);
        if(jComboBox2.getSelectedIndex()== 0){
            jButton4.setEnabled(false);
        }
        db = new database();
        db.initConnection_MySQL();
        populateJTable1();
        Color greenish = new Color(111,255,233);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(greenish);
        jTable1.setSelectionBackground(Color.lightGray);
        
        
        JTableHeader th = jTable1.getTableHeader();       
        th.setForeground(Color.BLACK);  
        
        th.setFont(new Font("Tahoma",Font.PLAIN,16) {
        });
    }
    
    
    
    void disconnectStudent(){
        int sId = Integer.valueOf(jTextFieldId.getText());
        int nId = Integer.valueOf(scolarshipStudentRemove.id);
        if (db.disconnectStudent(sId,nId)) {
                jTextArea1.setText("Student izbrisan iz liste natječaja");
                populateJTable1();
                } else {
                jTextArea1.setText("Pogreška kod upisa podataka!");
        }
        
    }
    
    
     public void populateJTable1(){
        int nId = Integer.valueOf(scolarshipStudentRemove.id);
        ArrayList<student> stuList = new ArrayList<student>();
        stuList = db.studentList2(nId);
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
    
    void searchTableConnected(){
         String send;
         int nId = Integer.valueOf(scolarshipStudentRemove.id);
         if(jComboBox2.getSelectedIndex() == 1){
             send = jTextFieldSearchName.getText();
         }
         else if(jComboBox2.getSelectedIndex() == 2){
             send = jTextFieldSearchSurname.getText();
         }
         else{
             send = jTextFieldSearchName.getText() +","+ jTextFieldSearchSurname.getText();
         }
         
        ArrayList<student> stuList = new ArrayList<student>();
        stuList = db.studentListConnectedSearch(nId,send,jComboBox2.getSelectedIndex());
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelUserPic1 = new javax.swing.JLabel();
        jLabelUsername1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelSName1 = new javax.swing.JLabel();
        jLabelSName7 = new javax.swing.JLabel();
        jTextFieldSearchSurname = new javax.swing.JTextField();
        jTextFieldSearchName = new javax.swing.JTextField();
        jLabelSName5 = new javax.swing.JLabel();
        jLabelSName6 = new javax.swing.JLabel();
        jLabelSName = new javax.swing.JLabel();
        jTextFieldSName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelSName3 = new javax.swing.JLabel();
        jLabelSName2 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));
        setForeground(new java.awt.Color(255, 51, 153));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));
        jPanel1.setForeground(new java.awt.Color(11, 19, 43));

        jLabelClose2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelClose2.setForeground(new java.awt.Color(111, 255, 233));
        jLabelClose2.setText("X");
        jLabelClose2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClose2MouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(111, 255, 233));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(111, 255, 233));
        jLabel6.setText("BRISANJE STUDENATA IZ NATJEČAJA");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(111, 255, 233));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("-");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabelUsername1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelUsername1.setForeground(new java.awt.Color(111, 255, 233));
        jLabelUsername1.setText("USERNAME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelUserPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsername1)
                .addGap(216, 216, 216)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose2)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelClose2)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabelUsername1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelUserPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(58, 80, 107));

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

        jLabelSName1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName1.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName1.setText("Popis studenata:");

        jLabelSName7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName7.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName7.setText("Prezime:");

        jTextFieldSearchSurname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldSearchSurname.setForeground(new java.awt.Color(111, 255, 233));

        jTextFieldSearchName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldSearchName.setForeground(new java.awt.Color(111, 255, 233));

        jLabelSName5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName5.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName5.setText("Pretraga:");

        jLabelSName6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSName6.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName6.setText("Ime:");

        jLabelSName.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSName.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName.setText("Ime natječaja:");

        jTextFieldSName.setEditable(false);
        jTextFieldSName.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldSName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextFieldSName.setForeground(new java.awt.Color(111, 255, 233));

        jTextArea1.setBackground(new java.awt.Color(11, 19, 43));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(111, 255, 233));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabelSName3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSName3.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName3.setText("Ime:");

        jLabelSName2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSName2.setForeground(new java.awt.Color(111, 255, 233));
        jLabelSName2.setText("Id:");

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldId.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(111, 255, 233));

        jTextFieldName.setBackground(new java.awt.Color(11, 19, 43));
        jTextFieldName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(111, 255, 233));

        jButton3.setBackground(new java.awt.Color(111, 255, 233));
        jButton3.setForeground(new java.awt.Color(60, 63, 65));
        jButton3.setText("UKLONI STUDENTA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(111, 255, 233));
        jButton4.setForeground(new java.awt.Color(60, 63, 65));
        jButton4.setText("PRETRAGA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(111, 255, 233));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Svi studenti", "Ime", "Prezime", "Ime i Prezime" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(111, 255, 233));
        jButton6.setForeground(new java.awt.Color(60, 63, 65));
        jButton6.setText("POVRATAK NA NATJEČAJ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(111, 255, 233));
        jButton5.setForeground(new java.awt.Color(60, 63, 65));
        jButton5.setText("POVRATAK NA POPIS STUDENATA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelSName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldSName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabelSName7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldSearchSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelSName1)
                                        .addGap(393, 393, 393)))
                                .addComponent(jButton4)
                                .addGap(499, 499, 499)))
                        .addGap(149, 149, 149))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabelSName5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabelSName6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelSName3)
                                    .addComponent(jLabelSName2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jButton3)))
                        .addGap(175, 175, 175))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSName))
                        .addGap(8, 8, 8)
                        .addComponent(jLabelSName5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSName6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSName3)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSName2))
                        .addGap(8, 8, 8)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearchSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSName7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelClose2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClose2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelClose2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTextFieldName.getText().isEmpty()){
            error("Niste odabrali studenta za brisanje iz natječaja!");
            return;
        }
        disconnectStudent();
        populateJTable1();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        searchTableConnected();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        // Get selected row index
        int rowIndex = jTable1.getSelectedRow();
        jTextFieldName.setText(jTable1.getValueAt(rowIndex, 1).toString());
        jTextFieldId.setText(jTable1.getValueAt(rowIndex, 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        
           int id = scolarshipStudentRemove.id;
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        allStudents as = new allStudents();
           as.setVisible(true);
           as.pack();
           as.setLocationRelativeTo(null);
           as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
           this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
         if(jComboBox2.getSelectedIndex()== 0){
            jButton4.setEnabled(false);
            populateJTable1();
            jTextFieldSearchSurname.setText("");
            jTextFieldSearchName.setText("");
        }
        if(jComboBox2.getSelectedIndex() == 1){
            jTextFieldSearchName.setEditable(true);
            jTextFieldSearchSurname.setEditable(false);
            jTextFieldSearchSurname.setText("");
            jButton4.setEnabled(true);
        }
        if(jComboBox2.getSelectedIndex() == 2){
            jTextFieldSearchName.setEditable(false);
            jTextFieldSearchSurname.setEditable(true);
            jTextFieldSearchName.setText("");
            jButton4.setEnabled(true);
        }
        if(jComboBox2.getSelectedIndex() == 3){
            jTextFieldSearchName.setEditable(true);
            jTextFieldSearchSurname.setEditable(true);
            jButton4.setEnabled(true);
        }
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(scolarshipStudentRemove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scolarshipStudentRemove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scolarshipStudentRemove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scolarshipStudentRemove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scolarshipStudentRemove().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelClose2;
    private javax.swing.JLabel jLabelSName;
    private javax.swing.JLabel jLabelSName1;
    private javax.swing.JLabel jLabelSName2;
    private javax.swing.JLabel jLabelSName3;
    private javax.swing.JLabel jLabelSName5;
    private javax.swing.JLabel jLabelSName6;
    private javax.swing.JLabel jLabelSName7;
    private javax.swing.JLabel jLabelUserPic1;
    public javax.swing.JLabel jLabelUsername1;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextFieldId;
    public javax.swing.JTextField jTextFieldName;
    public javax.swing.JTextField jTextFieldSName;
    public javax.swing.JTextField jTextFieldSearchName;
    public javax.swing.JTextField jTextFieldSearchSurname;
    // End of variables declaration//GEN-END:variables
}
