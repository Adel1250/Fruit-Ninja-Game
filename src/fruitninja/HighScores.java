package fruitninja;

import jaco.mp3.player.MP3Player;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public final class HighScores extends javax.swing.JFrame {

    public static final String SONG = "TossACoin.mp3";
    MP3Player mp3player = new MP3Player(new File(SONG));

    public HighScores() {

        initComponents();
        CustomCursor();

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        mp3player.play();

        ArrayList<User> listOfUsers = new ArrayList<User>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Users uss = (Users) jaxbUnmarshaller.unmarshal(new File("src\\fruitninja\\users.xml"));

            for (Iterator<User> it = uss.getUsers().iterator(); it.hasNext();) {
                User us = it.next();
                listOfUsers.add(us);
            }

        } catch (JAXBException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.sort(listOfUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {

                int nc = Integer.compare(o2.getScore(), o1.getScore());

                return nc;

            }
        });

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[2];
        for (int i = 0; i < listOfUsers.size(); i++) {
            rowData[0] = listOfUsers.get(i).getUsername();
            rowData[1] = listOfUsers.get(i).getScore();
            model.addRow(rowData);
        }
    }

    public void CustomCursor() {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image img = toolKit.getImage("cursor-icon-transparent-68.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolKit.createCustomCursor(img, point, "Cursor");
        setCursor(cursor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Score Board");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("Score Board");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 170, 35);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Score"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 350, 100);

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 230, 80, 31);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fruitninja/Background.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-8, -6, 1390, 310);

        setSize(new java.awt.Dimension(408, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Return to home page?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            dispose();
            HomeFrame.getInstance().setVisible(true);
            mp3player.stop();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HighScores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
