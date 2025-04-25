package dthaibinhf.project.mixmaster.view.pages;

import dthaibinhf.project.mixmaster.model.Cocktail;
import dthaibinhf.project.mixmaster.view.component.SearchForm;
import dthaibinhf.project.mixmaster.viewmodel.HomeViewModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class HomeView {
    private final HomeViewModel viewModel = new HomeViewModel();

    private final VBox view = new VBox();
    private final TilePane cocktailsView = new TilePane();
    private final Label errorLabel = new Label();

    private final ListProperty<Cocktail> cocktails = new SimpleListProperty<>(FXCollections.observableArrayList());


    public HomeView() {
        configureLayout();
        configureBindings();
        bindCocktails();
        configure();

        //initiate list cocktails when start
        viewModel.searchCocktails();
    }

    private void bindCocktails() {
        // Bind the ListView items to the cocktails ObservableList in the ViewModel
        cocktails.bind(viewModel.getCocktails());
        // Listen for changes to the cocktailsProperty and process the data
        cocktails.addListener((obs, oldList, newList) -> {
            processCocktailsData(newList);
        });
        // Initial processing in case the list already has data
        processCocktailsData(cocktails.get());
    }

    private void processCocktailsData(ObservableList<Cocktail> cocktails) {
        // Example: Process the cocktails data
        System.out.println("Cocktails data updated:");
        if (cocktails == null || cocktails.isEmpty()) {
            System.out.println("No cocktails available.");
        } else {
            for (Cocktail cocktail : cocktails) {
                System.out.println("Name: " + cocktail.getName() +
                        ", Image: " + cocktail.getImage() +
                        ", Info: " + cocktail.getInfo() +
                        ", Glass: " + cocktail.getGlass() +
                        ", Instructions: " + cocktail.getInstruction());
            }
        }
    }

    private void configureBindings() {
        // Bind the error label text to the errorMessage property in the ViewModel
        errorLabel.textProperty().bind(viewModel.errorMessageProperty());
    }

    private void configure() {


    }

    private void configureLayout() {

        //Set text
        Label welcomeLabel = new Label("Welcome to MixMaster");
        welcomeLabel.getStyleClass().add("welcome-label");

        //Apply style
        view.setSpacing(20);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.TOP_CENTER);
        view.getStyleClass().add("page");


        view.getChildren().addAll(welcomeLabel, new SearchForm(viewModel));
    }

    public Node getView() {
        return view;
    }
}
