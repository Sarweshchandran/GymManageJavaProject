import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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

public class UMyProfile extends JFrame
{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	Connection con;
	
	UMyProfile()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,700,50);
		p1.setBackground(new Color(96, 130, 182));
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,50,700,650);
		p2.setBackground(new Color(255,255,255));
		l1 = new JLabel("Customer ID:");
		l1.setFont(new Font("arial", Font.BOLD,14));
		l1.setBounds(0,55,120,25);
		l2 = new JLabel();
		l2.setFont(new Font("arial", Font.BOLD,14));
		l2.setBounds(120,55,100,25);
		l3 = new JLabel("Name:");
		l3.setFont(new Font("arial", Font.BOLD,14));
		l3.setBounds(30,95,80,25);
		l4 = new JLabel();
		l4.setFont(new Font("arial", Font.BOLD,14));
		l4.setBounds(120,95,100,25);
		l5 = new JLabel("DOB:");
		l5.setFont(new Font("arial", Font.BOLD,14));
		l5.setBounds(30,135,80,25);
		l6 = new JLabel();
		l6.setFont(new Font("arial", Font.BOLD,14));
		l6.setBounds(120,135,100,25);
		l7 = new JLabel("Phone No:");
		l7.setFont(new Font("arial", Font.BOLD,14));
		l7.setBounds(30,175,80,25);
		l8 = new JLabel();
		l8.setFont(new Font("arial", Font.BOLD,14));
		l8.setBounds(120,175,100,25);
		l9 = new JLabel("Height:");
		l9.setFont(new Font("arial", Font.BOLD,14));
		l9.setBounds(30,215,80,25);
		l10 = new JLabel();
		l10.setFont(new Font("arial", Font.BOLD,14));
		l10.setBounds(120,215,100,25);
		l11 = new JLabel("Weight:");
		l11.setFont(new Font("arial", Font.BOLD,14));
		l11.setBounds(30,255,80,25);
		l12 = new JLabel();
		l12.setFont(new Font("arial", Font.BOLD,14));
		l12.setBounds(120,255,100,25);
		l13 = new JLabel("Address:");
		l13.setFont(new Font("arial", Font.BOLD,14));
		l13.setBounds(30,295,80,25);
		l14 = new JLabel();
		l14.setFont(new Font("arial", Font.BOLD,14));
		l14.setBounds(120,295,100,25);
		l15 = new JLabel("Image:");
		l15.setFont(new Font("arial", Font.BOLD,14));
		l15.setBounds(30,335,80,25);
		l16 = new JLabel();
		l16.setFont(new Font("arial", Font.BOLD,14));
		l16.setBounds(120,335,200,200);
		//l16.setIcon(new ImageIcon("C:/Users/sarwe/OneDrive/Desktop/Sarwesh/Application, Certificates and Photo/sea.jpg"));
		add(p1);
		add(p2);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		p2.add(l5);
		p2.add(l6);
		p2.add(l7);
		p2.add(l8);
		p2.add(l9);
		p2.add(l10);
		p2.add(l11);
		p2.add(l12);
		p2.add(l13);
		p2.add(l14);
		p2.add(l15);
		p2.add(l16);
		/*p2.add(l17);
		p2.add(l);*/
		setSize(700,700);
		setLayout(null);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				dispose();
			}
		});
		
	}
	public static void main(String[] args)
	{
		new UMyProfile();
	}
}