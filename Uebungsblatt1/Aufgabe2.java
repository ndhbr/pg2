package Uebungsblatt1;

public class Aufgabe2
{
    public static void main (String[] args)
    {
        int x = 3;
        int y = 5;
        int tmp = 0;

        System.out.println("X: " + String.valueOf(x) + ", Y: " + String.valueOf(y));

        tmp = x;
        x = y;
        y = tmp;

        System.out.println("X: " + String.valueOf(x) + ", Y: " + String.valueOf(y));
    }
}