import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> allo=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> max=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> need=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> maxall=new ArrayList<Integer>();
		ArrayList<Integer> ss=new ArrayList<Integer>();
		ArrayList<Integer> done=new ArrayList<Integer>();

	// ACCEPT NO OF PROCESSES

		System.out.println("Enter no of processes");
		int nopr=scan.nextInt();

	// ACCEPT NO OF RESOURCES

		System.out.println("Enter no of resources");
		int nore=scan.nextInt();

	// ACCEPT MAXIMUM NO OF RESOURCES FOR EACH PROCESS

		System.out.println("Enter the max resources");
		for(int i=0;i<nore;i++)
		{
			maxall.add(scan.nextInt());
		}

	// ACCEPT ALLOCATION MATRIX

		for(int i=0;i<nopr;i++)
		{
			ArrayList<Integer> row=new ArrayList<Integer>();
			System.out.println("Enter allocation for :"+i);
			for(int j=0;j<nore;j++)
			{
				row.add(scan.nextInt());
			}
			allo.add(row);
			done.add(0);
		}

	// ACCEPT MAXIMUM REQUIREMENT MATRIX

		for(int i=0;i<nopr;i++)
		{
			ArrayList<Integer> row1=new ArrayList<Integer>();
			System.out.println("Enter maximum resources for :"+i);
			for(int j=0;j<nore;j++)
			{
				row1.add(scan.nextInt());
			}
			max.add(row1);
		}

	// PRINT ALLOCATION MATRIX

		System.out.println("\nAllocation is: ");
		for(int i=0;i<allo.size();i++)
		{
			for(int j=0;j<allo.get(i).size();j++)
			{
				System.out.print(allo.get(i).get(j)+" ");
			}
			System.out.println();
		}

	// PRINT MAXIMUM RESOURCES ALLOCATION

		System.out.println("\nMaximum resource allocation is: ");
		for(int i=0;i<max.size();i++)
		{
			for(int j=0;j<max.get(i).size();j++)
			{
				System.out.print(max.get(i).get(j)+" ");
			}
			System.out.println();
		}

	// CALCULATING NEED MATRIX

		int a=0,b=0,c=0;
		for(int i=0;i<allo.size();i++)
		{
			a=a+allo.get(i).get(0);
			b=b+allo.get(i).get(1);
			c=c+allo.get(i).get(2);
		}
		for(int i=0;i<allo.size();i++)
		{
			ArrayList<Integer> nee=new ArrayList<Integer>();
			nee.add(max.get(i).get(0)-allo.get(i).get(0));
			nee.add(max.get(i).get(1)-allo.get(i).get(1));
			nee.add(max.get(i).get(2)-allo.get(i).get(2));
			need.add(nee);
		}
		System.out.println("\nNeed Matrix is: ");

	// PRINTING NEED MATRIX

		for(int i=0;i<need.size();i++)
		{
			for(int j=0;j<need.get(i).size();j++)
			{
				System.out.print(need.get(i).get(j)+" ");
			}
			System.out.println();
		}

	// CALCULATING NO OF AVAILABLE RESOURCES

			a=maxall.get(0)-a;
			b=maxall.get(1)-b;
			c=maxall.get(2)-c;

	// PRINTING AVAILABLE RESOURCES
 
		System.out.println("\na: "+a);
		System.out.println("b: "+b);
		System.out.println("c: "+c);

	// CALCULATING SEQUENCE OF PROCESSES TO AVOID DEADLOCK
		
		int flag=0;
		while(true)
		{
			for(int i=0;i<done.size();i++)
			{
				if(done.get(i).equals(0))
				{
					flag=1;
					break;
				}
				else
					flag=0;
			}
			if(flag==1)
			{
				for(int i=0;i<need.size();i++)
				{
					if(done.get(i).equals(0))
					{
						if(need.get(i).get(0)<=a)
						{
							if(need.get(i).get(1)<=b)
							{
								if(need.get(i).get(2)<=c)
								{
									ss.add(i);
									a=a+allo.get(i).get(0);
									b=b+allo.get(i).get(1);
									c=c+allo.get(i).get(2);
									done.set(i, 1);
								}
							}
						}
					}
					else
						continue;
				}
			}
			else
				break;
		}
		System.out.println("\n SEQUENCE OF PROCESSES is: ");
		for(int i=0;i<ss.size();i++)
			System.out.print(ss.get(i)+" ");
		scan.close();
	}
}
