package com.example.crapsgame.views;

import com.example.crapsgame.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InstructionsView extends Stage {
    public InstructionsView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("instruction-view.fxml")
        );
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.setTitle("Craps Game - Instructions");
        this.setScene(scene);
    }

    public static InstructionsView getInstance() throws IOException {
        if (InstructionsView.InstructionsViewHolder.INSTANCE == null) {
            InstructionsView.InstructionsViewHolder.INSTANCE = new InstructionsView();
            return InstructionsView.InstructionsViewHolder.INSTANCE;
        } else {
            return InstructionsView.InstructionsViewHolder.INSTANCE;
        }
    }

    private static class InstructionsViewHolder {
        private static InstructionsView INSTANCE;
    }

}