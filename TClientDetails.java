import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Image;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TClientDetails extends JFrame
{
	JPanel p1,panel;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JComboBox<String> CID,TID;
	byte[] image1 = null;
	ImageIcon format = null;
	
	Connection con;
	
	TClientDetails()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setBounds(0,0,650,50);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.setBounds(0,51,650,750);
		l1 = new JLabel("Client Details");
		l1.setFont(new Font("arial",Font.BOLD,18));
		l1.setForeground(Color.white);
		l1.setBounds(170,15,220,30);
		l2 = new JLabel("Customer ID:");
		l2.setFont(new Font("arial",Font.BOLD,14));
		l2.setBounds(15,55,145,30);
		CID = new JComboBox<>();
		CID.setBounds(130,55,200,30);
		CID.addItem("--Choose Client ID--");
		CID.addPopupMenuListener(new PopupMenuListener() 
			{
                    
                    public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {}

                    
                    public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) 
					{
						String item = (String) CID.getSelectedItem();
						String sql = "SELECT * FROM NEWCLIENT WHERE Customer_ID = ?";
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
								t3.setText(rs.getString("DOB"));
								t4.setText(rs.getString("EmailId"));
								t5.setText(rs.getString("Phoneno"));
								t6.setText(rs.getString("Height"));
								t7.setText(rs.getString("Weight"));
								t8.setText(rs.getString("Address"));
								t9.setText(rs.getString("TrainerType"));
								byte[] imagedata = rs.getBytes("Image");
								format = new ImageIcon(imagedata);
								Image mm = format.getImage();
								Image img2 = mm.getScaledInstance(146,121,Image.SCALE_SMOOTH);
								ImageIcon image = new ImageIcon(img2);
								l13.setIcon(image);
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
		l3.setBounds(15,95,145,30);
		t1 = new JTextField();
		t1.setBounds(130,95,200,30);
		l4 = new JLabel("Gender:");
		l4.setFont(new Font("arial",Font.BOLD,14));
		l4.setBounds(15,145,145,30);
		t2 = new JTextField();
		t2.setBounds(130,145,200,30);
		l5 = new JLabel("DOB:");
		l5.setFont(new Font("arial",Font.BOLD,14));
		l5.setBounds(15,195,145,30);
		t3 = new JTextField();
		t3.setBounds(130,195,200,30);
		l6 = new JLabel("Mail:");
		l6.setFont(new Font("arial",Font.BOLD,14));
		l6.setBounds(15,245,145,30);
		t4 = new JTextField();
		t4.setBounds(130,245,200,30);
		l7 = new JLabel("Phone No.:");
		l7.setFont(new Font("arial",Font.BOLD,14));
		l7.setBounds(15,295,145,30);
		t5 = new JTextField();
		t5.setBounds(130,295,200,30);
		l8 = new JLabel("Height:");
		l8.setFont(new Font("arial",Font.BOLD,14));
		l8.setBounds(15,345,145,30);
		t6 = new JTextField();
		t6.setBounds(130,345,200,30);
		l9 = new JLabel("Weight:");
		l9.setFont(new Font("arial",Font.BOLD,14));
		l9.setBounds(15,395,145,30);
		t7 = new JTextField();
		t7.setBounds(130,395,200,30);
		l10 = new JLabel("Address:");
		l10.setFont(new Font("arial",Font.BOLD,14));
		l10.setBounds(15,445,145,30);
		t8 = new JTextField();
		t8.setBounds(130,445,200,30);
		l11 = new JLabel("Trainer Type");
		l11.setFont(new Font("arial",Font.BOLD,14));
		l11.setBounds(15,495,145,30);
		t9 = new JTextField();
		t9.setBounds(130,495,200,30);
		l12 = new JLabel("Image:");
		l12.setBounds(15,545,145,30);
		l13 = new JLabel();
		l13.setBounds(130,545,141,126);
		add(p1);
		add(panel);
		p1.add(l1);
		panel.add(l2);
		panel.add(CID);
		panel.add(l3);
		panel.add(t1);
		panel.add(l4);
		panel.add(t2);
		panel.add(l5);
		panel.add(t3);
		panel.add(l6);
		panel.add(t4);
		panel.add(l7);
		panel.add(t5);
		panel.add(l8);
		panel.add(t6);
		panel.add(l9);
		panel.add(t7);
		panel.add(l10);
		panel.add(t8);
		panel.add(l11);
		panel.add(t9);
		panel.add(l12);
		panel.add(l13);
		setSize(650,800);
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
			   CID.addItem(rss.getString("CUSTOMER_ID"));
		   }
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
	   }
	   
   }
	public static void main(String[] args)
	{
		new TClientDetails();
	}
}