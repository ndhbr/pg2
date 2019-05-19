public class Kunde {
    private String nachname;
    private String vorname;

    public Kunde() {}

    public Kunde(String nachname, String vorname) {
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}