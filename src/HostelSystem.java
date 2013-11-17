import java.util.LinkedList;

public class HostelSystem 
{
	LinkedList<User> users;
	LinkedList<Hostel> hostels;
	
	
	public void search()
	{
		for(Hostel h:hostels)
		{
			System.out.println(h.getName()+" "+h.getCity());
			h.generalsearch();
		}
	}
	
	public void book(String searchId, String userId)
	{
		
	}
	
	public void addUser()
	{
		
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
