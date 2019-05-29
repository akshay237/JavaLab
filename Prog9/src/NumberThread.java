import java.util.*;
public class NumberThread extends Thread {
  Scanner s = new Scanner(System.in);
  String num;
  String digit[]= new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
  public void run()
  {
	  System.out.println("Enter a 4 digits number");
	  num=s.next();
	  for(char c:num.toCharArray()) {
	  if(c>57||c<48) {
		  System.out.println("Invalid");
		  break;
	      }
	  System.out.println(digit[((int)c-48)]);
	  }
  }
}
