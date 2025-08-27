public class Player{
    private int id;
    private char[][] locationBoard; //added privdate and then location board turned red inside of Battleship
    private char[][] targetBoard;// added private and then targetboard truned red inside of battleship 

    //below is the constructor 
    public Player(int id){
        this.id = id;
        this.locationBoard = new char[5][5];
        this.targetBoard = new char[5][5];
    }


    public int getid(){
        return id;
    }

        public char[][] getlocationBoard() {
            return locationBoard;
        }
    

        public char[][] gettargetBoard() {
            return targetBoard;
        }

}
