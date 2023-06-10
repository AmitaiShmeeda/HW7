public class TotalAreaVisitor implements ElementVisitor {

    private double totalArea;

    public TotalAreaVisitor() {
        totalArea = 0.0;
    }

    @Override
    public void visit(Boat boat) {
        double radius = boat.getWidth() / 2.0;
        double rectangleLen = boat.getLength() - radius;
        double areaRectangle = rectangleLen * boat.getWidth();
        double areaSemicircle = 0.5 * Math.PI * Math.pow(radius, 2);
        double area = areaRectangle + areaSemicircle;
        totalArea += area;
    }

    @Override
    public void visit(Kite kite) {
        double areaKite = kite.getWidth() * kite.getLength()/2;
        totalArea += areaKite;
    }

    @Override
    public void visit(Lake lake) {
        double areaCircle = Math.PI * Math.pow(lake.getLength() / 2.0, 2);
        totalArea += areaCircle;
    }

    @Override
    public void visit(Island island) {
        double areaCircle = Math.PI * Math.pow(island.getLength() / 2.0, 2);
        totalArea += areaCircle;
    }

    @Override
    public void visit(Flag flag) {
        double areaFlag = flag.getLength() * flag.getWidth();
        totalArea += areaFlag;
    }

    @Override
    public void visit(Kid kid) {
        double areaRectangle = (kid.getLength() - kid.getWidth()) * kid.getWidth();
        double areaCircle = Math.PI * Math.pow(kid.getWidth() / 2.0, 2);
        totalArea += (areaRectangle + areaCircle);
    }

    @Override
    public void visit(Tree tree) {
        totalArea += (tree.width/2.0 *tree.getLength());
    }

    public long getTotalArea() {
        return Math.round(totalArea);
    }
}
