class AbrechnungenListe {

    private Abrechnung[] abrechnungen;
    private int abrechnungenAnzahl;
    private int aktuelleAbrechnungenAnzahl;

    public AbrechnungenListe(int abrechnungenAnzahl) {
        this.abrechnungenAnzahl = abrechnungenAnzahl;
        this.aktuelleAbrechnungenAnzahl = 0;

        this.abrechnungen = new Abrechnung[this.abrechnungenAnzahl];
    }

    int getSize() {
        return this.aktuelleAbrechnungenAnzahl;
    }

    boolean add(Abrechnung a) {
        if(this.aktuelleAbrechnungenAnzahl < this.abrechnungenAnzahl) {
            this.abrechnungen[this.aktuelleAbrechnungenAnzahl] = a;
            this.aktuelleAbrechnungenAnzahl++;

            return true;
        }

        return false;
    }

    Abrechnung get(int index) {
        if(index < 0 || index > abrechnungenAnzahl-1)
            return null;

        return this.abrechnungen[index];
    }

    Abrechnung set(int index, Abrechnung a) {
        if(index < 0 || index > abrechnungenAnzahl-1)
            return null;

        Abrechnung tmpAbrechnung = null;

        if(this.abrechnungen[index] != null)
            tmpAbrechnung = this.abrechnungen[index];

        this.abrechnungen[index] = a;

        return tmpAbrechnung;
    }
}