import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UTrainerDetails extends JFrame
{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JComboBox<String> TID;
	byte[] image1;
	ImageIcon format = null;
	Connection con;
	
	UTrainerDetails()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setBounds(0,0,500,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.white);
		p2.setBounds(0,51,500,750);
		l1 = new JLabel("Trainer Details");
		l1.setFont(new Font("arial",Font.BOLD,18));
		l1.setForeground(Color.white);
		l1.setBounds(170,15,250,30);
		l2 = new JLabel("Trainer ID:");
		l2.setFont(new Font("arial",Font.BOLD,14));
		l2.setBounds(15,55,145,30);
		TID = new JComboBox<>();
		TID.setBounds(130,55,250,30);
		TID.addItem("--Choose Trainer ID--");
		TID.addPopupMenuListener(new PopupMenuListener() 
			{
                    
                    public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {}

                    
                    public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) 
					{
						String item = (String) TID.getSelectedItem();
						String sql = "SELECT * FROM NEWTRAINER WHERE Trainer_id = ?";
						try
						{
							PreparedStatement sts;
							ResultSet rs;
							sts = con.prepareStatement(sql);
							sts.setString(1,item);
							rs = sts.executeQuery();
							if(rs.next())
							{
								t1.setText(rs.getString("Name"));
								t2.setText(rs.getString("Gender"));
								t3.setText(rs.getString("Phone_No"));
								t4.setText(rs.getString("Email_id"));
								t5.setText(rs.getString("Address"));
								t6.setText(rs.getString("Type"));
								t7.setText(rs.getString("Height"));
								t8.setText(rs.getString("Weight"));
								byte[] imagedata = rs.getBytes("Image");
								format = new ImageIcon(imagedata);
								Image mm = format.getImage();
								Image img2 = mm.getScaledInstance(146,121,Image.SCALE_SMOOTH);
								ImageIcon image = new ImageIcon(img2);
								l12.setIcon(image);
							}  
						}
						catch(Exception e)
						{
						}
					}
					public void popupMenuCanceled(PopupMenuEvent pme) {  
					}
                });
		l3 = new JLabel("Name:");
		l3.setFont(new Font("arial",Font.BOLD,14));
		l3.setBounds(15,100,145,30);
		t1 = new JTextField();
		t1.setBounds(130,100,250,30);
		l4 = new JLabel("Gender:");
		l4.setFont(new Font("arial",Font.BOLD,14));
		l4.setBounds(15,145,145,30);
		t2 = new JTextField();
		t2.setBounds(130,145,250,30);
		l5 = new JLabel("Phone No.:");
		l5.setFont(new Font("arial",Font.BOLD,14));
		l5.setBounds(15,200,145,30);
		t3 = new JTextField();
		t3.setBounds(130,200,250,30);
		l6 = new JLabel("Mail:");
		l6.setFont(new Font("arial",Font.BOLD,14));
		l6.setBounds(15,255,145,30);
		t4 = new JTextField();
		t4.setBounds(130,255,250,30);
		l7 = new JLabel("Address:");
		l7.setFont(new Font("arial",Font.BOLD,14));
		l7.setBounds(15,310,145,30);
		t5 = new JTextField();
		t5.setBounds(130,310,250,30);
		l8 = new JLabel("Type:");
		l8.setFont(new Font("arial",Font.BOLD,14));
		l8.setBounds(15,350,145,30);
		t6 = new JTextField();
		t6.setBounds(130,350,250,30);
		l9 = new JLabel("Height:");
		l9.setFont(new Font("arial",Font.BOLD,14));
		l9.setBounds(15,395,145,30);
		t7 = new JTextField();
		t7.setBounds(130,395,250,30);
		l10 = new JLabel("Weight:");
		l10.setFont(new Font("arial",Font.BOLD,14));
		l10.setBounds(15,445,145,30);
		t8 = new JTextField();
		t8.setBounds(130,445,250,30);
		l11 = new JLabel("Image:");
		l11.setFont(new Font("arial",Font.BOLD,14));
		l11.setBounds(15,520,145,30);
		l12 = new JLabel();
		l12.setForeground(Color.black);
		l12.setBounds(130,495,146,121);
		add(p1);
		add(p2);
		p1.add(l1);
		p2.add(l2);
		p2.add(TID);
		p2.add(l3);
		p2.add(t1);
		p2.add(l4);
		p2.add(t2);
		p2.add(l5);
		p2.add(t3);
		p2.add(l6);
		p2.add(t4);
		p2.add(l7);
		p2.add(t5);
		p2.add(l8);
		p2.add(t6);
		p2.add(l9);
		p2.add(t7);
		p2.add(l10);
		p2.add(t8);
		p2.add(l11);
		p2.add(l12);
		
		
		
		
		setSize(500,800);
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
	public static void main(String[] args)
	{
		new UTrainerDetails();
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
}