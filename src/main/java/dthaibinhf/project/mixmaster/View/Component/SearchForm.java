package dthaibinhf.project.mixmaster.View.Component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchForm {

    /*container*/
    private final HBox HbSearchBox;

    /*node*/
    private TextField txtSearch;
    private Button btnSearch;

    public SearchForm() {

        HbSearchBox = new HBox();
        btnSearch = new Button("Search");

        /*Config Container*/
        configContainer();
    }

    private void configContainer() {

        /*Search Field*/
        txtSearch = new TextField("Vodka");
        txtSearch.getStyleClass().add("search-field");
        txtSearch.setAlignment(Pos.CENTER_LEFT);

        /*Search Button*/
        btnSearch = new Button("Search");
        btnSearch.getStyleClass().addAll("btn", "btn-search");

        /*Class name*/
        HbSearchBox.getStyleClass().add("search-box");
        HbSearchBox.setAlignment(Pos.TOP_CENTER);

        HbSearchBox.getChildren().addAll(txtSearch, btnSearch);
    }

    public HBox getHbSearchBox() {
        return HbSearchBox;
    }

    public TextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(TextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }
}
