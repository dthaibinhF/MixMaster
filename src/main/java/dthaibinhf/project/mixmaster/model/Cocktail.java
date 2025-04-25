package dthaibinhf.project.mixmaster.model;

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

    public Cocktail() {
        name = "";
        image = "";
        info = "";
        glass = "";
        instruction = "";
    }

    public Cocktail(String name, String image, String info, String glass, String instruction) {
        this.name = name;
        this.image = image;
        this.info = info;
        this.glass = glass;
        this.instruction = instruction;
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

    @Override
    public String toString() {
        return name;
    }
}
