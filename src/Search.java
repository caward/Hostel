import java.util.ArrayList;

public class Search {
	int searchId = 0;
	ArrayList<Bedroom> beds = new ArrayList<Bedroom>();
	
	public boolean contains(int bed, int room)
	{
		for(Bedroom b:beds)
		{
			if(b.getBed()==bed&&b.getRoom()==room){return true;}
				
		}
		return false;
	}
	
	public void add(Bedroom bed)
	{
		beds.add(bed);
	}
}
