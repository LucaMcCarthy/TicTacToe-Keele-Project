
// console to play in the terminal 
import java.util.Scanner; 

public class TicTacToeConsole {
    private Scanner inputScan;
    private TicTacToeModel modelBoard; 
    private char[][] boardDisplay;   

    public TicTacToeConsole(TicTacToeModel m) { //constructor method
        this.modelBoard = m;
        inputScan = new Scanner(System.in);
        boardDisplay = new char[3][3];
    }

    public char getCurrentPlayer() { //basically keeps track of the currentplayer using model
        return modelBoard.getCurrentPlayer();
    }

    public void playTTT() { //runs the game in console
        boolean gameOver = false;
        while (gameOver == false) {
            updateBoardDisplay();
            showDisplayBoard();
            System.out.println("Player " + modelBoard.getCurrentPlayer() + "'s turn.");
            int usersRow = 12; //just setting it to a random number before input is decided and 12 is the best number 
            int usersColumn = 12;
            boolean inputSet = false;
            while (inputSet == false) {
                System.out.println("Choose row (0 - 2).");
                usersRow = inputScan.nextInt();
                System.out.println("Choose column (0 - 2).");
                usersColumn = inputScan.nextInt();

                if (modelBoard.isOutOfBounds(usersRow, usersColumn) == true) {
                    System.out.println("Choice was out of bounds. Try again.");
                }
                else if (modelBoard.placeMark(usersRow, usersColumn) == false) { //checks if place mark is false = position is taken = fail
                    System.out.println("Position is already taken. Try again.");
                }
                else {
                    inputSet = true;  
                }
            }

            updateBoardDisplay(); //update board display also at end so it displays winning turn too 
        
            gameOver = modelBoard.checkForWin() || modelBoard.isBoardFull(); //checks for either gameover condition, prints appropriate message or switches turn
            if (modelBoard.checkForWin()) {
                showDisplayBoard();
                System.out.println("Player " + modelBoard.getCurrentPlayer() + " wins!");
            } 
            else if (modelBoard.isBoardFull()) {
                showDisplayBoard();
                System.out.println("Players reached a draw!");
            } 
            else {
                modelBoard.switchPlayer();
            }
        } 
    }

    private void updateBoardDisplay() { //keeps track of the board
        for (int rl = 0; rl < 3; rl++) {
            for (int cl = 0; cl < 3; cl++) {
                boardDisplay[rl][cl] = modelBoard.getMark(rl, cl);
            }
        }
    }

    private void showDisplayBoard() { //prints the board
        System.out.println("Board Display:");
        System.out.print("   "); // spaces for row numbers
        for (int cl = 0; cl < 3; cl++) {
            System.out.print(" " + cl + "  "); //prints column numbers
        }
        System.out.println();
        for (int rl = 0; rl < 3; rl++) {
            System.out.print(rl + " "); //prints row numbers
            for (int cl = 0; cl < 3; cl++) {
                char mark = boardDisplay[rl][cl];
                if (mark == ' ') {
                    System.out.print("[-] "); //swaps spaces for dashes 
                } else {
                    System.out.print("[" + mark + "] ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) { 
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeConsole console = new TicTacToeConsole(model);
        System.out.println("Welcome to TicTacToe!");
        System.out.println("May the best player win.");
        System.out.println("---- Noughts & Crosses ----");
        console.playTTT();
    }

}
