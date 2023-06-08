 
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
       // System.out.println("element full name: " + element.getFullName());
       // System.out.println("element path: " + element.getPath());
        if (element.getPath().isEmpty()) {
            elementList.add(element);
            //System.out.println(element);
        } else {
            Element containingElement = pathToElementMap.get(element.getPath());
            if (containingElement.canContain(element)) {
                containingElement.addChild(element);
               // System.out.println(containingElement.getName() + " add chiled: " + element.getName());
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
