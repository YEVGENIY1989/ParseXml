import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXmlEmployee {

    private DocumentBuilderFactory mFactory;
    private DocumentBuilder mBuilder;
    private Document mDocument;
    private NodeList mEmployeeElements;

    private List<Employee>mEmployees;

    public ParseXmlEmployee() throws ParserConfigurationException, IOException, SAXException {
        mFactory = DocumentBuilderFactory.newInstance(); // делаем фабрику, для того чтоб получить билдер документов
        mBuilder = mFactory.newDocumentBuilder();   // получаем билдер, парсит XML, создает структуру Document в виде иерархического вида
        mDocument = mBuilder.parse(new File("employee.xml"));   // запарсили XML, создав структуру Document.  Есть доступ ко всем элементам , какие нам нужны
        mEmployees = new ArrayList<>();

        // Получаем список всех элементов employee внутри корнего элемента
        // getDocumentElement возвращает root элемент XML файла
        mEmployeeElements = mDocument.getDocumentElement().getElementsByTagName("employee");
    }

    public void classifyElement(){

        //Перебираем все элементы employee
        for(int i = 0; i < mEmployeeElements.getLength(); i++){
            //Берем каждый конкретный узел
            Node employee = mEmployeeElements.item(i);

            // Получение аттрибутов каждого конкретного элемента
            NamedNodeMap attributes = employee.getAttributes();
            // Получаем значение конкретного аттрибута с помощью метода getNodeValue()
            String id = attributes.getNamedItem("id").getNodeValue();
            mEmployees.add(new Employee(id, "", "",1,1));
        }

        for (Employee employee : mEmployees){
            System.out.println(employee.toString());
        }
    }


}
