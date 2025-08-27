public interface Impostor{

void freeze(Player p);// implicitly public 
void sabotage(Player p);// implicitly public 

}
/*
//the above file is complete

 

Impostor.java
This file defines an interface with the name Impostor. Impostors will 
be able to mess with Players through sabotage and freeze tagging them.


Method: freeze(Player p)
Abstract method that takes in a Player object and does not return anything
(Note: any class that implements Impostor must provide a method definition for this method)




Method: sabotage(Player p)
Abstract method that takes in a Player object and does not return
 anything
(Note: any class that implements Impostor must provide a method
definition for this method)

 */
