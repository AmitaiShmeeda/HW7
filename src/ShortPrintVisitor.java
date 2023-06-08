public class ShortPrintVisitor implements ElementVisitor {

    String printRes = "";
    @Override
    public void visit(Boat boat) {
        printRes += boat.getName() + " ,";

    }

    @Override
    public void visit(Kite kite) {
        printRes += kite.getName() + " ,";

    }

    @Override
    public void visit(Lake lake) {
        printRes += lake.getName() + " ,";

    }

    @Override
    public void visit(Island island) {
        printRes += island.getName() + " ,";

    }

    @Override
    public void visit(Flag flag) {
        printRes += flag.getName() + " ,";

    }

    @Override
    public void visit(Kid kid) {
        printRes += kid.getName() + " ,";

    }

    @Override
    public void visit(Tree tree) {
        printRes += tree.getName() + " ,";

    }

    public String shortPrintSTR()
    {
        return this.printRes;
    }

}
