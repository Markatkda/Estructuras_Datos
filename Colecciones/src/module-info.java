module Colecciones {


    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;

    opens Laboratorio2.Controller to javafx.fxml;
    opens Laboratorio2.Model to javafx.base;
    exports Laboratorio2.Application;

}