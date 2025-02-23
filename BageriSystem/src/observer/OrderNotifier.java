package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OrderNotifier {
    private static OrderNotifier instance;
    private final PropertyChangeSupport support;

    private OrderNotifier() {
        support = new PropertyChangeSupport(this);
    }

    public static synchronized OrderNotifier getInstance() {
        if (instance == null) {
            instance = new OrderNotifier();
        }
        return instance;
    }

    public void addObserver(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void notifyObservers(String message) {
        support.firePropertyChange("orderUpdate", null, message);
    }
}