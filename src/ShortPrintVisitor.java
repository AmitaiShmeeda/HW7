public class ShortPrintVisitor implements ElementVisitor {

    private StringBuilder printRes;

    public ShortPrintVisitor() {
        printRes = new StringBuilder();
    }

    @Override
    public void visit(Boat boat) {
        printRes.append(boat.getFullName()).append("\n");
    }

    @Override
    public void visit(Kite kite) {
        printRes.append(kite.getFullName()).append("\n");
    }

    @Override
    public void visit(Lake lake) {
        printRes.append(lake.getFullName()).append("\n");
    }

    @Override
    public void visit(Island island) {
        printRes.append(island.getFullName()).append("\n");
    }

    @Override
    public void visit(Flag flag) {
        // No specific information to print for the flag itself
    }

    @Override
    public void visit(Kid kid) {
        printRes.append(kid.getFullName()).append("\n");
    }

    @Override
    public void visit(Tree tree) {
        printRes.append(tree.getFullName()).append("\n");
    }

    public String shortPrintSTR() {
        return printRes.toString().trim();
    }
}
