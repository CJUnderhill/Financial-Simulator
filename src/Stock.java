import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.io.File;

public class Stock implements Investment {

	private String type = "Stock";	// Could be char code instead?
	
	
	void parseInfo(File file){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
