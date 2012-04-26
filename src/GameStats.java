
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class keeps track of the situation of a single game: the size(columns and rows),
 * whether the game is solved, which is the moveCount and the date when the game was finished.
 * @author Valeria
 */
public class GameStats implements Serializable, Comparable {

    private int boardRows;
    private int boardColumns;
    private int moveCount;
    private boolean gameSolved;
    private Date gameFinishedOn;

    public GameStats(int boardRows, int boardColumns, int moveCount, 
            boolean gameSolved, Date gameFinishedOn) {
        this.boardRows = boardRows;
        this.boardColumns = boardColumns;
        this.moveCount = moveCount;
        this.gameSolved = gameSolved;
        this.gameFinishedOn = gameFinishedOn;
    }

    public int getBoardColumns() {
        return boardColumns;
    }

    public int getBoardRows() {
        return boardRows;
    }

    public boolean isGameSolved() {
        return gameSolved;
    }

    public int getMoveCount() {
        return moveCount;
    }
    
    public Date getGameFinishedOn() {
        return gameFinishedOn;
    }

    @Override
    public int compareTo(Object t) {
        GameStats otherStat = (GameStats) t;
        return -1 * this.gameFinishedOn.compareTo(otherStat.getGameFinishedOn());
    }

    @Override
    public String toString() {
        return "" + boardRows + "x" + boardColumns + ": " + 
                (gameSolved ? "solved" : "unsolved") + " with " + 
                moveCount + " moves on " + new SimpleDateFormat("dd.MM.yyyy HH:mm").format(gameFinishedOn);
    }
    
    
    
}
