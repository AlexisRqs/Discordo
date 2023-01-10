module org.waa.sme.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.waa.sme.scenebuilder to javafx.fxml;
    exports org.waa.sme.scenebuilder;
}