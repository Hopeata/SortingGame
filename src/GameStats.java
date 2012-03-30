
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Valeria
 */
public class GameStats implements Serializable {

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
    public String toString() {
        return "" + boardRows + "x" + boardColumns + ": " + 
                (gameSolved ? "solved" : "unsolved") + " with " + 
                moveCount + " moves on " + gameFinishedOn;
    }
    
    
    
}
