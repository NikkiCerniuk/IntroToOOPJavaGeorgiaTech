import java.util.Scanner;


public class Battleship {
    
    static Scanner scanner = new Scanner(System.in); 
        public static void main (String[] argc){ //double check that i should not be passing in the 2D array here and instead make it in the program 
            System.out.println("Welcome to Battleship!"); //1. print "Welcome to Battleship!"
            System.out.println();
            Player player1 = new Player(1); //creates a player1 and player2 + their related boards 
            initalBoard(player1.getlocationBoard());
            initalBoard(player1.gettargetBoard());
            enterShips(player1);
           
            Player player2 = new Player(2);
            initalBoard(player2.getlocationBoard());
            initalBoard(player2.gettargetBoard());
            enterShips(player2);
        
            takeShot(player1, player2);
            scanner.close(); //closing the scanner prevents data leaks

    }


        // Use this method to print game boards to the console.
        private static void printBattleShip(char[][] player) {
            System.out.print("  ");
            for (int row = -1; row < 5; row++) {
                if (row > -1) {
                    System.out.print(row + " ");
                }
                for (int column = 0; column < 5; column++) {
                    if (row == -1) {
                        System.out.print(column + " ");
                    } else {
                        System.out.print(player[row][column] + " ");
                    }
                }
                System.out.println("");
            }
        }



//i am done wrting this block of code
//at the start of each game, each board should contain ships with no hits 
    public static void initalBoard(char[][] board){
        for(int row = 0; row < board.length; row++){ //must use at least once: A for loop (not including those used in provided code)
            for(int column = 0; column < board[row].length; column++){
                board[row][column]= '-';
            }
        }
    }



//done with this one 
// takes 5 ship locations and puts them on the board
    public static void enterShips(Player player){
        System.out.printf("PLAYER %d, ENTER YOUR SHIPS' COORDINATES.%n", player.getid());
        for (int i = 0;i < 5; i++){
            boolean shipPlaced = false;
            do{ //use a do-while loop at least once 
                System.out.println("Enter ship " + (i+1) + " location:");
                if (scanner.hasNextInt()){
                    int row = scanner.nextInt(); //puts the first int as row primative variable
                    if(scanner.hasNextInt()){
                        int column = scanner.nextInt(); // puts the second int as the column primative variable 
                        if(checkIfOnBoard(row, column, player.getlocationBoard()) == true){
                            if(player.getlocationBoard()[row][column] != '@'){
                                player.getlocationBoard()[row][column] = '@'; //puts ship on the board in the place you specified
                                shipPlaced= true; // goes to the next iteration of the loop
                            }else{
                                System.out.println("You already have a ship there. Choose different coordinates.");
                                //here how do i make it go to the next iteration of i?
                            }  
                        }else{
                            System.out.println("Invalid coordinates. Choose different coordinates."); //this is if its not on the board
                            //should redo the same iteration
                            //needs to repeat the same interation after this instead of doing the other else statement as well
                        }
                    }else{
                        System.out.println("Invalid coordinates. Choose different coordinates."); //this one is if int2 is not an int
                        scanner.nextLine();
                        //should redo the same interation
                    }
                }else{
                    System.out.println("Invalid coordinates. Choose different coordinates.");//this one is if int1 is not an int 
                    scanner.nextLine();
                }
            }while(!shipPlaced); //repeat this until we break
        }
            printBattleShip(player.getlocationBoard());//print location board. DO NOT alter the printBattleShip method. arrays get passed in by reference so we are motifying the same memory as the origional array 
            for(int j =0; j<100; j++){
                System.out.println(); //100 new lines must follow the printed board so that the other player will not see
            }
    }
              


//this one is finished 
//checks if board setup and firing coorindates are valid ints 
//for target board and location board 
    public static boolean checkIfOnBoard(int r, int c, char[][] board){
        if(
            r >= 0 && r < board.length &&
            c >=0 && c < board[r].length
            ){
            return true;
            }else{
            // already printing the error message in the enterShips 
            return false; 
            }
        // first int is row second int is column 
    }


//this one is finished
//checks if the player already fired on that spot of the opponent
//for target board
public static boolean notFired(int r, int c, char[][] board){
    if(board[r][c] == '-'){
        return true;
    }else{
        return false;
    }
}





//still need to finish this one 
public static void takeShot(Player player1, Player player2){
    boolean player1Turn = true; //we start with player 1s turn
    boolean gameOver = false;

    while(!gameOver){ //only ends when game ends 
        Player currentPlayer = player1Turn ? player1 : player2;
        Player opponentPlayer = player1Turn ? player2 : player1;
    

        do{
            System.out.printf("Player %d, enter hit row/column:%n", currentPlayer.getid());
            if(scanner.hasNextInt()){ //check if int1 is real 
                    int r = scanner.nextInt();//store int1 in row
                    if(scanner.hasNextInt()){ //check if int2 is real
                        int c = scanner.nextInt();//store int2 in column
                        if(checkIfOnBoard(r, c, currentPlayer.gettargetBoard()) == true){
                        if(notFired(r, c, currentPlayer.gettargetBoard()) == true){


                            // need to seperate check if on board and not fired becuase on board should print a different error 
                            if (opponentPlayer.getlocationBoard()[r][c]== '@'){ //if its a hit
                                opponentPlayer.getlocationBoard()[r][c] = 'X';
                                currentPlayer.gettargetBoard()[r][c] = 'X';
                                System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!%n", currentPlayer.getid(), opponentPlayer.getid());
                            }else{//if its a miss
                                opponentPlayer.getlocationBoard()[r][c] = 'O';
                                currentPlayer.gettargetBoard()[r][c] = 'O';
                                System.out.printf("PLAYER %d MISSED!%n", currentPlayer.getid());
                            }

                            printBattleShip(currentPlayer.gettargetBoard());

                            if(gameWin(opponentPlayer.getlocationBoard()) == true){
                                gameOver = true;
                                System.out.printf("PLAYER %d WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!%n", currentPlayer.getid());
                                System.out.println();
                                System.out.printf("Final boards:%n");
                                System.out.println();
                                printBattleShip(player1.getlocationBoard()); //print player 1 final location board
                                System.out.println();
                                printBattleShip(player2.getlocationBoard());// print player 2 final location board
                                break;
                            }else{
                                System.out.println();
                                player1Turn = !player1Turn; //switches turns 
                                break;
                            }
                            
                        }else{
                            System.out.println("You already fired on this spot. Choose different coordinates.");
                        }
                    }else{
                        System.out.println("Invalid coordinates. Choose different coordinates."); //this one is if int2 is not an int
                        scanner.nextLine(); //clears invalid input for the entire next line rather than just the next token
                    }
                    }else{
                        System.out.println("Invalid coordinates. Choose different coordinates."); //this one is if int2 is not an int
                        scanner.nextLine(); //clears invalid input for the entire next line rather than just the next token
                        //should redo the same interation
                        //if no second int then 
                    }
                }else{
                    System.out.println("Invalid coordinates. Choose different coordinates."); //this one is if int2 is not an int
                    scanner.nextLine(); //clears invalid input for the entire line not just the token
                    //if no first int then
                }

            }while(gameOver == false);
        }
    }


public static boolean gameWin(char[][] board){
        for (int row = 0; row < board.length; row++ ){
            for (int column= 0; column < board[row].length; column++){
                if(board[row][column] == '@'){
                return false; // found an unsunk ship
                }
            }
            }
            return true; // having true out here makes sure that the game checks the entire board before returning true, rather than returning true after the first iteration
}
}



