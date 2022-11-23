import java.util.*;
import java.io.*;
class Pass2
{
    public static void main(String args[]) throws Exception
    {
         BufferedReader br=new BufferedReader(new FileReader("Symtab.txt"));
         ArrayList<Table> symtab=new ArrayList<>();
         String line;
         while((line=br.readLine())!=null)
         {
              String parts[]=line.split("\\s+");
              symtab.add(new Table(parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[0])));
              System.out.println(Integer.parseInt(parts[0])+" "+parts[1]+" "+Integer.parseInt(parts[2]));




         }
     br.close();
    String code;
    BufferedReader bc=new BufferedReader(new FileReader("Ic.txt"));
    BufferedWriter wr=new BufferedWriter(new FileWriter("pass2.txt"));

     while((line=bc.readLine())!=null)
        {
            String parts[]=line.split("\\s+");
            if(parts[0].contains("AD") || parts[0].contains("DL,02"))
            {

                wr.write("\n");
            }
           
	    if(parts[0].contains("DL,01"))
	       {
	        		int constant=Integer.parseInt(parts[1].replaceAll("[^0-9]",""));
	        		code="00 0 00"+constant;
	        		wr.write(code+"\n");
	        		
	       }
            else if(parts.length==3)
	        {    
	        	int opcode=Integer.parseInt(parts[0].replaceAll("[^0-9]",""));
	       
	        	int regcode=Integer.parseInt(parts[1]);
	        	int symindex=Integer.parseInt(parts[2].replaceAll("[^0-9]",""));
	        	int add=symtab.get(symindex-1).getAddress();
	        	code="0"+opcode+" "+regcode+" "+add;
	        	wr.write(code+"\n");
	        	
	        			
	        }

          
        }
  bc.close();
  wr.close();


    }





}
