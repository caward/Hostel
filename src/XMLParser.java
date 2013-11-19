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
				Hostel hostel = new Hostel();
				Node node = list.item(i);

				System.out.println("\nCurrent Element :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element element = (Element) node;

					
					hostel.setName(tagInfo(element,"name",i));
					System.out.println("HostelName : " + hostel.getName() );
					
					hostel.setStreet(tagInfo(element,"street",i));					
					System.out.println("Street : " + hostel.getStreet());
					
					hostel.setPhone(tagInfo(element,"phone",i));
					System.out.println("phone: " +hostel.getPhone());
					
					hostel.setCity(tagInfo(element,"city",i));
					System.out.println("City : "+hostel.getCity());
					
					hostel.setState(tagInfo(element,"state",i));
					System.out.println("State : "+hostel.getState());
					
					hostel.setPostalCode(tagInfo(element,"postal_code",i));
					System.out.println("Postal Code : " + hostel.getPostalCode());
					
					hostel.setCountry(tagInfo(element,"country",i));
					System.out.println("Country : " + hostel.getCountry());
					
					hostel.setEmail(tagInfo(element,"email",i));
					System.out.println("Email : " + hostel.getEmail());
					
					hostel.setFacebook(tagInfo(element,"facebook",i));
					System.out.println("Facebook : " + hostel.getFacebook());
					
					hostel.setWeb(tagInfo(element,"web",i));
					System.out.println("website : " + hostel.getWeb());
					
					hostel.setCheckin(tagInfo(element,"check_in_time",i));
					System.out.println("Checkin : " + hostel.getCheckin());
					
					hostel.setCheckOut(tagInfo(element,"check_out_time",i));
					System.out.println("Checkout : " + hostel.getCheckOut());
					
					hostel.setSmoking(tagInfo(element,"smoking",i));
					System.out.println("Smoking : " + hostel.getSmoking());
					
					hostel.setAlcohol(tagInfo(element,"alcohol",i));
					System.out.println("Alcohol : " + hostel.getAlcohol());
					
					hostel.setDeadline(Integer.parseInt(tagInfo(element,"cancellation_deadline",i)));
					System.out.println("Deadline : " + hostel.getDeadline());
					
					hostel.setPenalty(tagInfo(element,"cancellation_penalty",i));;
					System.out.println("Penalty : " + hostel.getPenalty());
					
					
					NodeList list2 = doc.getElementsByTagName("availability");
					for (int j = 0; j < list2.getLength(); j++)
					{
						Bedroom bedroom = new Bedroom();
						Node node2= list2.item(j);
						System.out.println("\nCurrent Element :" + node2.getNodeName());

						if (node2.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element element2 = (Element) node;
							bedroom.setDate(Integer.parseInt(tagInfo(element2,"date",j)));
							System.out.println("date : " + bedroom.getDate() );
							bedroom.setRoom(Integer.parseInt(tagInfo(element2,"room",j)));
							System.out.println("room : " + bedroom.getRoom());
							bedroom.setBed(Integer.parseInt(tagInfo(element2,"bed",j)));
							System.out.println("bed : " + bedroom.getBed());
							bedroom.setPrice(Integer.parseInt(tagInfo(element2,"price",j)));
							System.out.println("price : " + bedroom.getPrice());
						}
						hostel.addBedroom(bedroom);
					}
				}
				hostel.generalsearch(); //Remove later
				hostel.availableSearch(20140704, 20140705);//remove later
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
