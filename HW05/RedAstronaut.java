import java.util.ArrayList;
import java.util.List;

//extends player means that RedAstronaut is a subclass of the Player parent class 
//implements imposter means that RedAstronaut agress to provide defintions for all the methods delcared in the imposter interface 
//interfaces force structure so if something claims to be an impostor then it must have a freeze and a sabatoge interface.
public class RedAstronaut extends Player implements Impostor {
    

    private String skill; // represents skill of the Red crewmate. value can be inexperienced,
                          // experienced, or expert.

    // parent constructor
    // done with this constructor builid
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase(); // skill may have different capitalization
    }

    // done with this child constructor build
    public RedAstronaut(String name) { // name as only para
        this(name, 15, "experienced"); // sets default susLevel to 15 and skill as experienced
    }

    @Override // need this if defining a method in a subclass after its mentioned in an an
              // abstract method
    public void emergencyMeeting() { // does not return anything
        if (!this.isFrozen()) { // if calling player is not frozen

            Player[] allPlayers = Player.getPlayers(); // puts players in the sortedPlayers array
            List<Player> eligiblePlayersList = new ArrayList<>();
            for (Player p : allPlayers) { // use get player to call player array
                if (!p.isFrozen() && p != this) { // players who are not frozen and not the calling player can be
                                                  // considered for voting.
                    eligiblePlayersList.add(p); // makes an array of players that can be voted off
                }
            }

            if (!eligiblePlayersList.isEmpty()) { // if eligable list is not empty

                int maxSusLevel = -1; //below any real sus level so we can make sure it intializes correctly at runtime
                int countAtSus = 0;
                Player mostSus = null;

                for (int i = 0; i < eligiblePlayersList.size(); i++) { // iterates through the size of eligable
                                                                       // player list
                    if (eligiblePlayersList.get(i).getSusLevel() == maxSusLevel) { // if current player sus level is
                                                                                   // equal to max sus
                        countAtSus++; // count at sus is incremented by 1. tells you how many players w this sus level
                    } else if (eligiblePlayersList.get(i).getSusLevel() > maxSusLevel) { // if current player sus level
                                                                                         // is // greater than max sus
                                                                                         // level
                        maxSusLevel = eligiblePlayersList.get(i).getSusLevel(); // arrays support bracket notation but
                                                                                // // lists do not. keep in mind
                        mostSus = eligiblePlayersList.get(i); // most sus is now current player if that player has
                                                              // highest sus level
                        countAtSus = 1; // resets count if a new max is found
                    }
                }

                if (countAtSus == 1) {
                    System.out.println(mostSus.getName() + " was the most sus and has been voted off."); // 5a. then
                                                                                                         // accuse the
                                                                                                         // person with
                                                                                                         // the highest
                                                                                                         // sus number
                                                                                                         // of
                                                                                                         // being the
                                                                                                         // impostor and
                                                                                                         // vote them
                                                                                                         // off
                    mostSus.setFrozen(true); // set frozen to true
                    this.gameOver(); // checks if the game is over
                } // if count > 1 then return; // in this case, no player is voted off

            } // exit method and return if eligable list is empty

        } // exit method and return if the calling player is frozen

        return;
    }



    public void freeze(Player p){
        if (!(p instanceof Impostor) && 
        !p.isFrozen() && 
        !this.isFrozen()){ //if player is not an impostor and player is not already frozen
            if (this.getSusLevel() < p.getSusLevel()){ //if redAstro sus level less than player than freeze succcess
                p.setFrozen(true);//freeze success 
            }else{
                this.setSusLevel(this.getSusLevel()*2); //else: freeze unsuccessful. increase impostor sus level by 2
            }
        }
        this.gameOver(); // checks if the game is over
        return; //return if potenital frozen is impostor or frozen. also return if calling player is frozen
    }

@Override
    public void sabotage(Player p){
        if (!p.isFrozen() && 
        !(p instanceof Impostor) && 
        !this.isFrozen()){ //cant sabatoge a frozen player or impostor. frozen impostor cant freeze  
            if (this.getSusLevel() < 20){
                p.setSusLevel((int)(p.getSusLevel()*1.5));  //if impostor sus level under 20, increase crew sus level by 50 percent. recast to int to truncate num
            }else{
                p.setSusLevel((int)(p.getSusLevel()*1.25));  //if impostor sus level over 20, increase crew sus level by 25 percent. recasted to an int so that it would truncate num
            }
        }
        return; 
    }


    
   public boolean equals(Object o){
    if (this == o){
        return true; //returns true if they are the same object 
    }

    if (!(o instanceof RedAstronaut)){
        return false; //cant be equal if o is not an impostor 
    }


    RedAstronaut other = (RedAstronaut) o;

    return ((this.getName().equals(other.getName())) && // cant use "==" for string comparision
        (this.isFrozen() == other.isFrozen()) &&
        (this.getSusLevel() == other.getSusLevel()) &&
        (this.skill.equals(other.skill)));

}


public String toString(){
    String baseString = super.toString();
    String fullString = baseString + " I am an " + this.skill + " player!";

    if(this.getSusLevel() > 15){
        return fullString.toUpperCase();
    }
    return fullString;
}

} //end of RedAstronaut class file 
