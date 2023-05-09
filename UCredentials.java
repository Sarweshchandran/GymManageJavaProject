import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UCredentials extends JFrame
{
	JPanel p1,p2;
	JLabel l1;
	JTable T1;
	JScrollPane P;Connection con;
	
	UCredentials()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,500,50);
		p1.setBackground(new Color(96, 130, 182));
		l1= new JLabel("Credentials");
		l1.setFont(new Font("arial",Font.BOLD,18));
		l1.setBounds(150,15,200,25);
		l1.setForeground(Color.white);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,50,500,450);
		p2.setBackground(new Color(255,255,255));
		String [][] data = {};
		String[] columnNames = {};
		T1 = new JTable(data,columnNames);
		P = new JScrollPane(T1);
		P.setBounds(50,80,300,40);
		add(p1);
		p1.add(l1);
		add(p2);
		p2.add(P);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
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
			String qry = "SELECT Username,Password FROM USERS WHERE USERNAME ='45678'";
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
		new UCredentials();
	}
}