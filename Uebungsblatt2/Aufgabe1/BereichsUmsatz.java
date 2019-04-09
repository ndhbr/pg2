package Uebungsblatt2.Aufgabe1;

class BereichsUmsatz {
    private String bereich;
    private double umsatz;

    BereichsUmsatz() {}
    BereichsUmsatz(String bereich, double umsatz) {
        if(umsatz > 0) {
            this.bereich = bereich;
            this.umsatz = umsatz;
        }
    }

    public String toString() {
        return this.bereich + " (" + this.umsatz + ")";
    }

    public void setBereich(String bereich) {
        this.bereich = bereich;
    }

    public void setUmsatz(double umsatz) {
        this.umsatz = umsatz;
    }

    public String getBereich() {
        return this.bereich;
    }

    public double getUmsatz() {
        return this.umsatz;
    }
}