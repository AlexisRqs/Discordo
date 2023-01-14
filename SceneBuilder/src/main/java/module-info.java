module org.waa.sme.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.beans;
    requires lombok;
    requires spring.context;


    opens org.waa.sme.scenebuilder to javafx.fxml;
    exports org.waa.sme.scenebuilder;
}