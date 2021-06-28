
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC Master Race
 */
public class database {
    
    public java.sql.Connection veza;
    public Logger logger;
    public Logger logger_err;

    public database() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public boolean isConnected(){
        if(this.veza!=null)
            return true;
        else
            return false;
    }

    public boolean disconnect() throws SQLException {
        boolean OK=false;
        try {
            if (veza != null) {
                veza.close();
                OK=true;
            }
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
        }
        finally{
            return OK;
        }   
    }

    public void initConnection_MySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /*     DriverManager.getConnection("jdbc:mysql://"server":"port"/"dbname"?user="user"&password="password"&characterEncoding=Cp1250");
             */
            java.util.Properties props = new java.util.Properties();

            props.put("characterEncoding", "cp1250");
            props.put("characterSetResults", "cp1250");
            props.put("user", "root");
            props.put("password", "");

            this.veza = DriverManager.getConnection("jdbc:mysql://localhost:3306/stipendije", props);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public boolean disconnect(Connection con) throws SQLException {
        boolean OK = false;
        try {
            if (con != null) {
                con.close();
                OK = true;
            }
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
        }
        return OK;
    }

    public Vector odrediSveStudente() throws java.sql.SQLException {

        Vector vec = new Vector();
        if (this.conn == null) {
            return vec;
        }
        try {
            Statement stm = this.conn.createStatement();
            String query = "SELECT  * FROM STUDENT ORDER BY PREZIME, IME";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Student data = new Student();
                data.setId(rs.getInt(1)); //  ID studenta
                data.setIme(rs.getString(2)); // Ime studenta
                data.setPrezime(rs.getString(3)); // Prezime studenta
                data.setSpol(rs.getInt(4)); // Spol studenta
                data.setGodina(rs.getInt(5)); // Godina studija studenta
                vec.addElement(data);
            }
            query = null;
            rs.close();
            stm.close();
            return vec;
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return vec;
        }
    }
    */
    public boolean addStudent(student data) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            
            String input = "INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = this.veza.prepareStatement(input);

            stmt.setInt(1, data.getId());
            stmt.setString(2, data.getIme());
            stmt.setString(3, data.getPrezime());
            stmt.setString(4, data.getAdresa());
            stmt.setInt(5, data.getGodina());
            stmt.setDate(6, data.getDat_rod());
            stmt.setString(7, data.getFakultet()); 
            stmt.setBytes(8, data.getSlika());
            if(stmt.executeUpdate() != 0){
                
                stmt.close();
                return true;
            }
            else{
                
                return false;
            }
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateStudent(student data,boolean image) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            
            Statement stm;
            
            if(image == true){
               String input = "UPDATE `student` SET `ime`= ? ,`prezime`= ? ,`adresa`= ? ,`godina`= ? ,`dat_rod`= ? ,`fakultet`= ? ,`slika`= ?  WHERE `id` = ?";
                            
                PreparedStatement stmt = this.veza.prepareStatement(input);

                stmt.setString(1, data.getIme());
                stmt.setString(2, data.getPrezime());
                stmt.setString(3, data.getAdresa());
                stmt.setInt(4, data.getGodina());
                stmt.setDate(5, data.getDat_rod());
                stmt.setString(6, data.getFakultet()); 
                stmt.setBytes(7, data.getSlika());
                stmt.setInt(8, data.getId());
                if(stmt.executeUpdate() != 0){
                     stmt.close();
                     return true;
                }
                 else{
                     return false;
                }
            }
            
            else{
                String input = "UPDATE `student` SET `ime`= ? ,`prezime`= ? ,`adresa`= ? ,`godina`= ? ,`dat_rod`= ? ,`fakultet`= ? WHERE `id` = ?";
                                            
                PreparedStatement stmt = this.veza.prepareStatement(input);  
                
                stmt.setString(1, data.getIme());
                stmt.setString(2, data.getPrezime());
                stmt.setString(3, data.getAdresa());
                stmt.setInt(4, data.getGodina());
                stmt.setDate(5, data.getDat_rod());
                stmt.setString(6, data.getFakultet());                 
                stmt.setInt(7, data.getId());
                
                if(stmt.executeUpdate() != 0){
                     stmt.close();
                     return true;
                }
                 else{
                     return false;
                }
                
        }
            
            
            
        } catch (SQLException e) {
                 logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
                 return false;
        }
               
               
               
            
        
            
    }
    
    
    public boolean deleteStudent(student data) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            String count = "SELECT COUNT(*) AS total FROM `popis` WHERE `student_id` = ?";
            PreparedStatement stmCount = this.veza.prepareStatement(count);
            stmCount.setInt(1, data.getId());
            ResultSet rs = stmCount.executeQuery();
            rs.next();
            int broj = rs.getInt("total");
            if( rs.getInt("total") > 0){
                
                String input1 = "DELETE FROM `popis` WHERE `student_id` = ?";
                PreparedStatement stmt1 = this.veza.prepareStatement(input1);
                String input = "DELETE FROM `student` WHERE `id` = ?";
                PreparedStatement stmt = this.veza.prepareStatement(input);

                stmt1.setInt(1, data.getId());
                stmt.setInt(1, data.getId());
                if(stmt1.executeUpdate() != 0 ){

                    if(stmt.executeUpdate() != 0 ){

                        stmt.close();
                        stmt1.close();
                        return true;
                        }
                        else{

                        return false;
                    }
                    
                }
            
            
            else{
                
                return false;
            }
        }
            else{
                String input = "DELETE FROM `student` WHERE `id` = ?";
                PreparedStatement stmt = this.veza.prepareStatement(input);
                
                stmt.setInt(1, data.getId());
                    if(stmt.executeUpdate() != 0 ){
                        stmt.close();
                        return true;
                        }
                        else{

                        return false;
                    }    
            }
            
            
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }
    
     // Student search
     public ArrayList<student> studentSearch(String src,int option){
        
        String input;
        String name = src;
        ArrayList<student> list = new ArrayList<student>();
        Statement st;
        ResultSet rs;
        PreparedStatement stmt;
        try {
            Statement stm;
            if(option == 1){
               input = "SELECT * FROM student WHERE ime LIKE ? ";
               stmt = this.veza.prepareStatement(input);
               stmt.setString(1,"%"+ name + "%");
               
              
            }
            else if (option == 2) {
               input = "SELECT * FROM student WHERE prezime LIKE ? ";
               stmt = this.veza.prepareStatement(input);
               stmt.setString(1,"%"+ name + "%");

            }
            else{
               input = "SELECT * FROM student WHERE ime LIKE ? AND prezime LIKE ? ";
                String[] result = src.split(",");
                stmt = this.veza.prepareStatement(input);
               
               stmt.setString(1, "%" +result[0] + "%");
               stmt.setString(2, "%" +result[1] + "%");
            }
            rs = stmt.executeQuery();
      
            student stu;
            while(rs.next()){
                stu = new student(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("prezime"),
                                    rs.getString("adresa"), 
                                    rs.getInt("godina"),
                                    rs.getDate("dat_rod"), 
                                    rs.getString("fakultet"), 
                                    rs.getBytes("slika"));
                list.add(stu);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
   
    
    
    // Student list on 'allStudents' form
    public ArrayList<student> studentList(){
        
        ArrayList<student> list = new ArrayList<student>();
        Statement st;
        ResultSet rs;
        try {
            st = this.veza.createStatement();
            rs = st.executeQuery("SELECT `id`, `ime`, `prezime`, `adresa`, `godina`, `dat_rod`, `fakultet`,`slika` FROM `student` ");
        
            student stu;
            while(rs.next()){
                stu = new student(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("prezime"),
                                    rs.getString("adresa"), 
                                    rs.getInt("godina"),
                                    rs.getDate("dat_rod"), 
                                    rs.getString("fakultet"), 
                                    rs.getBytes("slika"));
                list.add(stu);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
    
    
    
    
    
    // Right table on the 'connectStudents' form
    public ArrayList<student> studentList2(int id){
        
        ArrayList<student> list = new ArrayList<student>();
        Statement st;
        ResultSet rs;
        try {
            Statement stm;
            
            String input1 = "SELECT id, ime, prezime, adresa, godina, dat_rod, fakultet,slika FROM student AS student \n" +
"                     INNER JOIN  popis AS popis ON student.id = popis.student_id\n" +
"                      WHERE popis.natjecaj_id = ? ";
            PreparedStatement stmt = this.veza.prepareStatement(input1);

            stmt.setInt(1, id);
            rs = stmt.executeQuery();
      
            student stu;
            while(rs.next()){
                stu = new student(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("prezime"),
                                    rs.getString("adresa"), 
                                    rs.getInt("godina"),
                                    rs.getDate("dat_rod"), 
                                    rs.getString("fakultet"), 
                                    rs.getBytes("slika"));
                list.add(stu);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
    
    
    // Left table on the 'connectStudents' form
     public ArrayList<student> studentList3(int id){
        
        ArrayList<student> list = new ArrayList<student>();
        Statement st;
        ResultSet rs;
        try {
            Statement stm;
            String input = "SELECT * FROM student WHERE student.id NOT IN ( SELECT popis.student_id FROM popis WHERE popis.natjecaj_id = ?) ORDER BY student.ime ASC;";
           
            PreparedStatement stmt = this.veza.prepareStatement(input);

            stmt.setInt(1, id);
            rs = stmt.executeQuery();
      
            student stu;
            while(rs.next()){
                stu = new student(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("prezime"),
                                    rs.getString("adresa"), 
                                    rs.getInt("godina"),
                                    rs.getDate("dat_rod"), 
                                    rs.getString("fakultet"), 
                                    rs.getBytes("slika"));
                list.add(stu);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
     
     
     
     
     
     
      public ArrayList<student> studentListNotConnectedSearch(int id,String src,int option){
        String input;
        String name = src;
        ArrayList<student> list = new ArrayList<student>();
        Statement st;
        ResultSet rs;
        PreparedStatement stmt;
        try {
            Statement stm;
            if(option == 1){
               input = "SELECT * FROM student WHERE student.id NOT IN ( SELECT popis.student_id FROM popis WHERE popis.natjecaj_id = ?) AND student.ime LIKE ? ";
               stmt = this.veza.prepareStatement(input);
               stmt.setString(2,"%"+ name + "%");
               stmt.setInt(1, id);
              
            }
            else if (option == 2) {
               input = "SELECT * FROM student WHERE student.id NOT IN ( SELECT popis.student_id FROM popis WHERE popis.natjecaj_id = ?) AND student.prezime LIKE ?";
               stmt = this.veza.prepareStatement(input);
               stmt.setInt(1, id);
               stmt.setString(2,"%"+ name + "%");

            }
            else{
                input = "SELECT * FROM student WHERE student.id NOT IN ( SELECT popis.student_id FROM popis WHERE popis.natjecaj_id = ?) AND student.ime LIKE ? AND student.prezime LIKE ?";
                String[] result = src.split(",");
                stmt = this.veza.prepareStatement(input);
               stmt.setInt(1, id);
               stmt.setString(2, "%" +result[0] + "%");
               stmt.setString(3, "%" +result[1] + "%");
            }
            rs = stmt.executeQuery();
      
            student stu;
            while(rs.next()){
                stu = new student(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("prezime"),
                                    rs.getString("adresa"), 
                                    rs.getInt("godina"),
                                    rs.getDate("dat_rod"), 
                                    rs.getString("fakultet"), 
                                    rs.getBytes("slika"));
                list.add(stu);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
    
    
    public ArrayList<student> studentListConnectedSearch(int id,String src,int option){
        String input;
        String name = src;
        ArrayList<student> list = new ArrayList<student>();
        Statement st;
        ResultSet rs;
        PreparedStatement stmt;
        try {
            Statement stm;
            if(option == 1){
               input = "SELECT id, ime, prezime, adresa, godina, dat_rod, fakultet,slika FROM student AS student \n" +
                        "INNER JOIN  popis AS popis ON student.id = popis.student_id\n" +
                        " WHERE popis.natjecaj_id = ? AND student.ime LIKE ?";
               stmt = this.veza.prepareStatement(input);
               stmt.setString(2,"%"+ name + "%");
               stmt.setInt(1, id);
              
            }
            else if(option == 2){
               input = "SELECT id, ime, prezime, adresa, godina, dat_rod, fakultet,slika FROM student AS student \n" +
                        "INNER JOIN  popis AS popis ON student.id = popis.student_id\n" +
                        " WHERE popis.natjecaj_id = ? AND student.prezime LIKE ?";
               stmt = this.veza.prepareStatement(input);
               stmt.setString(2,"%"+ name + "%");
               stmt.setInt(1, id);
              
            }
            else{
               input = "SELECT id, ime, prezime, adresa, godina, dat_rod, fakultet,slika FROM student AS student \n" +
                        "INNER JOIN  popis AS popis ON student.id = popis.student_id\n" +
                        " WHERE popis.natjecaj_id = ? AND student.ime LIKE ? AND student.prezime LIKE ?";
               String[] result = name.split(",");
               stmt = this.veza.prepareStatement(input);
               stmt.setInt(1, id);
               stmt.setString(2,"%"+ result[0]+"%");
               stmt.setString(3,"%"+ result[1]+ "%");
            }

            rs = stmt.executeQuery();
      
            student stu;
            while(rs.next()){
                stu = new student(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("prezime"),
                                    rs.getString("adresa"), 
                                    rs.getInt("godina"),
                                    rs.getDate("dat_rod"), 
                                    rs.getString("fakultet"), 
                                    rs.getBytes("slika"));
                list.add(stu);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
    
    
    
    public ArrayList<natjecaj> scolarshipSearch(String src){
        ArrayList<natjecaj> list = new ArrayList<natjecaj>();
        Statement st;
        ResultSet rs;
        PreparedStatement stmt;
        try {
            st = this.veza.createStatement();
            String input = "SELECT `id`, `ime`, `podaci`, `broj_stipendija`, `iznos` FROM `natjecaj` WHERE natjecaj.ime LIKE ?";
            stmt = this.veza.prepareStatement(input);
            stmt.setString(1,"%"+ src + "%");
            rs = stmt.executeQuery();
            natjecaj nat;
            while(rs.next()){     
                nat = new natjecaj(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("podaci"),                                   
                                    rs.getInt("broj_stipendija"),
                                    rs.getInt("iznos"));
                list.add(nat);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
    
    
    
    
    
    // SCOLARSHIPS
    
     public boolean addScolarship(natjecaj data) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            Statement stm;
            String input = "INSERT INTO NATJECAJ VALUES (?,?,?,?,?)";
            PreparedStatement stmt = this.veza.prepareStatement(input);

            stmt.setInt(1, data.getId());
            stmt.setString(2, data.getIme());
            stmt.setString(3, data.getPodaci());
            stmt.setInt(5, data.getIznos());
            stmt.setInt(4, data.getBrojStipendija());
            
            if(stmt.executeUpdate() != 0){
                
                stmt.close();
                return true;
            }
            else{
                
                return false;
            }
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }
     
    
     
     public ArrayList<natjecaj> scolarshipList(){
        
        ArrayList<natjecaj> list = new ArrayList<natjecaj>();
        Statement st;
        ResultSet rs;
        try {
            st = this.veza.createStatement();
            rs = st.executeQuery("SELECT `id`, `ime`, `podaci`, `broj_stipendija`, `iznos` FROM `natjecaj` ");
        
            natjecaj nat;
            while(rs.next()){     
                nat = new natjecaj(rs.getInt("id"),
                                    rs.getString("ime"),
                                    rs.getString("podaci"),                                   
                                    rs.getInt("broj_stipendija"),
                                    rs.getInt("iznos"));
                list.add(nat);
                
            }
            
        } catch (Exception e) {
        }
        
        
        return list;
    }
     
     
     
     
     
     
       
    public boolean updateScolarship(natjecaj data) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            
            Statement stm; 
            String input = "UPDATE `natjecaj` SET `ime`= ? ,`podaci`= ? ,`broj_stipendija`= ?,`iznos`= ? WHERE `id` = ?";                             
            PreparedStatement stmt = this.veza.prepareStatement(input);  
                
                stmt.setString(1, data.getIme());
                stmt.setString(2, data.getPodaci());
                stmt.setInt(3, data.getBrojStipendija());
                stmt.setInt(4, data.getIznos());               
                stmt.setInt(5, data.getId());
                
                if(stmt.executeUpdate() != 0){
                     stmt.close();
                     return true;
                }
                 else{
                     return false;
                }

        } catch (SQLException e) {
                 logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
                 return false;
        }
 
    }
    
    
    
    public boolean deleteScolarship(natjecaj data) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            
            String count = "SELECT COUNT(*) AS total FROM `popis` WHERE `natjecaj_id` = ?";
            PreparedStatement stmCount = this.veza.prepareStatement(count);
            stmCount.setInt(1, data.getId());
            ResultSet rs = stmCount.executeQuery();
            rs.next();
            int broj = rs.getInt("total");
            if(broj >0 ){
                
                String input1 = "DELETE FROM `popis` WHERE `natjecaj_id` = ?";
                PreparedStatement stmt1 = this.veza.prepareStatement(input1);
                stmt1.setInt(1, data.getId());
                
                String input = "DELETE FROM `natjecaj` WHERE `id` = ?";
                PreparedStatement stmt = this.veza.prepareStatement(input);
                stmt.setInt(1, data.getId());
            
                if(stmt1.executeUpdate() != 0){
                    if(stmt.executeUpdate() != 0){
                         stmt1.close();
                         stmt.close();
                         return true;
                    }
                    else{
                        return false;
                    }
                }
                else{              
                    return false;
                }
            }
            else{
                String input = "DELETE FROM `natjecaj` WHERE `id` = ?";
                PreparedStatement stmt = this.veza.prepareStatement(input);
                stmt.setInt(1, data.getId());
                 if(stmt.executeUpdate() != 0){
                     stmt.close();
                     return true;
                 }
                 else{
                     return false;
                 }
            }
           
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean scolarshipCapacity(int id) throws java.sql.SQLException{
        try {
            String amount = "SELECT * FROM `natjecaj` WHERE `id` = ?";
            PreparedStatement stmAmount = this.veza.prepareStatement(amount);
            stmAmount.setInt(1, id);
            ResultSet rs1 = stmAmount.executeQuery();
            rs1.next();
            int max = rs1.getInt(4);
            
            String count = "SELECT COUNT(*) AS total FROM `popis` WHERE `natjecaj_id` = ?";
            PreparedStatement stmCount = this.veza.prepareStatement(count);
            stmCount.setInt(1, id);
            ResultSet rs = stmCount.executeQuery();
            rs.next();
            int broj = rs.getInt("total");
            if(max > broj){
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
        
        
    }
    
    
    public int scolarshipNumber(int id) throws java.sql.SQLException{
        int number = 0;
        try {
            String count = "SELECT COUNT(*) AS total FROM `popis` WHERE `natjecaj_id` = ?";
            PreparedStatement stmCount = this.veza.prepareStatement(count);
            stmCount.setInt(1, id);
            ResultSet rs = stmCount.executeQuery();
            rs.next();
            number = rs.getInt("total"); 
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING,"SQLException " + e.getMessage());
        }
        return number;
    }
     
     
     
    
    
    // SCOLARSHIPS END
    
    
    
    // CONNECT
    
    
    
    public boolean connectStudent(int sId,int nId) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            Statement stm;
            String input = "INSERT INTO POPIS VALUES (?,?)";
            PreparedStatement stmt = this.veza.prepareStatement(input);

            stmt.setInt(1, sId);
            stmt.setInt(2, nId);
            
            if(stmt.executeUpdate() != 0){
                
                stmt.close();
                return true;
            }
            else{
                
                return false;
            }
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }
    
    public boolean disconnectStudent(int sId,int nId) {
     
        if (this.veza == null ) {
            return false;
        }
        try {
            Statement stm;
            String input = "DELETE FROM popis WHERE popis.student_id = ? AND popis.natjecaj_id = ?";
            PreparedStatement stmt = this.veza.prepareStatement(input);

            stmt.setInt(1, sId);
            stmt.setInt(2, nId);
            
            if(stmt.executeUpdate() != 0){
                
                stmt.close();
                return true;
            }
            else{
                
                return false;
            }
            
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }
    
    
    
    public String login(String kor,String loz){
        
        
        ResultSet rs;
        String OK = "not";
        
        try {
            Statement stm;
            String input = "SELECT `kor_ime`,`lozinka` FROM `korisnik` WHERE `kor_ime` = ? AND `lozinka` = ?";
            PreparedStatement ps = this.veza.prepareStatement(input);
            
            
            //ps=this.veza.prepareStatement("SELECT `kor_ime`,`lozinka` FROM `korisnik` WHERE `kor_ime` = ? AND `lozinka` = ?");
            ps.setString(1, kor);
            ps.setString(2, loz);
            rs = ps.executeQuery();
            if(rs.next()){
                OK = kor;
                return OK;
            }
            else{
                return OK;
            }
  
        } catch (Exception e) {
             
                return OK;
        }
        
    }
    
    /*
    public boolean promijeniGodinaStudent(String ime, String prezime, int godina) {
         if (this.conn == null ) {
            return false;
        }
        try {
            Statement stmt = this.conn.createStatement();
            String query = "UPDATE  STUDENT SET godina=" + godina
                    + " WHERE ( ime = '" + ime + "' AND prezime='"+prezime+"' )";
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (SQLException ex) {
            logger_err.log(Level.WARNING, "SQLException: " + ex.getMessage());
            return false;
        }
    }
    
    public Vector odrediSveStudenteGodina(int godina) throws java.sql.SQLException {

        Vector vec = new Vector();
        if (this.conn == null) {
            return vec;
        }
        try {
            Statement stm = this.conn.createStatement();
            String query = "SELECT  * FROM STUDENT WHERE godina="+ godina+" ORDER BY PREZIME, IME";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Student data = new Student();
                data.setId(rs.getInt(1)); //  ID studenta
                data.setIme(rs.getString(2)); // Ime studenta
                data.setPrezime(rs.getString(3)); // Prezime studenta
                data.setSpol(rs.getInt(4)); // Spol studenta
                data.setGodina(rs.getInt(5)); // Godina studija studenta
                vec.addElement(data);
            }
            query = null;
            rs.close();
            stm.close();
            return vec;
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return vec;
        }
    }
    
    public Vector odrediSveStudenteSpol(int spol) throws java.sql.SQLException {

        Vector vec = new Vector();
        if (this.conn == null) {
            return vec;
        }
        try {
            Statement stm = this.conn.createStatement();
            String query = "SELECT  * FROM STUDENT WHERE spol="+ spol+" ORDER BY PREZIME, IME";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                student data = new student();
                data.setId(rs.getInt(1)); //  ID studenta
                data.setIme(rs.getString(2)); // Ime studenta
                data.setPrezime(rs.getString(3)); // Prezime studenta
                data.setSpol(rs.getInt(4)); // Spol studenta
                data.setGodina(rs.getInt(5)); // Godina studija studenta
                vec.addElement(data);
            }
            query = null;
            rs.close();
            stm.close();
            return vec;
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return vec;
        }
    }
    */
}
