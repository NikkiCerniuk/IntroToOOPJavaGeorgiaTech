public class Dog extends Pet{ //Since a Dog is also a Pet, this class must inherit from parent class Pet. This class is concrete.
    //******checked this one and should be correct  */
    
    //variable to delcare: double droolRate
    private double droolRate; 
    
    
    //parent constructor 
    public Dog(String name, double health, int painLevel, double droolRate){ //Dog(String name, double health, int painLevel, double droolRate)
        super(name, health, painLevel); //inherit these attributes from the super constructor 
        
        if (droolRate <= 0){
            this.droolRate = 0.5; //droolRate - If droolRate is less than or equal to zero, set drool rate to 0.5
        }else{
            this.droolRate = droolRate;
        }
    
    }
    
    //child constructor
    public Dog(String name, double health, int painLevel){ //Dog(String name, double health, int painLevel)
        super(name, health, painLevel); //inherit these attributes from the super constructor 
        this.droolRate = 5.0; //Default droolRate is 5.0
    }
    
    
    @Override// *********double check that i need override 
    public int treat(){ //Returns the time taken (in minutes) to treat the pet. Round values up.
    
        heal(); //**********double check that i am supposed to do this for each "treat" method bc it sets health and pain to a default value
    
        if (droolRate < 3.5){
            return ((int)Math.ceil((getPainLevel()*2)/getHealth())); //if droolRate is less than 3.5, the minutes for treatment is (painLevel*2)/health. tried to cast to int here 
        }
    
        else if (3.5 <= droolRate && droolRate <= 7.5){
            return ((int)Math.ceil(getPainLevel()/getHealth())); //if droolRate is in between 3.5 and 7.5 inclusive, the minutes for treatment is painLevel/health
        }
        else{
            return ((int)Math.ceil(getPainLevel()/(getHealth()*2))); //if droolRate is greater than 7.5, the minutes for treatment is painLevel/(health*2)
        }
    }
    
    
    public void speak(){ 
        super.speak(); //calls the parent method
    
        //Prints “bark” number of times of the painLevel
        if (getPainLevel() <= 5){
            for (int i=0; i < getPainLevel(); i++){
                System.out.print("bark");
                if (i < getPainLevel() - 1){
                    System.out.print(" ");
                }
            }
        }else{
            for (int i=0; i < getPainLevel(); i++){
                System.out.print("BARK"); //ALL UPPERCASE if painLevel is greater than 5, not inclusive
                if (i < getPainLevel() - 1){
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
    
    
    
    
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        } //returns true if both objects are the smae
    
        if (o == null || getClass() != o.getClass()){ //second part makes sure that they are of the samee class type not different class types in same heiarchy 
            return false;
        }
    
        Dog dog = (Dog) o; //casts object to a dog
    
        return super.equals(o) && droolRate == dog.droolRate; //makes sure they are both equal by name and by drool rate for the boolean
    }
    
    //getters for all instance fields, which should be camelCase with the variable name, e.g. a variable named hello should have a getter getHello()
    public double getDroolRate(){
        return droolRate;
    
    }
    
    }//end of Dog.java
