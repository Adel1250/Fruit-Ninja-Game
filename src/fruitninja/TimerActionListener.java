package fruitninja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerActionListener implements ActionListener {

    GamePanel gp;

    public TimerActionListener(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<GameObject> gameobjects = gp.gameobjects;
        for (int i = 0; i < gameobjects.size(); i++) {
            GameObject go = gameobjects.get(i);
            if (go.isMovingUp()) {
                MoveUpCommand mv = new MoveUpCommand(go);
                mv.execute();
            } else {
                MoveDownCommand mv = new MoveDownCommand(go);
                mv.execute();
            }
        }
        boolean alloffscreen = true;
        for (int i = 0; i < gameobjects.size(); i++) {
            GameObject go = gameobjects.get(i);
            if (!go.hasMovedOffScreen()) {
                alloffscreen = false;
                break;
            }
            if (go.hasMovedOffScreen()) {
                if (!go.isSliced() && go.id() != 6 && go.id() != 7 && go.id() != 4 && go.id() != 5) {
                    Player.getInstance().setLives(Player.getInstance().getLives() - 1);
                }
            }

        }

        if (Player.getInstance().getLives() == 0) {
            gameobjects.clear();
        }

        if (alloffscreen) {
            gameobjects.clear();
            gp.generateObjects();
        }
        gp.repaint();
    }
}
