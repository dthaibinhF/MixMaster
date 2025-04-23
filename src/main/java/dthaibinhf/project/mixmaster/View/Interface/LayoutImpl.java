package dthaibinhf.project.mixmaster.View.Interface;

import dthaibinhf.project.mixmaster.View.Component.Navbar;
import dthaibinhf.project.mixmaster.View.Home;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LayoutImpl implements Layout {

    private final Scene scene;

    public LayoutImpl(Stage stage, Scene scene, BorderPane root) {
        this.scene = scene;
        configBorderPane(root);
        configScene(scene);
        configStage(stage);
    }

    private void configStage(Stage stage) {
        stage.setScene(scene);
        stage.setMaximized(true);
    }

    private void configScene(Scene scene) {
        scene.getStylesheets().add(Objects.requireNonNull(Home.class.getResource("/dthaibinhf/project/mixmaster/css/style.css")).toExternalForm());
    }

    private void configBorderPane(BorderPane root) {
        root.getStyleClass().add("body");

        root.prefWidthProperty().bind(scene.widthProperty());
        root.prefHeightProperty().bind(scene.heightProperty());

        Top(root);
    }

    @Override
    public void Top(BorderPane root) {
        addNavbar(root);
    }

    private void addNavbar(BorderPane body) {
        Navbar navbar = new Navbar();

        body.setTop(navbar.getHbNavBar());
    }
}
