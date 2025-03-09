package cake;

public class CakeBuilder {
    public static Cake buildCake(String type) {
        return CakeFactory.createCake(type);
    }
}