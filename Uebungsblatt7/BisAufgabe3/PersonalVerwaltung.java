package BisAufgabe3;

class PersonalVerwaltung {

    static MyArrayList<Mitarbeiter> mitarbeiterListe;
    static MyArrayList<Abrechnung> abrechnungenListe;

    public static void main(String[] args) {
        mitarbeiterListe = new MyArrayList<Mitarbeiter>(3);
        abrechnungenListe = new MyArrayList<Abrechnung>(6);
        PersonalVerwaltung pv = new PersonalVerwaltung();

        Mitarbeiter m1 = new Mitarbeiter("Josef Maier");
        pv.addMitarbeiter(m1);

        Mitarbeiter m2 = new Mitarbeiter("Franz Huber");
        pv.addMitarbeiter(m2);

        Mitarbeiter m3 = new Mitarbeiter("Werner Müller");
        pv.addMitarbeiter(m3);

        Mitarbeiter m4 = new Mitarbeiter("Hans Meier");
        pv.addMitarbeiter(m4);

        Mitarbeiter m5 = new Mitarbeiter("Tom Tollbahn");
        pv.addMitarbeiter(m5);

        Mitarbeiter m6 = new Mitarbeiter("Friedrich Ulberger");
        pv.addMitarbeiter(m6);

        Mitarbeiter m7 = new Mitarbeiter("Franz Xaver");
        pv.addMitarbeiter(m7);

        Mitarbeiter m8 = new Mitarbeiter("Lena Dreher");
        pv.addMitarbeiter(m8);

        Mitarbeiter m9 = new Mitarbeiter("Laura Lang");
        pv.addMitarbeiter(m9);

        Mitarbeiter m10 = new Mitarbeiter("Günther Münther");
        pv.addMitarbeiter(m10);

        Mitarbeiter m11 = new Mitarbeiter("Rebecca Rehlauf");
        pv.addMitarbeiter(m11);

        Mitarbeiter m12 = new Mitarbeiter("Andreas Alpant");
        pv.addMitarbeiter(m12);

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
        System.out.println("Mitarbeiter: ");

        for(Mitarbeiter m : mitarbeiterListe) {
            System.out.println(m);
        }
    }

    public void listAbrechnungen(int periode) {
        System.out.println("Abrechnungen: ");

        for(Abrechnung a : abrechnungenListe) {
            if(a.getPeriode() != periode)
                continue;

            System.out.println(a);
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