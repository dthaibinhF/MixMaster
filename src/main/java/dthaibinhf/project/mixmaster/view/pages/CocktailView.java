package dthaibinhf.project.mixmaster.view.pages;

import dthaibinhf.project.mixmaster.model.Cocktail;
import dthaibinhf.project.mixmaster.viewmodel.AppViewModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CocktailView {
    //ViewModel
    private final AppViewModel appViewModel;

    //Layout
    private final VBox view = new VBox();
    private final Button btnBackHome = new Button("Back Home");
    private final HBox cocktailDetailView = new HBox(20);
    //Data
    private final Cocktail cocktail;

    public CocktailView(Cocktail cocktail, AppViewModel appViewModel) {
        this.cocktail = cocktail;
        this.appViewModel = appViewModel;
        configureLayout();
        configureCocktailLayout(cocktail);
    }

    private void configureCocktailLayout(Cocktail cocktail) {

        //
        cocktailDetailView.setAlignment(Pos.CENTER);
        cocktailDetailView.setPadding(new Insets(10, 10, 10, 10));

        //Image
        Image image = new Image(cocktail.getImage(), 800, 800, true, true, true);
        ImageView imageCocktail = new ImageView(image);
        imageCocktail.setFitWidth(300);
        imageCocktail.setFitHeight(400);
        imageCocktail.setPreserveRatio(true);

        //Information
        VBox cocktailInformation = new VBox(20);
        cocktailInformation.getChildren().addAll(
                createLabeledField("Name: ", cocktail.getName()),
                createLabeledField("Category: ", "cocktail"),
                createLabeledField("Info: ", cocktail.getInfo()),
                createLabeledField("Glass: ", cocktail.getGlass()),
                createLabeledField("Ingredient: ",
                        cocktail.getIngredients()
                                .toString()
                                .substring(1, cocktail.getIngredients().toString().length() - 1)),
                createLabeledField("Instruction: ", cocktail.getInstruction()));

        //Add nodes
        cocktailDetailView.getChildren().addAll(
                imageCocktail,
                cocktailInformation
        );
    }

    private HBox createLabeledField(String fieldName, String value) {
        HBox fieldBox = new HBox(); // 5px spacing between label and value
        fieldBox.setAlignment(Pos.CENTER_LEFT);

        // Field name label (e.g., "Name:")
        Label nameLabel = new Label(fieldName);
        nameLabel.getStyleClass().add("field-label");

        // Value label (e.g., "Vodka Slime")
        Label valueLabel = new Label(value);
        valueLabel.getStyleClass().add("field-value");
        valueLabel.setWrapText(true); // Allow text wrapping for long instructions

        fieldBox.getChildren().addAll(nameLabel, valueLabel);
        return fieldBox;
    }

    private void configureLayout() {
        //Node
        Label cocktailTitle = new Label(cocktail.getName());
        cocktailTitle.getStyleClass().add("h3");

        //Button
        btnBackHome.getStyleClass().add("btn");
        btnBackHome.setOnAction(e -> appViewModel.navigateToHome());

        view.setSpacing(20);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.TOP_CENTER);
        view.getStyleClass().addAll("cocktail-detail-page", "page");
        VBox.setMargin(view, new Insets(20, 20, 20, 20));


        view.getChildren().addAll(btnBackHome, cocktailTitle, cocktailDetailView);
    }

    public Node getView() {
        return view;
    }
}
