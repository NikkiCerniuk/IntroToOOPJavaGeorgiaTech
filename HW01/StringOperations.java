/*
    a) Create a new `String` object and assign it your name. Print it out.
    b) Pick the first letter in your name, and replace it with 'A'. Then, replace the last letter in your name with 'Z'. 
       Print out the result. Recall that, in Java, strings are *immutable*, meaning you cannot change a String in-place. 
       Do NOT just hard-code a new String with the first and last letters changed.
    c) Lastly, let's work with some URLs. Declare a new `String` and give it the value of some web address, in the 
       form `www.name.tld`, such as `www.gatech.edu` or `www.stackoverflow.com`. Print out this address.
    d) This last operation could be a little tricky. Create a substring of the variable that's just the "name" section, 
       and concatenate the integer "1331" to the end. For example, `www.gatech.edu` would become gatech1331. Print out this 
       final result. **Note**: the String class has a `.length()` method which you'll likely find useful here but is not necessary.
*/

public class StringOperations {
    
    //TODO: Start your code after this line
      public static void main(String[] args){
            String myName = "Nicole"; // Create a new String object and assign it your name. 
            System.out.println(myName); //   2. Print it out.
    
            String replaceName1 = myName.replace(myName.charAt(0),'A');// 3. Pick the first letter in your name, and replace it with ‘A’.
            String replaceName2 = replaceName1.replace(replaceName1.charAt(replaceName1.length()-1),'Z');// 4. Then, replace the last letter in your name with ‘Z’. 
            System.out.println(replaceName2);//5. Print out the result. Recall that, in Java, strings are immutable, meaning you cannot change a String in-place. Do NOT just hard-code a new String with the first and last letters changed.
    
            String firstUrl = "www.stackoverflow.com"; //6. Lastly, let’s work with some URLs.  Declare a new String and give it the value of some web address, in the form www.name.tld, such as www.gatech.edu or www.stackoverflow.com. 
            System.out.println(firstUrl);  //7. Print out this address.
            
            //8.This last operation could be a little tricky. Create a substring of the variable that’s just the “name” section
            int firstDot = firstUrl.indexOf('.'); //use indexOf to find first occurance of "." 
            String urlMinus1Dot = firstUrl.substring((firstDot+1));// and put everything after it into a string usnig substring
    
            int seconDot = urlMinus1Dot.indexOf('.');//use lastIndex0f to find the first occurance of "." again 
            String urlMinus2Dot = urlMinus1Dot.substring(0,seconDot);// and put everything before it into a string using substring 
            
            String finalConcat = urlMinus2Dot.concat("1331");//9.  concatenate the integer “1331” to the end. For example, www.gatech.edu would become gatech1331. Print out this final result. Note: the String class has a .length() method which you’ll likely find useful here but is not necessary.
            System.out.println(finalConcat); //10. print the final result 
        }
}
