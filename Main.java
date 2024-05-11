import java.util.ArrayList;
import java.lang.Math;


public class Main
{
  public static void main(String[] args) 
  {
      ArrayList<Integer> numberList = new ArrayList<Integer>();
      numberList.add(3);
      numberList.add(4);
      numberList.add(2);
      numberList.add(1);
      System.out.println("Iterative: " + IterativeBaseConverter(numberList, 5));
      System.out.println("Recursive: " + RecursiveBaseConverter(numberList, 5));
  }
  
  public static int IterativeBaseConverter(ArrayList<Integer> digits, int base)
  {
      int num = 0;
      int numDigits = digits.size();

      for (int i = 0; i < numDigits; i++)
      {
          int value = digits.get(i);
          Double multiplier = Math.pow(base, numDigits - 1 - i); // Flips the position of the digit

          num += value * multiplier; 
      }
      return num;
  }

  public static int RecursiveBaseConverter(ArrayList<Integer> digits, int base)
  {
    int numDigits = digits.size();
    System.out.println("Digit: " + numDigits);

    if (numDigits == 1)
    { return digits.get(0); }

    else
    {
      int value = digits.get(0);

      int multiplier = (int)Math.pow(base, (numDigits-1));
      System.out.println(base + "^" + (numDigits-1));

      int num = value * multiplier;

      ArrayList<Integer> newList = new ArrayList<Integer>(digits);
      newList.remove(0);

      return num + RecursiveBaseConverter(newList, base);
    }
  }
}