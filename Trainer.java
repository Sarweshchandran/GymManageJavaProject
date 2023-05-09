
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener; 

public class Trainer extends JFrame implements ActionListener
{
	JPanel p1;
	JMenuBar M;
	JMenu My_Info,View,CS,L;
	JMenuItem M1,M2,M3,M4,M5,M6,M7;
	Trainer()
	{
		setTitle("Trainer");
		p1 = new JPanel();
		p1.setBackground(new Color(111,143,175));
		p1.setBounds(0,0,2000,2000);
		M = new JMenuBar();
		My_Info = new JMenu("My Info");
		View = new JMenu("View");
		CS = new JMenu("Client Exercise");
		L = new JMenu("Logout");
		M1 = new JMenuItem("Profile");
		M1.setFont(new Font("arial",Font.PLAIN,14));
		M2 = new JMenuItem("Credentials");
		M2.setFont(new Font("arial",Font.PLAIN,14));
		M3 = new JMenuItem("Attendence");
		M3.setFont(new Font("arial",Font.PLAIN,14));
		M4 = new JMenuItem("Salary Details");
		M4.setFont(new Font("arial",Font.PLAIN,14));
		M5 = new JMenuItem("Client Details");
		M5.setFont(new Font("arial",Font.PLAIN,14));
		M6 = new JMenuItem("Schedule Exercise");
		M6.setFont(new Font("arial",Font.PLAIN,14));
		M7 = new JMenuItem("Logout");
		M7.setFont(new Font("arial",Font.PLAIN,14));
		M1.addActionListener(this);
		M2.addActionListener(this);
		M3.addActionListener(this);
		M4.addActionListener(this);
		M5.addActionListener(this);
		M6.addActionListener(this);
		M7.addActionListener(this);
		add(p1);
		M.add(My_Info);
		M.add(View);
		M.add(CS);
		M.add(L);
		My_Info.add(M1); My_Info.add(M2); My_Info.add(M3); My_Info.add(M4);
		View.add(M5); 
		CS.add(M6);
		L.add(M7);
		setJMenuBar(M);
		setLayout(null);
		setSize(2000,2000);
		setVisible(true);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windoeClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==M1)
		{
			TProfile T = new TProfile();
			T.setVisible(true);
			T.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M2)
		{
			TCredentials TC = new TCredentials();
			TC.setVisible(true);
			TC.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M3)
		{
			TAttendence TA = new TAttendence();
			TA.setVisible(true);
			TA.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M4)
		{
			SalaryDetails SD = new SalaryDetails();
			SD.setVisible(true);
			SD.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M5)
		{
			TClientDetails TCD = new TClientDetails();
			TCD.setVisible(true);
			TCD.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M6)
		{
			ScheduleExercise SE = new ScheduleExercise();
			SE.setVisible(true);
			SE.setLocationRelativeTo(null);
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
		new Trainer();
	}
}

/*
M1= profile[M];
M2=Credentials[M];
M3=Attendence[M];
M4=salary details;
M5=Client Details[V];
M6=Schedule Exercise[CS]*/