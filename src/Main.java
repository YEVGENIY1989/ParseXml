import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        /*ParseXmlEmployee pxe = new ParseXmlEmployee();
        pxe.classifyElement();*/
       /* URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("currensy.xml");
        fos.getChannel().transferFrom(rbc, 0,Long.MAX_VALUE);*/
       ParseXmlCurrency pxc = new ParseXmlCurrency();
       LogicWorkConverter lwc = new LogicWorkConverter(pxc);
       lwc.calculateCurrency();
    }

}
