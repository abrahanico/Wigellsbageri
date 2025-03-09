package command;

import cake.Cake;

public class DecorateCakeCommand implements Command {
    private final Cake cake;

    public DecorateCakeCommand(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void execute() {
        System.out.println("Dekorerar " + cake.getName() + " (ID: " + cake.getId() + "):");
        for (String step : cake.getDecorations()) {
            System.out.println("* " + step);
        }
        System.out.println(cake.getName() + " är färdig!");
    }
}