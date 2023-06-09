import java.util.ArrayList;
import java.util.List;


public class Lake extends Element {
    //protected List<Element> elements;
    protected String name;

    public Lake(String name, double diameter, String path) {
        super(diameter, diameter, path); // lake is a circle, so width and length are the same
        this.children = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name ;
    }

    //+  super.getPath().split("/")[super.getPath().split("/").length - 1];



    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
        for (Element element : children) {
            element.accept(visitor); // Then it visits the children
        }
    }

    @Override
    public boolean canContain(Element child) {
        if (child instanceof Flag) {
            return false;
        }
        return true;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }

    public void add(Element element) {
        // only add if the element is marine or amphibious
        if (element.getHabitat() == Habitat.TERRESTRIAL || element.getHabitat() == Habitat.AMPHIBIAN) {
            children.add(element);
        } else {
            System.out.println(element.getName() + " cannot be added to " + this.getName());
        }
    }

    public List<Element> getElements() {
        return children;
    }
}
