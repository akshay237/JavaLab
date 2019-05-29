import java.util.*;
public class StringThread extends Thread{
	String vowel="AEIOUaeiou";
    String string;int x=0;
    Scanner s = new Scanner(System.in);
    public void run()
    {
    	System.out.println("Enter the string");
    	string=s.next();
    	for(char c:string.toCharArray()) 
    	for(char ch:vowel.toCharArray())
    	if(c==ch) {
    		x++;
    		System.out.println(ch);
    	}
    	System.out.println(x + " vowels present");    		
    }
}
