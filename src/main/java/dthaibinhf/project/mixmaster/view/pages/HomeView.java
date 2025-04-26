package dthaibinhf.project.mixmaster.view.pages;

import dthaibinhf.project.mixmaster.model.Cocktail;
import dthaibinhf.project.mixmaster.view.component.SearchForm;
import dthaibinhf.project.mixmaster.viewmodel.HomeViewModel;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeView {
    private final HomeViewModel viewModel = new HomeViewModel();

    private final VBox view = new VBox();
    private final TilePane cocktailsList = new TilePane();
    private final ScrollPane scrollPane = new ScrollPane(cocktailsList); // Wrap TilePane in ScrollPane

    private final Label infoLabel = new Label("Welcome to MixMaster");
    private final Label errorLabel = new Label("Welcome to MixMaster");
    private final ListProperty<Cocktail> cocktails = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final Map<String, Image> imageCache = new HashMap<>();

    public HomeView() {
        configureLayout();
        configureError();
        bindCocktails();
        configureLayoutCocktailsView();

        //initiate list cocktails when start
        viewModel.searchCocktails();
    }

    private void bindCocktails() {
        // Bind the cocktails ListProperty to the ViewModel's cocktailsProperty
        cocktails.bind(viewModel.getCocktails());
        // Listen for changes to the cocktailsProperty and process the data
        cocktails.addListener((obs, oldList, newList) -> {
            Platform.runLater(() -> processCocktailsData(newList));
        });
        // Initial processing
        Platform.runLater(() -> processCocktailsData(cocktails.get()));
    }

    private void processCocktailsData(ObservableList<Cocktail> cocktails) {
        cocktailsList.getChildren().clear(); //clear all node when reload
        // Example: Process the cocktails data
        if (cocktails == null || cocktails.isEmpty()) {
            System.out.println("No cocktails available.");
        } else {
            //create a copy (snapshot) of the list to iterate over. This prevents issues if the original list is modified during iteration.
            List<Cocktail> cocktailsSnapshot = new ArrayList<>(cocktails);

            //preloading image
            List<Image> images = new ArrayList<>();
            for (Cocktail cocktail : cocktailsSnapshot) {
                //Get Url from data
                String imageUrl = cocktail.getImage();
                Image image; //create object
                if (imageUrl != null && !imageUrl.isEmpty()) {
                    image = imageCache.get(imageUrl); //try to get key with the url
                    if (image == null) { //Meaning there is no image with this url in map
                        // Load image asynchronously with specified dimensions
                        image = new Image(imageUrl, 300, 400, true, true, true);
                        if (image.isError()) {
                            System.out.println("Error loading image for " + cocktail.getName() + ": " + image.getException());
                            image = new Image(getClass().getResourceAsStream("/dthaibinhf/project/mixmaster/image/cocktail_left.png"));
                        }
                        imageCache.put(imageUrl, image); //Add to map
                    } else { //image url is null then we use backup image in local
                        image = new Image(getClass().getResourceAsStream("/dthaibinhf/project/mixmaster/image/cocktail_left.png"));
                    }
                    //Save the loaded image to list
                    images.add(image);
                }
            }

            for (Cocktail cocktail : cocktailsSnapshot) {
                // Create a VBox for each cocktail to stack image and labels vertically
                VBox cocktailCard = new VBox(5);
                cocktailCard.setAlignment(Pos.CENTER);
                cocktailCard.getStyleClass().add("cocktail-card");

                //image
                Image image = imageCache.get(cocktail.getImage());
                ImageView imageCocktail = new ImageView(image);
                imageCocktail.setFitWidth(300);
                imageCocktail.setFitHeight(400);
                imageCocktail.setPreserveRatio(true);

                // Labels
                Label nameCocktail = new Label(cocktail.getName());
                nameCocktail.getStyleClass().add("cocktail-name");
                Label glassCocktail = new Label(cocktail.getGlass());
                glassCocktail.getStyleClass().add("cocktail-glass");
                Label infoCocktail = new Label(cocktail.getInfo());
                infoCocktail.getStyleClass().add("cocktail-info");

                cocktailCard.getChildren().addAll(imageCocktail, nameCocktail, glassCocktail, infoCocktail);
                cocktailsList.getChildren().add(cocktailCard);
            }

        }

    }

    private void configureError() {
        // Bind the error label text to the errorMessage property in the ViewModel
        errorLabel.textProperty().bind(viewModel.errorMessageProperty());
        errorLabel.getStyleClass().add("error-label");
    }

    private void configureLayoutCocktailsView() {
        cocktailsList.setAlignment(Pos.CENTER);
        cocktailsList.setHgap(10);
        cocktailsList.setVgap(10);
        cocktailsList.getStyleClass().add("cocktails-list");

        // Configure ScrollPane
        scrollPane.setFitToWidth(true); // TilePane expands to ScrollPane width
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Vertical scrollbar when needed
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // No horizontal scrollbar
        scrollPane.setPannable(true); // Allow mouse dragging
        scrollPane.getStyleClass().add("scroll-pane");
    }

    private void configureLayout() {

        //Set text
        infoLabel.setText("Welcome to MixMaster");

        //Apply style
        view.setSpacing(20);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.TOP_CENTER);
        view.getStyleClass().add("page");
        view.getChildren().addAll(infoLabel, new SearchForm(viewModel), cocktailsList, scrollPane);
    }

    public Node getView() {
        return view;
    }
}
