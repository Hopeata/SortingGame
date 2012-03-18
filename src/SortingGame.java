
/**
 *
 * @author Valeria
 */
public class SortingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Board board = new Board(4, 5);
        board.initializeBoard();
        System.out.println(board.toString());
        
    }
}
