
public class Bedroom {
	private int bed = 0;
	private int room = 0;
	private boolean available = true;
	private int price = 0;
	private int date=0;
	private String hostelName="";
	
	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getBed()
	{
		return bed;
	}
	
	public void setBed(int bed)
	{
		this.bed = bed;
	}
	
	public int getRoom()
	{
		return room;
	}
	
	public void setRoom(int room)
	{
		this.room = room;
	}
	
	public boolean isAvailable()
	{
		return available;
	}
	
	public void setAvailable(boolean available)
	{
		this.available = available;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	
	
	
}
