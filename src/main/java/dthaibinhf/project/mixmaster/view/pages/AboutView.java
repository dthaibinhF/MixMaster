package dthaibinhf.project.mixmaster.view.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import static dthaibinhf.project.mixmaster.constants.Text.ABOUT_TEXT;

public class AboutView {
    private final VBox view = new VBox();
    Label lbTitle = new Label("About Us");
    Label lbText = new Label(ABOUT_TEXT);

    public AboutView() {
        configure();

        view.getChildren().addAll(lbTitle, lbText);
    }

    private void configure() {

        lbTitle.getStyleClass().add("h3");
        
        lbText.getStyleClass().add("text");
        lbText.setLineSpacing(2);
        lbText.setWrapText(true);

        view.setSpacing(20);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.TOP_LEFT);
        view.getStyleClass().add("page");
    }

    public Node getView() {
        return view;
    }
}
