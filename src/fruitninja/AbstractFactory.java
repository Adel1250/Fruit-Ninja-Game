package fruitninja;

public interface AbstractFactory {

    public GameObject getFruit(String obName);

    public GameObject getBomb(String obName);
}
