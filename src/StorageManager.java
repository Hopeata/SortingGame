
import java.io.*;
import java.util.ArrayList;

/**
 * This class takes care of saving game and player list files and loading them
 * when needed.
 *
 * @author Valeria
 */
public class StorageManager {

    /**
     * This method saves the game in file.
     *
     * @param board
     * @param player
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveGame(Board board, Player player) {
        try {
            try (FileOutputStream file = new FileOutputStream(getSaveGameFile(player))) {
                ObjectOutputStream save = new ObjectOutputStream(file);
                save.writeObject(board);
                save.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method creates and names the file.
     *
     * @param player
     * @return File that is new saveFile
     */
    private static File getSaveGameFile(Player player) {
        File saveFile = new File(player.getName() + "_game.save");
        return saveFile;
    }

    /**
     * This method loads the game of given player.
     *
     * @param player
     * @return Board, which is the saved board
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Board loadSavedGame(Player player) {
        try {
            File file = getSaveGameFile(player);
            if (!file.exists()) {
                return null;
            }
            try (FileInputStream fileStream = new FileInputStream(file)) {
                ObjectInputStream load = new ObjectInputStream(fileStream);
                return (Board) load.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void deleteSavedGame(Player player) {
        File file = getSaveGameFile(player);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * This method is overloaded to facilitate testing. It saves the list of
     * Players.
     *
     * @param players
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void savePlayers(ArrayList<Player> players) {
        savePlayers(null, players);
    }

    /**
     * This method is overloaded to facilitate testing. It saves the list of
     * Players with given file name.
     *
     * @param fileName
     * @param players
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void savePlayers(String fileName, ArrayList<Player> players) {
        try {
            try (FileOutputStream file = new FileOutputStream(getSavePlayersFile(fileName))) {
                ObjectOutputStream save = new ObjectOutputStream(file);
                save.writeObject(players);
                save.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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
     * This method is overloaded to facilitate testing. It loads the Player
     * list.
     *
     * @return ArrayList of Players
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Player> loadSavedPlayers() {
        return loadSavedPlayers(null);
    }

    /**
     * The method loads the list of Players.
     *
     * @param fileName
     * @return ArrayList of Players
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Player> loadSavedPlayers(String fileName) {
        try {
            File file = getSavePlayersFile(fileName);
            if (!file.exists()) {
                return new ArrayList<Player>();
            }
            try (FileInputStream fileStream = new FileInputStream(file)) {
                ObjectInputStream load = new ObjectInputStream(fileStream);
                return (ArrayList<Player>) load.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
