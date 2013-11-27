import java.util.Scanner;


public class H21 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		HostelSystem hostelSys = new HostelSystem();
		XMLParser parser = new XMLParser();
		// TODO Auto-generated method stub
		String line = "";
		Scanner stdin = new Scanner(System.in);
//		while 
		System.out.println("Please enter file path for hotels ");
		line=stdin.nextLine();
		String delims = "[ ]+";
		String[] tokens = line.split(delims);
		while(hostelSys.getHostels().isEmpty())
		{
			System.out.println("No hostels Loaded. ENTER:");
			System.out.println("h21 admin --load FILEPATH");
			line=stdin.nextLine();
			tokens = line.split(delims);
			if(tokens[0].equalsIgnoreCase("h21"))
			{
				
				if(tokens[1].equalsIgnoreCase("admin"))
				{
					hostelSys.addHostel(parser.load(tokens[3]));				
				}
			}
		}
		if(tokens[0].equalsIgnoreCase("h21"))
		{
			
			if(tokens[1].equalsIgnoreCase("admin"))
			{
				if(tokens[2].equalsIgnoreCase("--load"))
				{
					hostelSys.addHostel(parser.load(tokens[3]));
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
						hostelSys.view(Integer.parseInt(tokens[5]),Integer.parseInt(tokens[7]));
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
					else if()
					{
						
					}
				}
			}
			else if(tokens[1].equalsIgnoreCase("admin"))
			{
				
			}
		}
		else
		{
			System.out.println("Did not start Command with h21. Please try again");
		}
	}

}
