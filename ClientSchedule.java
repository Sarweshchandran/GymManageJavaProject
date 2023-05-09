import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientSchedule extends JFrame
{
	JPanel p1,p2;
	JLabel l1;
	Connection con;
	
	ClientSchedule()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		
		
		
		
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
		
	}
	public static void main(String[] args)
	{
		new ClientSchedule();
	}
}