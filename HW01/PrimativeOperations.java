    /* a) First, declare and initialize two variables, an integer type (byte, short, int, or long) and a floating point value (float or double). 
          The names and values can be whatever you like, for this step and all others. Make sure that the numbers you choose can be stored within 
          the respective primitive type you choose. Print each of these values out on their own line using `System.out.println()`.
       b) Multiply these variables together, and assign the outcome to a `new` variable, ensuring that no data is lost. For example, if I 
          multiply 5 and 3.5, the answer should be 17.5. Print out this new value.
       c) Use casting to convert the integer from the first step to a floating point value and store that in another `new` variable. Print out the value.
       d) Use casting to convert the floating point value from the first step to an integer type and store that in a `new` variable.  Print out the value.
       e) Shifting focus, declare a `char` variable, and assign an uppercase letter to it. Print out this value.
       f) Using a *numerical operation*, change the letter to the same letter, but in lowercase. Use a numerical operation - do not reassign the variable. 
          You may want to review a [table of ASCII values](https://ascii.cl/) as you're working on this section. Print out the new `char` value.
          **Hint:** you'll likely have to use casting to get this to work.
    */

public class PrimitiveOperations {
    
       //TODO: Start your code after this line
  public static void main(String[] args){
            int firstInt = 4; //1. First, declare and initialize two variables, an integer type (byte, short, int, or long)
            System.out.println(firstInt); 
    
            double firstDouble = 3.3; //2. floating point value (float or double). The names and values can be whatever you like,
            System.out.println(firstDouble); //3. Print each of these values out on their own line using System.out.println().
    
            double secondDouble = firstInt * firstDouble;// 4. Multiply these variables together, and assign the outcome to a new variable, ensuring that no data is lost. For example, if I multiply 5 and 3.5, the answer should be 17.5.Print out this new value.
            System.out.println(secondDouble);  //5.Print out this new value.
    
            double castDouble = (double)firstInt; //6. Use casting to convert the integer from the first step to a floating point value and store that in another new variable.
            System.out.println(castDouble); //7.  Print out the value
            
            int castInt = (int)firstDouble;// 8. Use casting to convert the floating point value from the first step to an integer type and store that in a new variable. 
            System.out.println(castInt); //9. Print out the value. 
    
            char firstChar = 'A'; //10.  declare a char variable, and assign an uppercase letter to it. 
            System.out.println(firstChar); // 11. Print out this value.
            
            char lowerChar = (char)(firstChar + 32); // 12. Using a numerical operation, change the letter to the same letter, but in lowercase. Use a numerical operation - do not reassign the variable. You may want to review a table of ASCII values as you’re working on this section. hint: you will likely need casting to get this to work 
            System.out.println(lowerChar);  //11. Print out this value. 
        }
    }

