import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class ClientFees extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4;  /*l1 = salary l2= trainer id l3 = month l4 amouthin(rs);*/ 
	JComboBox<String> id;
	JTextField month,amount;
	JButton submit;
	Connection con;
	
	ClientFees()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		p1 = new JPanel();
		p1.setBackground(new Color(96, 130, 182));
		p1.setLayout(null);
		p1.setBounds(0,0,500,50);
		l1 = new JLabel("Client Fees");
		l1.setFont(new Font("arial",Font.BOLD,20));
		l1.setForeground(new Color(255,255,255));
		l1.setBounds(170,15,200,25);
		p2 = new JPanel();
		p2.setBackground(new Color(255,255,255));
		p2.setLayout(null);
		p2.setBounds(0,50,500,450);
		l2 = new JLabel("Customer ID:");
		l2.setFont(new Font("arial",Font.PLAIN,14));
		l2.setBounds(45,70,80,25);
		id = new JComboBox<String>();
		id.setBounds(145,70,200,25);
		l3 = new JLabel("Month Of Payment:");
		l3.setFont(new Font("arial",Font.PLAIN,14));
		l3.setBounds(20,120,140,25);
		month = new JTextField();
		month.setBounds(145,120,200,25);
		l4 = new JLabel("Amount in (RS.):");
		l4.setFont(new Font("arial",Font.PLAIN,14));
		l4.setBounds(20,170,140,25);
		amount = new JTextField();
		amount.setBounds(145,170,200,25);
		submit = new JButton("Submit");
		submit.setBounds(145,220,90,25);
		submit.addActionListener(this);
		add(p1);
		p1.add(l1);
		add(p2);
		p2.add(l2);
		p2.add(id);
		p2.add(l3);
		p2.add(month);
		p2.add(l4);
		p2.add(amount);
		p2.add(submit);
		setSize(500,500);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				dispose();
			}
		});
		setvalues();
	}
	public void setvalues()
	{
		 try
	   {
		   PreparedStatement pst;
		   ResultSet rss;
		   String qry = "SELECT CUSTOMER_ID FROM NEWCLIENT";
		   pst = con.prepareStatement(qry);
		   rss = pst.executeQuery();
		   while(rss.next())
		   {
			   id.addItem(rss.getString("CUSTOMER_ID"));
		   }
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
	   }
	}
	public void actionPerformed(ActionEvent e)
	{
		String cid = id.getSelectedItem().toString();
		String M = month.getText();
		String A = amount.getText();
		PreparedStatement st;
		String query ="insert into CFees (Customer_id,Month,Amount) values (?,?,?)";
		try
		{
			st = con.prepareStatement(query);
			st.setString(1,cid);
			st.setString(2,M);
			st.setString(3,A);
			if(st.executeUpdate()>0)
			{
				JOptionPane.showMessageDialog(null,"Client Fees Added");
				this.dispose();
			}
		}
		catch(SQLException ex)
		{
			Logger.getLogger(ClientFees.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	public static void main(String[] args)
	{
		new ClientFees();
	}
}