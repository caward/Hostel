import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.LinkedList;
import java.io.File;


public class XMLParser {
	
	LinkedList<Hostel> hostels;
	//public void parser()
	public static void main(String argv[])
	{
		try
		{
			File file = new File("src/hostel.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList list = doc.getElementsByTagName("hostel");

			System.out.println("----------------------------");

			for (int i = 0; i < list.getLength(); i++)
			{
				//Hostel hostel = new Hostel();
				Node node = list.item(i);

				System.out.println("\nCurrent Element :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element element = (Element) node;

					System.out.println("HostelName : " + tagInfo(element,"name",i) );
					System.out.println("Street : " + tagInfo(element,"street",i));
					System.out.println("phone: " + tagInfo(element,"phone",i));
					System.out.println("room : " + tagInfo(element,"city",i));
					System.out.println("room : " + tagInfo(element,"state",i));
					System.out.println("room : " + tagInfo(element,"postal_code",i));
					System.out.println("room : " + tagInfo(element,"country",i));
					System.out.println("room : " + element.getElementsByTagName("email").item(i).getTextContent());
					System.out.println("room : " + element.getElementsByTagName("facebook").item(i).getTextContent());
					System.out.println("room : " + element.getElementsByTagName("web").item(i).getTextContent());
					System.out.println("room : " + element.getElementsByTagName("check_in_time").item(i).getTextContent());
					System.out.println("room : " + element.getElementsByTagName("check_out_time").item(i).getTextContent());
					System.out.println("room : " + element.getElementsByTagName("smoking").item(i).getTextContent());
					System.out.println("room : " + element.getElementsByTagName("alcohol").item(i).getTextContent());
					
					
					NodeList list2 = doc.getElementsByTagName("availability");
					for (int j = 0; j < list2.getLength(); j++)
					{
						Node node2= list2.item(j);
						System.out.println("\nCurrent Element :" + node2.getNodeName());

						if (node2.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element element2 = (Element) node;
							System.out.println("date : " + element2.getElementsByTagName("date").item(j).getTextContent());
							System.out.println("room : " + element2.getElementsByTagName("room").item(j).getTextContent());
							System.out.println("bed : " + element2.getElementsByTagName("bed").item(j).getTextContent());
							System.out.println("price : " + element2.getElementsByTagName("price").item(j).getTextContent());
						}
					}
				}
			}
		} catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	}
	private static String tagInfo(Element element, String info, int index)
	{
		return element.getElementsByTagName(info).item(index).getTextContent();
	}
	 

}
