
import java.io.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Valeria
 */
public class StorageManager {

    public static void saveGame(Board board, Player player) throws FileNotFoundException, IOException {
        try (FileOutputStream file = new FileOutputStream(getSaveGameFile(player))) {
            ObjectOutputStream save = new ObjectOutputStream(file);
            save.writeObject(board);
            save.flush();
        }
    }

    private static File getSaveGameFile(Player player) {
        File saveFile = new File(player.getName() + "_game.save");
        return saveFile;
    }

    public static Board loadSavedGame(Player player) throws FileNotFoundException, 
            IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(getSaveGameFile(player))) {
            ObjectInputStream load = new ObjectInputStream(file);
            return (Board) load.readObject();
        }
    }

    public static void savePlayers(ArrayList<Player> players) throws FileNotFoundException, IOException {
        savePlayers(null, players);
    }

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

    public static ArrayList<Player> loadSavedPlayers() throws FileNotFoundException, 
            IOException, ClassNotFoundException {
        return loadSavedPlayers(null);
    }

    public static ArrayList<Player> loadSavedPlayers(String fileName) 
            throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(getSavePlayersFile(fileName))) {
            ObjectInputStream load = new ObjectInputStream(file);
            return (ArrayList<Player>) load.readObject();
        }
    }
}
