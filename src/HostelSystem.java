import java.util.ArrayList;


public class HostelSystem 
{
	ArrayList<User> users=new ArrayList<User>();
	ArrayList<Hostel> hostels = new ArrayList<Hostel>();
	ArrayList<Booking> bookings = new ArrayList<Booking>();
	private int revenue=0;
	
	public void clearAllSearches()
	{
		for(Hostel h:hostels)
		{
			h.clearSearches();
		}
	}
	
	public void addHostel(Hostel h)
	{
		hostels.add(h);
	}
	public int getRevenue()
	{
		return revenue;
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
		city = city.substring(1,city.length()-1);
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
		city = city.substring(1,city.length()-1);
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
		city = city.substring(1,city.length()-1);
		for(Hostel h:hostels)
		{
			if(h.getCity().equalsIgnoreCase(city))
			{
				h.realSearch2(startDate, endDate,beds);
			}
		}	
	}
	
	public void book(int searchId, int userId)
	{
		Search realSearch=null;
		if(isUser(userId))
		{
			User user = getUser(userId);
			if(user.isCreditCard())
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
					booking.addUser(user);
					booking.setCost(realSearch.getTotalCost());
					revenue+=realSearch.getTotalCost();
					bookings.add(booking);
					booking.print();
					clearAllSearches();
				}
				else
				{
					System.out.println("No search found");
				}
			}
			else
			{
				System.out.println("Please enter credit card information");
			}
		}
		else
		{
			System.out.println("No user found");
		}
		
	}
	
	
	public void addUser(String fname, String lname, String email)
	{
		User user = new User(fname,lname,email);
		users.add(user);
		user.toString();
	}
	
	public void addUser(String fname, String lname, String email,long credit,int date, int code,String phone)
	{
		User user = new User(fname,lname,email);
		user.setCreditCardNumber(credit);
		user.setExpirationDate(date);
		user.setSecurityCode(code);
		user.setPhone(phone);
		users.add(user);
		user.toString();
	}
	
	public User getUser(int userId)
	{
		for(User user:users)
		{
			if(user.getUserId()==userId)
			{
				return user;
			}
		}
		return null;
	}
	
	public void setHostels(ArrayList<Hostel> hostels)
	{
		this.hostels = hostels;
	}
	public boolean isUser(String email)
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

	public void cancel(int bookid)
	{
		
	}
	
	public void viewBooking(int bookid)
	{
		for(Booking book:bookings)
		{
			if(book.getBookingId()==bookid)
			{
				book.print();
				System.out.println();
			}
		}
	}
	
	public void changeUser(int userId, String fname, String lname,
			String email)
	{
		for(User user:users)
		{
			if(user.getUserId()==userId)
			{
				user.setFname(fname);
				user.setLname(lname);
				user.setEmail(email);
			}	
		}
	}
	
	public void changeUser(int userId, String fname, String lname,
			String email, long credit,int date, int code, String phone)
	{
		for(User user:users)
		{
			if(user.getUserId()==userId)
			{
				user.setFname(fname);
				user.setLname(lname);
				user.setEmail(email);
				user.setCreditCardNumber(credit);
				user.setExpirationDate(date);
				user.setSecurityCode(code);
				user.setPhone(phone);
			}	
		}
	}
	public void changeUser(int userId,long credit,int date, int code, String phone)
	{
		for(User user:users)
		{
			if(user.getUserId()==userId)
			{
				user.setCreditCardNumber(credit);
				user.setExpirationDate(date);
				user.setSecurityCode(code);
				user.setPhone(phone);
			}	
		}
	}
	public void viewUser(int userId)
	{
		for(User user:users)
		{
			if(user.getUserId()==userId)
			{
				user.toString();
			}	
		}
	}


	
	
}
