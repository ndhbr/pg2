package Uebungsblatt1;

import java.util.Scanner;

public class Aufgabe8
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

        ergebnis = kgv(ersteZahl, zweiteZahl);

        System.out.println("Kleinstes gemeinsames Vielfaches von "  + ersteZahl +
            " und " + zweiteZahl + " ist: " + ergebnis);
    }

    private static int kgv(int a, int b)
    {
        if(a < 0 || b < 0)
            return -1;

        if(a == b)
            return a;

        if(a == 1)
            return b;

        if(b == 1)
            return a;

        int schrittA = a,
            schrittB = b;

        while (a != b) {
            if (a < b)
                a += schrittA;
            else
                b += schrittB;
        }

        return a;
    }
}