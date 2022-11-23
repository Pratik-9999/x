//4th java file

import java.util.Comparator;
public class SortByPriority implements Comparator<Process>{

	@Override
	public int compare(Process o1, Process o2) {
		
		return o1.priority-o2.priority;
	}



}
