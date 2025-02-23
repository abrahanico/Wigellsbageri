package command;

import cake.Cake;

public class DecorateChocolateCakeCommand implements Command {
    private final Cake cake;

    public DecorateChocolateCakeCommand(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void execute() {
        cake.addDecoration("Spackla tårtan med chokladsmörkräm");
        cake.addDecoration("Häll chokladganash på tårtan");
        cake.addDecoration("Garnera med hallon");

        cake.showDecorations();
    }
}