package fruitninja;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public interface GameObject {

    public void slice();

    public boolean hasMovedOffScreen();

    public void setMovedOff(boolean moved);

    public boolean isMovingUp();

    public boolean isSliced();

    public void setMovingUp(boolean movingUp);

    public int getXLocation();

    public void setXLocation(int x);

    public int getYLocation();

    public int getInitialVelocity();

    public int getFallingVelocity();

    public void setYLocation(int y);

    public int id();

    public ArrayList<ImageIcon> getBufferedImage();

    public void MoveUp();

    public void MoveDown();

}
