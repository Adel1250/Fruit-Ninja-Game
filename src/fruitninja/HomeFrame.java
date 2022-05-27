package fruitninja;

import static fruitninja.HomeFrame.SONG;
import jaco.mp3.player.MP3Player;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public final class HomeFrame extends javax.swing.JFrame {

    public HomeFrame() {
        initComponents();
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        mp3player.play();
        CustomCursor();
    }

    private static HomeFrame instance = null;

    public static HomeFrame getInstance() {
        if (instance == null) {
            instance = new HomeFrame();
        }
        
        return instance;
    }

    public static final String SONG = "Mucize Doktor Champion.mp3";

    MP3Player mp3player = new MP3Player(new File(SONG));

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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ClassicMode = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CreateAccount = new javax.swing.JButton();
        playMusic = new javax.swing.JButton();
        stopMusic = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fruit Ninja");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("A");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 0, 30, 70);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("R");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 10, 30, 50);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("F");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(14, 10, 30, 50);

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("U");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 0, 30, 70);

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("I");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(74, 0, 20, 70);

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 51));
        jLabel8.setText("T");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 0, 30, 70);

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 51));
        jLabel9.setText("N");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(120, 0, 30, 70);

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("I");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(144, 0, 20, 70);

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("N");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(150, 0, 30, 70);

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 0));
        jLabel13.setText("J");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(170, 0, 30, 70);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Welcome ☺");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 60, 190, 30);

        ClassicMode.setBackground(new java.awt.Color(255, 204, 102));
        ClassicMode.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ClassicMode.setForeground(new java.awt.Color(51, 0, 0));
        ClassicMode.setText("Start !");
        ClassicMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassicModeActionPerformed(evt);
            }
        });
        ClassicMode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ClassicModeKeyPressed(evt);
            }
        });
        getContentPane().add(ClassicMode);
        ClassicMode.setBounds(20, 180, 130, 31);

        Quit.setBackground(new java.awt.Color(255, 204, 102));
        Quit.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Quit.setForeground(new java.awt.Color(51, 0, 0));
        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        Quit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QuitKeyPressed(evt);
            }
        });
        getContentPane().add(Quit);
        Quit.setBounds(410, 240, 70, 40);

        timeLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(51, 0, 0));
        getContentPane().add(timeLabel);
        timeLabel.setBounds(399, 82, 200, 0);

        dateLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(51, 0, 0));
        getContentPane().add(dateLabel);
        dateLabel.setBounds(100, 80, 210, 0);

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 102));
        jLabel14.setText("Didn't Register ?");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 250, 180, 18);

        CreateAccount.setBackground(new java.awt.Color(255, 204, 102));
        CreateAccount.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateAccount.setForeground(new java.awt.Color(51, 0, 0));
        CreateAccount.setText("Create Account");
        CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountActionPerformed(evt);
            }
        });
        CreateAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CreateAccountKeyPressed(evt);
            }
        });
        getContentPane().add(CreateAccount);
        CreateAccount.setBounds(150, 240, 170, 40);

        playMusic.setBackground(new java.awt.Color(255, 204, 102));
        playMusic.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        playMusic.setForeground(new java.awt.Color(51, 0, 0));
        playMusic.setText("♫");
        playMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playMusicActionPerformed(evt);
            }
        });
        playMusic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playMusicKeyPressed(evt);
            }
        });
        getContentPane().add(playMusic);
        playMusic.setBounds(410, 20, 70, 45);

        stopMusic.setBackground(new java.awt.Color(255, 204, 102));
        stopMusic.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        stopMusic.setForeground(new java.awt.Color(51, 0, 0));
        stopMusic.setText("Mute");
        stopMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopMusicActionPerformed(evt);
            }
        });
        stopMusic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stopMusicKeyPressed(evt);
            }
        });
        getContentPane().add(stopMusic);
        stopMusic.setBounds(410, 70, 70, 27);

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 102));
        jLabel16.setText("Enter username");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 120, 120, 21);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 120, 180, 30);

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 0));
        jButton1.setText("Score Board");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 180, 127, 31);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fruitninja/Background.png"))); // NOI18N
        jLabel15.setText("jLabel15");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 1590, 400);

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(120, 120, 0, 0);

        setSize(new java.awt.Dimension(504, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClassicModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassicModeActionPerformed

        int f = 0;

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

        List<User> users = listOfUsers;

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUsername().equals(jTextField1.getText())) {

                f = 1;
                Player.getInstance().setLives(3);
                Player.getInstance().setScore(0);
                Player.getInstance().setUsername(users.get(i).getUsername());

                dispose();
                GameGUI.getInstance().setVisible(true);

                mp3player.stop();
            }
        }

        if (f == 0) {
            JOptionPane.showMessageDialog(this, "Invalid data.");
        }


    }//GEN-LAST:event_ClassicModeActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to leave ?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            close();
        }


    }//GEN-LAST:event_QuitActionPerformed

    private void CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to create an account", "Confirm", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            {
                new CreateAccountFrame().setVisible(true);
                mp3player.stop();

            }
        }
    }//GEN-LAST:event_CreateAccountActionPerformed

    private void playMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playMusicActionPerformed
        mp3player.play();
    }//GEN-LAST:event_playMusicActionPerformed

    private void stopMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopMusicActionPerformed
        mp3player.stop();
    }//GEN-LAST:event_stopMusicActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            if (jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "You Must Enter Data", "Confrm", JOptionPane.OK_OPTION);
            } else {

                int f = 0;
                ArrayList<User> listOfUsers = new ArrayList<>();

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

                List<User> users = listOfUsers;

                for (int i = 0; i < users.size(); i++) {

                    if (users.get(i).getUsername().equals(jTextField1.getText())) {

                        f = 1;
                        Player.getInstance().setLives(3);
                        Player.getInstance().setScore(0);
                        Player.getInstance().setUsername(users.get(i).getUsername());
                        new GameGUI().setVisible(true);
                        dispose();
                        mp3player.stop();
                    }
                }

                if (f == 0) {
                    JOptionPane.showMessageDialog(this, "Invalid data.");
                }
            }
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void playMusicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playMusicKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            mp3player.play();
        }
    }//GEN-LAST:event_playMusicKeyPressed

    private void stopMusicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stopMusicKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            mp3player.stop();
        }
    }//GEN-LAST:event_stopMusicKeyPressed

    private void CreateAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CreateAccountKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to create an account", "Confirm", JOptionPane.OK_CANCEL_OPTION);

            if (response == JOptionPane.OK_OPTION) {
                {
                    new CreateAccountFrame().setVisible(true);

                }
            }
        }
    }//GEN-LAST:event_CreateAccountKeyPressed

    private void QuitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuitKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to leave ?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

            if (response == JOptionPane.OK_OPTION) {
                close();
            }
        }
    }//GEN-LAST:event_QuitKeyPressed

    private void ClassicModeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClassicModeKeyPressed

        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            if (jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "You Must Enter Data", "Confrm", JOptionPane.OK_OPTION);
            } else {
                int f = 0;
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

                List<User> users = listOfUsers;

                for (int i = 0; i < users.size(); i++) {

                    if (users.get(i).getUsername().equals(jTextField1.getText())) {

                        f = 1;
                        Player.getInstance().setLives(3);
                        Player.getInstance().setScore(0);
                        Player.getInstance().setUsername(users.get(i).getUsername());
                        GameGUI.getInstance().setVisible(true);
                        dispose();
                        mp3player.stop();
                    }
                }

                if (f == 0) {
                    JOptionPane.showMessageDialog(this, "Invalid data.");
                }
            }
        }

    }//GEN-LAST:event_ClassicModeKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new HighScores().setVisible(true);
        dispose();
        mp3player.stop();
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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClassicMode;
    private javax.swing.JButton CreateAccount;
    private javax.swing.JButton Quit;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton playMusic;
    private javax.swing.JButton stopMusic;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }

}
