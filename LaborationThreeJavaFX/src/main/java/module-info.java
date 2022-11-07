module se.iths.jd.javafxttlabthree {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens javafxlabthree to javafx.fxml;
    exports javafxlabthree;
    exports javafxlabthree.shapes.shapesInheritMain;
    opens javafxlabthree.shapes.shapesInheritMain to javafx.fxml;
    exports javafxlabthree.shapes;
    opens javafxlabthree.shapes to javafx.fxml;
    exports javafxlabthree.Model;
    opens javafxlabthree.Model to javafx.fxml;
    exports javafxlabthree.controller;
    opens javafxlabthree.controller to javafx.fxml;
}