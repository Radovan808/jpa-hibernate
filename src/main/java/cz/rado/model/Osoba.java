package cz.rado.model;

import cz.rado.converters.PohlaviConverter;
import cz.rado.model.enums.Pohlavi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Osoba extends Obcan{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PohlaviConverter.class)
    private Pohlavi pohlavi;


    @Embedded
    private Jmeno jmeno;

    @OneToMany(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Telefon> telefony = new ArrayList<>();

    @ManyToMany(mappedBy = "osobyVSkupine", fetch = FetchType.LAZY)
    private Set<SkupinaKontaktu> skupinyOsoby = new HashSet<>();

    @OneToOne(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Adresa adresa;

    public Osoba() {
    }

    public Osoba(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public Jmeno getJmeno() {
        return jmeno;
    }

    public void setJmeno(Jmeno jmeno) {
        this.jmeno = jmeno;
    }

    public List<Telefon> getTelefony() {
        return telefony;
    }
    public void addTelefon(Telefon telefon){
        telefony.add(telefon);
        telefon.setOsoba(this);
    }

    public void removeTelefon(Telefon telefon){
        telefony.remove(telefon);
        telefon.setOsoba(null);
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public void setTelefony(List<Telefon> telefony) {
        this.telefony = telefony;
    }

    public Set<SkupinaKontaktu> getSkupinyOsoby() {
        return skupinyOsoby;
    }

    public void setSkupinyOsoby(Set<SkupinaKontaktu> skupinyOsoby) {
        this.skupinyOsoby = skupinyOsoby;
    }
    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", pohlavi=" + pohlavi +
                ", jmeno=" + jmeno +
                '}';
    }
}
