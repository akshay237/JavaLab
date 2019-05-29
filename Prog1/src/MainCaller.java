import java.util.*;
public class MainCaller {

	static LinkedList<MissedCall> miss = new LinkedList<MissedCall>();
	static Scanner sc = new Scanner(System.in);
	
	public static void missCallEntry()
	{
		
		int kill = 1;
		while(kill==1)
		{
			//System.out.println("Enter the choice");
			System.out.println("1:Add Missed Call\t 2.Delete the entry based on number\t 3:Display\t 4:Exit");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1: System.out.println("Enter missed call details");
						String n; 
						Long num = sc.nextLong();
						Calendar c = Calendar.getInstance();
						
						if(DatabaseCallers.hm.containsKey(num))
							n = DatabaseCallers.hm.get(num);
						else
							n = "Private Caller";
						
						MissedCall ms = new MissedCall(c,num,n);
						if(miss.size()==10)
						{
							miss.removeLast();
						}
						miss.addFirst(ms);
						break;
						
				case 2: System.out.println("Enter the entry to be deleted");
						Long delnum = sc.nextLong();
						ListIterator<MissedCall> it = miss.listIterator();
						int i=0;
						boolean b=false;
						while(it.hasNext())
						{
							i++;
							MissedCall mc = it.next();
							if(mc.num==delnum)
							{
								b = miss.remove(mc);
								break;
							}
						}
						if(i!=0)
						{
							if(b==true)
								System.out.println("Number "+delnum+" is deleted from missed calls");
							else
								System.out.println("Number does not exist");
						}
						else
							System.out.println("No missed calls");
						break;
						
				case 3: System.out.println("Missed Call Display");
						LinkedList<MissedCall> delmiss = new LinkedList<MissedCall>(); 
						ListIterator<MissedCall> it1 = miss.listIterator();
						int k=0;
						while(it1.hasNext())
						{	k++;
							MissedCall ms1 = it1.next();
							System.out.println("Missed Call Number :"+ms1.num);
							System.out.println("1.To Display Details  2.Delete this entry  3.Next Number");
							int dispc = sc.nextInt();
							if(dispc == 1 )
								ms1.display();
							else if(dispc == 2)
							{	delmiss.add(ms1);
							}
							else if(dispc == 3)
								continue;
							else
								break;
						}
						miss.removeAll(delmiss);
						
						if(k==0)
							System.out.println("No entries");
						else
							System.out.println("List Completed");
						break;
				case 4: kill=0;
						break;
				default: System.out.println("Invalid input");
						 break;
			}
		}
	}
	
	
	
	public static void main(String args[])
	{
		/*System.out.println("Enter the number of contacts");
		int n = sc.nextInt();*/
		
		DatabaseCallers.forHoldingCaller();
		missCallEntry();
}
}