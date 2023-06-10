public abstract class PaperDecorator implements Paper {
    protected Paper paper;

    public PaperDecorator(Paper paper) {
        this.paper = paper;
    }

    public abstract String write();
}

class TableDecorator extends PaperDecorator {
    public TableDecorator(Paper paper) {
        super(paper);
    }

    public String write() {
        return paper.write() + " Table";
    }
}

class EquationDecorator extends PaperDecorator {
    public EquationDecorator(Paper paper) {
        super(paper);
    }

    public String write() {
        return paper.write() + " Equation";
    }
}

class DiagramDecorator extends PaperDecorator {
    public DiagramDecorator(Paper paper) {
        super(paper);
    }

    public String write() {
        return paper.write() + " Diagram";
    }
}

class NoteDecorator extends PaperDecorator {
    public NoteDecorator(Paper paper) {
        super(paper);
    }

    public String write() {
        return paper.write() + " Note";
    }
}
