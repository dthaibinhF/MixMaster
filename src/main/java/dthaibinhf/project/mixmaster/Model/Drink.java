package dthaibinhf.project.mixmaster.Model;

/**
 * strAlcoholic:info,
 * strCategory:category,
 * strGlass:glass,
 * strInstructions:instructions
 */
public class Drink {
    private String name;
    private String image;
    private String info;
    private String glass;
    private String instruction;

    public Drink() {
        name = "";
        image = "";
        info = "";
        glass = "";
        instruction = "";
    }

    public Drink(String name, String image, String info, String glass, String instruction) {
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
}
