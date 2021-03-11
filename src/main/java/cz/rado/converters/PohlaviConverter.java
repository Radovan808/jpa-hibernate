package cz.rado.converters;

import cz.rado.model.enums.Pohlavi;

import javax.persistence.AttributeConverter;

public class PohlaviConverter implements AttributeConverter<Pohlavi, Character> {
    @Override
    public Character convertToDatabaseColumn(Pohlavi pohlavi) {
        if (pohlavi==null){
            return null;
        }
        return pohlavi.getKod();
    }

    @Override
    public Pohlavi convertToEntityAttribute(Character character) {
        if (character == null ){
            return null;
        }
        return Pohlavi.getEnumFromKod(character);
    }
}
