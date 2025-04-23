package dthaibinhf.project.mixmaster.View;

import dthaibinhf.project.mixmaster.View.Component.Navbar;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LandingCode {

    //define holder
    private Stage stage;
    private Scene scene;

    //define layout
    private BorderPane body;

    public LandingCode(Stage stage) {

        //define field
        this.stage = stage;
        body = new BorderPane();
        scene = new Scene(body);

        //initiate
        initiate(body);
        configScene(scene);
        configStage(stage);

        //show Stage
        stage.show();
    }

    private void configScene(Scene scene) {
        //stylesheet
        scene.getStylesheets().add(Objects.requireNonNull(LandingCode.class.getResource("/dthaibinhf/project/mixmaster/css/style.css")).toExternalForm());

    }

    private void configStage(Stage stage) {
        stage.setScene(scene);
        stage.setTitle("Mix Master");
        //Maximize Window
        stage.setMaximized(true);
    }

    private void initiate(BorderPane body) {
        configBody(body);
        configTopSection(body);
        configCenterSection(body);
    }

    private void configCenterSection(BorderPane body) {
    }

    private void configBody(BorderPane body) {
        body.getStyleClass().add("body");
        /*set width and height bind with scene*/
        body.prefWidthProperty().bind(scene.widthProperty());
        body.prefHeightProperty().bind(scene.heightProperty());

    }

    private void configTopSection(BorderPane body) {
        //add navbar for top
        addNavbar(body);
    }

    private void addNavbar(BorderPane body) {
        Navbar navbar = new Navbar(body);

    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getBody() {
        return body;
    }

    public void setBody(BorderPane body) {
        this.body = body;
    }

}
