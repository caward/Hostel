import java.util.ArrayList;


public class HostelSystem 
{
	ArrayList<User> users=new ArrayList<User>();
	ArrayList<Hostel> hostels;//initialized in xml
	
	
	
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
