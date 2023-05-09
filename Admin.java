import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener; 

public class Admin extends JFrame implements ActionListener
{
	JPanel p1;
	JMenuBar M;
	JLabel l1;
	JMenu Regis,Atten,View,Pay,CS,L;
	JMenuItem M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M14;
	Admin()
	{
		setTitle("Admin");
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setBounds(0,0,2000,2000);
		M = new JMenuBar();
		Regis = new JMenu("Registration");
		Regis.setFont(new Font("arial",Font.PLAIN,14));
		Atten = new JMenu("Attendence");
		Atten.setFont(new Font("arial",Font.PLAIN,14));
		View = new JMenu("View");
		View.setFont(new Font("arial",Font.PLAIN,14));
		Pay = new JMenu("Payments");
		Pay.setFont(new Font("arial",Font.PLAIN,14));
		CS = new JMenu("Client Schedule");
		CS.setFont(new Font("arial",Font.PLAIN,14));
		L = new JMenu("Logout");
		L.setFont(new Font("arial",Font.PLAIN,14));
		M1 = new JMenuItem("New Trainer Registration");
		M2 = new JMenuItem("New Client Registration");
		M3 = new JMenuItem("Trainer Attendence");
		M4 = new JMenuItem("Client Attendence");
		M5 = new JMenuItem("View Trainer Attendence");
		M6 = new JMenuItem("View Client Attendence");
		M7 = new JMenuItem("Trainer Details");
		M8 = new JMenuItem("Client Details");
		M9 = new JMenuItem("View All Trainer's");
		M10 = new JMenuItem("View All Client's");
		M11 = new JMenuItem("Trainer Salary");
		M12 = new JMenuItem("Client Fee ");
		M14 = new JMenuItem("Logout");
		l1 = new JLabel();
		l1.setIcon(new ImageIcon("G:/JavaProject/download.jpeg"));
		l1.setBounds(0,50,2000,2000);
		M1.addActionListener(this);
		M2.addActionListener(this);
		M3.addActionListener(this);
		M4.addActionListener(this);
		M5.addActionListener(this);
		M6.addActionListener(this);
		M7.addActionListener(this);
		M8.addActionListener(this);
		M9.addActionListener(this);
		M10.addActionListener(this);
		M11.addActionListener(this);
		M12.addActionListener(this);
		M14.addActionListener(this);
		add(p1);
		p1.add(l1);
		M.add(Regis); M.add(Atten); M.add(View); M.add(Pay); /*M.add(CS);*/ M.add(L);
		Regis.add(M1); Regis.add(M2);
		Atten.add(M3); Atten.add(M4); Atten.add(M5); Atten.add(M6);
		View.add(M7); View.add(M8); View.add(M9); View.add(M10);
		Pay.add(M11); Pay.add(M12);
		L.add(M14);
		setJMenuBar(M);
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
			NewTrainerRegistration N = new NewTrainerRegistration();
			N.setVisible(true);
			N.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M2)
		{
			NewClientRegistration C = new NewClientRegistration();
			C.setVisible(true);
			C.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M3)
		{
			TrainerAttendence T = new TrainerAttendence();
			T.setVisible(true);
			T.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M4)
		{
			ClientAttendence CA = new ClientAttendence();
			CA.setVisible(true);
			CA.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M5)
		{
			TrainerAttendenceView TA = new TrainerAttendenceView();
			TA.setVisible(true);
			TA.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M6)
		{
			ClientAttendenceView CV = new ClientAttendenceView();
			CV.setVisible(true);
			CV.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M7)
		{
			TrainerDetails T = new TrainerDetails();
			T.setVisible(true);
			T.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M8)
		{
			ClientDetails CD = new ClientDetails();
			CD.setVisible(true);
			CD.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M9)
		{
			TrainerDetailsTable D = new TrainerDetailsTable();
			D.setVisible(true);
			D.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M10)
		{
			ClientDetailsTable CDT = new ClientDetailsTable();
			CDT.setVisible(true);
			CDT.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M11)
		{
			TrainerSalary TS = new TrainerSalary();
			TS.setVisible(true);
			TS.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M12)
		{
			ClientFees CF = new ClientFees();
			CF.setVisible(true);
			CF.setLocationRelativeTo(null);
		}
		else if(evt.getSource()==M14)
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
	public static void main(String[] args)
	{
		new Admin();
	}
}
/*{
M1=New Trainer Registration, M2=New Client Registration
M3=Trainer Attendence M4 = Client Attendence
M5=Trainer Attendenceview(table)
M6=client Attendenceview {M7=TrainerDetails,
M8=client details M9=Trainer Details table
M10= Client Details Table M11=Trainer Salary
M12 = Client fees M13 = Client Schedule}*/

