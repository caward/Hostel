import java.util.ArrayList;


public class HostelSystem 
{
	ArrayList<User> users=new ArrayList<User>();
	ArrayList<Hostel> hostels = new ArrayList<Hostel>();//initialized in xml
	ArrayList<Booking> bookings = new ArrayList<Booking>();
	
	
	public void addHostel(Hostel h)
	{
		hostels.add(h);
	}
	
	public ArrayList<Hostel> getHostels() {
		return hostels;
	}
	public boolean isUser(int id)
	{
		for(User user:users)
		{
			if(user.getUserId()==id){return true;}	
		}
		return false;
	}
	public void search()
	{
		for(Hostel h:hostels)
		{
			h.generalsearch();
		}
	}
	
	public void search(String city)
	{
		for(Hostel h:hostels)
		{
			if(h.getCity().equalsIgnoreCase(city))
			{
				h.generalsearch();
			}
			
		}
	}
	
	public void search(String city, int startDate, int endDate)
	{
		for(Hostel h:hostels)
		{
			if(h.getCity().equalsIgnoreCase(city))
			{
				h.availableSearch(startDate, endDate);
			}
			
		}
	}
	
	public void search(String city, int startDate, int endDate, int beds)
	{
		for(Hostel h:hostels)
		{
			if(h.getCity().equalsIgnoreCase(city))
			{
				h.realSearch(startDate, endDate,beds);
			}
		}	
	}
	
	public void book(int searchId, int userId)
	{
		Search realSearch=null;
		if(isUser(userId))
		{
			for(Hostel h:hostels)
			{
				ArrayList<Search> searches;
				searches = h.getSearches();
				for(Search s:searches)
				{
					if(s.getId() == searchId)
					{
						realSearch = s;
					}
				}
			}
			if(realSearch!=null)
			{
				Booking booking= new Booking();
				booking.setBeds(realSearch.getBeds());
				bookings.add(booking);
				booking
			}
			else
			{
				System.out.println("No search found");
			}
			
		}
		else
		{
			System.out.println("No user found");
		}
	}
	
	
	public void addUser()
	{
		
	}
	
	public void setHostels(ArrayList<Hostel> hostels)
	{
		this.hostels = hostels;
	}
	public boolean isCustomer(String email)
	{
		for(User u:users)
		{
			if(email.equalsIgnoreCase(u.getEmail()))
			{
				System.out.println("User already in system.");
				u.userInfo();
				return true;
			}
		}
		return false;
	}
	
}
