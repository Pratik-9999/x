import java.io.*;
import java.util.*;


class Pass1
{
      public static void main(String args[])throws Exception
       {
         int lc=0;
         String code;
         BufferedReader br=new BufferedReader(new FileReader("input.txt"));
         BufferedWriter wr=new BufferedWriter(new FileWriter("Ic.txt"));
         BufferedWriter st=new BufferedWriter(new FileWriter("Symtab.txt"));
         String line;
         InstructionTable table=new InstructionTable();
           int ind=0;

         while((line=br.readLine())!=null)
              {  int count=0;
                
                 System.out.println("Ho");
                 String parts[]=line.split("\\s+");
                 
                  if(parts[1].equals("START"))
                   {
                     lc=Integer.parseInt(parts[2]);
                     code="(AC,02)\t"+"(C,"+lc+")";
                     wr.write(code+"\n");
                     System.out.println(code);

                   }
                   if(parts[1].equals("END"))
                   {
                     
                     code="(AC,02)\t";
                     wr.write(code+"\n");
                     System.out.println(code);

                   }
                   if(parts[1].equals("DC"))
                   {
                     int j=Integer.parseInt(parts[2]);
                     code="(DC,01)\t"+"(C,"+j+")";
                     wr.write(code+"\n");
                     st.write(count+" "+parts[0]+" "+lc+"\n");
                     System.out.println(code);
                     count++;
                    
                   }
                   if(parts[1].equals("DS"))
                   {
                     int j=Integer.parseInt(parts[2]);
                     code="(DC,02)\t"+"(C,"+j+")";
                     wr.write(code+"\n");
                     st.write(count+" "+parts[0]+" "+lc+"\n");
                     System.out.println(code);
                     lc=lc+j;
                   }
                  if(table.getType(parts[1]).equals("IS"))
			{
			code="(IS,0"+table.getCode(parts[1]) +")";	
			  int j=2;
			  String code2="";
			  while(j<parts.length)
			  {
				  if(table.getType(parts[j]).equals("RG"))
				  {
					  code2=code2+table.getCode(parts[j])+" ";
					  
				  }
				  else
				  {
					 
						
						  code2=code2+"(S,0"+ind+")";
					          ind++;
					  
				  }
				  j++;
				  
			  }
			  code=code+" "+code2;
			  wr.write(code+"\n");
                           
			}
                   
                

              
              }
            br.close();
            wr.close();
            st.close();

       }



}
