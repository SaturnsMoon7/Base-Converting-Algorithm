import java.util.ArrayList;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        int number = 6843;
        int initialBase = 9;
        int finalBase = 4;

        // Convert number to a string
        ArrayList<Integer> digitliList = new ArrayList<Integer>();
        String digitString = String.valueOf(number);

        for (int i = 0; i < digitString.length(); i++) { 
            char digitChar = digitString.charAt(i);
            digitliList.add(Character.getNumericValue(digitChar)); // Converts char to integer
        }
        
        System.out.println("base(?) --> base10");
        System.out.println("Iterative: " + number + "(base" + initialBase + ") --> " + IterativeBase10Converter(digitliList, initialBase) + "(base10)");
        System.out.println("Iterative: " + number + "(base" + initialBase + ") --> " + RecursiveBase10Converter(digitliList, initialBase) + "(base10)");
        System.out.println(); 
        System.out.println("base10 --> base(?)");
        System.out.println("Iteractive: " + number + "(base10) --> " + IterativeBaseBaseConverter(number, finalBase) + "(base" + finalBase + ")");
    }



    /* What quantity is the input "n" into your algorithm?
            The size of digitsArrayList is "n" in the function because the run-time of the function
            increases as the number of indices in digits increase.
    */
    /* What is the time complexity in Big O Notation of your algorithm? Explain/show your 
       reasoning to justify your answer.
            The time complexity in Big O Notation of the function is O(nlog(n)). The multiplier 
            contains a Math.pow() function that has a time complexity of O(log(n)). However,
            because the multiplier variable is within a for loop with a time complexity of O(n),
            these two time complexities are combined. 
     */
    public static int IterativeBase10Converter(ArrayList<Integer> digits, int base) {
        int base10 = 0;                                                                                                                          
        int numDigits = digits.size();                                

        // Loops through each index of the list
        for (int i = 0; i < numDigits; i++) {
            int value = digits.get(i); // The digit in position (i)

            // Checks if number is a valid a symbol for the base
            // If invalid, will throw error
            if (value > (base - 1)) { throw new ArithmeticException("Unknown symbol"); } 
            
            int multiplier = (int)Math.pow(base, (numDigits - 1) - i);       
            // The base to the power of the difference between #digits and (i)
            base10 += value * multiplier;                                    
        }
        return base10;                                                        
    }



    /* What quantity is the input "n" into your algorithm?
            The size of digitsArrayList is "n" in the RecursiveBase10Converter because the number 
            of recursive function calls increases as the number of indices in digitsArrayList increase.
    */
    /* What is the time complexity in Big O Notation of your algorithm? Explain/show your 
       reasoning to justify your answer.
            The time complexity in Big O Notation of the function is O(nlog(n)). The calculation 
            in the digits uses Math.pow() which has a time complexity of O(log(n)). Since the function
            recurses for the number of indices in digits, the time complexities for both will 
            be combined into O(nlog(n)).
     */
    public static int RecursiveBase10Converter(ArrayList<Integer> digits, int base) {
        int numDigits = digits.size();                                       

        // Base case 
        if (numDigits == 1) { return digits.get(0); }  // Last digit is raised to the power of 0
        else {
            int value = digits.get(0); // The digit in position (i)

            // Checks if number is a valid a symbol for the base
            // If invalid, will throw error
            if (value > (base - 1)) { throw new ArithmeticException("Unknown symbol"); } 

            int multiplier = (int)Math.pow(base, (numDigits - 1)); // The base to the power of digits.size()
            int num = value * multiplier;

            digits.remove(0); // Removes the first element in the list

            return num + RecursiveBase10Converter(digits, base); // Recurses
        }
    }
    


    /* What quantity is the input "n" into your algorithm?
            The initialNum is "n" in IterativeBaseBaseConverter because the bigger the initial
            number, the more times the while loop will loop.
    */
    /* What is the time complexity in Big O Notation of your algorithm? Explain/show your 
       reasoning to justify your answer.
            The time complexity in Big O Notation of the function is O(log(n)). The loop will
            more if initialNum increases, but since the remainder variable contains a modulo
            operator, the loop will run with a time complexity of O(log(n)) as initial num
            decreases exponentially.
     */
    public static int IterativeBaseBaseConverter(int initialNum, int base) {   
        String finalStringNum = "";

        boolean looping = true;
        while (looping) {
            if (initialNum < base) { // The last digit 
                finalStringNum = String.valueOf(initialNum) + finalStringNum; // Inserts last digit to beginning of finalStringNum
                looping = false;
            } else {
                int remainder = initialNum % base; // Modulo operation determines the remainder of initialNum / base
                finalStringNum = String.valueOf(remainder) + finalStringNum; // Inserts the remainder to the beginning of finalStringNum
                initialNum = (initialNum - remainder) / base;
            }
        }
        return Integer.parseInt(finalStringNum); // Converts finalStringNum to int
    }
} 


// "How to use Math.pow()"; --> Time complexity of O(log(n))
    /*
     https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
     */
//"How to convert char to int";
    /*
    https://www.javatpoint.com/java-char-to-int
     */

// "How to convert from one base to another?": 
    /* 
     https://math.libretexts.org/Courses/College_of_the_Canyons/Math_130%3A_Math_for_Elementary_School_Teachers_(Lagusker)/02%3A
     _Empathy_and_Primary_Mathematics/2.06%3A_Converting_Between_(our)_Base_10_and_Any_Other_Base_(and_vice_versa)
    */

// "What is the time complexity of the modulo operator?": --> For small integer operations, O(1)
    /*
     https://www.bartleby.com/subject/engineering/computer-science/concepts/modulus-operator
     */