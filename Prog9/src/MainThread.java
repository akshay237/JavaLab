public class MainThread extends Thread{
	public static void main(String args[]) throws InterruptedException{ 
	NumberThread nt = new NumberThread();
	StringThread st = new StringThread();
    nt.start();
    Thread.sleep(100);
    st.start();
  }
}