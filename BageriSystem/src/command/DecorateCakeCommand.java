package command;

import cake.Cake;

public class DecorateCakeCommand implements Command {
    private final Cake cake;

    public DecorateCakeCommand(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void execute() {
        cake.showDecorations();
    }
}