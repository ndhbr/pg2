package Uebungsblatt1;

import java.util.Scanner;

public class Aufgabe9
{
    public static void main (String[] args)
    {
        int einzuleseneZahl = 0,
            tmpZahl = 0,
            ergebnis = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Zahl: ");
        einzuleseneZahl = sc.nextInt();

        sc.close();

        tmpZahl = einzuleseneZahl;

        while(tmpZahl > 0) {
            ergebnis += tmpZahl % 10;
            tmpZahl /= 10;
        }

        System.out.println("Die Quersumme von  "  + einzuleseneZahl +
            " ist " + ergebnis);
    }
}