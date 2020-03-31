import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXmlCurrency {

    private DocumentBuilderFactory mFactory;
    private DocumentBuilder mBuilder;
    private Document mDocument;
    private NodeList mcurrencyElement;
    private List<ValueCurs> mValueCurs;

   public ParseXmlCurrency() throws ParserConfigurationException, IOException, SAXException {
       mFactory = DocumentBuilderFactory.newInstance(); // делаем фабрику, для того чтоб получить билдер документов
       mBuilder = mFactory.newDocumentBuilder();   // получаем билдер, парсит XML, создает структуру Document в виде иерархического вида
       mDocument = mBuilder.parse(new File("currensy.xml"));   // запарсили XML, создав структуру Document.  Есть доступ ко всем элементам , какие нам нужны

      mValueCurs = new ArrayList<>();

       // Получаем список всех элементов employee внутри корнего элемента
       // getDocumentElement возвращает root элемент XML файла
       mcurrencyElement = mDocument.getDocumentElement().getElementsByTagName("Valute");

       mDocument.getDocumentElement().getAttribute("Date"); // получаем текущую дату

       classifyElement();
   }


    public void classifyElement(){
        Node testNode = mDocument.getParentNode();

        //Перебираем все элементы employee
        for(int i = 0; i < mcurrencyElement.getLength(); i++){
            //Берем каждый конкретный узел
            Node currency = mcurrencyElement.item(i);

           /* // Получение аттрибутов каждого конкретного элемента
            NamedNodeMap attributes = currency.getAttributes();
            // Получаем значение конкретного аттрибута с помощью метода getNodeValue()
            String id = attributes.getNamedItem("ID").getNodeValue();
            String code = attributes.getNamedItem("CharCode").getNodeValue();
            Integer nominal = Integer.parseInt(attributes.getNamedItem("Nominal").getNodeValue());
            String name = attributes.getNamedItem("Name").getNodeValue();
            Double value = Double.parseDouble(attributes.getNamedItem("Value").getNodeValue());*/

            Element element = (Element) currency; // получем элемент


            // Получаем значение конкретного аттрибута с помощью метода getNodeValue()
            String id = element.getAttributes().getNamedItem("ID").getNodeValue();
            String code = element.getElementsByTagName("CharCode").item(0).getChildNodes().item(0).getNodeValue();
            Integer nominal = Integer.parseInt(element.getElementsByTagName("Nominal").item(0).getChildNodes().item(0).getNodeValue());
            String name =  element.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue();
            String value = element.getElementsByTagName("Value").item(0).getChildNodes().item(0).getNodeValue();

            mValueCurs.add(new ValueCurs(id,code, nominal, name, value));
        }

      /*  for(ValueCurs valueCurs : mValueCurs){
            System.out.println(valueCurs.getValue());
        }*/
    }

    public ArrayList<ValueCurs> getValueCurs(){
       return  (ArrayList) mValueCurs;
    }

}
