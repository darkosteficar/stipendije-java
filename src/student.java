
import java.sql.Blob;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC Master Race
 */
public class student {
    private int id;
    private String ime;
    private String prezime;
    private String adresa;
    private int godina;
    private Date dat_rod;
    private String fakultet;
    private byte[] slika;

    public student() {
    }

    public student(int id, String ime, String prezime, String adresa, int godina, Date dat_rod, String fakultet, byte[] slika) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.godina = godina;
        this.dat_rod = dat_rod;
        this.fakultet = fakultet;
        this.slika = slika;
    }
    
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public Date getDat_rod() {
        return dat_rod;
    }

    public void setDat_rod(Date dat_rod) {
        this.dat_rod = dat_rod;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }
    
    
    
    
}
