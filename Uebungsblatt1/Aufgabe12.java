package Uebungsblatt1;

public class Aufgabe12
{
    public static void main (String[] args)
    {
        int decNum = 105;
        String binNum = "";

        while(decNum > 0) {
            if(decNum % 2 == 0)
                binNum = "0" + binNum;
            else
                binNum = "1" + binNum;

            decNum /= 2;
        }

        System.out.println("Result: " + binNum);
    }
}