package book;
import java.util.*;
public class Book implements Comparable<Book>{
	String title,author,publisher;
	Integer price;
	Book(String t,String a,String p,int pr)
	{
		title=t;
		author=a;
		publisher=p;
		price=pr;
	}
	public int compareTo(Book  bk) {
	   return price.compareTo(bk.price);	
	}
	public String toString()
	{
		return "Book title is " + title + " by the author " + author + " and published by " + publisher + " with price  " + price;
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String t,a,p;
		int n,pr;
		ArrayList<Book> ab = new ArrayList<Book>();
		ArrayList<Book> abk = new ArrayList<Book>();
		System.out.println("Enter no of books");
		n = s.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the title:");
			t=s.next();
			System.out.println("Enter the author:");
			a=s.next();
			System.out.println("Enter the publisher:");
			p=s.next();
			System.out.println("Enter the price:");
			pr=s.nextInt();
			Book b = new Book(t,a,p,pr);
			ab.add(b);
		}
		System.out.println("Before Sorting:");
		for(Book b1:ab)
			System.out.println(b1);
		Collections.sort(ab);
		abk.addAll(ab);
		System.out.println("\n");
		System.out.println("After Sorting;");
		for(Book b1:abk)
			System.out.println(b1);
	}

}
