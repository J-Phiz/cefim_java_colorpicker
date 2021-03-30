package fr.jpsave.colorpicker.controller;

import fr.jpsave.colorpicker.model.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorPickerController implements Initializable {

    private Color color;

    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;
    @FXML
    private TextField textFieldRed;
    @FXML
    private TextField textFieldGreen;
    @FXML
    private TextField textFieldBlue;
    @FXML
    private TextField textFieldHex;
    @FXML
    private Pane paneColor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set sliders properties
        sliderRed.setMin(0);
        sliderRed.setMax(255);
        sliderRed.setBlockIncrement(10);
        sliderGreen.setMin(0);
        sliderGreen.setMax(255);
        sliderGreen.setBlockIncrement(10);
        sliderBlue.setMin(0);
        sliderBlue.setMax(255);
        sliderBlue.setBlockIncrement(10);

        // Initialize all components with black color
        sliderRed.setValue(0);
        textFieldRed.setText("0");

        sliderGreen.setValue(0);
        textFieldGreen.setText("0");

        sliderBlue.setValue(0);
        textFieldBlue.setText("0");

        textFieldHex.setText("#000000");
        paneColor.setStyle("-fx-background-color: #000000");

        // Initialize Model with black Color
        color = new Color("#000000");
    }


}
