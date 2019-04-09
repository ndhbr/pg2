package Uebungsblatt3;

class MitarbeiterListe {

    private Mitarbeiter[] mitarbeiter;
    private int mitarbeiterAnzahl;
    private int aktuelleMitarbeiterAnzahl;

    public MitarbeiterListe(int mitarbeiterAnzahl) {
        this.mitarbeiterAnzahl = mitarbeiterAnzahl;
        this.aktuelleMitarbeiterAnzahl = 0;

        this.mitarbeiter = new Mitarbeiter[this.mitarbeiterAnzahl];
    }

    int getSize() {
        return this.aktuelleMitarbeiterAnzahl;
    }

    boolean add(Mitarbeiter m) {
        if(this.aktuelleMitarbeiterAnzahl < mitarbeiterAnzahl) {
            this.mitarbeiter[this.aktuelleMitarbeiterAnzahl] = m;
            this.aktuelleMitarbeiterAnzahl++;
            return true;
        }

        return false;
    }

    boolean remove(Mitarbeiter m) {
        for(int i = 0; i < mitarbeiterAnzahl-1; i++) {
            if(this.mitarbeiter[i].equals(m))
            {
                this.mitarbeiter[i] = null;
                return true;
            }
        }

        return false;
    }

    Mitarbeiter get(int index) {
        if(index < 0 || index > mitarbeiterAnzahl-1)
            return null;

        return this.mitarbeiter[index];
    }

    Mitarbeiter set(int index, Mitarbeiter m) {
        if(index < 0 || index > mitarbeiterAnzahl-1)
            return null;

        Mitarbeiter tmpMitarbeiter = null;

        if(this.mitarbeiter[index] != null)
        	tmpMitarbeiter = this.mitarbeiter[index];

        this.mitarbeiter[index] = m;

        return tmpMitarbeiter;
    }
}