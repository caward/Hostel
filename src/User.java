import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {
//	private static int totalUsers=0;
	private static int userId = 0;
	private String fname="";
	private String lname="";
	private String email="";
	private String phone="";
	private long creditCardNumber=0;
	private int securityCode=0;
	private String expirationDate="";
	private String created="";
	
	public User(String fname, String lname, String email){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		userId+=1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		created = dateFormat.format(cal.getTime());
		userInfo();
	}
	
	public void userInfo() 
	{
		System.out.println("user_id: " +userId+"/n Name: "+fname+" "+lname+"/n Email: "+email+"/n Date Created: "+created);	
	}
	
	public int getUserId()
	{
		return userId;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public boolean isCreditCard()
	{
		return creditCardNumber!=0; 
	}
	
	
}
