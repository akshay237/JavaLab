import java.util.*;
public class MissedCall {
	
	Scanner sc = new Scanner(System.in);
	Calendar cd;
	Long num;
	String name;
	MissedCall(Calendar c,Long nu,String n)
	{
		cd=c;
		num=nu;
		name=n;
	}
	void display()
	{
		System.out.println("Name :"+name+"\n Number :"+num+"\n Time :"+cd.getTime());
	}
	
}