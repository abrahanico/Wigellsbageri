package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {
    private final String name;

    public CEO(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("VD " + name + " notifierad: " + evt.getNewValue());
    }
}