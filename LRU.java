import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LRU {
	

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Number of Pages:");
		 int numPages=sc.nextInt();
		 int pages[]=new int[numPages];
		 System.out.println("Enter Reference String: ");
		 for(int i=0;i<numPages;i++)
		 {
			 pages[i]=sc.nextInt();
		 }
		 
		 System.out.println("Enter Number of Frames");
		 int capacity=sc.nextInt();
		 
		 //To represent set of current pages
		 HashSet<Integer> frames=new HashSet<>(capacity);
		 
		 //To store LRU Indexes of pages //<key=Page,value=index>
		 HashMap<Integer,Integer>  index=new HashMap<>();
		 int pageFaults=0;
		 int hits=0;
		 for(int i=0;i<numPages;i++)
		 {
			 if(frames.size()<capacity) //check if set can hold n=more pages
			 {
				 //IF page not present insert into set and increment pagefault
				 if(!frames.contains(pages[i])) 
				 {
					 frames.add(pages[i]);
					 index.put(pages[i],i); //push current page into queue
					 pageFaults++;
					
					 /*for(int j:index)
						 System.out.print(j+"\t");
					 System.out.println();*/
				 }
				 else
				 {
					 hits++;
					 index.put(pages[i],i); 
				 }
			 }
			 else //set is full,need replacement
			 {
				 if(!frames.contains(pages[i])) //frame is not present present
				 {
					 int lru=Integer.MAX_VALUE;
					 int val=Integer.MIN_VALUE;
					
					 Iterator<Integer> itr=frames.iterator();
					 while(itr.hasNext())
					 {
						 int temp=itr.next();
						 if(index.get(temp)<lru)
						 {
							 lru=index.get(temp);
							 val=temp;
						 }
					 }
					 
					 frames.remove(val);
					 frames.add(pages[i]);
					 pageFaults++;
					 index.put(pages[i], i);
				 }
				 else //frame is present in set
				 {
					 hits++;
					 index.put(pages[i],i); 
				 }
			 }
			 frames.forEach(System.out::print);
			 System.out.println();
		 }
		 
		 System.out.println("Number of Page Faults : "+pageFaults);
		 System.out.println("Hits:\t"+hits);
		 System.out.println("hit ratio: "+((double)hits/(double)numPages));

	}
}

output::


/*
 * Enter Number of Pages:
12
Enter Reference String: 
2 3 2 1 5 2 4 5 3 2 5 2
Enter Number of Frames
3
2
23
23
123
152
152
452
452
453
523
523
523
Number of Page Faults : 7
Hits:	5
hit ratio: 0.4166666666666667
*/

K:\sposl\PageReplacement\src>javac LRU.java

K:\sposl\PageReplacement\src>java LRU
Enter Number of Pages:
5
Enter Reference String:
1 2 3 1 2
Enter Number of Frames
3
1
12
123
123
123
Number of Page Faults : 3
Hits:   2
hit ratio: 0.4

K:\sposl\PageReplacement\src>java LRU
Enter Number of Pages:
7
Enter Reference String:
1 2 3 4 5 1 2
Enter Number of Frames
4
1
12
123
1234
2345
1345
1245
Number of Page Faults : 7
Hits:   0
hit ratio: 0.0



