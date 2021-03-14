package cz.rado.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skupina")
public class SkupinaKontaktu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazev")
    private String nazevSkupiny;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "skupina_id",
                    foreignKey = @ForeignKey(name="fk_skupina_id")),
            inverseJoinColumns = @JoinColumn(name = "osoba_id",
                    foreignKey = @ForeignKey(name="fk_2_osoba_id")))
    private List<Osoba> osobyVSkupine = new ArrayList<>();

    public SkupinaKontaktu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazevSkupiny() {
        return nazevSkupiny;
    }

    public void setNazevSkupiny(String nazovSkupiny) {
        this.nazevSkupiny = nazovSkupiny;
    }

    public List<Osoba> getOsobyVSkupine() {
        return osobyVSkupine;
    }

    public void setOsobyVeSkupine(List<Osoba> osobyVSkupine) {
        this.osobyVSkupine = osobyVSkupine;
    }
}

/*
CREATE TABLE skupina (
  ID int(19) NOT NULL AUTO_INCREMENT,
  NAZEV varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE skupina_osoba (
  skupina_id int(19) NOT NULL,
  osoba_id int(19) NOT NULL,
  PRIMARY KEY (skupina_id, osoba_id)
);

ALTER TABLE skupina_osoba ADD CONSTRAINT fk_skupina_id FOREIGN KEY (skupina_id) REFERENCES skupina(ID);
ALTER TABLE skupina_osoba ADD CONSTRAINT fk_2_osoba_id FOREIGN KEY (osoba_id) REFERENCES OSOBA(ID);

 */
