 

public class Flag extends Element {

    Color color;
    int carrierHeight;

    public Flag(double width, double length, Color color, int carrierHeight, String path) {
        super(width, length, path);
        this.color = color;
        this.carrierHeight = carrierHeight;
    }

    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
    }

 
    public Color getColor() {
        return color;
    }

    public int getCarrierHeight() {
        return carrierHeight;
    }

    @Override
    public String getName() {
        return Flag.class.getSimpleName().toLowerCase();
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

    public int getPoleHeight() {
        return carrierHeight;
    }
}
