package dthaibinhf.project.mixmaster.view.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class NewsletterView {
    private final VBox view = new VBox();

    public NewsletterView() {
        configure();
    }

    private void configure() {
        Label welcomeLabel = new Label("Welcome to Newsletter of MixMaster");
        welcomeLabel.getStyleClass().add("welcome-label");
        view.setSpacing(20);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.TOP_CENTER);
        view.getChildren().addAll(welcomeLabel);
        view.getStyleClass().add("page");
    }

    public Node getView() {
        return view;
    }
}
