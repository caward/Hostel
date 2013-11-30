import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.ArrayList;
import java.io.File;

public class XMLParser {
	
	static ArrayList<Hostel> hostels= new ArrayList<Hostel>();
	Hostel hostel;
	
	//Parses xml file
	public void load(String path, HostelSystem hostelSys)
	{
		try
		{
			File file = new File(path);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getElementsByTagName("hostel");

			for (int i = 0; i < list.getLength(); i++)
			{
				Hostel hostel = new Hostel();
				Node node = list.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element element = (Element) node;
					
					hostel.setName(tagInfo(element,"name",i));
					
					hostel.setStreet(tagInfo(element,"street",i));		
					
					hostel.setPhone(tagInfo(element,"phone",i));
					
					hostel.setCity(tagInfo(element,"city",i));
					
					hostel.setState(tagInfo(element,"state",i));
					
					hostel.setPostalCode(tagInfo(element,"postal_code",i));
					
					hostel.setCountry(tagInfo(element,"country",i));
					
					hostel.setEmail(tagInfo(element,"email",i));
					
					hostel.setFacebook(tagInfo(element,"facebook",i));
					
					hostel.setWeb(tagInfo(element,"web",i));
					
					hostel.setCheckin(tagInfo(element,"check_in_time",i));
					
					hostel.setCheckOut(tagInfo(element,"check_out_time",i));
					
					hostel.setSmoking(tagInfo(element,"smoking",i));
					
					hostel.setAlcohol(tagInfo(element,"alcohol",i));
					
					hostel.setDeadline(Integer.parseInt(tagInfo(element,"cancellation_deadline",i)));
					
					hostel.setPenalty(tagInfo(element,"cancellation_penalty",i));;
									
					NodeList list2 = doc.getElementsByTagName("availability");
					for (int j = 0; j < list2.getLength(); j++)
					{
						Bedroom bedroom = new Bedroom();
						Node node2= list2.item(j);
						if (node2.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element element2 = (Element) node;
							bedroom.setDate(Integer.parseInt(tagInfo(element2,"date",j)));
							bedroom.setRoom(Integer.parseInt(tagInfo(element2,"room",j)));
							bedroom.setBed(Integer.parseInt(tagInfo(element2,"bed",j)));
							bedroom.setPrice(Integer.parseInt(tagInfo(element2,"price",j)));
						}
						bedroom.setHostelName(hostel.getName());
						bedroom.setCity(hostel.getCity());
						hostel.addBedroom(bedroom);						
					}
					hostelSys.addHostel(hostel);
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
