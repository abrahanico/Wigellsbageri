import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import observer.CEO;
import observer.OrderNotifier;
import observer.CEOView;

import java.util.ArrayList;
import java.util.List;

public class BakerySystem extends Application {
    private Stage primaryStage;
    private OrderNotifier notifier = OrderNotifier.getInstance();
    private CEO ceo = new CEO("Wigells");
    private CEOView ceoView = new CEOView();
    private Customer customer;
    private Label statusLabel = new Label("Beställ en tårta!");
    private TextArea historyTextArea = new TextArea();
    private List<String> selectedCakes = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        notifier.addObserver(ceo);
        notifier.addObserver(ceoView);
        showWelcomeScreen();
    }

    private void showWelcomeScreen() {
        VBox welcomeLayout = new VBox(10);
        Label welcomeLabel = new Label("Välkommen till Wigells Bageri!");
        Label nameLabel = new Label("Ange ditt namn:");
        TextField nameInput = new TextField();
        Button startButton = new Button("Fortsätt");

        startButton.setOnAction(e -> {
            String userName = nameInput.getText().trim();
            if (!userName.isEmpty()) {
                customer = new Customer(userName);
                showOrderScreen();
            } else {
                nameLabel.setText(" Ange ett namn för att fortsätta!");
            }
        });

        welcomeLayout.getChildren().addAll(welcomeLabel, nameLabel, nameInput, startButton);
        Scene welcomeScene = new Scene(welcomeLayout, 400, 300);
        primaryStage.setScene(welcomeScene);
        primaryStage.setTitle("Välkommen");
        primaryStage.show();
    }

    private void showOrderScreen() {
        VBox orderLayout = new VBox(10);
        Label orderLabel = new Label("Hej " + customer.getName() + "! Välj dina tårtor:");

        CheckBox princessCakeCheck = new CheckBox("Prinsesstårta");
        CheckBox operaCakeCheck = new CheckBox("Operatårta");
        CheckBox chocolateCakeCheck = new CheckBox("Chokladtårta");

        Button placeOrderButton = new Button("Beställ");
        Button backButton = new Button("Tillbaka");
        Button newOrderButton = new Button("Ny beställning");
        Button historyButton = new Button("Visa Orderhistorik");

        placeOrderButton.setOnAction(e -> {
            selectedCakes.clear();
            if (princessCakeCheck.isSelected()) selectedCakes.add("Prinsesstårta");
            if (operaCakeCheck.isSelected()) selectedCakes.add("Operatårta");
            if (chocolateCakeCheck.isSelected()) selectedCakes.add("Chokladtårta");

            if (!selectedCakes.isEmpty()) {
                placeOrder();
            } else {
                statusLabel.setText("Välj minst en tårta för att beställa!");
            }
        });

        backButton.setOnAction(e -> showWelcomeScreen());
        newOrderButton.setOnAction(e -> showOrderScreen());
        historyButton.setOnAction(e -> showOrderHistory());

        orderLayout.getChildren().addAll(orderLabel, princessCakeCheck, operaCakeCheck, chocolateCakeCheck,
                placeOrderButton, newOrderButton, backButton, historyButton, historyTextArea);

        Scene orderScene = new Scene(orderLayout, 400, 400);
        primaryStage.setScene(orderScene);
        primaryStage.setTitle("Beställ Tårta");
    }

    private void placeOrder() {
        for (String cakeType : selectedCakes) {
            customer.placeOrder(cakeType, notifier);
        }
        statusLabel.setText(" Beställning skickad!");
    }

    private void showOrderHistory() {
        historyTextArea.setText(String.join("\n", customer.getOrderHistory()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}