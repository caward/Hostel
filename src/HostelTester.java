
public class HostelTester
{
	int date;
	HostelSystem hostelSys;
	Hostel hostel;
	Bedroom bed;
	public HostelTester()
	{
		hostelSys = new HostelSystem();
		date = 20140701;
		hostel = new Hostel();
		bed = new Bedroom();
		bed.setCity("Chicago");
		bed.setHostelName("IIT MSV");
		bed.setPrice(100);
		bed.setRoom(1);
		bed.setBed(1);
		bed.setAvailable(true);
		bed.setDate(date);
		hostel.setName("IIT MSV");
		hostel.setCity("Chicago");
		
		
	}
	
	public void testDateFormat()
	{
		Booking book = new Booking();
		
		if(!book.formatDate(date).equals("07/01/2014"))
		{
			System.out.println("Format date not working.");
		}
	}
	
	public void generalSearch()
	{
		System.out.println("Correct format should look like:\nIIT MSV Chicago\n07/01/2014 to 07/02/2014 1 bed between $10 and $10");
		hostel.generalsearch();
	}
}
