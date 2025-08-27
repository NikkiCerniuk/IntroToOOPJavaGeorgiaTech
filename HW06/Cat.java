public class Cat extends Pet{ //Since a Cat is also a Pet, this class must inherit from parent class Pet. This class is concrete.
    //******checked this one and should be correct  */
    
    private int miceCaught; //variables to delcare include miceCaught


    //constuct 1 
    public Cat (String name, double health, int painLevel, int miceCaught){ //Cat(String name, double health, int painLevel, int miceCaught)
        super(name,health,painLevel);
        if (miceCaught < 0){
            this.miceCaught = 0; //If miceCaught passed in is less than 0, set miceCaught to 0
        }
    } //end of constructor 1

    //construct 2
    public Cat (String name, double health, int painLevel){ //Cat(String name, double health, int painLevel)
        super(name,health,painLevel); 
        this.miceCaught = 0; //Default miceCaught is 0
    } //end of constructor 2



    @Override// *********double check that i need override 
public int treat(){ //Returns the time taken (in minutes) to treat the pet. Round values up.

    heal(); //**********double check that i am supposed to do this for each "treat" method bc it sets health and pain to a default value

    if (miceCaught < 4){
        return ((int)Math.ceil((getPainLevel()*2)/getHealth())); //if miceCaught is less than 4, the minutes for treatment is (painLevel*2)/health. tried to cast to int here 
    }

    else if (4 <= miceCaught && miceCaught <= 7){
        return ((int)Math.ceil(getPainLevel()/getHealth())); //if miceCaught is in between 4 and 7 inclusive, the minutes for treatment is painLevel/health
    }
    else{
        return ((int)Math.ceil(getPainLevel()/(getHealth()*2))); //if miceCaught is greater than 7, the minutes for treatment is painLevel/(health*2)
    }
}


public void speak(){ 
    super.speak(); //calls the parent method

    //Prints meow number of times of the painLevel
    if (getPainLevel() <= 5){
        for (int i=0; i < getPainLevel(); i++){
            System.out.print("meow");
            if (i < getPainLevel() - 1){
                System.out.print(" ");
            }
        }
    }else{
        for (int i=0; i < getPainLevel(); i++){
            System.out.print("MEOW"); //ALL UPPERCASE if painLevel is greater than 5, not inclusive
            if (i < getPainLevel() - 1){
                System.out.print(" ");
            }
        }
    }
    System.out.println(); //prints line after last meow
}






@Override
public boolean equals(Object o){
    if (this == o){
        return true;
    } //returns true if both objects are the smae

    if (o == null || getClass() != o.getClass()){ //second part makes sure that they are of the samee class type not different class types in same heiarchy 
        return false;
    }

    Cat cat = (Cat) o; //casts object to a dog

    return super.equals(o) && miceCaught == cat.miceCaught; //Uses the equals() method in Pet as part of the decision-making with the additional condition of miceCaught being the same
}

//getters for all instance fields, which should be camelCase with the variable name, e.g. a variable named hello should have a getter getHello()
public int miceCaught(){
    return miceCaught;
}

}// end of cat class 
