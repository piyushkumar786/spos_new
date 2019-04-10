import java.util.*;
import java.io.*;
class motpot
{


public static void main(String args[]) throws IOException
 {
		FileReader fr=new FileReader("token.txt");
		BufferedReader br=new BufferedReader(fr);
		 c=new code1(op,4);
                String str,str1,str2;
		String code[]=new String[100];
                String mot[]=new String[]{"L","A","ST"};
	        String pot[]=new String[]{"START","END","USING","DC","DS"};
                
		int n=0;
		
		while((str=br.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(str);
			while (st.hasMoreTokens())
			 {
				str1=st.nextToken();
				if(str1.contains(","))
				{
					StringTokenizer st1=new StringTokenizer(str1);
					while(st1.hasMoreTokens())
					{
						str2=st1.nextToken(",");
						System.out.println(str2);
						
						
					}
				}
				else
				{
					System.out.println(str1);
				}
			}
		}
		}
       	
             void disp(int op,int len)
               { 
	         System.out.println("The MOT Table is:-");
		for(int i=0;i<mot.length;i++)
                 {
                     
                    System.err.println(mot[i]+" ");
                    LC++;
                 }
      
                System.out.println("The POT Table is:-");
                for(int i=0;i<pot.length;i++)
                 {
                   System.err.println(pot[i]+" ");
                 }	
		 }
	
}

