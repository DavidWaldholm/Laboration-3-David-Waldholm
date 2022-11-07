package javafxlabthree.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import javafxlabthree.shapes.Rectangle;
import javafxlabthree.shapes.Square;
import javafxlabthree.shapes.shapesInheritMain.WhatTypeOfShape;
import javafxlabthree.shapes.shapesInheritMain.Shapes;

import java.util.ArrayList;
import java.util.List;

import static javafxlabthree.shapes.shapesInheritMain.WhatTypeOfShape.*;

public class Model {

    public List<Shapes> shapes;
    public List<Shapes> selectedShapes;
    ObjectProperty<Color> color;
    DoubleProperty size;
    WhatTypeOfShape selectedShape;

    public Model() {

        shapes = new ArrayList<>();
        selectedShapes = new ArrayList<>();
        color = new SimpleObjectProperty<>(Color.BLACK);
        size = new SimpleDoubleProperty(4.3);
        selectedShape = SelectShape;

    }

    public List<Shapes> getSelectedShapes() {
        return selectedShapes;
    }

    public void addShapes(double x, double y) {
        if (getSelectedShape().equals(SQUARE)) {
            shapes.add(new Square(x, y, color.getValue(), size.getValue()));
            System.out.println("Creating a Square");
            System.out.println("Create Square where made at " + "x: " + x + " y: " + y);
        }
        if (getSelectedShape().equals(RECTANGLE)) {
            shapes.add(new Rectangle(x, y, color.getValue(), size.getValue()));
            System.out.println("Creating a Rectangle");
        }
    }

    public ObjectProperty<Color> getcolor() { return color; }

    public List<Shapes> getShapes() {
        return shapes;
    }

    public void switchSize() {
        for (Shapes shape : selectedShapes) {
            if (shape.getClass() == Square.class) {
                ((Square) shape).setRadius(size.getValue());
            } else {
                ((Rectangle) shape).setRadius(size.getValue());
            }
        }
    }

    public WhatTypeOfShape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(WhatTypeOfShape whatTypeOfShape) {
        this.selectedShape = whatTypeOfShape;
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public double getSize() {
        return size.get();
    }

    public void setSize(double size) {
        this.size.set(size);
    }


    public DoubleProperty sizeProperty() {
        return size;
    }

    public void remove() {
        shapes.remove(shapes.size() - 1);
    }

    public void switchColorOnSelected() {
        for (Shapes shapes : selectedShapes) {
            shapes.setColor(getColor());
        }
    }


}
