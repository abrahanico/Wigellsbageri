package cake;

public class CakeBuilder {
    private Cake cake;

    public CakeBuilder(String type) {
        this.cake = CakeFactory.createCake(type);
    }

    public Cake build() {
        if (cake instanceof PrincessCake) {
            addBase()
                    .addFilling("vaniljkräm").addLayer()
                    .addFilling("vaniljkräm").addLayer();

        } else if (cake instanceof OperaCake) {
            addBase()
                    .addFilling("vaniljkräm").addLayer()
                    .addFilling("hallonsylt").addLayer();
        } else if (cake instanceof ChocolateCake) {
            addBase()
                    .addFilling("hallonmousse").addLayer()
                    .addFilling("hallonmousse").addLayer();
        }

        cake.showSteps();
        return cake;
    }
    public CakeBuilder addBase() {
        cake.addIngredient("Ta fram en tårtbotten");
        return this;
    }

    public CakeBuilder addFilling(String filling) {
        cake.addIngredient("Bred på ett lager " + filling);
        return this;
    }

    public CakeBuilder addLayer() {
        cake.addIngredient("Lägg på en tårtbotten");
        return this;
    }
}
