package AbAufgabe4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class MyArrayList<T> implements Iterable<T> {

    private T[] elemente;
    private int aktuelleElementAnzahl;

    public MyArrayList(int elementAnzahl) {
        aktuelleElementAnzahl = 0;

        this.elemente = (T[]) new Object[elementAnzahl];
    }

    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {

        private int curIndex;

        private MyArrayListIterator() {
            curIndex = 0;
        }

        public boolean hasNext() {
            return curIndex < getSize();
        }

        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            return get(curIndex++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    int getSize() {
        return aktuelleElementAnzahl;
    }

    boolean add(T e) {
        if(aktuelleElementAnzahl == this.elemente.length) {
            elemente = Arrays.copyOf(elemente, this.elemente.length*2);
        }

        if(aktuelleElementAnzahl < this.elemente.length) {
            elemente[aktuelleElementAnzahl] = e;
            aktuelleElementAnzahl++;

            return true;
        }

        return false;
    }

    boolean remove(T m) {
        for(int i = 0; i < this.elemente.length-1; i++) {
            if(elemente[i].equals(m))
            {
                elemente[i] = null;
                return true;
            }
        }

        return false;
    }

    T get(int index) {
        if(index < 0 || index > this.elemente.length-1)
            return null;

        return elemente[index];
    }

    T set(int index, T m) {
        if(index < 0 || index > this.elemente.length-1)
            return null;

        T tmpElement = null;

        if(elemente[index] != null)
        	tmpElement = elemente[index];

        elemente[index] = m;

        return tmpElement;
    }
}