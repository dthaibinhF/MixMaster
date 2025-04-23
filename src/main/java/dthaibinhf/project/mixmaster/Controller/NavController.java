package dthaibinhf.project.mixmaster.Controller;

import dthaibinhf.project.mixmaster.View.About;
import dthaibinhf.project.mixmaster.View.Home;
import dthaibinhf.project.mixmaster.View.Newsletter;
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

    public void setLbNewsletter(Label button) {
        LbNewsletter = button;
        LbNewsletter.setOnMouseClicked(this::handleNewsletterNavigate);
    }

    private void handleAboutNavigate(MouseEvent mouseEvent) {
        Stage stage = getStage(LbAbout);
        About aboutPage = new About(stage);
    }

    private void handleHomeNavigate(MouseEvent mouseEvent) {
        Stage stage = getStage(LBHome);
        Home homePage = new Home(stage);
    }

    private void handleNewsletterNavigate(MouseEvent mouseEvent) {
        Stage stage = getStage(LbNewsletter);
        Newsletter newsletterPage = new Newsletter(stage);
    }

    private Stage getStage(Label lbl) {
        return (Stage) lbl.getScene().getWindow();
    }

}
