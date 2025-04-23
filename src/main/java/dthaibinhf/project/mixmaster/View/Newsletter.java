package dthaibinhf.project.mixmaster.View;

import dthaibinhf.project.mixmaster.View.Interface.Layout;
import dthaibinhf.project.mixmaster.View.Interface.LayoutImpl;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Newsletter {

    //define layout
    private final BorderPane root;

    public Newsletter(Stage stage) {

        root = new BorderPane();
        Scene scene = new Scene(root);
        Layout layout = new LayoutImpl(stage, scene, root);
        stage.setTitle("Newsletter of MixMaster");
        initiate();
        stage.show();
    }

    private void initiate() {
        configCenter();
    }

    private void configCenter() {
        Label label = new Label("Newsletter Page");
        root.setCenter(label);
    }

}
