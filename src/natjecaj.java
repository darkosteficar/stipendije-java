/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC Master Race
 */
public class natjecaj {
    
    private int id;
    private String ime;
    private String podaci;
    private int brojStipendija;
    private int iznos;

    public natjecaj() {
    }

    public natjecaj(int id, String ime, String podaci, int brojStipendija, int iznos) {
        this.id = id;
        this.ime = ime;
        this.podaci = podaci;
        this.brojStipendija = brojStipendija;
        this.iznos = iznos;
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

    public String getPodaci() {
        return podaci;
    }

    public void setPodaci(String podaci) {
        this.podaci = podaci;
    }

    public int getBrojStipendija() {
        return brojStipendija;
    }

    public void setBrojStipendija(int brojStipendija) {
        this.brojStipendija = brojStipendija;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }
    
    
}
