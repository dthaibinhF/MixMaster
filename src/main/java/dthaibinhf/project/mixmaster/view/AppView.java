package dthaibinhf.project.mixmaster.view;

import dthaibinhf.project.mixmaster.view.component.Navbar;
import dthaibinhf.project.mixmaster.viewmodel.AppViewModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppView {
    private final BorderPane root = new BorderPane();
    private final Scene scene = new Scene(root);
    private final AppViewModel viewModel = new AppViewModel();

    public AppView(Stage stage) {
        configureLayout();

        // Bind center content to AppViewModel's current view
        root.centerProperty().bind(viewModel.currentViewProperty());

        //Start on Home view
        viewModel.navigateToHome();

        //Set stage property
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        stage.setMaximized(true);
        stage.show();
    }

    private void configureLayout() {
        root.getStyleClass().add("body");
        root.prefWidthProperty().bind(scene.widthProperty());
        root.prefHeightProperty().bind(scene.heightProperty());

        // Apply stylesheet
        scene.getStylesheets().add(
                getClass().getResource("/dthaibinhf/project/mixmaster/css/style.css").toExternalForm()
        );

        //Set Nav bar at top
        root.setTop(new Navbar(viewModel));
    }
}
