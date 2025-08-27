public class Pond {
    public static void main(String[] args) {

    
        Frog Peepo = new Frog("Peepo"); //default tongue speed and age 
        Frog Pepe = new Frog("Pepe",10, 15); //10 months tongueSpeed 15
        Frog Peepaw = new Frog("Peepaw",4.6, 5); 
        Frog nikkiFrog = new Frog("nikkiFrog",20, 21); //20 months tongueSpeed 21

        Fly bug1 = new Fly(1, 3); //mass 1 speed 3
        Fly bug2 = new Fly(6); //6 mass and default speed
        Fly bug3 = new Fly(13, 7); // 13 mass and 7 speed 



        Frog.setSpecies("1331 Frogs");// cant set an instance of a class bc species is static so have to change the entire class to that

        System.out.println(Peepo); //Print out on a new line the description of the Frog named Peepo given by the toString method. technically you are not entering a parameter you are calling a method on a specific instacne of an object
    
        Peepo.eat(bug2);//Have the Frog named Peepo attempt to eat the Fly with a mass of 6.
        System.out.println(bug2);//Print out on a new line the description of the Fly with a mass of 6 given by the toString method.
        Peepo.grow(8); // Have the Frog named Peepo grow by 8 months.
        Peepo.eat(bug2);//Have the Frog named Peepo attempt to eat the Fly with a mass of 6.
        System.out.println(bug2);//Print out on a new line the description of the Fly with a mass of 6 given by the toString method.
        System.out.println(Peepo);//Print out on a new line the description of the Frog named Peepo given by the toString method.
        System.out.println(nikkiFrog); //Print out on a new line the description of your own Frog given by the toString method.
        Peepaw.grow(4); //Have the Frog named Peepaw grow by 4 months.
        System.out.println(Peepaw);//Print out on a new line the description of the Frog named Peepaw given by the toString method.
        System.out.println(Pepe);//Print out on a new line the description of the Frog named Pepe given by the toString method.
    }
}
