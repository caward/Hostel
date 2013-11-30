
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
		hostel.addBedroom(bed);
		hostelSys.addHostel(hostel);
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
	
	public void getBedTest()
	{
		if(!hostel.getBedroom(bed.getRoom(), bed.getBed(), bed.getDate()).equals(bed))
		{
			System.out.println("Error in getBed");
		}
	}
	
	public void getHostelTest()
	{
		if(!hostelSys.getHostel("Chicago").equals(hostel))
		{
			System.out.println("Error in getHostel");
		}
	}
	
	public void testSearch()
	{
		hostelSys.search("Chicago", 20140701, 20140702, 1);
		System.out.println("If no search found error");
	}
	
	public void testBooking()
	{
		hostelSys.book(1, 1);
		System.out.println("If booking made error");
	}
	
	public void runTest()
	{
		testDateFormat();
		generalSearch();
		getBedTest();
		getHostelTest();
		testSearch();
		testBooking();
	}
}