/* 

LocationBoard
    6a. A '–' character must represent an empty space.
    6b. '@' character must represent a ship that is not hit.
    6c. An 'X' character will represent a space with a ship that has been hit.
    6d. An 'O' character will represent a space that was fired upon, but since there is not ship at that location, the shot was a miss.


TargetHistoryBoard
8. after each hit or miss, display the target board to the console 
    8a. An 'X' character will represent a space with a ship that has been hit.
    8b. An 'O' character will represent a space that was fired upon, but since there is not ship at that location, the shot was a miss.
    8a. '-' character must represent a space that has not been attacked.




/*
rules:
- look at the README for any text specifications 
    

       



9. Prompt Player 1 to enter a coordinate to fire upon. You can expect the user input will be two ints separated by a space.
    - if the user enteres invalid ints print "Invalid coordinates. Choose different coordinates."
    - If the user enters a coordinate that they had already entered, print out the following "You already fired on this spot. Choose different coordinates.
"
    - If the user enters a coordinate with no ship on it, print out the following and print the updated 
            - Target History Board, where [NUM] is replaced with the attacked player's ID. "PLAYER [NUM] MISSED!"
            - Target History Board, "PLAYER [NUM A] HIT PLAYER [NUM B]'s SHIP!" where player num A is the attacking player and player num b is the player whose ship was hit



when This will occur when all of the '@' signs 
on their opponent's board have been replaced with 'X' symbols.
   
    - Using the provided method, print both players' Location Boards in order to verify the results of the
    game to the players. Player 1's Location Board should be printed first.
    "PLAYER [NUM] WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!"
    - terminate program gracefully after player wins





    prompt player 1 to enter a coordinate to fire upon
    - pass to checkIfOnBoard
    - pass to checkIfFired



*/

