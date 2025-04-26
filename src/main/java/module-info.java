module dthaibinhf.project.mixmaster {
    requires javafx.controls;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires org.json;

    opens dthaibinhf.project.mixmaster to javafx.fxml;

    exports dthaibinhf.project.mixmaster;
}