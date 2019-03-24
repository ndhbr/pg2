package Uebungsblatt1;

import java.lang.*;

public class Aufgabe3
{
    public static void main (String[] args)
    {
        double  a = 3.0,
                b = 9.0,
                c = 6.0;

        double resultPositive = quadratischeGleichungLoesen(a, b, c, true);
        double resultNegative = quadratischeGleichungLoesen(a, b, c, false);

        System.out.println("Positiv: " + String.valueOf(resultPositive) +
            ", Negativ: " + String.valueOf(resultNegative));
    }

    public static double quadratischeGleichungLoesen(double a, double b, double c, boolean positive)
    {
        double ergebnis = 0.0;

        if(positive)
        {
            ergebnis = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        }
        else
        {
            ergebnis = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        }

        return ergebnis;
    }
}