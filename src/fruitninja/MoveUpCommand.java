package fruitninja;

public class MoveUpCommand implements Command {

    GameObject gameobject;

    public MoveUpCommand(GameObject gameobject) {
        this.gameobject = gameobject;
    }

    @Override
    public void execute() {
        gameobject.MoveUp();
    }

}
