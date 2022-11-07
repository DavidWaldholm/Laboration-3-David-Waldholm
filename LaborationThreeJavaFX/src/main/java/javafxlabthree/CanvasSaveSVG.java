package javafxlabthree;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafxlabthree.Model.Model;
import javafxlabthree.shapes.shapesInheritMain.Shapes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CanvasSaveSVG {
    static FileChooser fileChooser = new FileChooser();

    public static void save(Model model) {

        setUpFileSave();

        Path path = Path.of(fileChooser.showSaveDialog(new Stage()).getPath());
        List<String> svgString = new ArrayList<>();
        svgString.add(startOfSvg());
        for (Shapes shape : model.getShapes()) {
            svgString.add(shape.toSVG());
        }

        svgString.add("</svg>");

        try {
            Files.write(path, svgString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String startOfSvg() {
        return "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"3840\" height=\"1080\">";
    }

    private static void setUpFileSave() {
        fileChooser.setTitle("Save as");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("SVG file", ".svg"));
    }

}
