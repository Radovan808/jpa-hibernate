package cz.rado.model;

import cz.rado.converters.PohlaviConverter;
import cz.rado.model.enums.Pohlavi;

import javax.persistence.*;

@Entity
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PohlaviConverter.class)
    private Pohlavi pohlavi;

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
}
