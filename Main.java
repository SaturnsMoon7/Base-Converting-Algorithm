import java.util.ArrayList;
import java.lang.Math;

public class Main
    {
    public static void main(String[] args) 
    {
        int number = 6473;
        int initialBase = 9;
        int finalBase = 4;

        ArrayList<Integer> digitliList = new ArrayList<Integer>();
        String digitString = String.valueOf(number);
        for (int i = 0; i < digitString.length(); i++)
        { 
            char digitChar = digitString.charAt(i);
            digitliList.add(Character.getNumericValue(digitChar)); // Converts char to integer
        }
        
        System.out.println("base to base10");
        System.out.println("Iterative (base" + initialBase + ")-->(base10): " + IterativeBase10Converter(digitliList, initialBase));
        System.out.println("Recursive (base" + initialBase + ")-->(base10): " + RecursiveBase10Converter(digitliList, initialBase));

        System.out.println("base10 to base");
        System.out.println("Iteractive (base10)-->(base" + finalBase + "): " + IterativeBaseBaseConverter(number, finalBase));

    }

    /* What quantity is the input "n" into your algorithm?
        The size of digitsArrayList is "n" in the function because the run-time of the function
        increases as the number of indices in digits increase.
    */
    /* What is the time complexity in Big O Notation of your algorithm? Explain/show your 
       reasoning to justify your answer.
        The time complexity in Big O Notation of the function is O(log(n)). The time complexity 
        of most lines are O(1) and O(n), but the Math.power() function has a time complexity
        of O(log(n)) which is more dominant than the other time complexities.
     */
    public static int IterativeBase10Converter(ArrayList<Integer> digits, int base)
    {
        int base10 = 0;                                                                                                                          
        int numDigits = digits.size();                                

        // Loops through each index of the list
        for (int i = 0; i < numDigits; i++)                                  
        {
            int value = digits.get(i); // The digit in position (i)

            // Checks if number is a valid a symbol for the base
            // If invalid, will throw error
            if (value > (base - 1))                                           
            { throw new ArithmeticException("Unknown symbol"); } 
            
            int multiplier = (int)Math.pow(base, (numDigits - 1) - i);       
            // The base to the power of the difference between #digits and (i)
            base10 += value * multiplier;                                    
        }
        return base10;                                                        
    }

    /* What quantity is the input "n" into your algorithm?
        The size of digitsArrayList is "n" in the function because the run-time of the function
        increases as the number of indices in digits increase.
    */
    /* What is the time complexity in Big O Notation of your algorithm? Explain/show your 
       reasoning to justify your answer.
        The time complexity in Big O Notation of the function is O(log(n)). The time complexity 
        of most lines are O(1) and O(n), but the Math.power() function has a time complexity
        of O(log(n)) which is more dominant than the other time complexities.
     */
    public static int RecursiveBase10Converter(ArrayList<Integer> digits, int base)
    {
        int numDigits = digits.size();                                       

        if (numDigits == 1) // Base case                                     
        { return digits.get(0); } // Last digit is raised to the power of 0

        else
        {
            int value = digits.get(0); // The digit in position (i)
            int multiplier = (int)Math.pow(base, (numDigits - 1)); // The base to the power of digits.size()
            int num = value * multiplier;

            digits.remove(0); // Removes the first element in the list

            return num + RecursiveBase10Converter(digits, base); // Recurses
        }
    }
    
    public static int IterativeBaseBaseConverter(int initialNum, int base)
    {   
        String finalStringNum = "";

        boolean looping = true;
        while (looping)
        {
            if (initialNum < base) // The last digit
            {   
                finalStringNum = String.valueOf(initialNum) + finalStringNum; // Inserts last digit to beginning of finalStringNum
                looping = false;
            } 
            else
            {
                int remainder = initialNum % base;
                finalStringNum = String.valueOf(remainder) + finalStringNum; // Inserts the remainder to the beginning of finalStringNum
                initialNum = (initialNum - remainder) / base;
            }
            
        }
        return Integer.parseInt(finalStringNum); // Converts finalStringNum to int
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
//How to convert char to int

// Base to base conversion reference: 
    /* 
    https://math.libretexts.org/Courses/College_of_the_Canyons/Math_130%3A_Math_for_Elementary_School_Teachers_(Lagusker)/
    02%3A_Empathy_and_Primary_Mathematics/2.06%3A_Converting_Between_(our)_Base_10_and_Any_Other_Base_(and_vice_versa)#:~:
    text=Example,2.6.1
    */