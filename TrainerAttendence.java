import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.*;
import java.util.Date.*;
import java.text.SimpleDateFormat;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerAttendence extends JFrame implements ActionListener
{
   JDateChooser d; 
   JPanel p1,p2;
   JLabel l1,l2,l3,l4;
   JComboBox<String> TID,status;
   JButton b1;
   Connection con;
    
   TrainerAttendence()
   {
		MyConnection my = new MyConnection();
		con = my.Connect();
		setTitle("Trainer Attendence");
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(96, 130, 182));
		p1.setBounds(0,0,500,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(255,255,255));
		p2.setBounds(0,51,500,450);
		l1 = new JLabel("Trainer Attendence");
		l1.setForeground(new Color(255,255,255));
		l1.setBounds(150,5,180,30);
		l1.setFont(new Font("Segoe UI",Font.BOLD,18));
		l2 = new JLabel("Trainer ID:");
		l2.setForeground(Color.red);
		l2.setBounds(40,30,70,25);
		TID = new JComboBox<>();
		TID.setBounds(116,30,150,25);
		l3 = new JLabel("Date:");
		l3.setBounds(70,70,70,25);
		d = new com.toedter.calendar.JDateChooser();
		d.setBounds(116,70,150,25);
		d.setDateFormatString("YYYY-MM-d");
		l4 = new JLabel("Status:");
		l4.setBounds(60,110,70,25);
		status = new JComboBox<>();
		status.addItem("Present");
		status.addItem("Absent");
		status.setBounds(116,110,150,25);
		b1 = new JButton("Submit");
		b1.setBounds(150,150,80,25);
		b1.addActionListener(this);
		add(p1);
		add(p2);
		p1.add(l1);
		p2.add(l2);
		p2.add(TID);
		p2.add(l3);
		p2.add(d);
		p2.add(l4);
		p2.add(status);
		p2.add(b1);
		setSize(480,300);
		setLayout(null);
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		setvalues();
		
   }
   public void actionPerformed(ActionEvent e)
   {
	   String id = TID.getSelectedItem().toString();
	   SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	   String date = sdf.format(d.getDate());
	   String set = status.getSelectedItem().toString();
	   PreparedStatement st;
	   String query ="INSERT INTO TRAINERATTENDENCE (TID,ADATE,STATUS) VALUES (?,?,?)";
	   try
		{
			st = con.prepareStatement(query);
			st.setString(1,id);
			st.setString(2,date);
			st.setString(3,set);
			if(st.executeUpdate() > 0)
			{
				JOptionPane.showMessageDialog(null,"Attendence Added");
				this.dispose();
			}
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex);
		}
	}
   
   public void setvalues()
   {
	   try
	   {
		   PreparedStatement pst;
		   ResultSet rss;
		   String qry = "SELECT TRAINER_ID FROM NEWTRAINER";
		   pst = con.prepareStatement(qry);
		   rss = pst.executeQuery();
		   while(rss.next())
		   {
			   TID.addItem(rss.getString("TRAINER_ID"));
		   }
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
	   }
	   
   }
  
  public static void main(String[] args)
   {
	   new TrainerAttendence();
   }
}