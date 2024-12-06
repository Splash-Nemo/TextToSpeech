package com.example.texttospeech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class TextToSpeechGUI extends Application {

    private static final int APP_WIDTH= 375;
    private static final int APP_HEIGHT= 475;

    private TextArea textArea;
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = createScene();

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(
                "style.css"
        )).toExternalForm());

        stage.setTitle("Text To Speech App");
        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene(){
        VBox box= new VBox();
        box.getStyleClass().add("body");

        Label textToSpeechLabel= new Label("Text-To-Speech");

        textToSpeechLabel.getStyleClass().add("text-to-speech-label");

        textToSpeechLabel.setMaxWidth(Double.MAX_VALUE);
        textToSpeechLabel.setAlignment(Pos.CENTER);

        textArea= new TextArea();
        textArea.setWrapText(true);
        textArea.getStyleClass().add("text-area");

        StackPane textAreaPane= new StackPane();

        textAreaPane.setPadding(new Insets(0, 15, 0, 15));
        textAreaPane.getChildren().add(textArea);

        box.getChildren().add(textToSpeechLabel);
        box.getChildren().add(textAreaPane);

        GridPane settingsPane= createSettingGridPane();

        box.getChildren().add(settingsPane);

        return new Scene(box, APP_WIDTH, APP_HEIGHT);
    }

    private static GridPane createSettingGridPane(){
        GridPane gridPane= new GridPane();
        Label voicelabel= new Label("Voice");
        Label rateLabel= new Label("Rate");
        Label volumeLabel= new Label("Volume");

        gridPane.add(voicelabel, 0, 0);
        gridPane.add(rateLabel, 1, 0);
        gridPane.add(volumeLabel, 2, 0);

        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}