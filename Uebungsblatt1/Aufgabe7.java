package Uebungsblatt1;

import java.util.Scanner;

public class Aufgabe7
{
    public static void main (String[] args)
    {
        int ersteZahl = 0,
            zweiteZahl = 0,
            ergebnis = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Zahl1: ");
        ersteZahl = sc.nextInt();

        System.out.print("Zahl2: ");
        zweiteZahl = sc.nextInt();

        sc.close();

        ergebnis = ggt(ersteZahl, zweiteZahl);

        System.out.println("Kleinster gemeinsamer Teiler von "  + ersteZahl +
            " und " + zweiteZahl + " ist: " + ergebnis);
    }

    private static int ggt(int a, int b)
    {
        while (b != 0)
        {
            if (a > b)
            {
                a -= b;
            }
            else {
                b = b - a;
            }
        }

        return a;
    }
}