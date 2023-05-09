import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
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


public class ClientDetails extends JFrame implements ActionListener
{
	JPanel p1,panel;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JComboBox<String> CID,TID,plan;
	FileInputStream fis;
	String filename = null;
	byte[] person_image = null;
	byte[] image1 = null;
	JFileChooser chooser;
	ImageIcon format = null;
	JButton b1,b2,b3;
	Connection con;
	ClientDetails()
	{
		setTitle("Client Details");
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
		CID.addPopupMenuListener(new PopupMenuListener() 
			{
                    
                    public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {}

                    
                    public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) 
					{
						String item = (String) CID.getSelectedItem();
						String item1 = (String) TID.getSelectedItem();
						String sql = "SELECT * FROM NEWCLIENT  WHERE Customer_ID = ?";
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
								l16.setIcon(image);
							}  
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
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
		l12 = new JLabel("Trainern ID:");
		l12.setBounds(15,545,145,30);
		TID = new JComboBox<>();	
		TID.setBounds(130,545,200,30);
		TID.addPopupMenuListener(new PopupMenuListener() 
			{
                    
                    public void popupMenuWillBecomeVisible(PopupMenuEvent pme1) {}

                    
                    public void popupMenuWillBecomeInvisible(PopupMenuEvent pme1) 
					{
						String item1 = (String) TID.getSelectedItem();
						String sql2 = "SELECT NAME FROM NEWTRAINER WHERE TRAINER_ID = ?";
						try
						{
							PreparedStatement sts1;
							ResultSet rsst;
							sts1 = con.prepareStatement(sql2);
							sts1.setString(1,item1);
							rsst = sts1.executeQuery();
							if(rsst.next())
							{
								t10.setText(rsst.getString("Name"));
							}  
						}
						catch(Exception er)
						{
							JOptionPane.showMessageDialog(null,er);
						}
					}
					public void popupMenuCanceled(PopupMenuEvent pme1) {  
					}
                });
		l13 = new JLabel("Trainer Name:");
		l13.setBounds(15,595,145,30);
		t10 = new JTextField();
		t10.setBounds(130,595,200,30);
		l14 = new JLabel("Preffered Plan:");
		l14.setBounds(15,645,145,30);
		plan = new JComboBox<>();
		plan.addItem("1-Month");
		plan.addItem("3-Months");
		plan.addItem("5-Months");
		plan.addItem("6-Months");
		plan.addItem("1-Year");
		plan.setBounds(130,645,200,30);
		l15 = new JLabel("Image:");
		l15.setBounds(400,95,145,30);
		l16 = new JLabel();
		l16.setBounds(470,55,141,126);
		b1 = new JButton("Update");
		b1.setBounds(360,245,100,30);
		b1.addActionListener(this);
		b2 = new JButton("Delete");
		b2.setBounds(470,245,80,30);
		b2.addActionListener(this);
		b3 =  new JButton("Browse");
		b3.setBounds(470,195,80,30);
		b3.addActionListener(this);
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
		panel.add(TID);
		panel.add(l13);
		panel.add(t10);
		panel.add(l14);
		panel.add(plan);
		panel.add(l15);
		panel.add(l16);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		setSize(650,800);
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
			String id = CID.getSelectedItem().toString();
			String name = t1.getText();
			String G = t2.getText();
			String db = t3.getText();
			String mail = t4.getText();
			String PH = t5.getText();
			String H = t6.getText();
			String W = t7.getText();
			String addr = t8.getText();
			String t = t9.getText();
			String Tid = TID.getSelectedItem().toString();
			String pp = plan.getSelectedItem().toString();
			PreparedStatement st;
			String query = "UPDATE NEWCLIENT SET Name = '"+name+"',Gender = '"+G+"',DOB = '"+db+"',EmailId = '"+mail+"', Phoneno = '"+PH+"', Height = '"+H+"', Weight = '"+W+"', Address = '"+addr+"', TrainerType = '"+t+"', TrainerID = '"+Tid+"', PrefferredPlan = '"+pp+"' WHERE Customer_ID ='"+id+"' ";
			try
			{
				st = con.prepareStatement(query);
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Client Data Updated");
				this.dispose();
				
			}
			catch(Exception  ex)
			{
				JOptionPane.showMessageDialog(null,ex);
			}
			try
			{
				File file = new File(filename);
				FileInputStream fis = new FileInputStream(file);
				byte[] image1 = new byte[(int)file.length()];
				fis.read(image1);
				String sql1 = "UPDATE NEWCLIENT SET Image = ? WHERE Customer_ID = '"+id+"'";
				st = con.prepareStatement(sql1);
				st.setBytes(1,image1);
				st.executeUpdate();
			}
			catch(Exception er)
			{
				//JOptionPane.showMessageDialog(null,er);
			}
		}
		if(e.getSource() == b2)
		{
			String id = CID.getSelectedItem().toString();
			int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?","Delete",JOptionPane.YES_NO_OPTION);
			if(d==0)
			{
				PreparedStatement sts;
				String qry2 = "DELETE FROM NEWCLIENT WHERE CUSTOMER_ID = '"+id+"'";
				try
				{
					sts = con.prepareStatement(qry2);
					sts.execute();
					JOptionPane.showMessageDialog(null,"Client Data Deleted");
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
			chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
        
			filename =f.getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(l16.getWidth(), l16.getHeight(), Image.SCALE_SMOOTH));
			l16.setIcon(imageIcon);
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
		   String qry = "SELECT N.CUSTOMER_ID,T.Trainer_id FROM NEWCLIENT N, NEWTRAINER T";
		   pst = con.prepareStatement(qry);
		   rss = pst.executeQuery();
		   while(rss.next())
		   {
			   CID.removeAllItems();
			   CID.addItem("--Choose Client ID--");
			   CID.addItem(rss.getString("CUSTOMER_ID"));
			   TID.addItem(rss.getString("Trainer_id"));
			}
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
	   }
	   
   }
   
   public static void main(String args[])
	{
		new ClientDetails();
	}
}