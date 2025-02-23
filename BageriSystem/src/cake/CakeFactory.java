package cake;

public class CakeFactory {
    public static Cake createCake(String type) {
        switch (type.toLowerCase()) {
            case "prinsesstårta":
                return new PrincessCake();
            case "operatårta":
                return new OperaCake();
            case "chokladtårta":
                return new ChocolateCake();
            default:
                throw new IllegalArgumentException("Ogiltig tårttyp: " + type);
        }
    }
}