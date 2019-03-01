package Chapter18_IO.xml;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

import java.util.ArrayList;

/**
 *
 */
public class People extends ArrayList<Person> {

    public People(String fileName) throws Exception {
        Document doc = new Builder().build(fileName);
        Elements elements =
                doc.getRootElement().getChildElements();
        for(int i = 0; i < elements.size(); i++)
            add(new Person(elements.get(i)));
    }

    public static void main(String[] args) throws Exception {
        People p = new People("People.xml");
        System.out.println(p);
    }
}
