package GYM;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.*;
import java.util.Date.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import com.toedter.calendar.JDateChooser;

public class TrainerAttendence extends JFrame
{
   JDateChooser d; 
   TrainerAttendence()
   {
		setTitle("Contoh JdateChooser");
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		d = new com.toedter.calendar.JDateChooser();
		d.setBounds(20,40,150,25);
		add(d);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
   }
   
   public static void main(String[] args)
   {
	   new TrainerAttendence();
   }
}