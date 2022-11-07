package javafxlabthree;

import javafx.scene.paint.Color;
import javafxlabthree.Model.Model;
import javafxlabthree.shapes.Rectangle;
import javafxlabthree.shapes.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest { //Junit5 Testing
    Model model = new Model();
    Rectangle rectangle = new Rectangle(5, 5, Color.BLACK, 25);
    Square square = new Square(5, 5, Color.BLACK, 25);

    @Test
    void addShapeToListAndChecksItsSize() {
        model.shapes.add(rectangle);
        model.shapes.add(square);
        assertEquals(2, model.shapes.size());
    }

    @Test
    void switchColor() {
        model.shapes.add(rectangle);
        model.shapes.add(square);
        model.shapes.get(1).setColor(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, model.shapes.get(1).getColor());
    }

}