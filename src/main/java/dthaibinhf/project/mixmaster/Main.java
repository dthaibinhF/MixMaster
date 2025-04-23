package dthaibinhf.project.mixmaster;

import dthaibinhf.project.mixmaster.View.LandingCode;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LandingCode landing = new LandingCode(primaryStage);
    }
}