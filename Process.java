//2nd java File

public class Process {
      public Process(String name, int bT, int aT) {
	
		this.name = name;
		BT = bT;
		AT = aT;
		WT=TAT=CT=remBT=0;
		priority=0;
	}
	String name;
      public Process(String name, int bT, int aT, int priority) {
		
		this.name = name;
		BT = bT;
		AT = aT;
		this.priority = priority;
		WT=TAT=CT=0;
		remBT=BT;
		flag=false;
	}
	int BT,AT,CT,TAT,FT,WT,remBT,priority;
      boolean flag;
      
      public void display()
      {
    	  System.out.println(name+"\t"+BT+"\t"+AT+"\t"+CT+"\t"+TAT+"\t"+WT+"\t"+priority);
    	  
    	  
      }
      
}
