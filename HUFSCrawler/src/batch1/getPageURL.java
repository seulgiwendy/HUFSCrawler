package batch1;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.ArrayList;


 
 
public class getPageURL{
    static ArrayList<String> getURL(String result) throws Exception {
    	
    	ArrayList <String> resultList = new ArrayList<>();
    	
    	
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	
    	InputStream is = new ByteArrayInputStream(result.getBytes());

    	Document doc = dBuilder.parse(is);
    	doc.getDocumentElement().normalize();
    	Element newElement = doc.getDocumentElement();
    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    	  NodeList nList = newElement.getElementsByTagName("link");
    	  System.out.println("-----------------------");
    	  
    	  int n = nList.getLength();
    	  for (int i = 1; i < n; i++){
    		  Node nItem = nList.item(i);
    		  Node linkResult = nItem.getFirstChild();
    		  //System.out.println(linkResult.getNodeValue());
    		  resultList.add(linkResult.getNodeValue());
    		  
    	  }
    	  System.out.println("-----------------------");
		  System.out.println("검색 결과: " + (n - 1) + "개");
       return resultList;
}
}


