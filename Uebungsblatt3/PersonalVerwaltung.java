package Uebungsblatt3;

class PersonalVerwaltung {

    static MitarbeiterListe mitarbeiterListe;
    static AbrechnungenListe abrechnungenListe;

    public static void main(String[] args) {
        mitarbeiterListe = new MitarbeiterListe(3);
        abrechnungenListe = new AbrechnungenListe(6);
        PersonalVerwaltung pv = new PersonalVerwaltung();

        Mitarbeiter m1 = new Mitarbeiter("Josef Maier");
        pv.addMitarbeiter(m1);

        Mitarbeiter m2 = new Mitarbeiter("Franz Huber");
        pv.addMitarbeiter(m2);

        Mitarbeiter m3 = new Mitarbeiter("Werner Müller");
        pv.addMitarbeiter(m3);

        pv.listMitarbeiter();
        pv.sortMitarbeiter();
        pv.listMitarbeiter();

        pv.addAbrechnung(new LohnAbrechnung(1, m1, 10, 158));
        pv.addAbrechnung(new GehaltsAbrechnung(1, m2, 3010));
        pv.addAbrechnung(new GehaltsAbrechnung(1, m3, 2700));
        pv.addAbrechnung(new LohnAbrechnung(2, m1, 16, 158));
        pv.addAbrechnung(new GehaltsAbrechnung(2, m2, 3010));
        pv.addAbrechnung(new GehaltsAbrechnung(2, m3, 2800));
        pv.listAbrechnungen(2);
    }

    public void addMitarbeiter(Mitarbeiter m) {
        mitarbeiterListe.add(m);
    }

    public void removeMitarbeiter(Mitarbeiter m) {
        mitarbeiterListe.remove(m);
    }

    public void addAbrechnung(Abrechnung a) {
        abrechnungenListe.add(a);
    }

    public void listMitarbeiter() {
        int size = mitarbeiterListe.getSize();

        for(int i = 0; i < size; i++) {
            System.out.println(mitarbeiterListe.get(i).toString());
        }
    }

    public void listAbrechnungen(int periode) {
        int size = abrechnungenListe.getSize();

        for(int i = 0; i < size; i++) {
            Abrechnung tmpAbrechnung = abrechnungenListe.get(i);

            if(tmpAbrechnung.getPeriode() == periode) {
                System.out.println(periode + ", " +
                    tmpAbrechnung.getMitarbeiter().getName() + ", " +
                    tmpAbrechnung.getVerdienst());
            }
        }
    }

    public void sortMitarbeiter() {
        int size = mitarbeiterListe.getSize();

        for(int i = 1; i < size; i++) {
            for(int j = 0; j < size-i; j++) {
                Mitarbeiter a = mitarbeiterListe.get(j);
                Mitarbeiter b = mitarbeiterListe.get(j+1);

                if(b != null && b.istKleiner(a)) {
                    Mitarbeiter tmpMitarbeiter = mitarbeiterListe.set(j, b);
                    mitarbeiterListe.set(j+1, tmpMitarbeiter);
                }
            }
        }
    }
}