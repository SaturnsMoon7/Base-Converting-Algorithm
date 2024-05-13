import java.util.ArrayList;
import java.lang.Math;

public class Main
    {
    public static void main(String[] args) 
    {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList.add(7);
        numberList.add(2);
        numberList.add(4);
        numberList.add(3); 
        int base = 8;

        System.out.println("Iterative: " + IterativeBaseConverter(numberList, base));
        System.out.println("Recursive: " + RecursiveBaseConverter(numberList, base));

        System.out.println(Log(3, 7));
        //System.out.println("Iterative: " + IterativeBaseConverterMod(numberList, base, 6));
    }

    public static int IterativeBaseConverter(ArrayList<Integer> digits, int base)
    {
        int num = 0;
        int numDigits = digits.size();

        for (int i = 0; i < numDigits; i++) // Loops through each index of the list
        {
            int value = digits.get(i); // The digit in position (i)

            if (value > (base - 1)) // Checks if number is a valid symbol for the base
            { throw new ArithmeticException("Unknown symbol"); }

            int multiplier = (int)Math.pow(base, (numDigits - 1) - i); // The base to the power of the difference of #digits and (i)
            num += value * multiplier; 
        }
        return num;
    }

    public static int RecursiveBaseConverter(ArrayList<Integer> digits, int base)
    {
        int numDigits = digits.size();

        if (numDigits == 1) // Base case 
        { return digits.get(0); } // Last digit is raised to the power of 0

        else
        {
            int value = digits.get(0); // The digit in position (i)
            int multiplier = (int)Math.pow(base, (numDigits - 1)); // The base to the power of digits.size()
            int num = value * multiplier;

            ArrayList<Integer> newList = new ArrayList<Integer>(digits); // Clones digitsList
            newList.remove(0); // Removes the first element in the list

            return num + RecursiveBaseConverter(newList, base); // Recursion
        }
    }

    // Argument must be element of Reals
    public static int Log(int base, int argument)
    {
        if ((argument % base) != 0) // Checks if argument is multiple of base (will be false at base if log is not whole #)
            { throw new ArithmeticException(); }

        if (argument == base)
        { return 1; }
        else
        { argument /= base; }

        return 1 + Log(base, argument);
    }

    public static int IterativeBaseConverterMod(ArrayList<Integer> digits, int intialBase, int finalBase)
    {
        int initialNum = 0;
        int numDigits = digits.size();

        for (int i = 0; i < numDigits; i++) // Loops through each index of the list
        {
            int value = digits.get(i); // The digit in position (i)

            if (value > (intialBase - 1)) // Checks if number is a valid symbol for the base
            { throw new ArithmeticException("Unknown symbol"); }

            int multiplier = (int)Math.pow(intialBase, (numDigits - 1) - i); // The base to the power of the difference of #digits and (i)
            initialNum += value * multiplier; 
        }
        
        int finalNum = 0;
        int remainder = initialNum % finalBase;
        int digitSize = Log(finalBase, (finalNum - remainder));

        ArrayList<Integer> finalNum

        return finalNum;
    }
} 

// How to convert double to int
// How to have multiple data types in a list
// How to use Math.pow()
// How to convert base2 --> base10
// How to convert base10 --> base2
// How to convert base2 to any base (except base10)
// How to convert int to string
// Do {} While {}