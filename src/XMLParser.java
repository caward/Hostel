import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.ArrayList;
import java.io.File;



public class XMLParser {
	
	static ArrayList<Hostel> hostels= new ArrayList<Hostel>();
	//public void parser()
	public static void main(String argv[])
	{
		try
		{
			File file = new File("src/hostel1.xml");
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
					System.out.println("City : " + tagInfo(element,"city",i));
					System.out.println("State : " + tagInfo(element,"state",i));
					System.out.println("Postal Code : " + tagInfo(element,"postal_code",i));
					System.out.println("Country : " + tagInfo(element,"country",i));
					System.out.println("Email : " + tagInfo(element,"email",i));
					System.out.println("Facebook : " + tagInfo(element,"facebook",i));
					System.out.println("website : " + tagInfo(element,"web",i));
					System.out.println("Checkin : " + tagInfo(element,"check_in_time",i));
					System.out.println("Checkout : " + tagInfo(element,"check_out_time",i));
					System.out.println("Smoking : " + tagInfo(element,"smoking",i));
					System.out.println("Alcohol : " + tagInfo(element,"alcohol",i));
					System.out.println("Deadline : " + tagInfo(element,"cancellation_deadline",i));
					System.out.println("Penalty : " + tagInfo(element,"cancellation_penalty",i));
					
					
					NodeList list2 = doc.getElementsByTagName("availability");
					for (int j = 0; j < list2.getLength(); j++)
					{
						//Bedroom bedroom = new Bedroom();
						Node node2= list2.item(j);
						System.out.println("\nCurrent Element :" + node2.getNodeName());

						if (node2.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element element2 = (Element) node;
							System.out.println("date : " + tagInfo(element2,"date",j));
							System.out.println("room : " + tagInfo(element2,"room",j));
							System.out.println("bed : " + tagInfo(element2,"bed",j));
							System.out.println("price : " + tagInfo(element2,"price",j));
						}
						//hostel.addBedroom(bedroom);
					}
				}
				//hostel.sortBedrooms();
				//hostels.add(hostel);
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
