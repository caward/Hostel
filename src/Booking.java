import java.util.ArrayList;

public class Booking
{
	ArrayList<Bedroom> beds;
	User user;
	private static int bkId=0;
	private int price = 0;
	private int bk_id;
	private String status; 
	
	public Booking()
	{
		bk_id=bkId ++;
		status = "Ordered";
	}

	public ArrayList<Bedroom> getBeds() {
		return beds;
	}
	
	//Takes in array of beds
	public void setBeds(ArrayList<Bedroom> beds) {
		this.beds = beds;
		for(Bedroom b:this.beds)
		{
			b.setAvailable(false);
		}
	}
	public int getBookingId()
	{
		return bk_id;
	}
	
	public void setCost(int cost)
	{
		price=cost;
	}
	
	public int getCost()
	{
		return price;
	}
	
	public void addUser(User user1)
	{
		user = user1;
	}
	
	//Prints booking information
	public void print()
	{
		System.out.println("Booking successful! Here's the detail of your booking:");
		System.out.println(beds.get(0).getHostelName()+", " +beds.get(0).getCity());
		System.out.println("Check-in date: "+formatDate(beds.get(0).getDate()));
		System.out.println("Check-out date: "+formatDate(beds.get(beds.size()-1).getDate()+1));
		int numBeds = beds.size()/(beds.get(beds.size()-1).getDate()+1-beds.get(0).getDate());
		System.out.println("Beds: "+numBeds);
		System.out.println("Booking ID: "+ bk_id);
		System.out.println("Name: "+user.getFname()+" "+user.getLname());
		System.out.println("Price: $"+price);
		System.out.println("Status: "+status);
	}
	public String getStatus() {
		return status;
	}
	
	//Returns number of beds in booking
	public int getBedNum()
	{
		return beds.size()/(beds.get(beds.size()-1).getDate()+1-beds.get(0).getDate());
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	//Formats the date
	public String formatDate(int i)
	{
		String date = String.valueOf(i);
		date= date.substring(4,6)+"/"+date.substring(6)+"/"+date.substring(0, 4);
		return date;
	}
}
