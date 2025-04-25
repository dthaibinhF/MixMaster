package dthaibinhf.project.mixmaster.view.component;

import dthaibinhf.project.mixmaster.viewmodel.HomeViewModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchForm extends HBox {

    private final HomeViewModel viewModel;

    private final TextField txtSearch = new TextField();
    private final Button btnSearch = new Button("Search");

    public SearchForm(HomeViewModel homeViewModel) {
        this.viewModel = homeViewModel;
        configureLayout();
        configureFunction();


        getChildren().addAll(txtSearch, btnSearch);
    }

    private void configureFunction() {
        // Bind the txtSearch text property to the searchQuery property in the ViewModel
        txtSearch.textProperty().bindBidirectional(viewModel.searchQueryProperty());
        // Set the action for the search button to trigger the searchCocktails method
        btnSearch.setOnAction(event -> viewModel.searchCocktails());
        // Trigger search on Enter key press in the TextField
        txtSearch.setOnAction(event -> viewModel.searchCocktails());
    }

    private void configureLayout() {
        setAlignment(Pos.CENTER);

        //Input
        txtSearch.getStyleClass().add("search-field");
        txtSearch.setAlignment(Pos.CENTER_LEFT);
        txtSearch.setFocusTraversable(false);
        setMargin(txtSearch, new Insets(2));

        //Button
        btnSearch.getStyleClass().addAll("btn", "btn-search");

        //Apply stylesheet
        getStyleClass().add("search-box");
    }

    public HomeViewModel getViewModel() {
        return viewModel;
    }

    public TextField getTxtSearch() {
        return txtSearch;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }
}
