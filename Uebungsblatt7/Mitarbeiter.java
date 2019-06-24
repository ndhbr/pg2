class Mitarbeiter {

    private static int count = 1;

    private int id;
    private String name;

    public Mitarbeiter() {}

    public Mitarbeiter(String name) {
        this.id = count;
        this.name = name;

        count++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean istKleiner(Mitarbeiter m) {
        if(this.name.compareTo(m.name) > 0)
            return false;

        return true;
    }

    public String toString() {
        return this.id + ", " + this.name;
    }
}