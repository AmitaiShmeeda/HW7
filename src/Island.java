import java.util.ArrayList;
import java.util.List;

public class Island extends Element {
    //protected List<Element> elements;
    protected String name ;

    public Island(String name, double diameter, String path) {
        super(diameter, diameter, path); // island is a circle, so width and length are the same
        this.children = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String getName() {
        //return name + super.getPath().split("/")[super.getPath().split("/").length - 1];
        return this.name;
    }


    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);  // The visitor visits the current element first
        for (Element element : children) {
            //System.out.println("xx "+ element);
            element.accept(visitor); // Then it visits the children
        }
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

    public void add(Element element) {
        // only add if the element is terrestrial or amphibious
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



