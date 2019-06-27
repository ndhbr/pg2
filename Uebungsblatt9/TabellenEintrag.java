public class TabellenEintrag {

    private int platz;
    private String clubName;
    private int punkte;

    public TabellenEintrag() {}

    public TabellenEintrag(int platz, String clubName, int punkte) {
        this.platz = platz;
        this.clubName = clubName;
        this.punkte = punkte;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public int getPlatz() {
        return this.platz;
    }

    public String getClubName() {
        return this.clubName;
    }

    public int getPunkte() {
        return this.punkte;
    }
}