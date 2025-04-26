package dthaibinhf.project.mixmaster.model;

import java.util.ArrayList;
import java.util.List;

/**
 * strAlcoholic:info,
 * strCategory:category,
 * strGlass:glass,
 * strInstructions:instructions
 */
public class Cocktail {
    private String name;
    private String image;
    private String info;
    private String glass;
    private String instruction;
    private List<String> ingredients;

    public Cocktail() {
        name = "";
        image = "";
        info = "";
        glass = "";
        instruction = "";
        ingredients = new ArrayList<>();
    }

    public Cocktail(String name, String image, String info, String glass, String instruction, List<String> ingredients) {
        this.name = name;
        this.image = image;
        this.info = info;
        this.glass = glass;
        this.instruction = instruction;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return name;
    }
}
