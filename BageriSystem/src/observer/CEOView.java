package observer;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEOView implements PropertyChangeListener {
    private final TextArea logArea;

    public CEOView() {
        Stage stage = new Stage();
        stage.setTitle("VD Panel - Wigells Bageri");

        logArea = new TextArea();
        logArea.setEditable(false);

        VBox layout = new VBox(10);
        layout.getChildren().add(logArea);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logArea.appendText(evt.getNewValue() + "\n");
    }
}