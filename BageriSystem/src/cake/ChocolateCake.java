package cake;

public class ChocolateCake extends Cake {
    public ChocolateCake() {
        super("Chokladtårta");

        buildBase();
        buildFilling();
        buildLayers();
        buildDecoration();
    }

    private void buildBase() {
        addIngredient("Ta fram en chokladtårtbotten");
    }

    private void buildFilling() {
        addIngredient("Bred på ett lager hallonmousse");
    }

    private void buildLayers() {
        addIngredient("Lägg på en chokladtårtbotten");
        addIngredient("Bred på ett lager hallonmousse");
        addIngredient("Lägg på en chokladtårtbotten");
    }

    private void buildDecoration() {
        addDecoration("Spackla tårtan med chokladsmörkräm");
        addDecoration("Häll chokladganash på tårtan");
        addDecoration("Garnera med hallon");
    }
}