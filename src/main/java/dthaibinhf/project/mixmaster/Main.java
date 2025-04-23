package dthaibinhf.project.mixmaster;

import dthaibinhf.project.mixmaster.View.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Home home = new Home(primaryStage);
    }
}