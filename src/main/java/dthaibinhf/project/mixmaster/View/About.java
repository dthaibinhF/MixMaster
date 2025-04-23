package dthaibinhf.project.mixmaster.View;

import dthaibinhf.project.mixmaster.View.Interface.Layout;
import dthaibinhf.project.mixmaster.View.Interface.LayoutImpl;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class About {

    /*field*/
    private final Scene scene;
    private final BorderPane root;
    /*Interface*/
    private final Layout layout;
    /*Nodes*/
    private Label label;

    public About(Stage stage) {

        //define field
        root = new BorderPane();
        scene = new Scene(root);
        layout = new LayoutImpl(stage, scene, root);

        initiate();

        /*Stage*/
        stage.setTitle("About of MixMaster");
    }

    private void initiate() {
        configCenter();
    }

    private void configCenter() {
        label = new Label("About Page");
        root.setCenter(label);
    }
}
