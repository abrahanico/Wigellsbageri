package cake;

import java.util.ArrayList;
import java.util.List;
import utils.IDGenerator;

public class Cake {
    private final String id;
    private final String name;
    private final List<String> ingredients = new ArrayList<>();
    private final List<String> decorations = new ArrayList<>();

    public Cake(String name) {
        this.id = IDGenerator.generateShortId();
        this.name = name;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void addDecoration(String decoration) {
        decorations.add(decoration);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public List<String> getDecorations() {
        return new ArrayList<>(decorations);
    }

    public void showSteps() {
        System.out.println("Bygger grund för " + name + " (ID: " + id + "):");
        for (String step : ingredients) {
            System.out.println("" + step);
        }
    }

    public void showDecorations() {
        System.out.println("Dekorerar " + name + " (ID: " + id + "):");
        for (String step : decorations) {
            System.out.println("*" + step);
        }
    }
}