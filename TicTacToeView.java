// the GUI 
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class TicTacToeView extends JFrame {
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JButton resetButton; 

    public TicTacToeView() { //constructor 
        setTitle ("Tic-Tac-Toe");
        setSize(500, 550);
        setLocationRelativeTo(null); //centers it
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel tttPanel = new JPanel(new GridLayout (3, 3)); //makes the actual grid, makes a 3x3 grid with empty buttons
        buttons = new JButton[3][3];
        for(int r = 0; r < 3; r++) {
            for(int c = 0;c < 3; c++) {
                buttons[r][c] = new JButton("");
                buttons[r][c].setFont(new Font("Arial", Font.BOLD, 40)); //sets the font
                buttons[r][c].setBackground(Color.lightGray);
                buttons[r][c].setOpaque(true);
                buttons[r][c].setBorder(new LineBorder(Color.black, 3));
                tttPanel.add(buttons[r][c]);
            }
        }
        add(tttPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER); //makes the label, set to player x turn by default since controller will change
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setBackground(Color.gray);
        statusLabel.setOpaque(true);
        add(statusLabel, BorderLayout.NORTH);

        resetButton = new JButton("Reset Board"); //displays reset button
        resetButton.setFont(new Font("Arial", Font.PLAIN, 16));
        resetButton.setForeground(Color.RED);     
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resetButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void enableBoard(boolean enabled) { //enable or disable all buttons on the board, written like this (as void) so i can do both
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setEnabled(enabled);
            }
        }
    }
    
    public void resetBoard() { //clears board; sets all button text back to blank and then reenables all buttons
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("");
                buttons[r][c].setEnabled(true);
                buttons[r][c].setBackground(Color.lightGray);
            }
        }
        statusLabel.setForeground(Color.BLACK);
    }

    public void changeButtonColour(int[][] positions) { //turns buttons green; used for making the winning row green 
        for (int t = 0; t < 3; t++) {
            int row = positions[t][0];
            int col = positions[t][1];
            buttons[row][col].setBackground(Color.green);
        }
    }
    
    public void changeStatusTextColour(Color color) { //changes colour of the top label text; used for green when win
        statusLabel.setForeground(color);
    }

    public void setStatus(String status) { //sets status to (new) text
        statusLabel.setText(status);
    }

    public JButton getResetButton() { //returns reset button so controller can use it
        return resetButton;
    }

    public JButton[][] getButtons() { //returns buttons so controller can use it
        return buttons; 
    }
}
