
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Valeria
 */
public class SortingGameUI extends javax.swing.JFrame {

    private SortingGame game;

    /**
     * Creates new form SortingGameUI
     */
    public SortingGameUI() {
        game = new SortingGame();
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        showPlayerSelectionPanel();
    }

    public int getBoardRows() {
        return game.getBoard().getRows();
    }

    public int getBoardColumns() {
        return game.getBoard().getColumns();
    }

    public ArrayList<Player> getPlayers() {
        return game.getPlayers();
    }

    public Player getSelectedPlayer() {
        return game.getSelectedPlayer();
    }

    public int getMoveCount() {
        return game.getBoard().getMoveCount();
    }

    public void deleteSavedGame() {
        game.deleteSavedGame();
    }

    public void selectPlayer(Player player) {
        if (player == null) {
            JOptionPane.showMessageDialog(null, "No player has been selected");
        } else {
            game.setSelectedPlayer(player);
            Board savedGame = game.getSavedGame();
            if (savedGame != null) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to want to "
                        + "continue the previous game?") == 0) {
                    game.setBoard(savedGame);
                    showGamePanel();
                    return;
                } else {
                    deleteSavedGame();
                }
            }
            showBoardSettingPanel();
        }
    }

    private void setContentPanelContent(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.revalidate();
    }

    public void showGamePanel() {
        setContentPanelContent(new GamePanel(this));
    }

    public void showBoardSettingPanel() {
        setContentPanelContent(new BoardSettingPanel(this));
    }

    public void showPlayerSelectionPanel() {
        setContentPanelContent(new PlayerSelectionPanel(this));
    }

    public void selectNewPlayer() {
        Player player = null;
        while (player == null) {
            String name = JOptionPane.showInputDialog("Please give your name");
            if (name == null) {
                return;
            }
            player = game.addPlayer(name);
            if (player == null) {
                JOptionPane.showMessageDialog(null, "The player already exists, "
                        + "choose another name", "Player exists", JOptionPane.PLAIN_MESSAGE);
            }
        }
        selectPlayer(player);
    }

    public void deleteSelectedPlayer(Player player) {
        if (player == null) {
            JOptionPane.showMessageDialog(null, "No player has been selected", 
                    "No player selected", JOptionPane.PLAIN_MESSAGE);
        } else {
            game.deleteSelectedPlayer(player);
            setContentPanelContent(new PlayerSelectionPanel(this));
        }
    }

    public Tile[][] getBoardTiles() {
        return game.getBoard().getBoard();
    }

    public void startNewGame(int row, int column) {
        game.startNewGame(row, column);
        showGamePanel();
    }

    public void moveTile(int row, int column) {
        game.moveTile(row, column);
    }

    public void checkIfTilesInOrder() {
        if (game.tilesInOrder()) {
            JOptionPane.showMessageDialog(null,
                    "Congratulations! You solved the game (hope you didn't expect fireworks)", 
                    "Game solved", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void showStats() {
        JOptionPane.showMessageDialog(null, new StatsPanel(this), null, JOptionPane.PLAIN_MESSAGE);
    }

    public void addGameStats() {
        game.addGameStats(new GameStats(getBoardRows(), getBoardColumns(), getMoveCount(), game.tilesInOrder(), new Date()));
    }

    public void closeGame() {
        if (game.tilesInOrder()) {
            addGameStats();
            System.exit(0);
        }
        int dialogSelection = JOptionPane.showConfirmDialog(null, "Do you want to save your game?");
        if (dialogSelection == JOptionPane.YES_OPTION) {
            StorageManager.saveGame(game.getBoard(), game.getSelectedPlayer());
            System.exit(0);
        } else if (dialogSelection == JOptionPane.NO_OPTION) {
            addGameStats();
            System.exit(0);
        }
    }

    public void cheat() {
        game.cheat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SortinGame");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosingHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowClosingHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosingHandler
        for (Component component : contentPanel.getComponents()) {
            if (component instanceof GamePanel) {
                closeGame();
                return;
            }
        }
        System.exit(0);
    }//GEN-LAST:event_windowClosingHandler

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;




                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SortingGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortingGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortingGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortingGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SortingGameUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
