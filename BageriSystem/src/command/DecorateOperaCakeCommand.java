package command;

import cake.Cake;

public class DecorateOperaCakeCommand implements Command {
    private final Cake cake;

    public DecorateOperaCakeCommand(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void execute() {
        cake.addDecoration("Fördela hårt vispad grädde på tårtan");
        cake.addDecoration("Lägg marsipanlocket på tårtan (rosa)");
        cake.addDecoration("Garnera med marsipanros");
        cake.addDecoration("Pudra över florsocker");
    }
}