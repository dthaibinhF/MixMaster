package dthaibinhf.project.mixmaster.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LandingController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox VbPage;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;

    public LandingController(BorderPane borderPane, VBox vbPage) {
        this.borderPane = borderPane;
        VbPage = vbPage;
    }

    @FXML
    public void btnSearchOnAction(ActionEvent actionEvent) {
        txtSearch.clear();

    }

}
