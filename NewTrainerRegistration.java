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


public class NewTrainerRegistration extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JPasswordField pass;
	JComboBox<String> gender,Ttype;
	JButton b1,b2,b3;
	FileInputStream fis;
	String filename = null;
	byte[] person_image = null;
	JFileChooser filechooser;
	Border border;
	Connection con;
   
	NewTrainerRegistration()
	{
		MyConnection my = new MyConnection();
	    con = my.Connect();
		setTitle("New Registration");
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setBounds(0,0,800,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.white);
		p2.setBounds(0,51,800,750);
		l1 = new JLabel("New Trainer Registration");
		l1.setFont(new Font("arial",Font.BOLD,18));
		l1.setForeground(Color.white);
		l1.setBounds(170,15,250,30);
		l2 = new JLabel("Trainer ID:");
		l2.setFont(new Font("arial",Font.BOLD,14));
		l2.setBounds(15,45,145,30);
		t1 = new JTextField();
		t1.setBounds(130,45,200,30);
		l3 = new JLabel("Name:");
		l3.setFont(new Font("arial",Font.BOLD,14));
		l3.setBounds(15,95,145,30);
		t2 = new JTextField();
		t2.setBounds(130,95,200,30);
		l4 = new JLabel("Gender:");
		l4.setFont(new Font("arial",Font.BOLD,14));
		l4.setBounds(15,145,145,30);
		gender = new JComboBox<>();
		gender.addItem("Male");
		gender.addItem("Female");
		gender.setBounds(130,145,200,30);
		l5 = new JLabel("Phone No.:");
		l5.setFont(new Font("arial",Font.BOLD,14));
		l5.setBounds(15,195,145,30);
		t3 = new JTextField();
		t3.setBounds(130,195,200,30);
		l6 = new JLabel("Mail:");
		l6.setFont(new Font("arial",Font.BOLD,14));
		l6.setBounds(15,245,145,30);
		t4 = new JTextField();
		t4.setBounds(130,245,200,30);
		l7 = new JLabel("Address:");
		l7.setFont(new Font("arial",Font.BOLD,14));
		l7.setBounds(15,295,145,30);
		t5 = new JTextField();
		t5.setBounds(130,295,200,30);
		l8 = new JLabel("Type:");
		l8.setFont(new Font("arial",Font.BOLD,14));
		l8.setBounds(15,345,145,30);
		Ttype = new JComboBox<>();
		Ttype.addItem("Public");
		Ttype.addItem("Personal");
		Ttype.setBounds(130,345,200,30);
		l9 = new JLabel("Height:");
		l9.setFont(new Font("arial",Font.BOLD,14));
		l9.setBounds(15,395,145,30);
		t6 = new JTextField();
		t6.setBounds(130,395,200,30);
		l10 = new JLabel("Weight:");
		l10.setFont(new Font("arial",Font.BOLD,14));
		l10.setBounds(15,445,145,30);
		t7 = new JTextField();
		t7.setBounds(130,445,200,30);
		l11 = new JLabel("Image:");
		l11.setFont(new Font("arial",Font.BOLD,14));
		l11.setBounds(15,520,145,30);
		l12 = new JLabel();
		l12.setForeground(Color.black);
		l12.setBounds(130,495,146,121);
		b1 = new JButton("Register");
		b1.setBounds(130,650,100,30);
		b1.addActionListener(this);
		b2 = new JButton("Clear");
		b2.setBounds(270,650,80,30);
		b2.addActionListener(this);
		b3 =  new JButton("Browse");
		b3.setBounds(300,530,80,30);
		b3.addActionListener(this);
		add(p1);
		add(p2);
		p1.add(l1);
		p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(t2);
		p2.add(l4);
		p2.add(gender);
		p2.add(l5);
		p2.add(t3);
		p2.add(l6);
		p2.add(t4);
		p2.add(l7);
		p2.add(t5);
		p2.add(l8);
		p2.add(Ttype);
		p2.add(l9);
		p2.add(t6);
		p2.add(l10);
		p2.add(t7);
		p2.add(l11);
		p2.add(l12);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			String id = t1.getText();
			String name = t2.getText();
			String G = gender.getSelectedItem().toString();
			String PH = t3.getText();
			String mail = t4.getText();
			String addr = t5.getText();
			String t= Ttype.getSelectedItem().toString();
			String H = t6.getText();
			String W = t7.getText();
			PreparedStatement st;
			String query = "INSERT INTO NEWTRAINER (Trainer_id, Name, Gender, Phone_No, Email_id, Address, Type, Height, Weight, Image) VALUES (?,?,?,?,?,?,?,?,?,?)";
			try
			{
				st = con.prepareStatement(query);
				st.setString(1,id);
				st.setString(2,name);
				st.setString(3,G);
				st.setString(4,PH);
				st.setString(5,mail);
				st.setString(6,addr);
				st.setString(7,t);
				st.setString(8,H);
				st.setString(9,W);
				st.setBytes(10,person_image);
				if(st.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(null,"New Trainer Added");
					this.dispose();
				}
			}
			catch(SQLException /*| IOException*/ ex)
			{
				Logger.getLogger(NewTrainerRegistration.class.getName()).log(Level.SEVERE,null,ex);
			}
		}
		if(e.getSource() == b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			l12.setIcon(null);
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
	
	public static void main(String args[])
	{
		new NewTrainerRegistration();
	}
}