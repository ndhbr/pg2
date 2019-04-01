package Uebungsblatt1;

public class Aufgabe10
{
    public static void main (String[] args)
    {
        int x = 100;
        int resultA = recursiveFibonacci(x);
        int resultB = iterativeFibonacci(x);

        System.out.println("x = " + x + ", resultA = " + resultA +
            ", resultB = " + resultB);
    }

    private static int recursiveFibonacci(int x) {
        if(x <= 0)
            return 0;
        else if(x == 1)
            return 1;
        else
            return recursiveFibonacci(x-2) + recursiveFibonacci(x-1);
    }

    private static int iterativeFibonacci(int x) {
        int result = 1;
        int tmp[] = {1, 1};

        if(x <= 0)
            return 0;
        else if(x == 1)
            return 1;

        for(int i = 2; i < x; i++) {
            tmp[0] = result;
            result += tmp[1];
            tmp[1] = tmp[0];
        }

        return result;
    }
}