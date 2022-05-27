package fruitninja;

public class MoveDownCommand implements Command {

    GameObject gameobject;

    public MoveDownCommand(GameObject gameobject) {
        this.gameobject = gameobject;
    }

    @Override
    public void execute() {
        gameobject.MoveDown();
    }

}
