import java.util.Scanner;

// this appears to be working properly 
public class Calculator { 
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
         System.out.println("List of operations: add subtract multiply divide alphabetize"); // List of operations: add subtract multiply divide alphabetize
         System.out.println("Enter an operation:"); //print to user "Enter an operation:"
         String desiredOperation = scanner.nextLine().toLowerCase(); //reads input and converts to lowercase 
         interpDesiOperation(desiredOperation); //puts the desired string into interpDesiOperation
}

//this appears to be working properly 
public static void interpDesiOperation(String desired){ 
    switch (desired){
        case "add":
            addMethod(); // go to add method 
            break;
        case "subtract":
            subtractMethod();  //go to subtract method
            break;
        case "multiply": 
            multiplyMethod(); //go to multiply method
            break;
        case "divide":
            divideMethod(); //go to divide method
            break;
        case "alphabetize":
            alphabetizeMethod(); //go to alphabetize
            break;
        default:
            System.out.println("Invalid input entered. Terminating..."); // has to terminate here or move this to main
            break;
    }
    return;
}

//seems to be working properly
public static void addMethod (){
    System.out.println("Enter two integers:");  //prompt the user: "Enter two integers:"
    if(scanner.hasNextInt()){
        int num1 = scanner.nextInt();
        if(scanner.hasNextInt()){
            int num2 = scanner.nextInt();
            int answer = num1 + num2; // adds the ints
            System.out.println("Answer: " + answer); // prints the answer
        }else{
            System.out.println("Invalid input entered. Terminating..."); // error message if 2 ints are not supplied 

        }
    }else{
        System.out.println("Invalid input entered. Terminating..."); // error message if 2 ints are not supplied 
    }
    return;
}

    
    
public static void subtractMethod (){
    System.out.println("Enter two integers:");  //prompt the user: "Enter two integers:"
    if(scanner.hasNextInt()){
        int num1 = scanner.nextInt();
        if(scanner.hasNextInt()){
            int num2 = scanner.nextInt();
            int answer = num1 - num2; // subtracts the ints
            System.out.println("Answer: " + answer); // prints the answer
        }else{
            System.out.println("Invalid input entered. Terminating..."); // error message if 2 ints are not supplied 

        }
    }else{
        System.out.println("Invalid input entered. Terminating..."); // error message if 2 ints are not supplied 
    }
    return;
}


    
    
//seems to be functioning properly
public static void multiplyMethod (){
    System.out.println("Enter two doubles:");
    if(scanner.hasNextDouble()){
        double num1 = scanner.nextDouble();
        if(scanner.hasNextDouble()){
            double num2 = scanner.nextDouble();
            double answer = num1 * num2; //multiplies the doubles
            System.out.printf("Answer: %.2f%n", answer); // print the result to two decimal places. use printf
        }else{
            System.out.printf("Invalid input entered. Terminating...%n"); // error message if 2 doubles are not supplied 
        }

    }else{
        System.out.printf("Invalid input entered. Terminating...%n"); // error message if 2 doubles are not supplied 
    }
    return;
}
    
    

//seems to be functioning properly
public static void divideMethod (){
    System.out.println("Enter two doubles:");
    if(scanner.hasNextDouble()){
        double num1 = scanner.nextDouble();
        if(scanner.hasNextDouble()){
            double num2 = scanner.nextDouble();
            if (num2 != 0){ // checks that the denomiator will be non-zero
                double answer = (num1/num2);
                System.out.printf("Answer: %.2f%n", answer); //uses printf to print answer within 2 decimal places 
             }else{
               System.out.printf("Invalid input entered. Terminating...%n");
             }
        }else{
            System.out.printf("Invalid input entered. Terminating...%n");
        }
    }else{
        System.out.printf("Invalid input entered. Terminating...%n");
    }
    return;
}



    // this method appears to be working correctly 
public static void alphabetizeMethod (){
    System.out.println("Enter two words:");
    if(scanner.hasNext() && scanner.hasNext()){ //checks that there is 2 data points but doesnt check if they are strings
        String word1 = scanner.next(); //Zreads the next input as a String even if the next input looks like an integer.
        String word1Revised = word1.toLowerCase(); //puts it in lower case

        String word2 = scanner.next();// same as above comment
        String word2Revised = word2.toLowerCase(); //puts it in lower case

        int comparison = word1Revised.compareTo(word2Revised); //compares word1 to word2
        if(comparison > 0){
            System.out.printf("Answer: %s comes before %s alphabetically.%n", word2, word1);
        }else if(comparison < 0){
            System.out.printf("Answer: %s comes before %s alphabetically.%n", word1, word2);
        }else if(comparison == 0){
            System.out.printf("Answer: Chicken or Egg.%n");
        }else{
            System.out.printf("Invalid input entered. Terminating...%n"); //error message if output if comparison is not a number >,<,== 0.
        }
    }else{
        System.out.printf("Invalid input entered. Terminating...%n"); //error mesage if not two strings
    }
    return;
     //**** fill in info here
}

}
