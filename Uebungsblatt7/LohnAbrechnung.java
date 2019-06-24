public class LohnAbrechnung extends Abrechnung {

    private double stundenLohn;
    private double anzahlStunden;

    public LohnAbrechnung(int periode, Mitarbeiter m, double stundenlohn, double stunden) {
        super(periode, m);

        this.stundenLohn = stundenlohn;
        this.anzahlStunden = stunden;
    }

    public double getVerdienst() {
        return stundenLohn * anzahlStunden;
    }
}