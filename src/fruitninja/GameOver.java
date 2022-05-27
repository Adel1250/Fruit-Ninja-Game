package fruitninja;

import jaco.mp3.player.MP3Player;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public final class GameOver extends javax.swing.JFrame {

    public static final String SONG = "CoffinDanceFRNJA.mp3";
    MP3Player mp3player = new MP3Player(new File(SONG));

    public GameOver() {
        
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

        for (int i = 0; i < listOfUsers.size(); i++) {
            if (listOfUsers.get(i).getUsername().equals(Player.getInstance().getUsername())) {
                highScoreLabelGameOver.setText("" + listOfUsers.get(i).getScore());
                
                break;
            }
        }
        if (highScoreLabelGameOver.getText().equals(Integer.toString(Player.getInstance().getScore()))) {
            jLabel5.setText("NEW !");
        } else {
            jLabel5.setText("KEEP IT UP !");
        }
        scoreLabelGameOver.setText("" + Player.getInstance().getScore());
        CustomCursor();

    }

    public void close() {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        scoreLabelGameOver = new javax.swing.JLabel();
        highScoreLabelGameOver = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Home = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GAME OVER");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Game Over\n");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(83, 6, 324, 66);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("High Score");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(174, 90, 160, 35);

        scoreLabelGameOver.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        scoreLabelGameOver.setForeground(new java.awt.Color(255, 204, 102));
        scoreLabelGameOver.setText("       0");
        getContentPane().add(scoreLabelGameOver);
        scoreLabelGameOver.setBounds(280, 200, 120, 40);

        highScoreLabelGameOver.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        highScoreLabelGameOver.setForeground(new java.awt.Color(255, 204, 102));
        highScoreLabelGameOver.setText("     0");
        getContentPane().add(highScoreLabelGameOver);
        highScoreLabelGameOver.setBounds(220, 140, 100, 26);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 102));
        jLabel6.setText("Score");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 200, 100, 35);

        Home.setBackground(new java.awt.Color(255, 204, 102));
        Home.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Home.setForeground(new java.awt.Color(255, 0, 0));
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        getContentPane().add(Home);
        Home.setBounds(400, 270, 100, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 100, 0, 0);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 100, 120, 21);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fruitninja/Background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 370);

        setSize(new java.awt.Dimension(530, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Return to home page?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            close();
            mp3player.stop();
            HomeFrame.getInstance().setVisible(true);

        }

    }//GEN-LAST:event_HomeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JLabel highScoreLabelGameOver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel scoreLabelGameOver;
    // End of variables declaration//GEN-END:variables

}
