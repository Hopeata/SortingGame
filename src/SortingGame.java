
import java.io.*;
import java.util.Scanner;

/**
 * This class deals with different game instances(boards) and saving game files, 
 * it knows the Player objects and functions at the moment as a user interface
 * @author Valeria
 */
public class SortingGame {

    public void saveGame(Board board) throws Exception {
        try (FileOutputStream file = new FileOutputStream(getSaveFile())) {
            ObjectOutputStream save = new ObjectOutputStream(file);
            save.writeObject(board);
            save.flush();
        }
    }

    private File getSaveFile() {
        File saveFile = new File("game.save");
        return saveFile;
    }

    public Board loadSavedGame() throws Exception {
        try (FileInputStream file = new FileInputStream(getSaveFile())) {
            ObjectInputStream load = new ObjectInputStream(file);
            return (Board)load.readObject();
        }
    }

    private void textUserInterface() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Give the number of rows (3-10): ");
        int rows = reader.nextInt();
        System.out.println("Give the number of columns (3-10): ");
        int columns = reader.nextInt();
        Board board = new Board(rows, columns);
        board.initializeBoard();
        while (true) {
            System.out.println(board.toString());
            System.out.println("Your moves: " + board.getMoveCount());
            if (board.tilesInOrder()) {
                System.out.println("Congratulations, you've won the game!");
                break;
            }
            System.out.println("Give the number of the row of the tile you want to move,"
                    + "\n  -1 ends the game"
                    + "\n  -2 saves the game"
                    + "\n  -3 loads the game");
            int row = reader.nextInt();
            try {
                if (row == -1) {
                    break;
                } else if (row == -2) {
                    saveGame(board);
                    continue;
                } else if (row == -3) {
                    board = loadSavedGame();
                    continue;
                }

                System.out.println("Give the number of the column of the tile you want to move, "
                        + "-1 sorts the tiles in order");
                int column = reader.nextInt();
                if (column == -1) {
                    board.sortTilesInOrder();
                } else {
                    boolean movePossible = board.moveTile(row - 1, column - 1);
                    if (!movePossible) {
                        System.out.println("This move is not possible");
                    } else {
                        System.out.println("The move was successful");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortingGame game = new SortingGame();
        game.textUserInterface();


    }
}
