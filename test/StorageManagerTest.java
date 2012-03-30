/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Valeria
 */
public class StorageManagerTest {

    private static final String PLAYER_SAVE_FILENAME = "jUnit_test_players.save";

    public StorageManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        File playerSaveFile = new File(PLAYER_SAVE_FILENAME);
        if (playerSaveFile.exists()) {
            playerSaveFile.delete();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private ArrayList<Player> getTestPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player("jUnit");
        PlayerStats stats = player.getStats();
        stats.addPlayedGame(new GameStats(5, 5, 120, true, new Date()));
        players.add(player);
        player = new Player("jUnit2");
        stats = player.getStats();
        stats.addPlayedGame(new GameStats(4, 4, 93, true, new Date()));
        stats.addPlayedGame(new GameStats(4, 6, 101, false, new Date()));
        players.add(player);
        return players;
    }

    @Test
    public void savePlayer() {
        try {
            ArrayList<Player> players = getTestPlayers();
            StorageManager.savePlayers(PLAYER_SAVE_FILENAME, players);
            ArrayList<Player> loadedPlayers = StorageManager.loadSavedPlayers(PLAYER_SAVE_FILENAME);
            for (Player loadedPlayer : loadedPlayers) {
                System.out.println(loadedPlayer);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
