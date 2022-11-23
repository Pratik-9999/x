import java.util.HashMap;
class InstructionTable
{
   HashMap<String,Integer> IS,DL,AD,RG;

   public InstructionTable()
     {
         IS=new HashMap();
         DL=new HashMap();
         AD=new HashMap();
         RG=new HashMap();


          IS.put("ADD",01);
          IS.put("SUB",02);

          DL.put("DC",01);
          DL.put("DS",02);

          AD.put("START",01);
          AD.put("END",02);

          RG.put("AREG",01);
          RG.put("BREG",02);

                 
      }

public String getType(String s)
{

   s.toUpperCase();

   if(AD.containsKey(s))
      return "AD";

   else if(IS.containsKey(s))
      return "IS";


   else if(DL.containsKey(s))
       return "DL";

   else if(RG.containsKey(s))
       return "RG";

   else 
       return " ";



}

public int getCode(String s)
{
   s=s.toUpperCase();
   
   if(AD.containsKey(s))
     return AD.get(s);
 
   else if(IS.containsKey(s))
      return IS.get(s);


   else if(DL.containsKey(s))
       return DL.get(s);

   else if(RG.containsKey(s))
       return RG.get(s);

   else 
       return -1;



}




}