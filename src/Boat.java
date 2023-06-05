 

public class Boat extends Element{
    Material material;
    public Boat(double width, double length, Material m, String path) {
        super(width, length, path);
        this.material=m;
    }
    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
    }
    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return "boat";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }
}
