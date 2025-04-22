package dthaibinhf.project.mixmaster.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Landing {
    private Stage stage;
    private Scene scene;

    public Landing(Stage stage) {
        this.stage = stage;
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/dthaibinhf/project/mixmaster/Pages/Landing.fxml")));
            scene = new Scene(loader.load());
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(Landing.class.getResource("/dthaibinhf/project/mixmaster/css/style.css")).toExternalForm());
            stage.setTitle("MixMaster");
            stage.setResizable(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
