
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyConnection 
{
    Connection con = null;
	public Connection Connect()
	{
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/gym","root","Admin");
		   return con;
        } 
		catch (ClassNotFoundException | SQLException ex)
		{
            System.out.println(ex.getMessage());
			return null;
		}
	}
}