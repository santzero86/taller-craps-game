package com.example.crapsgame;

import com.example.crapsgame.views.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WelcomeView welcomeView = WelcomeView.getInstance();
        welcomeView.show();

        /*
        Button button = new Button("Event Test");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello, I am a Button Event");
                System.out.println("Type:" + actionEvent.getEventType());
                System.out.println("Source:" + actionEvent.getSource());
                System.out.println("Target:" + actionEvent.getTarget());
            }
        });

        Label label = new Label("Hello FOPE");
        label.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Hello, I am a Label Event");
                System.out.println("Type:" + mouseEvent.getEventType());
                System.out.println("Source:" + mouseEvent.getSource());
                System.out.println("Target:" + mouseEvent.getTarget());
            }
        }));

        VBox vbox = new VBox();
        vbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Hello, I am a VBox Event");
                System.out.println("Type:" + mouseEvent.getEventType());
                System.out.println("Source:" + mouseEvent.getSource());
                System.out.println("Target:" + mouseEvent.getTarget());
            }
        });

        vbox.getChildren().add(label);
        vbox.getChildren().add(button);
        Scene scene = new Scene(vbox, 200, 200);
        stage.setScene(scene);
        stage.show();
        */
    }

    public static void main(String[] args) {
        launch();
    }
}