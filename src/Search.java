import java.util.ArrayList;

public class Search {
	static int searchId = 1;
	ArrayList<Bedroom> beds = new ArrayList<Bedroom>();
	int search_id;
	public Search()
	{
		search_id = searchId++;
	}
	
	//Checks if bed is in search object
	public boolean contains(int bed, int room)
	{
		for(Bedroom b:beds)
		{
			if(b.getBed()==bed&&b.getRoom()==room){return true;}
				
		}
		return false;
	}
	
	//Total Cost of a particular search
	public int getTotalCost()
	{
		int cost = 0;
		for(Bedroom b : beds)
		{
			if(b!=null)
			{
				cost+=b.getPrice();
			}
		}
		return cost;
	}
	public void add(Bedroom bed)
	{
		beds.add(bed);
	}
	
	public int getId()
	{
		return search_id;
	}
	
	public ArrayList<Bedroom> getBeds()
	{
		return beds;
	}
}
