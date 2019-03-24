package Uebungsblatt1;

public class Aufgabe4
{
    public static void main (String[] args)
    {
        int primeCount = 0,
            x = 2,
            i = 2;

        while(primeCount < 1000)
        {
            for(i = 2; i <= x; i++)
            {
                if((x % i) == 0 && x != i)
                    break;

                if(x == i)
                {
                    System.out.println(String.valueOf(x));
                    primeCount++;
                }
            }

            x++;
        }
    }
}