
import java.io.*;
import java.util.ArrayList;

/**
 * This class takes care of saving game and player list files and loading them when needed. 
 * @author Valeria
 */
public class StorageManager {

    /**
     * This method saves the game in file.
     * @param board
     * @param player
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void saveGame(Board board, Player player) throws FileNotFoundException, IOException {
        try (FileOutputStream file = new FileOutputStream(getSaveGameFile(player))) {
            ObjectOutputStream save = new ObjectOutputStream(file);
            save.writeObject(board);
            save.flush();
        }
    }
    
    /**
     * This method creates and names the file.
     * @param player
     * @return File that is new saveFile
     */
    private static File getSaveGameFile(Player player) {
        File saveFile = new File(player.getName() + "_game.save");
        return saveFile;
    }

    /**
     * This method loads the game of given player.
     * @param player
     * @return Board, which is the saved board
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static Board loadSavedGame(Player player) throws FileNotFoundException, 
            IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(getSaveGameFile(player))) {
            ObjectInputStream load = new ObjectInputStream(file);
            return (Board) load.readObject();
        }
    }
    
    /**
     * This method is overloaded to facilitate testing. It saves the list of Players.
     * @param players
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void savePlayers(ArrayList<Player> players) throws FileNotFoundException, IOException {
        savePlayers(null, players);
    }

    /**
     * This method is overloaded to facilitate testing. It saves the list of Players with given file name.
     * @param fileName
     * @param players
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void savePlayers(String fileName, ArrayList<Player> players) throws FileNotFoundException, IOException {
        try (FileOutputStream file = new FileOutputStream(getSavePlayersFile(fileName))) {
            ObjectOutputStream save = new ObjectOutputStream(file);
            save.writeObject(players);
            save.flush();
        }
    }

    private static File getSavePlayersFile(String fileName) {
        if (fileName == null) {
            fileName = "players.save";
        }
        File saveFile = new File(fileName);
        return saveFile;
    }

    /**
     * This method is overloaded to facilitate testing. It loads the Player list.
     * @return ArrayList of Players
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static ArrayList<Player> loadSavedPlayers() throws FileNotFoundException, 
            IOException, ClassNotFoundException {
        return loadSavedPlayers(null);
    }

    /**
     * The method loads the list of Players.
     * @param fileName
     * @return ArrayList of Players
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static ArrayList<Player> loadSavedPlayers(String fileName) 
            throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(getSavePlayersFile(fileName))) {
            ObjectInputStream load = new ObjectInputStream(file);
            return (ArrayList<Player>) load.readObject();
        }
    }
}
