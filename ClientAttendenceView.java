import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientAttendenceView extends JFrame
{
	JTable T1;
	JLabel l1;
	JPanel p1,p2;
	JScrollPane P;
	Connection con;
	
	ClientAttendenceView()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		setTitle("Client Attendence View");
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(96, 130, 182));
		p1.setBounds(0,0,750,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,51,750,650);
		p2.setBackground(Color.white);
		l1= new JLabel("Client Attendence");
		l1.setForeground(Color.white);
		l1.setBounds(300,15,200,20);
		l1.setFont(new Font("arial",Font.BOLD,18));
		String data[][] =
		{
			
		};
		String []columnNames = {};
		T1 = new JTable(data,columnNames);
		T1.setBounds(50,100,600,100);
		P = new JScrollPane(T1);
		P.setBounds(50,100,600,200);
		add(p1);
		add(p2);
		p2.add(P);
		p1.add(l1);
		setSize(750,700);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		updateTable();
	}
	public void updateTable()
	{
		 try
	   {
		   PreparedStatement ps;
		   ResultSet rs;
		   String qry = "SELECT CID as 'Customer ID',ADate as'Attendence Date',Status as 'Status'  FROM CLIENTATTENDENCE";
		   ps = con.prepareStatement(qry);
		   rs = ps.executeQuery();
		   T1.setModel(DbUtils.resultSetToTableModel(rs));
		}
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
	   }
	}
	public static void main(String[] args)
	{
		new ClientAttendenceView();
	}
}