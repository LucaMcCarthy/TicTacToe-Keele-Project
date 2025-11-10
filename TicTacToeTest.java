// JUnit testing
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TicTacToeTest {
    private TicTacToeModel model;

    @Before //set up model before each test 
    public void myTestSetUpModel() {
        model = new TicTacToeModel();
        System.out.println("Test set-up completed.");
    }

    @After 
    public void myTearDown() {
        System.out.println("Test tear-down completed.");
    }

    @Test
    public void testTopRow() { //places mark at in positions (so all top row this time), checks for win
        model.placeMark(0, 0);
        model.placeMark(0, 1);
        model.placeMark(0, 2);
        boolean result = model.checkForWin();
        System.out.println("Test Top Row: " + result); //has to go first or it wont print on a fail 
        assertTrue(result);
    }

    @Test
    public void testMiddleRow() {
        model.placeMark(1, 0);
        model.placeMark(1, 1);
        model.placeMark(1, 2);
        boolean result = model.checkForWin();
        System.out.println("Test Middle Row: " + result); 
        assertTrue(result);
    }

    @Test
    public void testBottomRow() {
        model.placeMark(2, 0);
        model.placeMark(2, 1);
        model.placeMark(2, 2);
        boolean result = model.checkForWin();
        System.out.println("testBottomRow: " + result); 
        assertTrue(result);
    }

    @Test
    public void testLeftColumn() {
        model.placeMark(0, 0);
        model.placeMark(1, 0);
        model.placeMark(2, 0);
        boolean result = model.checkForWin();
        System.out.println("Test Left Column: " + result); 
        assertTrue(result);
    }

    @Test
    public void testMiddleColumn() {
        model.placeMark(0, 1);
        model.placeMark(1, 1);
        model.placeMark(2, 1);
        boolean result = model.checkForWin();
        System.out.println("Test Middle Column: " + result); 
        assertTrue(result);
    }

    @Test
    public void testRightColumn() {
        model.placeMark(0, 2);
        model.placeMark(1, 2);
        model.placeMark(2, 2);
        boolean result = model.checkForWin();
        System.out.println("Test Right Column: " + result); 
        assertTrue(result);
    }

    @Test
    public void testLTRDiagonal() { //left to right diagonal
        model.placeMark(0, 0);
        model.placeMark(1, 1);
        model.placeMark(2, 2);
        boolean result = model.checkForWin();
        System.out.println("Test Left-to-Right Diagonal: " + result); 
        assertTrue(result);
    }

    @Test
    public void testRTLDiagonal() { //right to left
        model.placeMark(0, 2);
        model.placeMark(1, 1);
        model.placeMark(2, 0);
        boolean result = model.checkForWin();
        System.out.println("Test Right-to-Left Diagonal: " + result);  
        assertTrue(result);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("TicTacToeTest");
        System.out.println("Beginning tests. True = successful test, False = unsuccessful test.");
    }

}