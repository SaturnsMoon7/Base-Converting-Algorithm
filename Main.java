import java.util.ArrayList;
import java.lang.Math;


public class Main
{
    public static void main(String[] args) 
    {
        String number = "5F3A";
        ArrayList<String> numberList = new ArrayList<String>();
        for (int i = 0; i < number.length(); i++)
        {
            numberList.add(number.charAt(i));
        }

        System.out.println(numberList);
        System.out.println(IterativeBaseConverter(numberList, 16));
    }

    public static int digitConverter(String digit)
    {
        ArrayList<Object> hexNum = new ArrayList<Object>();
        hexNum.add(0);
        hexNum.add(1);
        hexNum.add(2);
        hexNum.add(3);
        hexNum.add(4);
        hexNum.add(5);
        hexNum.add(6);
        hexNum.add(7);
        hexNum.add(8);
        hexNum.add(9);
        hexNum.add("A");
        hexNum.add("B");
        hexNum.add("C");
        hexNum.add("D");
        hexNum.add("E");
        hexNum.add("F");

        return hexNum.indexOf(digit);
    }

    public static int IterativeBaseConverter(ArrayList<String> digits, int base)
    {
        int num = 0;
        int numDigits = digits.size();

        for (int i = 0; i < numDigits; i++)
        {
            String value = digits.get(i);
            int digit = digitConverter(value);
            System.out.println(digit);
            Double multiplier = Math.pow(base, numDigits - 1 - i); // Flips the position of the digit

            num += digit * multiplier; 
        }

        return num;
    }
}