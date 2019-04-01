package Uebungsblatt1;

public class Aufgabe13
{
    public static void main (String[] args)
    {
        int x = 2,
            i = 2,
            counter = 0,
            results[] = new int[500];

        while(x < 1000)
        {
            for(i = 2; i <= x; i++)
            {
                if((x % i) == 0 && x != i)
                    break;

                if(x == i)
                {
                    results[counter] = x;
                    counter++;
                }
            }

            x++;
        }

        for(int j = 0; j < counter; j++) {
            System.out.println(String.valueOf(results[j]));
        }
    }
}