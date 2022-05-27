package fruitninja;

public class FactoryOfFruits implements AbstractFactory {

    private static FactoryOfFruits instance;

    private FactoryOfFruits() {

    }

    public static FactoryOfFruits getInstance() {

        if (instance == null) {
            instance = new FactoryOfFruits();
        }
        return instance;
    }

    @Override
    public GameObject getBomb(String obName) {
        return null;
    }

    @Override
    public GameObject getFruit(String obName) {

        switch (obName) {

            case "apple":
                return new Apple();
            case "orange":
                return new Orange();
            case "watermelon":
                return new Watermelon();
            case "specialFruit1":
                return new SpecialFruit1();
            case "specialFruit2":
                return new SpecialFruit2();
            default:
                return null;
        }
    }
}
