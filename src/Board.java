
import java.util.ArrayList;

/**
 *
 * @author Valeria
 */
public class Board {

    private Tile[][] board;

    public Board(int rows, int columns) {
        if (rows < 3 || rows > 10 || columns < 3 || columns > 10) {
            throw new IllegalArgumentException("The number of rows and columns must be between 3 and 10. "
                    + "Received " + rows + " rows and " + columns + " columns." );
        }
        this.board = new Tile[rows][columns];
    }
    
    public int getRows() {
        return board.length;
    }
    
    public int getColumns() {
        return board[0].length;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        ArrayList<Tile> tiles = getTilesForBoard();
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getColumns(); column++) {
                if (tiles.size() > 0) {
                    int randomTileIndex = (int) (Math.random() * tiles.size());
                    board[row][column] = tiles.remove(randomTileIndex);
                }
            }
        }
    }

    private ArrayList<Tile> getTilesForBoard() {
        int numberOfTiles = board.length * board[0].length - 1;
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int orderNumber = 1; orderNumber <= numberOfTiles; orderNumber++) {
            Tile tile = new Tile(orderNumber);
            tiles.add(tile);
        }
        return tiles;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("Board situation:\n");
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getColumns(); column++) {
                if (column != 0) {
                    toString.append(" | ");
                }
                Tile tile = board[row][column];
                if (tile != null) {
                    toString.append(String.format("%2s", tile.toString()));
                } else {
                    toString.append("  ");
                }
            }
            toString.append("\n");
        }
        return toString.toString();
    }
}
