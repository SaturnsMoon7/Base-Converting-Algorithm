import java.util.ArrayList;
import java.lang.Math;

public class Main
    {
    public static void main(String[] args) 
    {
        int number = 8436;
        int initialBase = 9;
        int finalBase = 4;

        ArrayList<Integer> digitliList = new ArrayList<Integer>();
        String digitString = String.valueOf(number);

        for (int i = 0; i < digitString.length(); i++)
        { 
            char digitChar = digitString.charAt(i);
            String charString = String.valueOf(digitChar);
            int strInt = Integer.parseInt(charString);
            digitliList.add(strInt); 
        }
        
        System.out.println("Iterative: " + IterativeBaseConverter(digitliList, initialBase));
        System.out.println("Recursive: " + RecursiveBaseConverter(digitliList, initialBase));

        System.out.println("Iterative (base" + initialBase + ")-->(base" + finalBase + "): " + IterativeBaseConverterMod(digitliList, initialBase, finalBase));
    }

    public static int IterativeBaseConverter(ArrayList<Integer> digits, int base)
    {
        int base10 = 0;
        int numDigits = digits.size();

        for (int i = 0; i < numDigits; i++) // Loops through each index of the list
        {
            int value = digits.get(i); // The digit in position (i)

            if (value > (base - 1)) // Checks if number is a valid symbol for the base
            { throw new ArithmeticException("Unknown symbol"); }

            int multiplier = (int)Math.pow(base, (numDigits - 1) - i); // The base to the power of the difference of #digits and (i)
            base10 += value * multiplier; 
        }
        return base10;
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


    public static int IterativeBaseConverterMod(ArrayList<Integer> digits, int intialBase, int finalBase)
    {
        // Converting intial base to base10
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

        // Converting base10 number to final base
        ArrayList<String> newDigits = new ArrayList<String>();

        boolean looping = true;
        while (looping) // Divides the base10 number each loop
        {
            if (initialNum < finalBase) // Dividing the last number thats smaller than the finalBase will give decimal
            {
                newDigits.add(0, String.valueOf(initialNum)); // Converts the digit to a string and adds to list
                looping = false;
            }
            else
            {
                int remainder = initialNum % finalBase; // Saves the remainder;    
                newDigits.add(0, String.valueOf(remainder));                  
                initialNum = (initialNum - remainder) / finalBase; // Makes the initialNum the # of whole divisions possible by the base    
            }
        }

        /* 
        The backward order of the remainders
        froms each division will be the number
        in the new base.
        */

        String finalNum = "";
        for (int i = 0; i < newDigits.size(); i++)
        { finalNum += newDigits.get(i); } // Concatenates the digits in newDigits into one string

        return Integer.parseInt(finalNum); // Returns the string converted to int
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

// Base to base conversion reference: 
    /* 
    https://math.libretexts.org/Courses/College_of_the_Canyons/Math_130%3A_Math_for_Elementary_School_Teachers_(Lagusker)/
    02%3A_Empathy_and_Primary_Mathematics/2.06%3A_Converting_Between_(our)_Base_10_and_Any_Other_Base_(and_vice_versa)#:~:
    text=Example,2.6.1
    */