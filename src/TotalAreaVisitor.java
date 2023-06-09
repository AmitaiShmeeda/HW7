public class TotalAreaVisitor implements ElementVisitor{

    protected double total_area = 0;
    @Override
    public void visit(Boat boat) {
        double  radius = boat.width / 2;
        double  rectangle_len = boat.length - radius;
        double area_rectangle = rectangle_len * boat.width;
        double areaSemicircle = 0.5 * Math.PI * Math.pow(radius, 2);
        double area = area_rectangle + areaSemicircle;
        total_area += area;
    }

    @Override
    public void visit(Kite kite) {
        double areaKite = (kite.width * kite.length) ;
        total_area +=  areaKite;
    }

    @Override
    public void visit(Lake lake) {
        double areaCircle = Math.PI * Math.pow(lake.length/2, 2);
        total_area +=  areaCircle;

    }

    @Override
    public void visit(Island island) {
        double areaCircle = Math.PI * Math.pow(island.length/2, 2);
        total_area +=  areaCircle;
    }

    @Override
    public void visit(Flag flag) {
        total_area += (flag.length*flag.width);
    }

    @Override
    public void visit(Kid kid) {

        total_area += (kid.length-kid.width*2) * kid.width; // rectangle
        total_area += Math.PI * Math.pow(kid.width/2, 2); // circle
    }

    @Override
    public void visit(Tree tree) {
    total_area += tree.length *tree.width/2 * 1.5; // todo - its not clear what they mean ...
    }

    public double getTotal_area() {
        return total_area;
    }
}
