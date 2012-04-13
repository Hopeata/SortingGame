
import java.io.Serializable;
import java.util.ArrayList;


/**
 * This class keeps track about the name and statistics of each player. 
 * @author Valeria
 */
public class Player implements Serializable {
    
    private String name;
    private PlayerStats stats;
    
    public Player(String name) {
        this.name = name;
        this.stats = new PlayerStats();
    }
    
    public String getName() {
        return name;
    }
    
    public PlayerStats getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return name;
    }
    
    

    
}
