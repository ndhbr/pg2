package Uebungsblatt3;

public abstract class Abrechnung {

    private int periode;
    private Mitarbeiter mitarbeiter;

    public Abrechnung(int periode, Mitarbeiter m) {
        this.periode = periode;
        this.mitarbeiter = m;
    }

    public abstract double getVerdienst();

    public int getPeriode() {
        return periode;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public String toString() {
        return String.valueOf(getPeriode()) + ", " + getMitarbeiter().getName() +
            ", " + getVerdienst();
    }
}