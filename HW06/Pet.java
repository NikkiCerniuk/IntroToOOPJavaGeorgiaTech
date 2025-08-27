import java.util.Objects;
//******checked this one and should be correct  */
////class represents any pet that would seek consultation from the clinic.

public abstract class Pet{ //needs to be public for Clinic.java to use it 

    //variables 
    private String name; //String name
    private double health; //double health. a percentage value ranging from 0.0 to 1.0
    private int painLevel;  //int painLevel. Ranges from 1 to 10


//constructor Pet(String name, double health, int painLevel)
public Pet(String name, double health, int painLevel){

    
    this.name = name;


    if (health > 1.0) {
        this.health = 1.0; //If health passed in is greater than 1.0, set health to 1.0
    } else if(health<0){
        
            this.health = 0.0; //If health passed in is less than 0.0, set health to 0.0
        }else{
        this.health = health;
    }
        // end of health if else 
   

    if(painLevel > 10) {
            this.painLevel = 10; //If painLevel passed in is greater than 10, set pain level to 10

        } else if(painLevel < 1){
                this.painLevel = 1; //If painLevel passed in is less than 1, set pain level to 1
            }else{
                this.painLevel = painLevel;
            }
} //end of Pet constructor


public abstract int treat(); //we had to put abstact in the class header for this to be legal. However, it doesnt mean that we cant have any non-abstract methods in this class
//Should be an abstract method that returns the time taken (in minutes) to treat the pet

void speak(){ //This method prints “Hello! My name is “ with the pet’s name
if(painLevel > 5){
    String upperCaseGreeting = ("Hello! My name is " + name).toUpperCase();
    System.out.println(upperCaseGreeting); //If painLevel is greater than 5 prints the message in UPPERCASE

}else{
    System.out.println("Hello! My name is " + name);
}
} // end of speak method 


@Override
public boolean equals(Object o){ // if a class is overriding another, it must be public 
    if (this == o){ // *if curent pet is the same as the object return true 
        return true;
    }

    if (o == null || getClass() != o.getClass()) {
        return false;
    }

    Pet pet = (Pet) o;

    return Objects.equals(name, pet.name); // Simplified null-safe comparison of 'name'
}


protected void heal(){ //Should be protected to prevent access by external classes
    health = 1.0; //Sets health to 1.0
    painLevel = 1; //Sets painLevel to 1
}






public String getName(){//name getter
    return name;
}

public double getHealth(){ //health getter
    return health;
}

public int getPainLevel(){
    return painLevel;
}

}// end of Pet class
/*




Methods:
getters for all instance fields,
 which should be camelCase with the variable name,
  e.g. a variable named hello should have a getter getHello()


 */
