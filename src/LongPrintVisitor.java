/*
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongPrintVisitor implements ElementVisitor {
    private StringBuilder stringBuilder;
    private Set<Element> visitedElements;

    public LongPrintVisitor() {
        this.stringBuilder = new StringBuilder();
        this.visitedElements = new HashSet<>();
    }

    public void visit(Element element) {
        if (!visitedElements.contains(element)) {
            visitedElements.add(element);
            element.accept(this);
        }
    }

    private void visitElements(List<Element> elements, String description) {
        if (!elements.isEmpty()) {
            stringBuilder.append(description).append(": ");
            for (int i = 0; i < elements.size(); i++) {
                Element childElement = elements.get(i);
                childElement.accept(this); // Use element's accept method
            }
            stringBuilder.append(". ");
        }
    }

    public String getLongPrintString() {
        return stringBuilder.toString();
    }

    @Override
    public void visit(Boat boat) {
        stringBuilder.append("A boat made of ").append(boat.getMaterial()).append(" material. ");
    }

    @Override
    public void visit(Kite kite) {
        stringBuilder.append("A kite of color: ").append(kite.getColor()).append(". ");
    }

    @Override
    public void visit(Lake lake) {
        stringBuilder.append("A lake named ").append(lake.getName()).append(" ");
        visitElements(lake.getChildren(), "containing");
    }

    @Override
    public void visit(Island island) {
        stringBuilder.append("An empty island named ").append(island.getName()).append(". ");
        visitElements(island.getChildren(), "containing");
    }

    @Override
    public void visit(Flag flag) {
        stringBuilder.append("A flag with color: ").append(flag.getColor())
                .append(", pole height: ").append(flag.getPoleHeight())
                .append(", width: ").append(flag.getWidth())
                .append(", length: ").append(flag.getLength()).append(". ");
    }

    @Override
    public void visit(Kid kid) {
        int age = java.time.LocalDate.now().getYear() - kid.getBirthYear();
        stringBuilder.append("A ").append(age).append(" year old kid with ")
                .append(kid.getHairColor()).append(" hair. ");
    }

    @Override
    public void visit(Tree tree) {
        stringBuilder.append("A tree with an amount of ").append(tree.getLeavesAmount()).append(" leaves. ");
    }
}
*/
public class LongPrintVisitor implements ElementVisitor {
    private StringBuilder output;

    public LongPrintVisitor() {
        this.output = new StringBuilder();
    }

    public String getOutput() {
        return output.toString();
    }

    @Override
    public void visit(Boat boat) {
        output.append("A boat made of ")
                .append(boat.getMaterial())
                .append(" material.")
                .append(" ");
    }

    @Override
    public void visit(Kite kite) {
        output.append("A kite of color: ")
                .append(kite.getColor())
                .append(".")
                .append(" ");
    }

    @Override
    public void visit(Lake lake) {
        output.append("A lake named ")
                .append(lake.getName())
                .append(" containing:");

        for (Element element : lake.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Island island) {
        output.append("An island named ")
                .append(island.getName())
                .append(" containing:");

        for (Element element : island.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Flag flag) {
        // Ignore terrestrial elements like flags in the lake
    }

    @Override
    public void visit(Kid kid) {
        output.append("A ")
                .append((2023 - kid.getBirthYear()))
                .append(" year old kid with ")
                .append(kid.getHairColor())
                .append(" hair.")
                .append(" ");
    }

    @Override
    public void visit(Tree tree) {
        output.append("A tree with an amount of ")
                .append(tree.getLeavesAmount())
                .append(" leaves.")
                .append(" ");
    }
}
