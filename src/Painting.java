 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;
    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }




    public void addElement(Element element) {
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()) {
            elementList.add(element);
        } else {
            Element containingElement = pathToElementMap.get(element.getFullName());
            if (containingElement.canContain(element)) {
                containingElement.addChild(element);
            } else {
                System.out.println(containingElement.getName() + " cannot contain " + element.getName());
            }
        }
    }


    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }

    public void accept(ElementVisitor visitor) {
        for (Element element : elementList) {
            element.accept(visitor);
        }
    }


}
