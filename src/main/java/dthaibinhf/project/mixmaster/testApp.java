package dthaibinhf.project.mixmaster;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class testApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Scene scene = new Scene(root, 400, 300); // Set scene size for visibility

        // Load image from the internet
        String imageUrl = "https://www.thecocktaildb.com/images/media/drink/jqh2141572807327.jpg";
        Image image = new Image(imageUrl, 100, 100, true, true, true);
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException());
        }
        ImageView imageCocktail = new ImageView(image);
        imageCocktail.setFitWidth(100);
        imageCocktail.setFitHeight(100);
        imageCocktail.setPreserveRatio(true);

        root.getChildren().add(imageCocktail);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test App");
        primaryStage.show();
    }
}