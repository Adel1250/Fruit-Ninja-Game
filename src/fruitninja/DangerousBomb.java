package fruitninja;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DangerousBomb implements GameObject {

    boolean movingUp = true;
    boolean movedoffScreen = false;

    boolean sliced = false;
    int x, y;

    @Override
    public boolean isMovingUp() {
        return movingUp;
    }

    @Override
    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    @Override
    public void slice() {
        sliced = true;
    }

    @Override
    public int getXLocation() {
        return x;
    }

    @Override
    public void setXLocation(int x) {
        this.x = x;
    }

    @Override
    public int getYLocation() {
        return y;
    }

    @Override
    public void setYLocation(int y) {
        this.y = y;
    }

    @Override
    public ArrayList<ImageIcon> getBufferedImage() {
        ArrayList<ImageIcon> arrImages = new ArrayList<ImageIcon>();
        ImageIcon i1 = new ImageIcon("GameImages\\DangerousBomb.png");
        ImageIcon i2 = new ImageIcon("GameImages\\exp.png");
        arrImages.add(i1);
        arrImages.add(i2);
        return arrImages;
    }

    @Override
    public int getInitialVelocity() {
        return 17;
    }

    @Override
    public int getFallingVelocity() {
        return 27;
    }

    @Override
    public boolean isSliced() {
        return sliced;
    }

    @Override
    public boolean hasMovedOffScreen() {
        return movedoffScreen;
    }

    @Override
    public void setMovedOff(boolean moved) {
        this.movedoffScreen = moved;
    }

    @Override
    public int id() {
        return 6;
    }

    @Override
    public void MoveUp() {
        int newy = y - getInitialVelocity();
        y = newy;
        setXLocation(getXLocation() - 5);
        if (newy < 30) {
            setXLocation(getXLocation() - 5);
        }
        if (newy < 20) {

            setXLocation(getXLocation() - 5);
            setMovingUp(false);

        }
    }

    @Override
    public void MoveDown() {
        int newy = y + getFallingVelocity();
        setYLocation(newy);
        setXLocation(getXLocation() - 5);
        if (newy > 800) {
            setMovedOff(true);
        }
    }

}
