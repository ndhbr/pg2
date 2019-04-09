package Uebungsblatt3;

public class GehaltsAbrechnung extends Abrechnung {

    private double gehalt;

    public GehaltsAbrechnung(int periode, Mitarbeiter m, double gehalt) {
        super(periode, m);

        this.gehalt = gehalt;
    }

    public double getVerdienst() {
        return gehalt;
    }
}