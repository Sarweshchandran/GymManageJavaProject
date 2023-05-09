import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;


public class TrainerDetails extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JComboBox<String> TID;
	JButton b1,b2,b3;
	FileInputStream fis;
	String filename;
	byte[] person_image;
	byte[] image1;
	ImageIcon format;
	Connection con;
	
	TrainerDetails()
	{
		MyConnection my = new MyConnection();
	    con = my.Connect();
		setTitle("Trainer Details");
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setBounds(0,0,800,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.white);
		p2.setBounds(0,51,800,750);
		l1 = new JLabel("Trainer Details");
		l1.setFont(new Font("arial",Font.BOLD,18));
		l1.setForeground(Color.white);
		l1.setBounds(170,15,250,30);
		l2 = new JLabel("Trainer ID:");
		l2.setFont(new Font("arial",Font.BOLD,14));
		l2.setBounds(15,55,145,30);
		TID = new JComboBox<>();
		TID.setBounds(130,55,200,30);
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
		t1.setBounds(130,100,200,30);
		l4 = new JLabel("Gender:");
		l4.setFont(new Font("arial",Font.BOLD,14));
		l4.setBounds(15,145,145,30);
		t2 = new JTextField();
		t2.setBounds(130,145,200,30);
		l5 = new JLabel("Phone No.:");
		l5.setFont(new Font("arial",Font.BOLD,14));
		l5.setBounds(15,200,145,30);
		t3 = new JTextField();
		t3.setBounds(130,200,200,30);
		l6 = new JLabel("Mail:");
		l6.setFont(new Font("arial",Font.BOLD,14));
		l6.setBounds(15,255,145,30);
		t4 = new JTextField();
		t4.setBounds(130,255,200,30);
		l7 = new JLabel("Address:");
		l7.setFont(new Font("arial",Font.BOLD,14));
		l7.setBounds(15,310,145,30);
		t5 = new JTextField();
		t5.setBounds(130,310,200,30);
		l8 = new JLabel("Type:");
		l8.setFont(new Font("arial",Font.BOLD,14));
		l8.setBounds(15,350,145,30);
		t6 = new JTextField();
		t6.setBounds(130,350,200,30);
		l9 = new JLabel("Height:");
		l9.setFont(new Font("arial",Font.BOLD,14));
		l9.setBounds(15,395,145,30);
		t7 = new JTextField();
		t7.setBounds(130,395,200,30);
		l10 = new JLabel("Weight:");
		l10.setFont(new Font("arial",Font.BOLD,14));
		l10.setBounds(15,445,145,30);
		t8 = new JTextField();
		t8.setBounds(130,445,200,30);
		l11 = new JLabel("Image:");
		l11.setFont(new Font("arial",Font.BOLD,14));
		l11.setBounds(15,520,145,30);
		l12 = new JLabel();
		l12.setForeground(Color.black);
		l12.setBounds(130,495,146,121);
		b1 = new JButton("Update");
		b1.setBounds(130,650,100,30);
		b1.addActionListener(this);
		b2 = new JButton("Delete");
		b2.setBounds(270,650,80,30);
		b2.addActionListener(this);
		b3 =  new JButton("Browse");
		b3.setBounds(300,530,80,30);
		b3.addActionListener(this);
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
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		setSize(800,800);
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
		setvalues();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			String id = TID.getSelectedItem().toString();
			String name = t1.getText();
			String G = t2.getText();
			String PH = t3.getText();
			String mail = t4.getText();
			String addr = t5.getText();
			String t= t6.getText();
			String H = t7.getText();
			String W = t8.getText();
			
			PreparedStatement st;
			String query = "UPDATE NEWTRAINER SET Name = '"+t1.getText()+"' , Gender = '"+t2.getText()+"' , Phone_No = '"+t3.getText()+"', Email_id = '"+t4.getText()+"', Address = '"+t5.getText()+"' , Type = '"+t6.getText()+"' , Height = '"+t7.getText()+"' , Weight = '"+t8.getText()+"' WHERE Trainer_id = '"+TID.getSelectedItem()+"'";
			try
			{
				
				st = con.prepareStatement(query);
				st.executeUpdate();
				
					JOptionPane.showMessageDialog(null," Trainer Data Updated");
					this.dispose();
				
			}
			catch(SQLException ex)
			{
				Logger.getLogger(TrainerDetails.class.getName()).log(Level.SEVERE,null,ex);
			}
			try
			{
				File file = new File(filename);
				FileInputStream fis = new FileInputStream(file);
				byte[] image1 = new byte[(int)file.length()];
				fis.read(image1);
				String sql1 = "UPDATE NEWTRAINER SET Image = ? WHERE Trainer_id = '"+TID.getSelectedItem()+"'";
				st = con.prepareStatement(sql1);
				st.setBytes(1,image1);
				st.executeUpdate();
			}
			catch(NullPointerException | SQLException |IOException er)
			{
				//JOptionPane.showMessageDialog(null,er);
			}
		}
		if(e.getSource() == b2)
		{
			int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?","Delete",JOptionPane.YES_NO_OPTION);
			if(d==0)
			{
				PreparedStatement sts;
				String qry2 = "DELETE FROM NEWTRAINER WHERE TRAINER_ID = '"+TID.getSelectedItem()+"'";
				try
				{
					sts = con.prepareStatement(qry2);
					sts.execute();
					JOptionPane.showMessageDialog(null,"Trainer Data Deleted");
					this.dispose();
				}
				catch(Exception ed)
				{
					JOptionPane.showMessageDialog(null,ed);
				}
			}
			
		}
		if(e.getSource() == b3)
		{
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
        
			filename =f.getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(l12.getWidth(), l12.getHeight(), Image.SCALE_SMOOTH));
			l12.setIcon(imageIcon);
			try {

				File image = new File(filename);
				FileInputStream fis = new FileInputStream (image);
				ByteArrayOutputStream bos= new ByteArrayOutputStream();
				byte[] buf = new byte[1024];

				for(int readNum; (readNum=fis.read(buf))!=-1; ){

					bos.write(buf,0,readNum);
				}
				person_image=bos.toByteArray();
			}

			catch(Exception ew){
            JOptionPane.showMessageDialog(null,ew);

			}
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
		
	public static void main(String args[])
	{
		new TrainerDetails();
	}
}