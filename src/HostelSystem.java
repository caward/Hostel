import java.util.LinkedList;

public class HostelSystem 
{
	LinkedList<User> users;
	LinkedList<Hostel> hostels;
	
	
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
	
	public void book(String searchId, String userId)
	{
		
	}
	
	public void addUser()
	{
		
	}
	
	public void setHostels(LinkedList<Hostel> hostels)
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
