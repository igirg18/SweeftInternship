import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CurrencyCalculator {
    private static final String URL = "http://www.nbg.ge/rss.php";

    // returns string representation of xml that is inside CDATA tag
    private String getMainData(Element e){
        CharacterData data = (CharacterData) e.getChildNodes().item(0);
        return data.getData();
    }

    // parses data inside single <tr> tag
    private void updateMap(String specificCurrencyXML, Map<String, Double> result){
        //get first column value
        int startIndex = specificCurrencyXML.indexOf("<td>");
        int endIndex = specificCurrencyXML.indexOf("</td>", startIndex);
        String currencyName = specificCurrencyXML.substring(startIndex+4, endIndex);

        //get second column
        startIndex = specificCurrencyXML.indexOf("<td>", endIndex);
        endIndex = specificCurrencyXML.indexOf("</td>", startIndex);
        int amount = Integer.parseInt(specificCurrencyXML.substring(startIndex+4, endIndex).split(" ")[0]);
        //get third column value

        startIndex = specificCurrencyXML.indexOf("<td>", endIndex);
        endIndex = specificCurrencyXML.indexOf("</td>", startIndex);
        Double currency = Double.parseDouble(specificCurrencyXML.substring(startIndex+4, endIndex))/amount;
        result.put(currencyName, currency);
    }

    // parses <![CDATA [ ... ]]> segment
    private Map<String, Double> parseXMLString(String xml){
        Map <String, Double> result = new HashMap<>();
        int startIndex = xml.indexOf("<tr>");
        while (startIndex != -1) {
            int endIndex = xml.indexOf("</tr>", startIndex);
            String subStr = xml.substring(startIndex + 4, endIndex);
            updateMap(subStr, result);
            startIndex = xml.indexOf("<tr>", endIndex);
        }
        result.put("GEL", 1.0);
        return result;
    }

    public Double exchangeRate(String from, String to){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(URL).openStream());
            doc.getDocumentElement().normalize();
            Element e = (Element) doc.getElementsByTagName("description").item(1);
            String dataToParse = getMainData(e);
            Map <String, Double> currencies = parseXMLString(dataToParse);
            Double fromValue = currencies.get(from);
            Double toValue = currencies.get(to);
            return fromValue / toValue;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.out.println("smth happened. calculation failed !!!");
        }
        return 0.;
    }

    public static void main(String[] args) {
        CurrencyCalculator cc = new CurrencyCalculator();
        System.out.println(cc.exchangeRate("GEL", "USD"));
        System.out.println(cc.exchangeRate("AED", "AMD"));
        System.out.println(cc.exchangeRate("EUR", "GEL"));
    }
}
