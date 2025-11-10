// controller to link view and model
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;

    public TicTacToeController(TicTacToeModel m, TicTacToeView v) { //constructor 
        this.model = m;
        this.view = v;
        hookUpListeners();
        view.setStatus("Player " + model.getCurrentPlayer() + "'s turn."); //update the label to the current players turn 
    }

    private void hookUpListeners() { //setting up actionlisteners for each button
        JButton[][] buttons = view.getButtons();
        for (int r = 0; r < 3 ; r++) {
            for (int c = 0; c < 3; c++) {
                final int row = r;
                final int column = c;
                buttons[row][column].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (model.placeMark(row, column)) { //if placeMark = true (valid position), places a String of the current player (X, O)
                            buttons[row][column].setText(String.valueOf(model.getCurrentPlayer()));
                            buttons[row][column].setEnabled(false);

                            if (model.checkForWin()) { //
                                view.setStatus("Player " + model.getCurrentPlayer() + " wins!!");
                                view.changeStatusTextColour(Color.green);
                                view.changeButtonColour(model.getWinningTiles());
                                disableButtons(); //checks for win, if you do then disables buttons + green status text + green buttons 
                            }
                            else if (model.isBoardFull()) {
                                view.setStatus("Both players have reached a draw!");
                                view.changeStatusTextColour(Color.yellow);
                                for (int r = 0; r < 3; r++) {
                                    for (int c = 0; c < 3; c++) {
                                        buttons[r][c].setBackground(Color.yellow);
                                    }
                                }
                                disableButtons(); //same as win but for draw, changes entire board to yellow instead 
                            }
                            else {
                                model.switchPlayer();
                                view.setStatus("Player " + model.getCurrentPlayer() + "'s turn."); //otherwise switches turns and continues 
                            }
                        }
                    }
                });
            }
        }
        view.getResetButton().addActionListener(new ActionListener() { //adding actionlistener to reset button, resets board in model, view, reenables buttons and resets status to default
            @Override
            public void actionPerformed (ActionEvent e){
                model.resetBoard();
                view.resetBoard();
                view.enableBoard(true);
                view.setStatus("Player X's turn.");
            }
        });

    }

    private void disableButtons() { //sets enableBoard to false and disables all buttons
        view.enableBoard(false);
    }

    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView();
        new TicTacToeController(model, view);
    }
}