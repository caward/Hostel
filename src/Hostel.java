import java.util.ArrayList;
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
	private int deadline=0;
	private String penalty="";
	ArrayList<Bedroom> bedrooms=new ArrayList<Bedroom>();
	ArrayList<Search> searches = new ArrayList<Search>();
	
	public void clearSearches()
	{
		searches.clear();
	}
	
	public ArrayList<Search> getSearches()
	{
		return searches;
	}
	
	public boolean isAvailable(int room, int bed, int date)
	{
		for(Bedroom b:bedrooms)
		{
			if(b.getBed()==bed&&b.getDate()==date&&b.getRoom()==room){return b.isAvailable();}
		}
		return false;
	}
	
	public void addToSearch(int days,int end,Search s)
	{
		int j=0;
		int done = 0;
		Bedroom b2;
		for(Bedroom b:bedrooms)
		{
			if(!isPresentInAnySearch(b.getRoom(),b.getBed()))
			{
				if(!s.contains(b.getBed(), b.getRoom()))//check if bedroom is in search			
				{
					for(int i =0; i<days; i++)//checks to see if room is available for duration of stay
					{

						b2=getBedroom(b.getRoom(),b.getBed(), b.getDate()+i);
						if(b2!=null&&b2.getDate()<end)
						{
							if(b2.isAvailable()){j++;}
						}
					}

				}
				if(j==days&&done==0)//if available for duration add to search
				{
					Bedroom b1;
					while(j!=0)
					{
						b1=getBedroom(b.getRoom(),b.getBed(), b.getDate()+j-1);
						s.add(b1);
						j--;
					}
					done=1;
				}
			}
		}
	}
	
	public void realSearch2(int start, int end, int numbed)
	{
		searches.clear();
		int count = end-start;
		for(int j=0;j<bedrooms.size();j++)
//		for(Bedroom b:bedrooms)
		{
			Search s = new Search();
			for(int i = 0; i<numbed;i++)
			{

				addToSearch(count,end,s);
			}
			if(s.getBeds().size()==(numbed*count))
			{
				searches.add(s);
			}
		}
		printSearches(start,count);
	}
	
	public void printSearches(int date, int count)
	{
		System.out.println(getName()+" "+getCity());
		if(searches.isEmpty())
		{ 
			System.out.println("No Sorry, not enough beds available on " +formatDate(date));
		}
		else
		{
			ArrayList<Bedroom> bList;
			for (Search s:searches)
			{
				if(s!=null)
				{
					bList = s.getBeds();
					System.out.print("search_id:"+s.getId()+", $"+s.getTotalCost()+", rooms ");
					for(int i = 0; i < bList.size(); i++)
					{
//						if()
						System.out.print("#"+bList.get(i).getRoom()+" ");	
					}
					System.out.println();
				}
			}
		}
	}
	public boolean isPresentInAnySearch(int room, int bed)
	{
		for(Search s:searches)
		{
			if(s.contains(bed,room)){return true;}
		}
		return false;
	}
	
	public Bedroom getBedroom(int room, int bed, int date)
	{
		for(Bedroom b:bedrooms)
		{
			if(b.getBed()==bed&&b.getDate()==date&&b.getRoom()==room){return b;}
		}
		return null;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public String getPenalty() {
		return penalty;
	}
	public void setPenalty(String penalty)
	{
		this.penalty = penalty;
	}
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
		System.out.println();
	}
	
	public void availableSearch(int startDate, int endDate)
	{
		System.out.println(getName()+" "+getCity());
		ListIterator<Bedroom> litr = bedrooms.listIterator();
		int date=startDate;
		int min=1000000;
		int max = 0;
		int count=0;
		int tempPrice=0;
		int done = 0;
		Bedroom bed; //= litr.next();
//		date=bed.getDate();
//		min=bed.getPrice();
//		max=bed.getPrice();
		
		while(litr.hasNext())//loops to correct date
		{
	         bed = litr.next();
	         if(bed.getDate()==date)
	         {		
	        	bed = litr.previous();//first correct date
	        	 while(litr.hasNext())
	        	 {
	        		 bed = litr.next();
	        		 if(bed.getDate()==date)//check if this bed has the date needed
	        		 {
	        			 if(bed.isAvailable()==true)//sees if bed is available
	        			 {
	        				 count++;		//Counts number of beds for a particular day
	        				 //Finds max and min bed prices for that day
	        				 tempPrice=bed.getPrice();
	        				 min = tempPrice<min ? tempPrice:min;
	        				 max = tempPrice>max ? tempPrice:max;
	        			 }
	        		 }
	        		 else//if bed date and date don't match all beds for that particular day have been counted and will be printed
	        		 {
	        			 if(date!=0)//if date is zero no need to print anything
	        			 {
	        				 if(count==0)
	        				 {
	        					 System.out.println(formatDate(date)+" to "+formatDate(date+1)+": No beds available");
	        				 }
	        				 else
	        				 {
	        					 System.out.println(formatDate(date)+" to "+formatDate(date+1)+": "+count+" available "+ (count==1?"bed":"beds") +" between $"+min+" and $"+max);
	        				 }
	        				 date = bed.getDate();//change date for next day
	        				 if(date>=endDate)//if endDate reached, stop and print out last listing
	        				 {
	        					 done=1;
	        					 date=0;
	        				 }
	        				 else
	        				 {
	        					 count = 1;
	        					 min = bed.getPrice();
	        					 max = bed.getPrice();
	        				 } 
	        			 }	 
	        		 }
	        	 }if(done==0)
	        	 {
	        		 System.out.println(formatDate(date)+" to "+formatDate(date+1)+": "+count+" available "+(count==1?"bed":"beds")+" between $"+min+" and $"+max);
	        	}
	         }
	    }
	}
	
	private String formatDate(int i)
	{
		String date = String.valueOf(i);
		date= date.substring(4,6)+"/"+date.substring(6)+"/"+date.substring(0, 4);
		return date;
	}
	
}
