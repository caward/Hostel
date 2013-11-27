import java.util.ArrayList;

public class Search {
	static int searchId = 1;
	ArrayList<Bedroom> beds = new ArrayList<Bedroom>();
	
	public Search()
	{
		searchId++;
	}
	public boolean contains(int bed, int room)
	{
		for(Bedroom b:beds)
		{
			if(b.getBed()==bed&&b.getRoom()==room){return true;}
				
		}
		return false;
	}
	
	public int getTotalCost()
	{
		int cost = 0;
		for(Bedroom b : beds)
		{
			cost+=b.getPrice();
		}
		return cost;
	}
	public void add(Bedroom bed)
	{
		beds.add(bed);
	}
	
	public int getId()
	{
		return searchId;
	}
	
	public ArrayList<Bedroom> getBeds()
	{
		return beds;
	}
}
