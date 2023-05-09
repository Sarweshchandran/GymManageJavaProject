import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TrainerDetailsTable extends JFrame
{
	JTable T1;
	JLabel l1;
	JPanel p1,p2;
	JScrollPane P;
	Connection con;
	
	TrainerDetailsTable()
	{
		MyConnection my = new MyConnection();
		con = my.Connect();
		setTitle("Trainer Details Table");
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(96, 130, 182));
		p1.setBounds(0,0,2000,50);
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,51,2000,700);
		p2.setBackground(Color.white);
		l1= new JLabel("Trainer View");
		l1.setForeground(Color.white);
		l1.setBounds(700,15,200,20);
		l1.setFont(new Font("arial",Font.BOLD,18));
		String [][] data = {};
		String[] columnNames = {};
		T1 = new JTable(data,columnNames);
		P = new JScrollPane(T1);
		P.setBounds(10,100,1400,600);
		/*TableModel model = new TableModel(data,columnNames);
		T1.setModel(model);
		T1.setRowHeight(120);
		T1.getColumnModel().getColumn(10).setPreferredWidth(150);*/
		add(p1);
		add(p2);
		p1.add(l1);
		p2.add(P);
		setSize(2000,2000);
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
		updateTable();
	}
	public void updateTable()
	{
		 try
	   {
		   PreparedStatement ps;
		   ResultSet rs;
		   String qry = "SELECT * FROM NEWTRAINER";
		   ps = con.prepareStatement(qry);
		   rs = ps.executeQuery();
		   T1.setModel(DbUtils.resultSetToTableModel(rs));
		}
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
	   }
	}
	public static void main(String[] args)
	{
		new TrainerDetailsTable();
	}
}