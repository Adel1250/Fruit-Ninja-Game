package fruitninja;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class CreateAccountFrame extends javax.swing.JFrame {

    public CreateAccountFrame() {
        initComponents();
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        CustomCursor();
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

        createAccount = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNameTextAccount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Account");
        setResizable(false);
        getContentPane().setLayout(null);

        createAccount.setBackground(new java.awt.Color(255, 204, 102));
        createAccount.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        createAccount.setForeground(new java.awt.Color(51, 0, 0));
        createAccount.setText("Create");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        getContentPane().add(createAccount);
        createAccount.setBounds(10, 130, 100, 37);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("Enter your name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 80, 150, 21);

        userNameTextAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextAccountActionPerformed(evt);
            }
        });
        userNameTextAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameTextAccountKeyPressed(evt);
            }
        });
        getContentPane().add(userNameTextAccount);
        userNameTextAccount.setBounds(170, 70, 150, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Registration");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 340, 68);

        exit.setBackground(new java.awt.Color(255, 204, 102));
        exit.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(51, 0, 0));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        exit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exitKeyPressed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(290, 130, 100, 37);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fruitninja/Background.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 440, 270);

        setSize(new java.awt.Dimension(411, 208));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTextAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextAccountActionPerformed


    }//GEN-LAST:event_userNameTextAccountActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Do you want to save your account?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

        if (response == JOptionPane.YES_OPTION) {

            try {

                String usName = userNameTextAccount.getText();

                User user = new User();

                user.setUsername(usName);
                user.setScore(0);

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
                    Logger.getLogger(CreateAccountFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                listOfUsers.add(user);
                Users users = new Users();
                users.setUsers(listOfUsers);

                JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(users, new File("src\\fruitninja\\users.xml"));

            } catch (JAXBException ex) {
                Logger.getLogger(CreateAccountFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            userNameTextAccount.setText("");

        } else if (response == JOptionPane.CANCEL_OPTION) {
            dispose();
        }

    }//GEN-LAST:event_createAccountActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Return to home page?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            HomeFrame.getInstance().setVisible(true);
            dispose();
        }


    }//GEN-LAST:event_exitActionPerformed

    private void userNameTextAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextAccountKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_userNameTextAccountKeyPressed

    private void exitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            int response = JOptionPane.showConfirmDialog(this, "Return to home page?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

            if (response == JOptionPane.OK_OPTION) {
                dispose();
            }
        }
    }//GEN-LAST:event_exitKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateAccountFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccount;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField userNameTextAccount;
    // End of variables declaration//GEN-END:variables
}
