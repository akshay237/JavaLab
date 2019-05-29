import java.io.DataOutputStream;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.FileReader;
public class SocketClient{
	public static void main(String args[]) {
		try {
			Socket  s = new Socket("localhost",1999);
			BufferedReader br = new BufferedReader(new FileReader("/home/akshay/eclipse-workspace/Prog12/src/1.txt"));
			byte[] b = new byte[30];
			String k = br.readLine();
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(k);
			System.out.println("Transfer Complete");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}