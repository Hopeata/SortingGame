
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
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
        return "Player " + name + "'s results:\n" + stats;
    }
    
    

    
}
