package dthaibinhf.project.mixmaster.view.component;

import dthaibinhf.project.mixmaster.viewmodel.AppViewModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public class Navbar extends HBox {
    private final HBox HbLogoContainer = new HBox();
    private final HBox HbLinkContainer = new HBox();
    private final AppViewModel viewModel;

    Label lbLogo = new Label("Mix Master");
    Label lbHome = new Label("Home");
    Label lbAbout = new Label("About");
    Label lbNewsletter = new Label("Newsletter");

    public Navbar(AppViewModel viewModel) {
        this.viewModel = viewModel;
        configureLayout();
        configureFunction();
        getChildren().addAll(HbLogoContainer, HbLinkContainer);

    }

    private void configureLayout() {
        /***Logo**/
        lbLogo.getStyleClass().add("logo");
        HbLogoContainer.setAlignment(Pos.CENTER_LEFT);
        HbLogoContainer.getStyleClass().add("logo-container");
        HbLogoContainer.getChildren().add(lbLogo);

        /**Links**/
        for (Label label : List.of(lbHome, lbAbout, lbNewsletter)) {
            label.getStyleClass().add("nav-link");
            HbLinkContainer.getChildren().add(label);
        }
        HbLinkContainer.getStyleClass().add("links-container");
        HbLinkContainer.setAlignment(Pos.CENTER_RIGHT);

        setSpacing(50);
        // Apply stylesheet
        getStyleClass().add("navbar-center");


        // Initialize highlight for Home (default view)
        lbHome.getStyleClass().add("nav-link-active");
    }

    private void configureFunction() {
        lbHome.setOnMouseClicked(e -> {
            System.out.println(viewModel.currentViewProperty().toString());
            viewModel.navigateToHome();
        });
        lbAbout.setOnMouseClicked(e -> {
            System.out.println(viewModel.currentViewProperty().toString());
            viewModel.navigateToAbout();
        });
        lbNewsletter.setOnMouseClicked(e -> {
            System.out.println(viewModel.currentViewProperty().toString());
            viewModel.navigateToNewsletter();
        });


    }
}
