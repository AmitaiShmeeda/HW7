public class LongPrintVisitor implements ElementVisitor{

    String printRes = "";
    @Override
    public void visit(Boat boat) {
        printRes +=  " ,";

    }

    @Override
    public void visit(Kite kite) {
        printRes +=  " ,";

    }

    @Override
    public void visit(Lake lake) {
        printRes +=" ,";

    }

    @Override
    public void visit(Island island) {
        printRes +=  " ,";

    }

    @Override
    public void visit(Flag flag) {
        printRes +=  " ,";

    }

    @Override
    public void visit(Kid kid) {
        printRes += " ,";

    }

    @Override
    public void visit(Tree tree) {
        printRes +=" ,";

    }

    public String longtPrintSTR()
    {
        return this.printRes;
    }
}
