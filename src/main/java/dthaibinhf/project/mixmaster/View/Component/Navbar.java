package dthaibinhf.project.mixmaster.View.Component;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Navbar {
    //container
    private BorderPane root;

    //Hbox in top section
    private HBox HbNavBar;

    //Node in navbar
    private Label lbLogo;

    public Navbar(BorderPane body) {
        HbNavBar = new HBox();
        lbLogo = new Label("Mix Master");

        styleNavbar(HbNavBar);

        HbNavBar.getChildren().add(lbLogo);
    }

    private void styleNavbar(HBox hbNavBar) {
        //set class
        hbNavBar.getStyleClass().add("navbar");
        //set alignment to center
        hbNavBar.setAlignment(Pos.CENTER);
        //
    }
}
