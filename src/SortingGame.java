
import java.util.Scanner;

/**
 *
 * @author Valeria
 */
public class SortingGame {

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
                    + " -1 ends the game");
            int row = reader.nextInt();
            if (row == -1) {
                break;
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
