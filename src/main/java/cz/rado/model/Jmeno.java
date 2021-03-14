package cz.rado.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Jmeno {
    @Column(name = "titul_pred")
    private String titulpred;

    @Column(name = "titul_za")
    private String titulza;

    @Column(name = "jmeno")
    private String jmeno;

    @Column(name = "prijmeni")
    private String prijmeni;

    @Column(name = "prezdivka")
    private String prezdivka;

    public Jmeno(String titulpred, String jmeno, String prijmeni, String titulza, String prezdivka) {
        this.titulpred = titulpred;
        this.titulza = titulza;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.prezdivka = prezdivka;
    }

    public Jmeno() {
    }

    public String getTitulpred() {
        return titulpred;
    }

    public void setTitulpred(String titulpred) {
        this.titulpred = titulpred;
    }

    public String getTitulza() {
        return titulza;
    }

    @Override
    public String toString() {
        return "Jmeno{" +
                "titulpred='" + titulpred + '\'' +
                ", titulza='" + titulza + '\'' +
                ", jmeno='" + jmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                ", prezdivka='" + prezdivka + '\'' +
                '}';
    }

    public void setTitulza(String titulza) {
        this.titulza = titulza;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        this.prezdivka = prezdivka;
    }
}
