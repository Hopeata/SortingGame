
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class keeps track about one single game at once and functions as a board for the tiles at the same
 * time. It initializes each game/board, makes the moves and sorts them if necessary. It knows, when the
 * game has been won and counts the moves.
 * @author Valeria
 */
public class Board implements Serializable {

    private Tile[][] board;
    private int moveCount = 0;

    public Board(int rows, int columns) {
        if (rows < 3 || rows > 10 || columns < 3 || columns > 10) {
            throw new IllegalArgumentException("The number of rows and columns must be between 3 and 10. "
                    + "Received " + rows + " rows and " + columns + " columns.");
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

    public int getMoveCount() {
        return moveCount;
    }

    /**
     * The method initialize a new game / the Board and annulate the move
     * counter
     */
    public void initializeBoard() {
        boolean tilesInOrder = true;
        while (tilesInOrder) {
            ArrayList<Tile> tiles = getTilesForBoard();
            for (int row = 0; row < getRows(); row++) {
                for (int column = 0; column < getColumns(); column++) {
                    if (tiles.size() > 0) {
                        int randomTileIndex = (int) (Math.random() * tiles.size());
                        board[row][column] = tiles.remove(randomTileIndex);
                    }
                }
            }
            tilesInOrder = tilesInOrder();
        }
        moveCount = 0;
    }

    /**
     * The method creates a new list of Tile objects for a new game / the Board
     *
     * @return a list of Tile objects
     */
    private ArrayList<Tile> getTilesForBoard() {
        int numberOfTiles = board.length * board[0].length - 1;
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int orderNumber = 1; orderNumber <= numberOfTiles; orderNumber++) {
            Tile tile = new Tile(orderNumber);
            tiles.add(tile);
        }
        return tiles;
    }

    /**
     * The method 'makes a move' on the Board with tile if possible
     *
     * @param row given by the user
     * @param column given by the user
     * @return boolean whether the Tile can be moved or not
     */
    public boolean moveTile(int row, int column) {
        int[] emptyTileCoordinates = findEmptyTile(row, column);
        if (emptyTileCoordinates != null) {
            board[emptyTileCoordinates[0]][emptyTileCoordinates[1]] = board[row][column];
            board[row][column] = null;
            moveCount++;
            return true;
        }
        return false;
    }

    private int[] findEmptyTile(int row, int column) {
        if (column > 0 && board[row][column - 1] == null) {
            return new int[]{row, column - 1};
        } else if (row > 0 && board[row - 1][column] == null) {
            return new int[]{row - 1, column};
        } else if (column < (getColumns() - 1) && board[row][column + 1] == null) {
            return new int[]{row, column + 1};
        } else if (row < (getRows() - 1) && board[row + 1][column] == null) {
            return new int[]{row + 1, column};
        }
        return null;
    }

    public boolean tilesInOrder() {
        int expectedOrderNumber = 1;
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getColumns(); column++) {
                if (board[row][column] == null) {
                    if (row != getRows() - 1 || column != getColumns() - 1) {
                        return false;
                    }
                } else {
                    if (board[row][column].getOrderNumber() != expectedOrderNumber) {
                        return false;
                    }
                    expectedOrderNumber++;
                }
            }
        }
        return true;
    }

    public void sortTilesInOrder() {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getColumns(); column++) {
                Tile tile = board[row][column];
                if (tile != null) {
                    tiles.add(tile);
                    board[row][column] = null;
                }
            }
        }
        Collections.sort(tiles);
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getColumns(); column++) {
                if (tiles.size() > 0) {
                    board[row][column] = tiles.remove(0);
                }
            }
        }
        moveCount = 0;
    }

        @Override
        public String toString
        
            () {
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
