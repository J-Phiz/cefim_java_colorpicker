package fr.jpsave.colorpicker.controller;

import fr.jpsave.colorpicker.model.Color;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
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

        // Add listener on each slider
        sliderRed.valueProperty().addListener((ov, old_val, new_val) -> {
            color.setRed((int) sliderRed.valueProperty().get());
            textFieldRed.setText(Integer.toString(color.getRed()));
            textFieldHex.setText(color.getRgbCode());
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });
        sliderGreen.valueProperty().addListener((ov, old_val, new_val) -> {
            color.setGreen((int) sliderGreen.valueProperty().get());
            textFieldGreen.setText(Integer.toString(color.getGreen()));
            textFieldHex.setText(color.getRgbCode());
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });
        sliderBlue.valueProperty().addListener((ov, old_val, new_val) -> {
            color.setBlue((int) sliderBlue.valueProperty().get());
            textFieldBlue.setText(Integer.toString(color.getBlue()));
            textFieldHex.setText(color.getRgbCode());
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });

        // Add listener on each textField
        textFieldRed.textProperty().addListener((ov, old_val, new_val) -> {
            try {
                color.setRed(Integer.parseInt(textFieldRed.textProperty().get()));
            }
            catch (IllegalArgumentException e) {
                color.setRed(0);
            }
            sliderRed.setValue(color.getRed());
            textFieldHex.setText(color.getRgbCode());
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });
        textFieldGreen.textProperty().addListener((ov, old_val, new_val) -> {
            try {
                color.setGreen(Integer.parseInt(textFieldGreen.textProperty().get()));
            }
            catch (IllegalArgumentException e) {
                color.setGreen(0);
            }
            sliderGreen.setValue(color.getGreen());
            textFieldHex.setText(color.getRgbCode());
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });
        textFieldBlue.textProperty().addListener((ov, old_val, new_val) -> {
            try {
                color.setBlue(Integer.parseInt(textFieldBlue.textProperty().get()));
            }
            catch (IllegalArgumentException e) {
                color.setBlue(0);
            }
            sliderBlue.setValue(color.getBlue());
            textFieldHex.setText(color.getRgbCode());
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });

        textFieldHex.textProperty().addListener((ov, old_val, new_val) -> {
            try {
                color.setRgbCode(textFieldHex.textProperty().get());
            }
            catch (IllegalArgumentException e) {
                color.setRgbCode("#");
            }
            sliderRed.setValue(color.getRed());
            sliderGreen.setValue(color.getGreen());
            sliderBlue.setValue(color.getBlue());
            textFieldRed.setText(Integer.toString(color.getRed()));
            textFieldGreen.setText(Integer.toString(color.getGreen()));
            textFieldBlue.setText(Integer.toString(color.getBlue()));
            paneColor.setStyle("-fx-background-color: " + color.getRgbCode());
        });
    }

}
