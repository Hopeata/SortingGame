
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class manages the information of the games the Player has played.
 * @author Valeria
 */
public class PlayerStats implements Serializable {

    private ArrayList<GameStats> playedGames;

    public PlayerStats() {
        playedGames = new ArrayList<>();
    }
    
    /**
     * This method adds a GameStats object containing the information of a single game
     * to the list of played games.
     * @param playedGame 
     */
    public void addPlayedGame(GameStats playedGame) {
        playedGames.add(playedGame);
    }

    public ArrayList<GameStats> getPlayedGames() {
        return playedGames;
    }
    
    public int getNumberOfPlayedGames() {
        return playedGames.size();
    }
    
    public int getNumberOfSolvedGames() {
        int numberOfSolvedGames = 0;
        for (GameStats gameStats : playedGames) {
            if (gameStats.isGameSolved()) {
                numberOfSolvedGames++;
            }
        }
        return numberOfSolvedGames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solved games: " + getNumberOfSolvedGames() + " / " + getNumberOfPlayedGames());
        sb.append("\nPlayed games:\n");
        for (GameStats gameStats : playedGames) {
            sb.append(gameStats + "\n");
        }
        return sb.toString();
    }
    
    
}
