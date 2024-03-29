
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class deals with different game instances(boards) and saving game files,
 * it knows the Player objects and functions at the moment as a user interface
 *
 * @author Valeria
 */
public class SortingGame {

    private Player selectedPlayer;
    private ArrayList<Player> players;
    private Board board;
    
    public SortingGame() {
        players = StorageManager.loadSavedPlayers();
        selectedPlayer = null;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }
    
    public void setBoard(Board board) {
        this.board = board;
    }
    
    public Board getSavedGame() {
        return StorageManager.loadSavedGame(selectedPlayer);
    }
    
    public void deleteSavedGame() {
        StorageManager.deleteSavedGame(selectedPlayer);
    }

    public void startNewGame(int rows, int columns) {
        board = new Board(rows, columns);
        board.initializeBoard();
    }

    public Player addPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return null;
            }
        }
        Player player = new Player(name);
        players.add(player);
        StorageManager.savePlayers(players);
        return player;
    }
    
    public void deleteSelectedPlayer(Player player) {
        players.remove(player);
        StorageManager.savePlayers(players);
        StorageManager.deleteSavedGame(player);
    }
    
    public boolean moveTile(int row, int column) {
        return board.moveTile(row, column);
    }
    
    public boolean tilesInOrder() {
        return board.tilesInOrder();
    }
    
    public void cheat() {
        board.sortTilesInOrder();
        board.moveTile(board.getRows() - 1, board.getColumns() - 2);
    }
    
    public void addGameStats(GameStats gameStats) {
        selectedPlayer.getStats().addPlayedGame(gameStats);
        StorageManager.savePlayers(players);
    }

    private void textUserInterface() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Give the number of rows (3-10): ");
        int rows = reader.nextInt();
        System.out.println("Give the number of columns (3-10): ");
        int columns = reader.nextInt();
        Board board = new Board(rows, columns);
        board.initializeBoard();
        Player player = new Player("TextUI");
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
                    StorageManager.saveGame(board, player);
                    continue;
                } else if (row == -3) {
                    board = StorageManager.loadSavedGame(player);
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
