import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Optimal {
	

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
	
		 HashSet<Integer> frames=new HashSet<>();
		 
		 HashMap<Integer, Integer> index=new HashMap<>();
		 int pagefaults=0;
		 int hits=0;
		 for(int i=0;i<numPages;i++)
		 {
			 if(frames.size()<capacity)
			 {
				 if(!frames.contains(pages[i]))
				 {
					 pagefaults++;
					 frames.add(pages[i]);
					 
					 //finding next access of page
					 int farthest=nextIndex(pages, i);
					 
					 index.put(pages[i], farthest);
					 
				 }
				 else
				 {
					 hits++;
					 index.put(pages[i], nextIndex(pages,i));
				 }
			 }
			 else
			 {
				 if(!frames.contains(pages[i]))
				 {
					 int farthest=-1;
					 int val=0;
					 
					 Iterator<Integer> itr=frames.iterator();
					 while(itr.hasNext())
					 {
						 int temp=itr.next();
						 
						 if(index.get(temp)>farthest)
						 {
							 farthest=index.get(temp);
							 val=temp;
						 }
					 }
					 
					 frames.remove(val);
					 index.remove(farthest);
					 frames.add(pages[i]);
					 pagefaults++;
					 int nextUse=nextIndex(pages, i);
					 index.put(pages[i],nextUse);
				 }
				 else
				 {
					 hits++;
					 index.put(pages[i], nextIndex(pages, i));
				 }
				 
			 }
			 frames.forEach(System.out::print);
			 System.out.println();
			
		 }
		 System.out.println("Number of Page Faults : "+pagefaults);
		 System.out.println("Hits:\t"+hits);
		 System.out.println("hit ratio: "+((double)hits/(double)numPages));
	}
	public static int nextIndex(int pages[],int curIndex)
	{
		 int farthest=curIndex;
		 int currentPage=pages[curIndex];
		 int j=farthest;
		 for(j=farthest+1;j<pages.length;j++)
		 {
			 if(pages[j]==currentPage)
			 {
				 farthest=j;
				 return farthest; //5 6 7 8 9
			 }
		 }
		 return Integer.MAX_VALUE;
	}
}



output::

K:\sposl\PageReplacement\src>javac Optimal.java

K:\sposl\PageReplacement\src>java Optimal
Enter Number of Pages:
7
Enter Reference String:
1 2 3 2 4 2 1
Enter Number of Frames
3
1
12
123
123
124
124
124
Number of Page Faults : 4
Hits:   3
hit ratio: 0.42857142857142855

K:\sposl\PageReplacement\src>java Optimal
Enter Number of Pages:
8
Enter Reference String:
1 2 3 2 4 2 5 6
Enter Number of Frames
4
1
12
123
123
1234
1234
2345
3456
Number of Page Faults : 6
Hits:   2
hit ratio: 0.25

