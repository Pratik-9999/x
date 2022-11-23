//3rd Java file
import java.util.Comparator;

public class SortByArrival implements Comparator<Process>
{

	@Override
	public int compare(Process o1, Process o2) {
		// TODO Auto-generated method stub
		return o1.AT-o2.AT;
	}

}
