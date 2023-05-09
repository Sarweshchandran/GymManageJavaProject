import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.sql.*;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScheduleExercise extends JFrame implements ActionListener
{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JComboBox<String> CID,S,M,T,W,TH,F,SAT;
	JButton b1,b2;
	Connection con;
	
	ScheduleExercise()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		setTitle("Schedule Exercise");
		p1 = new JPanel();
		p1.setBackground(new Color(96,130,182));
		p1.setBounds(0,0,700,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.white);
		p2.setBounds(0,50,700,750);
		l1 = new JLabel("Schedule Exercise");
		l1.setForeground(Color.white);
		l1.setBounds(150,25,250,25);
		l1.setFont(new Font("arial",Font.BOLD,20));
		l2 = new JLabel("Client ID:");
		l2.setBounds(30,60,100,25);
		CID = new JComboBox<>();
		CID.setBounds(120,60,200,25);
		CID.addPopupMenuListener(new PopupMenuListener()
		{
                    
                    public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {}

                    
                    public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) 
					{
						String item = (String) CID.getSelectedItem();
						String sql = "SELECT * FROM SCHEDULE WHERE Customer_ID = ?";
						try
						{
							PreparedStatement sts;
							ResultSet rs;
							sts = con.prepareStatement(sql);
							sts.setString(1,item);
							rs = sts.executeQuery();
							if(rs.next())
							{
								t1.setText(rs.getString("WORKOUT1"));
								t2.setText(rs.getString("WORKOUT2"));
								t3.setText(rs.getString("WORKOUT3"));
								t4.setText(rs.getString("WORKOUT4"));
								t5.setText(rs.getString("WORKOUT5"));
								t6.setText(rs.getString("WORKOUT6"));
								t7.setText(rs.getString("WORKOUT7"));
							}  
						}
						catch(Exception e)
						{
						}
					}
					public void popupMenuCanceled(PopupMenuEvent pme) {  
					}
                });
		l3 = new JLabel("Day 1:");
		l3.setBounds(30,100,100,25);
		S = new JComboBox<>();
		S.addItem("Select Day");
		S.addItem("Sunday");
		S.addItem("Monday");
		S.addItem("Tuesday");
		S.addItem("Wednesday");
		S.addItem("Thursday");
		S.addItem("Friday");
		S.addItem("Saturday");
		S.setBounds(120,100,200,25);
		l10 = new JLabel("Workout");
		l10.setBounds(30,140,100,25);
		t1 = new JTextField();
		t1.setBounds(120,140,200,25);
		l4 = new JLabel("Day 2:");
		l4.setBounds(30,180,100,25);
		M = new JComboBox<>();
		M.addItem("Select Day");
		M.addItem("Sunday");
		M.addItem("Monday");
		M.addItem("Tuesday");
		M.addItem("Wednesday");
		M.addItem("Thursday");
		M.addItem("Friday");
		M.addItem("Saturday");
		M.setBounds(120,180,200,25);
		l11  = new JLabel("Workout");
		l11.setBounds(30,220,100,25);
		t2 = new JTextField();
		t2.setBounds(120,220,200,25);
		l5 = new JLabel("Day 3:");
		l5.setBounds(30,260,100,25);
		T = new JComboBox<>();
		T.addItem("Select Day");
		T.addItem("Sunday");
		T.addItem("Monday");
		T.addItem("Tuesday");
		T.addItem("Wednesday");
		T.addItem("Thursday");
		T.addItem("Friday");
		T.addItem("Saturday");
		T.setBounds(120,260,200,25);
		l12 = new JLabel("Workout");
		l12.setBounds(30,300,100,25);
		t3 = new JTextField();
		t3.setBounds(120,300,200,25);
		l6 = new JLabel("Day 4:");
		l6.setBounds(30,340,100,25);
		W = new JComboBox<>();
		W.addItem("Select Day");
		W.addItem("Sunday");
		W.addItem("Monday");
		W.addItem("Tuesday");
		W.addItem("Wednesday");
		W.addItem("Thursday");
		W.addItem("Friday");
		W.addItem("Saturday");
		W.setBounds(120,340,200,25);
		l13 = new JLabel("Workout");
		l13.setBounds(30,380,100,25);
		t4 = new JTextField();
		t4.setBounds(120,380,200,25);
		l7 = new JLabel("Day 5:");
		l7.setBounds(30,420,100,25);
		TH = new JComboBox<>();
		TH.addItem("Select Day");
		TH.addItem("Sunday");
		TH.addItem("Monday");
		TH.addItem("Tuesday");
		TH.addItem("Wednesday");
		TH.addItem("Thursday");
		TH.addItem("Friday");
		TH.addItem("Saturday");
		TH.setBounds(120,420,200,25);
		l14 = new JLabel("Workout");
		l14.setBounds(30,460,100,25);
		t5 = new JTextField();
		t5.setBounds(120,460,200,25);
		l8 = new JLabel("Day 6:");
		l8.setBounds(30,500,100,25);
		F = new JComboBox<>();
		F.addItem("Select Day");
		F.addItem("Sunday");
		F.addItem("Monday");
		F.addItem("Tuesday");
		F.addItem("Wednesday");
		F.addItem("Thursday");
		F.addItem("Friday");
		F.addItem("Saturday");
		F.setBounds(120,500,200,25);
		l15 = new JLabel("Workout");
		l15.setBounds(30,540,100,25);
		t6 = new JTextField();
		t6.setBounds(120,540,200,25);
		l9 = new JLabel("Day 7:");
		l9.setBounds(30,580,100,25);
		SAT = new JComboBox<>();
		SAT.addItem("Select Day");
		SAT.addItem("Sunday");
		SAT.addItem("Monday");
		SAT.addItem("Tuesday");
		SAT.addItem("Wednesday");
		SAT.addItem("Thursday");
		SAT.addItem("Friday");
		SAT.addItem("Saturday");
		SAT.setBounds(120,580,200,25);
		l16 = new JLabel("Workout");
		l16.setBounds(30,620,100,25);
		t7 = new JTextField();
		t7.setBounds(120,620,200,25);
		b1 = new JButton("Submit");
		b1.setBounds(50,660,100,25);
		b1.addActionListener(this);
		b2 = new JButton("Update");
		b2.setBounds(160,660,100,25);
		b2.addActionListener(this);
		setSize(700,800);
		setLayout(null);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				dispose();
			}
		});
		add(p1);
		add(p2);
		p1.add(l1);
		p2.add(l2);
		p2.add(CID);
		p2.add(l3);
		p2.add(S);
		p2.add(l10);
		p2.add(t1);
		p2.add(l4);
		p2.add(M);
		p2.add(l11);
		p2.add(t2);
		p2.add(l5);
		p2.add(T);
		p2.add(l12);
		p2.add(t3);
		p2.add(l6);
		p2.add(W);
		p2.add(l13);
		p2.add(t4);
		p2.add(l7);
		p2.add(TH);
		p2.add(l14);
		p2.add(t5);
		p2.add(l8);
		p2.add(F);
		p2.add(l15);
		p2.add(t6);
		p2.add(l9);
		p2.add(SAT);
		p2.add(l16);
		p2.add(t7);
		p2.add(b1);
		p2.add(b2);
		setValues();
		
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==b1)
		{
			String id = CID.getSelectedItem().toString();
			String d1 = S.getSelectedItem().toString();
			String W1 = t1.getText();
			String d2 = M.getSelectedItem().toString();
			String W2 = t2.getText();
			String d3 = T.getSelectedItem().toString();
			String W3 = t3.getText();
			String d4 = W.getSelectedItem().toString();
			String W4 = t4.getText();
			String d5 = TH.getSelectedItem().toString();
			String W5 = t5.getText();
			String d6 = F.getSelectedItem().toString();
			String W6 = t6.getText();
			String d7 = SAT.getSelectedItem().toString();
			String W7 = t7.getText();
			PreparedStatement st;
			String query = "INSERT INTO SCHEDULE (CUSTOMER_ID,DAY1,WORKOUT1,DAY2,WORKOUT2,DAY3,WORKOUT3,DAY4,WORKOUT4,DAY5,WORKOUT5,DAY6,WORKOUT6,DAY7,WORKOUT7) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			/*if(S.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}
			if(M.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}
			if(T.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}
			if(W.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}
			if(TH.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}
			if(F.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}
			if(SAT.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select the Day");
			}*/
			try
			{
				st = con.prepareStatement(query);
				st.setString(1,id);
				st.setString(2,d1);
				st.setString(3,W1);
				st.setString(4,d2);
				st.setString(5,W2);
				st.setString(6,d3);
				st.setString(7,W3);
				st.setString(8,d4);
				st.setString(9,W4);
				st.setString(10,d5);
				st.setString(11,W5);
				st.setString(12,d6);
				st.setString(13,W6);
				st.setString(14,d7);
				st.setString(15,W7);
				if(st.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(null,"Workout Scheduled:)");
					this.dispose();
					
				}
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,ex);
			}
		}
		if(evt.getSource()==b2)
		{
			String id = CID.getSelectedItem().toString();
			String d1 = S.getSelectedItem().toString();
			String W1 = t1.getText();
			String d2 = M.getSelectedItem().toString();
			String W2 = t2.getText();
			String d3 = T.getSelectedItem().toString();
			String W3 = t3.getText();
			String d4 = W.getSelectedItem().toString();
			String W4 = t4.getText();
			String d5 = TH.getSelectedItem().toString();
			String W5 = t5.getText();
			String d6 = F.getSelectedItem().toString();
			String W6 = t6.getText();
			String d7 = SAT.getSelectedItem().toString();
			String W7 = t7.getText();
			PreparedStatement sst;
			String query1 = "UPDATE SCHEDULE SET DAY1 = '"+d1+"', Workout1 = '"+W1+"', Day2 = '"+d2+"', Workout2 = '"+W2+"', Day3 = '"+d3+"', Workout3 = '"+W3+"', Day4 = '"+d4+"', Workout4 = '"+W4+"', Day5 = '"+d5+"', Workout5 = '"+W5+"', Day6 = '"+d6+"', Workout6 = '"+W6+"', Day7 = '"+d7+"', Workout7 = '"+W7+"' WHERE CUSTOMER_ID = '"+id+"'";
			try
			{
				sst = con.prepareStatement(query1);
				sst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Schedule Updated:)");
				this.dispose();
			}
			catch(SQLException er)
			{
				JOptionPane.showMessageDialog(null,er);
			}
		}
	}
	public void setValues()
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
		new ScheduleExercise();
	}
}