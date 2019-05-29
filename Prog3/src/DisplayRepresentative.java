import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.sql.*;;

public class DisplayRepresentative extends JFrame {


private static final long serialVersionUID = 1L;
JButton click=new JButton("Click Here to Display Representative Details having Credit Limit greater than 15000.");
JTextArea area=new JTextArea();


public DisplayRepresentative(String title) {
// TODO Auto-generated constructor stub
super(title);

area.setEditable(false);
setLayout(new GridLayout(0, 1));

add(click);
add(area);
click.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

// TODO Auto-generated method stub
area.setText("");
try {
Class.forName("com.mysql.jdbc.Driver");
Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1628");
java.sql.Statement stmt=conn.createStatement();
System.out.println("Working");
String query="select * from representative where repnoData in (Select repnoData from customer where creditData>15000);";
ResultSet rs=stmt.executeQuery(query);
while(rs.next()) {
System.out.println("Working till here");
int repnoData=Integer.parseInt(rs.getString(1));
String repnameData=rs.getString(2);
String stateData=rs.getString(3);
int commData=Integer.parseInt(rs.getString(4));
int rateData=Integer.parseInt(rs.getString(5));
System.out.println("Finally");
area.append("\nRepNo:"+repnoData+"\nRepName:"+repnameData+"\nState:"+stateData+"\nCommission:"+commData+"\nRate:"+rateData+"\n");

}
}
catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
});
}







public static void main(String[] args) {
// TODO Auto-generated method stub
DisplayRepresentative dr=new DisplayRepresentative("Representative Deatils");
dr.setSize(500, 500);
dr.setVisible(true);

}
}