public class InvalidPetException extends RuntimeException{ //RuntimeException is a built in java class 
        //******checked this one and should be correct  */

   public InvalidPetException(){
    super("Your pet is invalid!"); //InvalidPetException() has message “Your pet is invalid!”
//super because exeptions are meant to be thrown and handled, not printed directly 
   }

   public InvalidPetException(String s){
    super(s); //InvalidPetException(String s) has message s
   }
}



/*
 InvalidPetException.java
An unchecked exception with two constructors

Constructors
InvalidPetException() has message “Your pet is invalid!”
InvalidPetException(String s) has message s
*/
