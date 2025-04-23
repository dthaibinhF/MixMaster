package dthaibinhf.project.mixmaster.View;

import dthaibinhf.project.mixmaster.View.Interface.Layout;
import dthaibinhf.project.mixmaster.View.Interface.LayoutImpl;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Home {

    /*Interface*/
    private final Layout layout;
    //define holder
    private final Scene scene;
    //define layout
    private final BorderPane root;

    public Home(Stage stage) {

        //define field
        root = new BorderPane();
        scene = new Scene(root);
        layout = new LayoutImpl(stage, scene, root);

        //initiate
        initiate(root);

        /*Stage*/
        
        stage.setTitle("Mix Master");
        stage.show();
    }

    private void initiate(BorderPane root) {
        configCenterSection(root);
    }

    private void configCenterSection(BorderPane root) {
    }

}
