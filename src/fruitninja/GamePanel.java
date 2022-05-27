package fruitninja;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.Timer;

public final class GamePanel extends JPanel {

    private final MouseTrail mouseTrail = new MouseTrail(20);

    ArrayList<GameObject> gameobjects = new ArrayList<>();

    Point pointStart = null;
    Point pointEnd = null;

    FactoryOfFruits fr = FactoryOfFruits.getInstance();
    FactoryOfBombs fb = FactoryOfBombs.getInstance();

    Timer t;

    public GamePanel() {

        TimerActionListener tl = new TimerActionListener(this);

        t = new Timer(40, tl);
        generateObjects();
        t.start();

        BladeMouseMotionListener mouse1 = new BladeMouseMotionListener(this);
        addMouseMotionListener(mouse1);

        Mouse mouse2 = new Mouse();
        addMouseListener(mouse2);
        addMouseMotionListener(mouse2);

        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                update1();
                repaint();

            }
        }, 100, 1000 / 60);
    }

    public void update1() {
        if (Mouse.pressed) {
            mouseTrail.addTrail(Mouse.x, Mouse.y);
        } else {
            mouseTrail.standBy();
        }
    }

    public void generateObjects() {
        int noofshapes;
        Random r = new Random();
        noofshapes = r.nextInt(4) + 1;
        int xloc = 270;
        int yloc = 500;

        for (int i = 0; i < noofshapes; i++) {
            GameObject g = generateRandomObject();
            g.setXLocation(xloc);
            g.setYLocation(yloc);
            gameobjects.add(g);
            xloc += 80;
        }
    }

    public GameObject generateRandomObject() {
        Random r = new Random();
        int x = r.nextInt(7);
        if (x == 0) {
            return fr.getFruit("apple");
        } else if (x == 1) {
            return fr.getFruit("orange");
        } else if (x == 2) {
            return fr.getFruit("watermelon");
        } else if (x == 3) {
            return fr.getFruit("specialFruit1");
        } else if (x == 4) {
            return fr.getFruit("specialFruit2");
        } else if (x == 5) {
            return fb.getBomb("dangerousBomb");
        } else {
            return fb.getBomb("fatalBomb");
        }
    }

    public void draw(Graphics2D g) {
        mouseTrail.draw(g);
    }

    @Override
    protected void paintComponent(Graphics gr) {

        super.paintComponent(gr);
        Graphics2D g2d = (Graphics2D) gr;
        draw(g2d);

        for (int i = 0; i < gameobjects.size(); i++) {
            GameObject go = gameobjects.get(i);
            if (!go.isSliced()) {
                gr.drawImage(go.getBufferedImage().get(0).getImage(), go.getXLocation(), go.getYLocation(), this);
            } else {
                if (go.id() == 6 || go.id() == 7) {
                    gr.drawImage(go.getBufferedImage().get(1).getImage(), go.getXLocation(), go.getYLocation(), this);
                } else {
                    gr.drawImage(go.getBufferedImage().get(1).getImage(), go.getXLocation(), go.getYLocation() - 80, this);
                    gr.drawImage(go.getBufferedImage().get(2).getImage(), go.getXLocation() + 80, go.getYLocation(), this);
                }
            }
        }
    }
}
