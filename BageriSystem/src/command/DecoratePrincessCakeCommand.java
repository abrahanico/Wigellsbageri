package command;

import cake.Cake;

public class DecoratePrincessCakeCommand implements Command {
    private final Cake cake;

    public DecoratePrincessCakeCommand(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void execute() {
        cake.addDecoration("Fördela hårt vispad grädde på tårtan");
        cake.addDecoration("Lägg marsipanlocket på tårtan (grönt)");
        cake.addDecoration("Garnera med marsipanros");
        cake.addDecoration("Pudra över florsocker");

        cake.showDecorations();
    }
}