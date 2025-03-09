package cake;

public class OperaCake extends Cake {
    public OperaCake() {
        super("Operatårta");

        buildBase();
        buildFilling();
        buildLayers();
        buildDecoration();
    }

    private void buildBase() {
        addIngredient("Ta fram en tårtbotten");
    }

    private void buildFilling() {
        addIngredient("Bred på ett lager vaniljkräm");
    }

    private void buildLayers() {
        addIngredient("Lägg på en tårtbotten");
        addIngredient("Bred på ett lager hallonsylt");
        addIngredient("Lägg på en tårtbotten");
    }

    private void buildDecoration() {
        addDecoration("Fördela hårt vispad grädde på tårtan");
        addDecoration("Lägg marsipanlocket på tårtan (rosa)");
        addDecoration("Garnera med marsipanros");
        addDecoration("Pudra över florsocker");
    }
}