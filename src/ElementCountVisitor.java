public class ElementCountVisitor implements ElementVisitor {
    int count = 0;


    @Override
    public void visit(Boat boat) {
        count++;
    }

    @Override
    public void visit(Kite kite) {
        count++;
    }

    @Override
    public void visit(Lake lake) {
        count++;
    }

    @Override
    public void visit(Island island) {
        count++;
    }

    public void visit (Flag flag){
        count ++;
    }

    public void visit (Kid kid){
        count ++;
    }

    public void visit (Tree tree){
        count++;
    }

    public int getCount() {
        return count;
    }
}
