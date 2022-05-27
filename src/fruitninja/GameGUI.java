package fruitninja;

import jaco.mp3.player.MP3Player;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class GameGUI extends javax.swing.JFrame implements Observer {

    static int seconds = 0;
    static int minutes = 0;

    static boolean state = true;

    Thread t = new Thread() {
        @Override
        public void run() {
            for (;;) {
                if (state == true) {

                    try {
                        sleep(1000);
                        if (Player.getInstance().getScore() == 0) {
                            seconds = 0;
                            minutes = 0;
                            mp3player.play();
                        }
                        if (seconds > 60) {
                            seconds = 0;
                            minutes++;
                        }

                        if (minutes > 60) {
                            seconds = 0;
                            minutes = 0;
                        }
                        timeSecondsLabel.setText(":" + seconds);
                        seconds++;
                        timeMinutesLabel.setText("   " + minutes);
                    } catch (Exception e) {

                    }

                } else {
                    break;
                }
            }
        }
    };

    public GameGUI() {
        initComponents();
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        t.start();
        CustomCursor();
        Player.getInstance().attach(this);
        mp3player.play();
    }

    private static GameGUI instance = null;

    public static GameGUI getInstance() {
        if (instance == null) {
            instance = new GameGUI();
        }
        return instance;
    }

    public void close() {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }

    @Override
    public void update() {

        String s;
        String l;
        String hs;

        s = Integer.toString(Player.getInstance().getScore());
        l = Integer.toString(Player.getInstance().getLives());

        scoreLabel.setText(s);
        livesLabel.setText(l);

        if (Player.getInstance().getLives() == 0) {

            close();
            new GameOver().setVisible(true);

            mp3player.stop();

        }

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

                if (Player.getInstance().getScore() > listOfUsers.get(i).getScore()) {
                    try {
                        listOfUsers.get(i).setScore(Player.getInstance().getScore());
                        Users users = new Users();
                        users.setUsers(listOfUsers);
                        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
                        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        jaxbMarshaller.marshal(users, new File("src\\fruitninja\\users.xml"));
                    } catch (JAXBException ex) {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                hs = Integer.toString(listOfUsers.get(i).getScore());
                highScoreLabel.setText(hs);
            }
        }
    }

    public static final String SONG = "Mucize Doktor Champion.mp3";

    MP3Player mp3player = new MP3Player(new File(SONG));

    public void CustomCursor() {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image img = toolKit.getImage("");
        Point point = new Point(0, 0);
        Cursor cursor = toolKit.createCustomCursor(img, point, "Cursor");
        setCursor(cursor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gameFrame1 = new fruitninja.GamePanel();
        playMusic = new javax.swing.JButton();
        stopMusic = new javax.swing.JButton();
        Label = new javax.swing.JLabel();
        livesLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        highScoreLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        timeMinutesLabel = new javax.swing.JLabel();
        timeSecondsLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game");
        setResizable(false);
        getContentPane().setLayout(null);

        gameFrame1.setBackground(new java.awt.Color(102, 51, 0));
        gameFrame1.setForeground(new java.awt.Color(102, 51, 0));
        gameFrame1.setOpaque(false);

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

        Label.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 204, 102));
        Label.setText("Lives:");

        livesLabel.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        livesLabel.setForeground(new java.awt.Color(255, 204, 102));
        livesLabel.setText("3");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("Score:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Time:");

        highScoreLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        highScoreLabel.setForeground(new java.awt.Color(255, 204, 102));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 102));
        jLabel5.setText("High Score:");

        scoreLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 204, 102));

        timeMinutesLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        timeMinutesLabel.setForeground(new java.awt.Color(255, 204, 102));
        timeMinutesLabel.setText("00:");

        timeSecondsLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        timeSecondsLabel.setForeground(new java.awt.Color(255, 204, 102));
        timeSecondsLabel.setText("00");

        javax.swing.GroupLayout gameFrame1Layout = new javax.swing.GroupLayout(gameFrame1);
        gameFrame1.setLayout(gameFrame1Layout);
        gameFrame1Layout.setHorizontalGroup(
            gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameFrame1Layout.createSequentialGroup()
                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameFrame1Layout.createSequentialGroup()
                        .addGap(565, 565, 565)
                        .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameFrame1Layout.createSequentialGroup()
                                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(livesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(playMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(gameFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(65, 65, 65)
                                    .addComponent(timeMinutesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(stopMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(gameFrame1Layout.createSequentialGroup()
                        .addGap(728, 728, 728)
                        .addComponent(timeSecondsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        gameFrame1Layout.setVerticalGroup(
            gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameFrame1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(highScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label)
                    .addComponent(livesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(gameFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeMinutesLabel)
                        .addComponent(timeSecondsLabel)))
                .addGap(25, 25, 25)
                .addComponent(playMusic)
                .addGap(18, 18, 18)
                .addComponent(stopMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        getContentPane().add(gameFrame1);
        gameFrame1.setBounds(0, 0, 880, 480);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fruitninja/Background.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 940, 510);

        setSize(new java.awt.Dimension(783, 515));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stopMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopMusicActionPerformed
        mp3player.stop();
    }//GEN-LAST:event_stopMusicActionPerformed

    private void playMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playMusicActionPerformed
        mp3player.play();
    }//GEN-LAST:event_playMusicActionPerformed

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

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private fruitninja.GamePanel gameFrame1;
    private javax.swing.JLabel highScoreLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel livesLabel;
    private javax.swing.JButton playMusic;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton stopMusic;
    private javax.swing.JLabel timeMinutesLabel;
    private javax.swing.JLabel timeSecondsLabel;
    // End of variables declaration//GEN-END:variables

}
