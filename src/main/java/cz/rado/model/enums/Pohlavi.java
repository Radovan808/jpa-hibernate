package cz.rado.model.enums;

public enum Pohlavi {
    Muz('M'),
    Zena('Z');
    private char kod;
    Pohlavi(char kod) {
        this.kod = kod;
    }

    public static Pohlavi getEnumFromKod(Character kod) {
        if (kod.equals('M') || kod.equals('m')){
            return Muz;
        }
        if (kod.equals('Z') || kod.equals('z')){
            return Zena;
        }
        throw new UnsupportedOperationException("Pro dany kod " + kod + " neexistuje enum typu Pohlavi");
    }

    public char getKod() {
        return kod;
    }
}
