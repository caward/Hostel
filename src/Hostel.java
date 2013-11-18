import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Iterator;
import java.util.ListIterator;
public class Hostel {
	private String hostelName ="";
	private String street ="";
	private String city ="";
	private String state ="";
	private String postalCode ="";
	private String country ="";
	private String phone ="";
	private String email ="";
	private String facebook ="";
	private String web ="";
	private String checkInTime ="";
	private String checkOutTime ="";
	private String smoking ="";
	private String alcohol ="";
	ArrayList<Bedroom> bedrooms;
	
	public void setName(String name)
	{
		hostelName=name;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setPostalCode(String postal)
	{
		postalCode = postal;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setFacebook(String facebook)
	{
		this.facebook = facebook;
	}
	public void setWeb(String web)
	{
		this.web = web;
	}
	public void setCheckin(String checkIn)
	{
		this.checkInTime = checkIn;
	}
	public void setCheckOut(String checkOut)
	{
		this.checkOutTime = checkOut;
	}
	public void setSmoking(String smoking)
	{
		this.smoking = smoking;
	}
	public void setAlcohol(String alcohol)
	{
		this.alcohol = alcohol;
	}
	public String getName()
	{
		return hostelName;
	}
	public String getStreet()
	{
		return this.street;
	}
	public String getCity()
	{
		return this.city;
	}
	public String getState()
	{
		return this.state;
	}
	public String getPostalCode()
	{
		return postalCode;
	}
	public String getCountry()
	{
		return this.country;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getFacebook()
	{
		return this.facebook;
	}
	public String getWeb()
	{
		return this.web;
	}
	public String getCheckin()
	{
		return this.checkInTime;
	}
	public String getCheckOut()
	{
		return this.checkOutTime;
	}
	public String getSmoking()
	{
		return this.smoking;
	}
	public String getAlcohol()
	{
		return this.alcohol;
	}
	
	public void addBedroom(Bedroom bedroom)
	{
		bedrooms.add(bedroom);
	}
	
	public void sortBedrooms()
	{
		Bedroom[] beds = bedrooms.toArray(new Bedroom[bedrooms.size()]);
		beds=insertionSort(beds);
		bedrooms.clear();
		bedrooms.addAll(Arrays.asList(beds));
	}
	
	private Bedroom[] insertionSort(Bedroom[] bed)
	{
		int j;
		Bedroom b;
		for (int i = 1; i < bed.length; i++)
		{
			j = i;
			b = bed[i];
			while ((j > 0) && (bed[j-1].getDate() > b.getDate()))
			{
				bed[j] = bed[j-1];
				j--;
			}
			  bed[j] = b;
		}
		return bed;
	}
	
	public void generalsearch()
	{
		System.out.println(getName()+" "+getCity());
		ListIterator<Bedroom> litr = bedrooms.listIterator();
		int date=0;
		int min=0;
		int max = 0;
		int count=0;
		int tempPrice=0;
		Bedroom bed = litr.next();
		date=bed.getDate();
		min=bed.getPrice();
		max=bed.getPrice();
		count++;
		while(litr.hasNext())
		{
	         bed = litr.next();
	         if(bed.getDate()==date)
	         {
	        	 count++;		//Counts number of beds for a particular day
	        	 //Finds max and min bed prices for that day
	        	 tempPrice=bed.getPrice();
	        	 min = tempPrice<min ? tempPrice:min;
	        	 max = tempPrice>max ? tempPrice:max;
	         }
	         else
	         {
	        	 System.out.println(formatDate(date)+" to "+formatDate(date+1)+": "+count+" beds between $"+min+" and $"+max);
	        	 date = bed.getDate();
	        	 count = 1;
	        	 min = bed.getPrice();
	        	 max = bed.getPrice(); 	 
	         }
	     }
		System.out.println(formatDate(date)+" to "+formatDate(date+1)+": "+count+" beds between $"+min+" and $"+max);
	}
	
	public void availableSearch(int startDate, int endDate)
	{
		System.out.println(getName()+" "+getCity());
		ListIterator<Bedroom> litr = bedrooms.listIterator();
		int date=startDate;
		int min=0;
		int max = 0;
		int count=0;
		int tempPrice=0;
		Bedroom bed = litr.next();
		date=bed.getDate();
		min=bed.getPrice();
		max=bed.getPrice();
		count++;
		while(litr.hasNext())
		{
	         bed = litr.next();
	         if(bed.getDate()==date)
	         {
	        	 count++;		//Counts number of beds for a particular day
	        	 //Finds max and min bed prices for that day
	        	 tempPrice=bed.getPrice();
	        	 min = tempPrice<min ? tempPrice:min;
	        	 max = tempPrice>max ? tempPrice:max;
	         }
	         else
	         {
	        	 System.out.println(formatDate(date)+" to "+formatDate(date+1)+": "+count+" beds between $"+min+" and $"+max);
	        	 date = bed.getDate();
	        	 count = 1;
	        	 min = bed.getPrice();
	        	 max = bed.getPrice(); 	 
	         }
	     }
		System.out.println(formatDate(date)+" to "+formatDate(date+1)+": "+count+" beds between $"+min+" and $"+max);
		
	}
	
	private String formatDate(int i)
	{
		String date = String.valueOf(i);
		date= date.substring(4,6)+"/"+date.substring(6, 8)+"/"+date.substring(0, 4);
		return date;
	}
	
	
//	private String name ="";
	
//	private String name ="";
}
