package dthaibinhf.project.mixmaster.viewmodel;

import dthaibinhf.project.mixmaster.constants.ApiConstants;
import dthaibinhf.project.mixmaster.model.Cocktail;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.Node;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Model communicate HomeView with it component
 */
public class HomeViewModel {
    private final ObjectProperty<Node> currentView = new SimpleObjectProperty<>();
    private final StringProperty searchQuery = new SimpleStringProperty("gin");
    private final ListProperty<Cocktail> cocktails = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final StringProperty errorMessage = new SimpleStringProperty("");

    public HomeViewModel() {

    }

    public void searchCocktails() {
        String query = searchQuery.get();
        if (query == null || query.trim().isEmpty()) {
            errorMessage.set("PLease enter a search query");
            return;
        }
        //Clear previous result and errors
        cocktails.clear();
        errorMessage.set("");

        //Create a Task for async API call
        Task<Void> searchTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                try {
                    //Build and send HTTP request using ApiConstants
                    String url = ApiConstants.COCKTAIL_SEARCH_URL + query.trim();
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET()
                            .build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    //parse JSON response
                    JSONObject json = new JSONObject(response.body());
                    //get drinks property in json get from response
                    JSONArray drinks = json.optJSONArray("drinks"); // Use optJSONArray to handle null
                    if (drinks == null || drinks.isEmpty()) {
                        errorMessage.set("No cocktails found for \"" + query + "\".");
                        return null;
                    }
                    //convert JSON to Cocktail object
                    for (int i = 0; i < drinks.length(); i++) {
                        JSONObject drink = drinks.getJSONObject(i);
                        //Take ingredient from Json
                        List<String> ingredients = new ArrayList<>();
                        //iterate through all key in object
                        //this method is a bit long for loading
                        /*for (String key : drink.keySet()) {
                            if (key.startsWith("strIngredient") && !drink.get(key).toString().equals("null")) {
                                ingredients.add(drink.get(key).toString());
                            }
                        }*/
                        //try new method
                        ingredients = drink.keySet().stream()
                                .filter(key -> key.startsWith("strIngredient") && !drink.get(key).toString().equals("null"))
                                .map(key -> drink.get(key).toString())
                                .collect(Collectors.toList());
                        Cocktail cocktail = new Cocktail(
                                drink.getString("strDrink"),           // name
                                drink.getString("strDrinkThumb"),      // image
                                drink.getString("strAlcoholic"),       // info
                                drink.getString("strGlass"),           // glass
                                drink.getString("strInstructions"),     // instruction,
                                ingredients
                        );
                        cocktails.get().add(cocktail); // Update on JavaFX thread handled by ObservableList
                    }

                } catch (Exception e) {
                    errorMessage.set("Error fetching cocktails: " + e.getMessage());
                }
                return null;
            }
        };

        // Run the task in a background thread
        new Thread(searchTask).start();

    }

    public StringProperty searchQueryProperty() {
        return searchQuery;
    }

    public ListProperty<Cocktail> getCocktails() {
        return cocktails;
    }

    public StringProperty errorMessageProperty() {
        return errorMessage;
    }


}
