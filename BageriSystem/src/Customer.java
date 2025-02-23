import cake.Cake;
import cake.CakeBuilder;
import command.*;
import observer.OrderNotifier;
import java.util.ArrayList;
import java.util.List;
import utils.IDGenerator;

public class Customer {
    private String id;
    private String name;
    private List<String> orderHistory = new ArrayList<>();

    public Customer(String name) {
        this.id = IDGenerator.generateShortId();
        this.name = name;
    }

    public void placeOrder(String cakeType, OrderNotifier notifier) {
        notifier.notifyObservers(" Order lagd: " + cakeType + " av " + name + " (ID: " + id + ")");

        Cake cake = new CakeBuilder(cakeType).build();

        notifier.notifyObservers(" Grunden till " + cake.getName() + " (ID: " + cake.getId() + ") är färdig!");

        Command decorate;
        switch (cakeType.toLowerCase()) {
            case "prinsesstårta":
                decorate = new DecoratePrincessCakeCommand(cake);
                break;
            case "operatårta":
                decorate = new DecorateOperaCakeCommand(cake);
                break;
            case "chokladtårta":
                decorate = new DecorateChocolateCakeCommand(cake);
                break;
            default:
                throw new IllegalArgumentException("Okänd tårttyp: " + cakeType);
        }

        decorate.execute();

        notifier.notifyObservers("Tårtan " + cake.getName() + " (ID: " + cake.getId() + ") är färdig för leverans!");
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
