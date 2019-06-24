import java.util.Arrays;

class MyArrayList<T> {

    private T[] elemente;
    private int elementAnzahl;
    private int aktuelleElementAnzahl;

    public MyArrayList(int elementAnzahl) {
        this.elementAnzahl = elementAnzahl;
        aktuelleElementAnzahl = 0;

        this.elemente = (T[]) new Object[this.elementAnzahl];
    }

    int getSize() {
        return aktuelleElementAnzahl;
    }

    boolean add(T e) {
        if(aktuelleElementAnzahl == elementAnzahl) {
            elementAnzahl *= 2;
            elemente = Arrays.copyOf(elemente, elementAnzahl);
        }

        if(aktuelleElementAnzahl < elementAnzahl) {
            elemente[aktuelleElementAnzahl] = e;
            aktuelleElementAnzahl++;

            return true;
        }

        return false;
    }

    boolean remove(T m) {
        for(int i = 0; i < elementAnzahl-1; i++) {
            if(elemente[i].equals(m))
            {
                elemente[i] = null;
                return true;
            }
        }

        return false;
    }

    T get(int index) {
        if(index < 0 || index > elementAnzahl-1)
            return null;

        return elemente[index];
    }

    T set(int index, T m) {
        if(index < 0 || index > elementAnzahl-1)
            return null;

        T tmpElement = null;

        if(elemente[index] != null)
        	tmpElement = elemente[index];

        elemente[index] = m;

        return tmpElement;
    }
}