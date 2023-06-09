
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "p: Papers");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }


    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();
        //Map<String, Element> files = new HashMap();

        Files.lines(Paths.get(path))
                .map(ElementDetailsFactory::getPaintingElement)
                .forEach(painting::addElement);
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path=scanner.nextLine();
        //System.out.println(path);
        Painting root= readElementDetails(path);

        // initialize visitors
        ElementCountVisitor countVisitor = new ElementCountVisitor();
        ShortPrintVisitor shortPrintVisitor = new ShortPrintVisitor();
        TotalAreaVisitor totalAreaVisitor = new TotalAreaVisitor();
        LongPrintVisitor longPrintVisitor = new LongPrintVisitor();


        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    // use count visitor
                    root.accept(countVisitor);
                    System.out.println(countVisitor.getCount());
                    break;
                case "sh":
                    root.accept(shortPrintVisitor);
                    System.out.println(shortPrintVisitor.shortPrintSTR());

                    break;
                case "ta":
                    root.accept(totalAreaVisitor);
                    System.out.println(totalAreaVisitor.getTotalArea());
                    break;
                case "lp":
                    root.accept(longPrintVisitor);
                    System.out.println(longPrintVisitor.longPrintSTR());
                    break;


            }

        }
    }

    public static void paperMenu(Scanner scanner) {
        System.out.println("Choose from the following papers:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "jr: journal article\n" +
                "bk: book");

        Paper paper = null;
        String choice = "";
        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());
            }
        }
    }




    public static Paper paperElementMenu(Scanner scanner, Paper paper) {
        System.out.println("Choose from the following elements:\n" +
                "tb: table\n" +
                "eq: equation\n" +
                "d: diagram\n" +
                "nt: note");

        String choice = scanner.nextLine();
        while (!choice.equals("s")) {
            if (choice.equals("tb")) {
                paper = new TableDecorator(paper);
            } else if (choice.equals("eq")) {
                paper = new EquationDecorator(paper);
            } else if (choice.equals("d")) {
                paper = new DiagramDecorator(paper);
            } else if (choice.equals("nt")) {
                paper = new NoteDecorator(paper);
            }

            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                System.out.println("Choose from the following elements:\n" +
                        "tb: table\n" +
                        "eq: equation\n" +
                        "d: diagram\n" +
                        "nt: note");
                choice = scanner.nextLine();
            }
        }

        return paper;
    }



}
