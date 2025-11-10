//model; game logic and win/draw conditions

public class TicTacToeModel {
    private char[][] board;
    private char currentPlayer;
    private int[][] winningTiles = new int[3][2]; //3 = 3 tiles, 2 = row/column for each of those 3 tiles (i keep getting confused)

    public TicTacToeModel() { // constructor, starts board and sets player as X
        initialiseBoard();
        currentPlayer = 'X';
    }

    private void initialiseBoard() { // makes a 3x3 grid, loops through to set all as ' ', sets player as X
        board = new char[3][3]; 
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    public void resetBoard() { //literally just reruns initialiseboard
        initialiseBoard();
    }

    public char getCurrentPlayer() { //returns current player 
        return currentPlayer;
    }

    public char getMark(int row, int column) { //checks if out of bounds (return space bc char), else returns the specified char (x, O, ' ')
        if (isOutOfBounds(row, column)) {
            return ' ';
        }
        return board[row][column];
    }

    public int[][] getWinningTiles() { //returns winning tiles for controller
        return winningTiles;
    }

    public void switchPlayer() { //if player is x, makes it O, else makes it x
        if (currentPlayer == 'X') { 
            currentPlayer = 'O';
        } 
        else {
            currentPlayer = 'X';
        }
    }

    public boolean placeMark(int row, int column) { //checks for outofbound, if space is empty swaps it to the currentplayers symbol, if not is false
        if (isOutOfBounds(row, column)) {
            return false;
        }
        else if (board[row][column] == ' ') {
            board[row][column] = currentPlayer;
            return true;
        } 
        return false;
    }

    public boolean isBoardFull() { //checks for spaces, if none then board is full 
        for (int r = 0; r < 3; r++) 
            for (int c = 0; c < 3; c++) 
                if (board[r][c] == ' ') {
                return false;
                }
        return true;
    }

    public boolean isOutOfBounds(int row, int column) { //checks if out of bounds
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            return true;
        } 
        return false;
    }

    public boolean checkForWin() { //checks rows, columns and diagonals to detect win condition 
        if ((checkRows() == true) || (checkColumns() == true) || (checkDiagonals() == true)) {
            return true;
        }
        return false;
    }

    private boolean checkRows() { //check if any row is filled (loop to move through each row), filled = true, not = false, creates the winning tiles array
        for (int r = 0; r < 3; r++) {
            if (board[r][0] != ' ' && board[r][0] == board[r][1] && board[r][1] == board[r][2]) { //if all positions in a row are the same and not a space
                winningTiles[0] = new int[]{r, 0}; //first tile in winning row; make new int with correct row and then first row (has to be a straight line)
                winningTiles[1] = new int[]{r, 1};
                winningTiles[2] = new int[]{r, 2};
                return true;
            }
        }
    return false; 
    }

    private boolean checkColumns() { //same as checkrows but for columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] != ' ' && board[0][c] == board[1][c] && board[1][c] == board[2][c]) { 
                winningTiles[0] = new int[]{0, c}; 
                winningTiles[1] = new int[]{1, c};
                winningTiles[2] = new int[]{2, c};
                return true;
            }
        }
    return false; 
    }

    private boolean checkDiagonals() { //checks diagnonal; no need for loop because only two possible diagonals which remain same
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winningTiles[0] = new int[]{0,0}; //has to be separate this time for each one 
            winningTiles[1] = new int[]{1,1};
            winningTiles[2] = new int[]{2,2};
            return true;
        }
        else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winningTiles[0] = new int[]{0,2};
            winningTiles[1] = new int[]{1,1};
            winningTiles[2] = new int[]{2,0};
            return true;
        }
        return false;
    }

}