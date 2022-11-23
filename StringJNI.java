class StringJNI
{
   static{
    System.loadLibrary("Hello");
    }
  
  public native String concate(String ms1,String ms2);
  
  public static void main(String args[])
     {     StringJNI obj=new StringJNI();
           System.out.println("Result:"+obj.concate("Amrut","vahini"));  
           
     }
     
     
  


}
