package fruitninja;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BladeMouseMotionListener implements MouseMotionListener {

    GamePanel g;

    public BladeMouseMotionListener(GamePanel g) {
        this.g = g;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        for (GameObject ob : g.gameobjects) {
            if (x >= ob.getXLocation() && x <= ob.getXLocation() + ob.getBufferedImage().get(0).getIconWidth()) {
                if (y >= ob.getYLocation() && y <= ob.getYLocation() + ob.getBufferedImage().get(0).getIconHeight()) {

                    if (!ob.isSliced()) {

                        ob.setMovingUp(false);
                        ob.slice();

                        int sc = Player.getInstance().getScore();
                        int li = Player.getInstance().getLives();

                        if (ob.id() == 1) {
                            Player.getInstance().setScore(sc + 20);
                        } else if (ob.id() == 2) {
                            Player.getInstance().setScore(sc + 20);
                        } else if (ob.id() == 3) {
                            Player.getInstance().setScore(sc + 20);
                        } else if (ob.id() == 4) {
                            Player.getInstance().setScore(sc + 100);
                        } else if (ob.id() == 5) {
                            Player.getInstance().setScore(sc + 70);
                            if (Player.getInstance().getLives() == 1 || Player.getInstance().getLives() == 2) {
                                Player.getInstance().setLives(li + 1);
                            }
                        } else if (ob.id() == 6) {
                            Player.getInstance().setLives(li - 1);
                        } else if (ob.id() == 7) {
                            Player.getInstance().setLives(0);

                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}
