package fruitninja;

public class FactoryOfBombs implements AbstractFactory {

    private static FactoryOfBombs instance;

    private FactoryOfBombs() {

    }

    public static FactoryOfBombs getInstance() {

        if (instance == null) {
            instance = new FactoryOfBombs();
        }
        return instance;
    }

    @Override
    public GameObject getFruit(String obName) {
        return null;
    }

    @Override
    public GameObject getBomb(String obName) {

        switch (obName) {

            case "dangerousBomb":
                return new DangerousBomb();
            case "fatalBomb":
                return new FatalBomb();
            default:
                return null;
        }
    }
}
