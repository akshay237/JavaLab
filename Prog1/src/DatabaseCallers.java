import java.util.*;
public class DatabaseCallers {

	public static HashMap<Long,String> hm = new HashMap<Long,String>();
	public static Scanner sc = new Scanner(System.in);
	public static void createEntries(int n)
	{
		for(int i=0;i<n;i++){
			System.out.println("Enter the number and name of caller");
			Long l = sc.nextLong();
			String na = sc.next();
			hm.put(l, na);
		}
		
	}
	public static void forHoldingCaller()
	{
		System.out.println("Enter the no. of caller details to be stored");
		int n = sc.nextInt();
		createEntries(n);
	}
}