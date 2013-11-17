import java.util.LinkedList;
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
	LinkedList<Bedroom> bedroom;
	
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
	
	
	
//	private String name ="";
	
//	private String name ="";
}
