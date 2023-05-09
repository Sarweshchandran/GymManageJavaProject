import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UDailySchedule extends JFrame
{
	JPanel p1,p2;
	JLabel l1;
	JTable T1;
	JScrollPane P;
	Connection con;
	
	UDailySchedule()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1600,50);
		p1.setBackground(new Color(96,132,182));
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(255,255,255));
		p2.setBounds(0,50,1600,650);
		String [][] data = {};
		String[] columnNames = {};
		T1 = new JTable(data,columnNames);
		P = new JScrollPane(T1);
		P.setBounds(20,80,1500,100);
		
		
		setSize(1600,700);
		setLayout(null);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				dispose();
			}
		});
		add(p1);
		add(p2);
		p2.add(P);
		updateTable();
	}
	public void updateTable()
	{
		try
		{
			PreparedStatement ps;
			ResultSet rs;
			String qry = "SELECT * FROM SCHEDULE";
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
		new UDailySchedule();
	}
}