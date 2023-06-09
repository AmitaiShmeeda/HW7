public class LongPrintVisitor implements ElementVisitor {

    private StringBuilder printRes;

    public LongPrintVisitor() {
        printRes = new StringBuilder();
    }

    @Override
    public void visit(Boat boat) {
        printRes.append("A boat made of ").append(boat.getMaterial()).append(" material. ");
    }

    @Override
    public void visit(Kite kite) {
        printRes.append("A kite of color: ").append(kite.getColor()).append(". ");
    }

    @Override
    public void visit(Lake lake) {
        printRes.append("A lake named ").append(lake.getName()).append(" containing: ");

    }

    @Override
    public void visit(Island island) {
        printRes.append("An empty island named ").append(island.getName()).append(". ");
    }

    @Override
    public void visit(Flag flag) {
        // No specific information to print for the flag itself
    }

    @Override
    public void visit(Kid kid) {
        int age = 2023 - kid.getBirthYear(); // Assuming the current year is 2023
        printRes.append("A ").append(age).append(" year old kid with ").append(kid.getHairColor()).append(" hair. ");
    }

    @Override
    public void visit(Tree tree) {
        printRes.append("A tree with an amount of ").append(tree.getLeavesAmount()).append(" leaves. ");
    }

    public String longPrintSTR() {
        return printRes.toString().trim();
    }
}
