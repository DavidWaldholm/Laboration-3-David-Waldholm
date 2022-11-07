package javafxlabthree.shapes.shapesInheritMain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes {
    private double x;
    private double y;
    private Color color;
    private Color borderColor;

    public Shapes(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.borderColor = Color.TRANSPARENT;
    }

    public static String colorToString(Color color) {
        return String.format("#%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean isSelected(double x, double y);

    public abstract void draw(GraphicsContext graphicsContext);


    public abstract String toSVG();
}
