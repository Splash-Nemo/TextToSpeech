module com.example.texttospeech {
    requires javafx.controls;
    requires javafx.fxml;
    requires freetts;

    opens com.example.texttospeech to javafx.fxml;
    exports com.example.texttospeech;
}