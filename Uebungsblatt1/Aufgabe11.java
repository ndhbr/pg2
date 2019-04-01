package Uebungsblatt1;

public class Aufgabe11
{
    public static void main (String[] args)
    {
        int zeilen = 6;

        for(int i = 0; i < zeilen; i++)
        {
            for(int j = 0; j < i; j++)
            {
                System.out.print(pascal(i, j) + " ");
            }

            System.out.println();
        }
    }

    private static int pascal(int zeile, int spalte)
    {
        if(spalte == 0 || spalte == zeile || zeile == 0)
            return 1;

        return pascal(zeile-1, spalte-1) + pascal(zeile-1, spalte);
    }
}