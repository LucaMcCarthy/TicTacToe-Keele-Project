import java.util.Scanner;

public class Main {
    public static void main(String [ ] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Welcome to TicTacToe!");
        System.out.println("Choose version you'd like to play:");
        System.out.println("GUI - 1");
        System.out.println("Console - 2");
        System.out.println("Enter 1 or 2");

        String modeChoice = scanner.nextLine();

        switch(modeChoice) {
            case "1": {
                TicTacToeModel model = new TicTacToeModel();
                TicTacToeView view = new TicTacToeView();
                new TicTacToeController(model, view);
                break;
            }
            
            case "2": {
                TicTacToeModel model = new TicTacToeModel();
                TicTacToeConsole console = new TicTacToeConsole(model);
                System.out.println("May the best player win.");
                System.out.println("---- Noughts & Crosses ----");
                console.playTTT();
                break;
            }

            default:
                System.out.println("Invalid choice. Exiting.");
                break;
        }

    scanner.close();
    }
}
