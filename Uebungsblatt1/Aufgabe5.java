package Uebungsblatt1;

import java.util.Scanner;

public class Aufgabe5
{
    public static void main (String[] args)
    {
        int von, bis, sum = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Zahl1: ");
        von = sc.nextInt();

        System.out.print("Zahl2: ");
        bis = sc.nextInt();

        sc.close();

        if(bis < von) {
            int tmp = von;
            von = bis;
            bis = tmp;
        }

        sum = von + bis;

        System.out.print(String.valueOf(von) + " + ");

        ++von;

        for(;von < bis; von++) {
            System.out.print(String.valueOf(von) + " + ");
            sum += von;
        }

        System.out.print(String.valueOf(bis) + " = " + String.valueOf(sum) + "\n");
    }
}