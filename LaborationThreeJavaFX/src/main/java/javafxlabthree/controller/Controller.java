package javafxlabthree.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafxlabthree.CanvasSaveSVG;
import javafxlabthree.Model.Model;
import javafxlabthree.shapes.shapesInheritMain.Shapes;
import javafxlabthree.shapes.shapesInheritMain.WhatTypeOfShape;
import javax.imageio.ImageIO;
import java.io.File;


public class Controller {
    Model model;
    @FXML
    private Slider brushSize;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ChoiceBox<WhatTypeOfShape> choiceBox;

    ObservableList<WhatTypeOfShape> whatTypesListOfShape = FXCollections.observableArrayList(WhatTypeOfShape.values());

    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }

    public void initialize() {
        model = new Model();
        colorPicker.valueProperty().bindBidirectional(model.getcolor());
        brushSize.valueProperty().bindBidirectional(model.sizeProperty());
        choiceBox.setItems(whatTypesListOfShape);


    }

    @FXML
    public void pickedShape(ActionEvent event) {
        switch (choiceBox.getValue()) {
            case RECTANGLE -> {
                model.setSelectedShape(WhatTypeOfShape.RECTANGLE);
            }
            case SQUARE -> {
                model.setSelectedShape(WhatTypeOfShape.SQUARE);
            }
            case SelectShape -> {
                model.setSelectedShape(WhatTypeOfShape.SelectShape);
            }
        }
    }

    @FXML
    private void handleCanvasClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (choiceBox.getValue() == WhatTypeOfShape.SelectShape) {
            for (Shapes shapes : model.getShapes()) {
                if (shapes.isSelected(x, y)) {
                    System.out.println(model.getSelectedShapes());
                    shapes.setBorderColor(Color.MAGENTA);
                    model.getSelectedShapes().add(shapes);
                }
            }
        } else {
            model.addShapes(x, y);
        }
        drawOnExecute();
    }

    @FXML
    void undoLatestShape(ActionEvent event) { //Removes the  latest drawn shape
        model.remove();
        drawOnExecute();
    }

    @FXML
    void saveImage() { //Saves image as a SVG-file
        CanvasSaveSVG.save(model);

        try {
            Image snapShot = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to save " + e);
        }

    }

    @FXML
    void switchColor(MouseEvent event) {
        model.switchColorOnSelected();
        drawOnExecute();
    }

    @FXML
    void switchSize(MouseEvent event) {
        model.switchSize();
        drawOnExecute();
    }

    private void drawOnExecute() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shapes shape : model.getShapes()) {
            shape.draw(gc);
        }
    }
}