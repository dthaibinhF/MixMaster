package dthaibinhf.project.mixmaster.View.Component;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class Navbar {
    //Hbox in top section
    private final HBox HbNavBar;
    private final HBox HbLogoContainer;
    private final HBox HbLinkContainer;
    //container
    private final BorderPane root;
    //Node in navbar
    private Label lbLogo;
    private Label lbHome;
    private Label lbAbout;
    private Label lbNewsletter;

    public Navbar(BorderPane body) {
        root = body;

        HbNavBar = new HBox();
        HbLogoContainer = new HBox();
        HbLinkContainer = new HBox();


        /*config*/
        configLabel();
        configContainer();

        /*body add node*/
        root.setTop(HbNavBar);
    }

    private void configContainer() {

        /*class name*/
        HbNavBar.getStyleClass().add("navbar-center");

        /*alignment*/
//        HbNavBar.setAlignment(Pos.CENTER);
        HbNavBar.setSpacing(50); // Add spacing between logo and links


        /*Left - Right Navbar*/
        configLeftSide();
        configRightSide();

        /*add Node*/
        HbNavBar.getChildren().addAll(HbLogoContainer, HbLinkContainer);
    }

    private void configLeftSide() {
        /*Style*/
        styleLeftSide();
        /*add nodes*/
        HbLogoContainer.getChildren().addAll(lbLogo);
    }


    private void styleLeftSide() {

        /*Class name*/
        HbLogoContainer.getStyleClass().add("logo-container");
        //set alignment to Center Left
        HbLogoContainer.setAlignment(Pos.CENTER_LEFT);
        /*LOGO*/
        lbLogo.getStyleClass().add("logo");
    }

    private void configRightSide() {
        /*Style*/
        styleRightSide();
        /*Add nodes*/
        HbLinkContainer.getChildren().addAll(lbHome, lbAbout, lbNewsletter);
    }

    private void styleRightSide() {
        /*Class name*/
        HbLinkContainer.getStyleClass().add("links-container");
        for (Label label : List.of(lbHome, lbAbout, lbNewsletter)) {
            label.getStyleClass().add("nav-link");
        }

        /*set alignment to right*/
        HbLinkContainer.setAlignment(Pos.CENTER_RIGHT);

    }


    private void configLabel() {
        lbLogo = new Label("Mix Master");
        lbHome = new Label("Home");
        lbAbout = new Label("About");
        lbNewsletter = new Label("Newsletter");

    }

}
