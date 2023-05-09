import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class User extends JFrame implements ActionListener
{
	JPanel p1;
	JMenuBar P;
	JMenu My_Info,View,SC,L;
	JMenuItem M1,M2,M3,M4,M5,M6,M7;
	User()
	{
		setTitle("User");
		p1 = new JPanel();
		p1.setBackground(new Color(167,199,231));
		p1.setBounds(0,0,2000,2000);
		P = new JMenuBar();
		My_Info = new JMenu("My Info");
		My_Info.setFont(new Font("arial",Font.PLAIN,14));
		View = new JMenu("View");
		View.setFont(new Font("arial",Font.PLAIN,14));
		SC = new JMenu("Schedule");
		SC.setFont(new Font("arial", Font.PLAIN,14));
		L= new JMenu("Logout");
		M1 = new JMenuItem(" My Profile");
		M2 = new JMenuItem("Credentials");
		M3 = new JMenuItem("Attendence");
		M4 = new JMenuItem("Trainer Details");
		M5 = new JMenuItem("Payment Details");
		M6 = new JMenuItem("Daily Schedule");
		M7 = new JMenuItem("Logout");
		M1.addActionListener(this);
		M2.addActionListener(this);
		M3.addActionListener(this);
		M4.addActionListener(this);
		M5.addActionListener(this);
		M6.addActionListener(this);
		M7.addActionListener(this);
		add(p1);
		P.add(My_Info);
		P.add(View);
		P.add(SC);
		P.add(L);
		My_Info.add(M1); My_Info.add(M2);
		View.add(M3); View.add(M4); View.add(M5);
		SC.add(M6);
		L.add(M7);
		setJMenuBar(P);
		setLayout(null);
		setSize(2000,2000);
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
		public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==M1)
		{
			UMyProfile UM = new UMyProfile();
			UM.setVisible(true);
			UM.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M2)
		{
			UCredentials UC = new UCredentials();
			UC.setVisible(true);
			UC.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M3)
		{
			UAttendence UA = new UAttendence();
			UA.setVisible(true);
			UA.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M4)
		{
			UTrainerDetails UTD = new UTrainerDetails();
			UTD.setVisible(true);
			UTD.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M5)
		{
			UPaymentDetails UPD = new UPaymentDetails();
			UPD.setVisible(true);
			UPD.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M6)
		{
			UDailySchedule UD = new UDailySchedule();
			UD.setVisible(true);
			UD.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M7)
		{
			int a; 
			a=JOptionPane.showConfirmDialog(null,"Do you really want to quit user registration page?","Select",JOptionPane.YES_NO_OPTION);
			if(a==0)
			{
				setVisible(false);
				new Login().setVisible(true);
			}
		}
	}
	public static void main(String args[])
	{
		new User();
	}
}