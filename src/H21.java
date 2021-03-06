///////////////////////////////////////////////////////////////////////////////
// Title:            h21
// Files:            User.java, Booking.java, Search.java, XMLParser.java
//					 HotelSystem.java, Bedroom.java, Hostel.java
// Semester:         CS445 Fall 2013
//
// Author:           Corey Ward
// Email:            cward3@hawk.iit.edu
// CS Login:         cward3
// Lecturer's Name:  Virgil Bistriceanu
///////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class H21 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		HostelSystem hostelSys = new HostelSystem();
		ArrayList<String> token = new ArrayList<String>();
		XMLParser parser = new XMLParser();
		String line = "";
		String regex= "\"([^\"]*)\"|(\\S+)";
		Scanner stdin = new Scanner(System.in);
		Matcher m;
		String[] tokens;
		
		System.out.println("Command List");
		System.out.println("h21 admin --load");
		System.out.println("h21 admin revenue");
		System.out.println("h21 admin occupancy");
		System.out.println("h21 search");
		System.out.println("h21 search --city");
		System.out.println("h21 search --city --start_date --end_date");
		System.out.println("h21 search --city --start_date --end_date --beds");		
		System.out.println("h21 book add --search_id --user_id");
		System.out.println("h21 book cancel --booking_id");
		System.out.println("h21 book view --booking_id");
		System.out.println("h21 user add --first_name --last_name --email");
		System.out.println("h21 user add --first_name --last_name --email --cc_number --expiration_date --security_code --phone");
		System.out.println("h21 user change --user_id --first_name --last_name --email");
		System.out.println("h21 user change --user_id --first_name --last_name --email --cc_number --expiration_date --security_code --phone");
		System.out.println("h21 user change --user_id --cc_number --expiration_date --security_code --phone");
		System.out.println("h21 email_user --message \"Put message in double quotes\"");
		System.out.println("Enter: h21 admin --load src/hostel1.xml");
		System.out.println();
		while(hostelSys.getHostels().isEmpty())
		{
			token.clear();
			System.out.println("No hostels Loaded. ENTER:");
			System.out.println("h21 admin --load FILEPATH");
			line=stdin.nextLine();
			m = Pattern.compile(regex).matcher(line);
			while(m.find())
			{
				token.add(m.group(0));
			}
			tokens=token.toArray(new String[token.size()]);
			if(tokens[0].equalsIgnoreCase("h21"))
			{
				if(tokens[1].equalsIgnoreCase("admin"))
				{
					parser.load(tokens[3],hostelSys);				
				}
			}
		}
		while(true)
		{
			token.clear();
			System.out.println("Enter a command");
			line=stdin.nextLine();
			m = Pattern.compile(regex).matcher(line);
			while(m.find())
			{
				token.add(m.group(0));
			}
			tokens=token.toArray(new String[token.size()]);
			if(tokens[0].equalsIgnoreCase("h21"))
			{
				if(tokens[1].equalsIgnoreCase("admin"))
				{
					if(tokens[2].equalsIgnoreCase("--load"))
					{
						parser.load(tokens[3], hostelSys);
					}
					else if(tokens[2].equalsIgnoreCase("revenue"))
					{
						System.out.println("Revenue: "+hostelSys.getRevenue());
					}
					else if(tokens[2].equalsIgnoreCase("occupancy"))
					{
						System.out.println("Occupancy: "+hostelSys.getRevenue());
					}
				}
				else if(tokens.length==4)
				{
					hostelSys.emailUsers(tokens[3]);
				}
				else if(tokens[1].equalsIgnoreCase("search"))
				{
					if(tokens.length==2)
					{
						hostelSys.search();
					}
					else if(tokens.length==4)
					{
						hostelSys.search(tokens[3]);
					}
					else if(tokens.length==8)
					{
						hostelSys.search(tokens[3],Integer.parseInt(tokens[5]),Integer.parseInt(tokens[7]));
					}
					else if(tokens.length==10)
					{
						hostelSys.search(tokens[3],Integer.parseInt(tokens[5]),Integer.parseInt(tokens[7]),Integer.parseInt(tokens[9]));
					}
				}
				else if(tokens[1].equalsIgnoreCase("book"))
				{
					if(tokens.length==7)
					{
						if(tokens[2].equalsIgnoreCase("add"))
						{
							hostelSys.book(Integer.parseInt(tokens[4]),Integer.parseInt(tokens[6]));
						}
					}
					if(tokens.length==5)
					{
						if(tokens[2].equalsIgnoreCase("cancel"))
						{
							hostelSys.cancel(Integer.parseInt(tokens[4]));
						}
						if(tokens[2].equalsIgnoreCase("view"))
						{
							hostelSys.viewBooking(Integer.parseInt(tokens[4]));
						}
					}
					else
					{
						System.out.println("Invalid command. Please try again");
					}
				}
				else if(tokens[1].equalsIgnoreCase("user"))
				{
					if(tokens[2].equalsIgnoreCase("add"))
					{
						if (tokens.length==9)
						{
							if(!hostelSys.isUser(tokens[8]))
							{
								hostelSys.addUser(tokens[4],tokens[6],tokens[8]);
							}
						}
						else if(tokens.length==17)
						{
							if(!hostelSys.isUser(tokens[8]))
							{
								hostelSys.addUser(tokens[4],tokens[6],tokens[8],Long.parseLong(tokens[10]),Integer.parseInt(tokens[12]),Integer.parseInt(tokens[14]),tokens[16]);
							}
						}
						else
						{
							System.out.println("Wrong  number of inputs");
							System.out.println("h21 user add --first_name --last_name --email [ --cc_number --expiration_date --security_code --phone ]");
						}
					}
					else if(tokens[2].equalsIgnoreCase("change"))
					{
						if(hostelSys.isUser(Integer.parseInt(tokens[4])))
						{
							//if changing name and email
							if(tokens.length==11)
							{
								hostelSys.changeUser(Integer.parseInt(tokens[4]),tokens[6],tokens[8],tokens[10]);							
							}
							//if changing Credit Card info
							else if(tokens.length==13)
							{
								hostelSys.changeUser(Integer.parseInt(tokens[4]),Long.parseLong(tokens[6]),Integer.parseInt(tokens[8]),Integer.parseInt(tokens[10]),tokens[12]);
							}
							//if changing name, email, and credit card info
							else if (tokens.length==19)
							{
								hostelSys.changeUser(Integer.parseInt(tokens[4]),tokens[6],tokens[8],tokens[10],Long.parseLong(tokens[12]),Integer.parseInt(tokens[14]),Integer.parseInt(tokens[16]),tokens[18]);
							}
						}
						else
						{
							System.out.println("Not a user. Please add user.");
						}
					}
					else if(tokens[2].equalsIgnoreCase("view"))
					{
						if(tokens.length==5)
						{
							if(hostelSys.isUser(Integer.parseInt(tokens[4])))
							{
								hostelSys.viewUser(Integer.parseInt(tokens[4]));
							}
							else
							{
								System.out.println("Not a user. Please add user.");
							}
						}
					}
				}
			}
			else
			{
				System.out.println("Did not start Command with h21. Please try again");
			}
		}
	}
}
