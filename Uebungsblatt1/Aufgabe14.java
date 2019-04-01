package Uebungsblatt1;

public class Aufgabe14
{
    public static void main (String[] args)
    {
        boolean bedingung = false;

        if(bedingung)
            System.out.println("True");
        else
            System.out.println("False");

        while(bedingung) {
            System.out.println("True");
            break;
        }

        while(!bedingung) {
            System.out.println("False");
            break;
        }
    }
}