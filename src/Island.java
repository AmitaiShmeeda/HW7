import java.util.ArrayList;
import java.util.List;

public class Island extends Element {
    private List<Element> elements;

    public Island(String name, double diameter, String path) {
        super(diameter, diameter, path); // island is a circle, so width and length are the same
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
        return Habitat.TERRESTRIAL;
    }

    public void add(Element element) {
        // only add if the element is terrestrial or amphibious
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
