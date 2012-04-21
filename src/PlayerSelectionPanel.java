
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.ListModel;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Valeria
 */
public class PlayerSelectionPanel extends javax.swing.JPanel {

    private SortingGameUI sortingGameUI;

    /**
     * Creates new form PlayerSelectionPanel
     */
    public PlayerSelectionPanel(SortingGameUI sortingGameUI) {
        this.sortingGameUI = sortingGameUI;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        selectButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        newPlayerButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setPreferredSize(new java.awt.Dimension(500, 375));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel1.setText("Select player");

        selectButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        selectButton.setText("Select player");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        deleteButton.setText("Delete player");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        newPlayerButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        newPlayerButton.setText("New player");
        newPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlayerButtonActionPerformed(evt);
            }
        });

        playerList.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        playerList.setModel(getPlayerListModel());
        playerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(playerList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectButton)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newPlayerButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(newPlayerButton)
                    .addComponent(selectButton))
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        sortingGameUI.selectPlayer((Player) playerList.getSelectedValue());
    }//GEN-LAST:event_selectButtonActionPerformed

    private void newPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlayerButtonActionPerformed
        sortingGameUI.selectNewPlayer();
    }//GEN-LAST:event_newPlayerButtonActionPerformed

    private ListModel getPlayerListModel() {
        DefaultListModel model = new DefaultListModel();
        ArrayList<Player> listOfPlayers = sortingGameUI.getPlayers();
        for (Player player : listOfPlayers) {
            model.addElement(player);
        }
        return model;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton newPlayerButton;
    private javax.swing.JList playerList;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
