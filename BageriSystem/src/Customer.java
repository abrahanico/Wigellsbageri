import cake.Cake;
import cake.CakeBuilder;
import command.Command;
import command.DecorateCakeCommand;
import observer.OrderNotifier;
import utils.IDGenerator;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String id;
    private final String name;
    private final List<String> orderHistory = new ArrayList<>();

    public Customer(String name) {
        this.id = IDGenerator.generateShortId();
        this.name = name;
    }

    public void placeOrder(String cakeType, OrderNotifier notifier) {
        notifier.notifyObservers(" Order lagd: " + cakeType + " av " + name + " (ID: " + id + ")");


        Cake cake = CakeBuilder.buildCake(cakeType);
        cake.showSteps();

        notifier.notifyObservers(" Grunden till " + cake.getName() + " (ID: " + cake.getId() + ") är färdig!");


        Command decorate = new DecorateCakeCommand(cake);
        decorate.execute();

        notifier.notifyObservers(" Tårtan " + cake.getName() + " (ID: " + cake.getId() + ") är färdig för leverans!");


        orderHistory.add(cake.getName());
    }

    public List<String> getOrderHistory() {
        return orderHistory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}