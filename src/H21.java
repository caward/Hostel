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
//		String delims = "[ ]+";
		Matcher m;
		String[] tokens;
		while(hostelSys.getHostels().isEmpty())
		{
			token.clear();
			System.out.println("No hostels Loaded. ENTER:");
			System.out.println("h21 admin --load FILEPATH");
			line=stdin.nextLine();
//			tokens = line.split(delims);
			m = Pattern.compile(regex).matcher(line);
//			tokens = new String[m.groupCount()+2];
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
//			tokens = line.split(delims);
			m = Pattern.compile(regex).matcher(line);
//			tokens = new String[m.groupCount()];
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
							hostelSys.book(Integer.parseInt(tokens[5]),Integer.parseInt(tokens[7]));
						}
						else if(tokens[2].equalsIgnoreCase("cancel"))
						{
							hostelSys.cancel(Integer.parseInt(tokens[4]));
						}
						else if(tokens[2].equalsIgnoreCase("view"))
						{
							//hostelSys.view(Integer.parseInt(tokens[5]),Integer.parseInt(tokens[7]));
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
								hostelSys.changeUser(Integer.parseInt(tokens[4]),tokens[6],tokens[8],tokens[10],Long.parseLong(tokens[6]),Integer.parseInt(tokens[8]),Integer.parseInt(tokens[10]),tokens[12]);
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
