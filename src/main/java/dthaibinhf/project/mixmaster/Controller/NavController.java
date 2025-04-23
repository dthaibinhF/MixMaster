package dthaibinhf.project.mixmaster.Controller;

import dthaibinhf.project.mixmaster.View.About;
import dthaibinhf.project.mixmaster.View.Home;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NavController {
    private Label LBHome;
    private Label LbAbout;
    private Label LbNewsletter;

    public void setLBHome(Label label) {
        LBHome = label;
        LBHome.setOnMouseClicked(this::handleHomeNavigate);
    }

    public void setLbAbout(Label button) {
        LbAbout = button;
        LbAbout.setOnMouseClicked(this::handleAboutNavigate);
    }

    private void handleAboutNavigate(MouseEvent mouseEvent) {
        System.out.println("About Navigate");
        Stage stage = getStage(LbAbout);
        stage.setTitle("About of Mix Master");
        About aboutPage = new About(stage);
    }

    private void handleHomeNavigate(MouseEvent mouseEvent) {
        Stage stage = getStage(LBHome);
        Home homePage = new Home(stage);
    }

    private Stage getStage(Label btn) {
        return (Stage) btn.getScene().getWindow();
    }
}
