import java.util.ArrayList;
import java.util.List;

public class Lake extends Element {
    private List<Element> elements;

    public Lake(String name, double diameter, String path) {
        super(diameter, diameter, path); // lake is a circle, so width and length are the same
        this.elements = new ArrayList<>();
    }

    @Override
    public String getName() {
        return super.getPath().split("/")[super.getPath().split("/").length - 1];
    }

    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }

    public void add(Element element) {
        // only add if the element is marine or amphibious
        if (element.getHabitat() == Habitat.TERRESTRIAL || element.getHabitat() == Habitat.AMPHIBIAN) {
            elements.add(element);
        } else {
            System.out.println(element.getName() + " cannot be added to " + this.getName());
        }
    }

    public List<Element> getElements() {
        return elements;
    }
}
