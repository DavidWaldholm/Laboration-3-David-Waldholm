package javafxlabthree.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafxlabthree.shapes.shapesInheritMain.Shapes;

public class Square extends Shapes {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Square(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getBorderColor());
        graphicsContext.fillRect(getX() - (radius / 2) - 2.5, getY() - (radius / 2) - 2.5, radius + 5, radius + 5);
        graphicsContext.setFill(getColor());
        graphicsContext.fillRect(getX() - (radius / 2), getY() - (radius / 2), radius, radius);
        System.out.println(this);
    }

    @Override
    public boolean isSelected(double x, double y) {
        double westSide = x - (radius / 2);
        double eastSide = x + (radius / 2);
        double lowerEdge = y - (radius / 2);
        double upperEdge = y + (radius / 2);

        return (westSide <= x && x <= eastSide) && (lowerEdge <= y && y <= upperEdge);
    }


    @Override
    public String toSVG() {
        String color = "#" + getColor().toString().substring(2, 10);
        return "<rect x=\"" + getX() + "\" y=\"" + getY() + "\" width=\"" + radius + "\" height=\"" + radius + "\" fill=\"" + color + "\" />";
    }
}
