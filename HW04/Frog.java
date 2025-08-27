public class Frog{ // classes do not take parameters in their defintion
    private String name; // name - the name of this Frog, which can be made of any combination of
                         // characters
    private int age; // age - the age of the Frog as an integer number of months
    private double tongueSpeed;// how quickly this Frog’s tongue can shoot out of its mouth
    private boolean isFroglet; // isFroglet - a value that represents if this Frog is young. must be older than 1 month but less than 7 months
    private static String species = "Rare Pepe"; // //species - the name of the species of this Frog, which must be the

 
    // parent
    // constuctor
    public Frog(String name, int age, double tongueSpeed) { // constructor (name, age, tongueSpeed)
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = age > 1 && age < 7;
        // something here to update froglet status*****
    }

    // child1 of parent
    // constructor
    public Frog(String name, double ageInYears, double tongueSpeed) { // constructors of a class must share the name of
                                                                      // that class
        // when converting age in years to age (int num of months) round down ***
        this(name, (int) (ageInYears * 12), tongueSpeed); // constructor chaining. converts age in years to months and
                                                          // passes it to parent
    }

    // child of child1
    // constructor(name)
    public Frog(String name) {
        this(name, 5, 5.0); // sets default age to 5 and tongueSpeed to 5.0 if just given a name and nothing
                            // else
    }

    public void grow(int numMonths){ //parameter represents num of months 
     // double check on the modifer for this*********
        for (int i = 0; i < numMonths; i++){
            if (age < 12){
                tongueSpeed += 1; //increases tongue speed by 1 until frog is 12 months old 
            }else{
                if(age > 30 && tongueSpeed>5){ //You must not decrease tongueSpeed to less than 5.
                    tongueSpeed -= 1; //decrease tongueSpeed by 1 for every month that it ages beyond 30 months
                }
        }
    }
    if(1 < age && age < 7){
        isFroglet = true;
    }else{
        isFroglet = false;
    }
}

     
         // you must use method overloading at least once. do not create any other method
    public void grow() { //takes no parameters 
        age +=1; // ages the frog by one month
        grow(1); //updates things according to the other grow method
    }

    public void eat(Fly fly){
        // double check public and void*********
        if (fly.isDead()== true){ //check if fly is dead 
            return; //terminate method
        }else{
            if (tongueSpeed > fly.getSpeed()){
                if (fly.getMass() >= age*0.5){
                    grow(); //the frog ages by one month using the method grow
                }
                fly.setMass(0); // If the Fly is caught, the mass of the Fly must be set to 0.
            }else{
                fly.grow(1); //mass of the Fly must be increased by 1 while updating the speed of the Fly using only one Fly method.
            }
        }

    }
    
    public String toString(){
        if (isFroglet == true){
            return "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        }else{
            return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    }
}


 public static String getSpecies(){//need a getter for the species 
    return species;
 }

 public static void setSpecies(String newSpecies){ //seter for species 
    species = newSpecies;
 }


     


}
