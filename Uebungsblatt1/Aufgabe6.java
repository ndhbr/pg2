package Uebungsblatt1;

public class Aufgabe6
{
    public static void main (String[] args)
    {
        float squareRootOf = 25;

        float x = squareRootOf;
        float y = 1;
        float accuracy = 0.000001f;

        while (x - y > accuracy) {
            x = (x + y) / 2;
            y = squareRootOf / x;
        }

        System.out.println("Wurzel aus " + String.valueOf(squareRootOf) +
            " ist " + String.valueOf(x));
    }
}