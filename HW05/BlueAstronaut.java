import java.util.ArrayList;
import java.util.List;

public class BlueAstronaut extends Player implements Crewmate {

    // delcare variables as private

    private int numTasks; // must be int
    private int taskSpeed; // must be pos nonzero int. validate in your constructor

    // parent constructor
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        if (taskSpeed > 0) {
            this.taskSpeed = taskSpeed;
        } else {
            this.taskSpeed = 1; // rounds to 1 if task speed is lower than 1 bc lower than 1 doenst make sense
        }

    }

    // child constructor
    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    @Override
    public void emergencyMeeting() {
        if (!this.isFrozen()) { // A Player that is frozen cannot call an emergency meeting.
            Player[] allPlayers = Player.getPlayers(); // puts players in the sortedPlayers array
            List<Player> eligiblePlayersList = new ArrayList<>();
            for (Player p : allPlayers) { // use get player to call player array
                if (!p.isFrozen()) { // only players who are not frozen can be considered for voting.
                    eligiblePlayersList.add(p); // makes an array of players that can be voted off
                }
            }

            if (!eligiblePlayersList.isEmpty()) { // if eligable list is not empty

                int maxSusLevel = -1; // below any real sus level so we can make sure it intializes correctly at
                                      // runtime
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

        }
        return;
    } // end of emergency meeting method

    /*
     * 
     */

 // end of BlueAstronaut class

public void completeTask() {
    if (!this.isFrozen()) {
        if (this.taskSpeed > 20) {
            this.numTasks -= 2;
        } else {
            this.numTasks -= 1;
        }

        if (this.numTasks <= 0) {
            this.numTasks = 0; // If numTasks falls below 0, set it to 0
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int) ((this.getSusLevel()) * 0.5));

        }
    }
    // just return if the blue astro is frozen
    return;

}

public boolean equals(Object o) {
    if (this == o) {
        return true; // returns true if they are the same object
    }

    if (!(o instanceof BlueAstronaut)) {
        return false; // cant be equal if o is not an impostor
    }

    BlueAstronaut other = (BlueAstronaut) o;

    return ((this.getName().equals(other.getName())) && // cant use "==" for string comparision
            (this.isFrozen() == other.isFrozen()) &&
            (this.getSusLevel() == other.getSusLevel()) &&
            (this.numTasks == other.numTasks) &&
            (this.taskSpeed == other.taskSpeed));

}



public String toString(){
    String baseString = super.toString();
    String fullString = baseString + " I have " + this.numTasks + " left over.";
    

    if(this.getSusLevel() > 15){
        return fullString.toUpperCase();
    }
    return fullString;
}


}// end of blue astro method 
