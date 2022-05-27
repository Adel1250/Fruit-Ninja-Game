package fruitninja;

import java.util.ArrayList;

public class Player {

    private static Player instance = null;
    private int Score;
    private int lives = 3;
    private String username;
    private int level;

    ArrayList<Observer> listOfobservers = new ArrayList<>();

    public void attach(Observer o) {
        listOfobservers.add(o);
    }

    public void notifyAllObservers() {
        for (Observer x : listOfobservers) {
            x.update();
        }
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
        notifyAllObservers();
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
        notifyAllObservers();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private Player() {

    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }
}
