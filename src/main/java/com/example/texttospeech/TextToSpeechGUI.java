package com.example.texttospeech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
    private static ComboBox<String> voices, rates, volumes;

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
        gridPane.setHgap(30);
        gridPane.setPadding(new Insets(10, 0, 0, 0));


        Label voicelabel= new Label("Voice");
        Label rateLabel= new Label("Rate");
        Label volumeLabel= new Label("Volume");

        voicelabel.getStyleClass().add("setting-label");
        rateLabel.getStyleClass().add("setting-label");
        volumeLabel.getStyleClass().add("setting-label");

        gridPane.add(voicelabel, 0, 0);
        gridPane.add(rateLabel, 1, 0);
        gridPane.add(volumeLabel, 2, 0);

        gridPane.setAlignment(Pos.CENTER);

        GridPane.setHalignment(voicelabel, HPos.CENTER);
        GridPane.setHalignment(rateLabel, HPos.CENTER);
        GridPane.setHalignment(volumeLabel, HPos.CENTER);

        voices= new ComboBox<>();
        voices.getStyleClass().add("setting-combo-box");
        rates= new ComboBox<>();
        rates.getStyleClass().add("setting-combo-box");
        volumes= new ComboBox<>();
        volumes.getStyleClass().add("setting-combo-box");

        gridPane.add(voices, 0, 1);
        gridPane.add(rates, 1, 1);
        gridPane.add(volumes, 2, 1);

        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}