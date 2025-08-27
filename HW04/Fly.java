public class Fly{//declare Fly class 
    private double mass; // mass as a double.
    private double speed; //speed as a double. 

//constuctor here (mass, speed)
        // parent
    public Fly(double mass, double speed){
        this.mass = mass;
        this.speed = speed;
    }


       //constructor here (mass)
        //child1 of parent
    public Fly(double mass){
        this(mass,10); //calls parent constructor. constructor chaining
    }
 
    //constructor here ()
    public Fly(){
        this(5,10);
        // takes no parameters
            //potential child of child1
    }


    public String toString(){ //takes no parameters
        if (mass == 0){
            return "I'm dead, but I used to be a fly with a speed of " + String.format("%.2f", speed)+ ".";
        }else{
            return "I'm a speedy fly with " + String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
        }
    //method: toString()
        //takes no parameters 
        //returns a string. include value in brackets and exclude double quotes 
            // If mass is 0: “I’m dead, but I used to be a fly with a speed of [speed].”  (all values up to 2 decimals)
            // Otherwise: “I’m a speedy fly with [speed] speed and [mass] mass.” (all values up to 2 decimals)
            // 
    }


    public void grow(int addedMass){   //takes an int parameter representing the added mass. i made this name  called addedMass. no name listed in README
        for(int i=0; i< addedMass; i++){
            if (mass < 20){
                speed += 1;
            }else{
                speed -= 0.5;
            }
            mass += 1;
        }
    // method: grow(addedMass)
      // increases the mass of the fly by that given number of mass
        // as mass increases, speed does the following:
            // If mass is less than 20: 
                //increases speed by 1 for every mass the Fly grows until it reaches 20 mass.
            // If the mass is 20 or more: 
                //decreases speed by 0.5 for each mass unit added over 20.
    }


    public boolean isDead(){
        return mass == 0; //returns true if mass ==0 otherwise, false. 
    }


//double check that you can have these setters and getters without getting points deducted**
    public double getSpeed(){ //getter for speed 
        return speed;
    }

    public void setSpeed(double speed){ //setter for speed 
        this.speed = speed;

    }

    public void setMass(double mass){ 
        this.mass = mass;
    }

    public double getMass(){ //getter for mass
        return mass;
    }

}
