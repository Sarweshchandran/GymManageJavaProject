import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection
{
	public static Connection getConnection() throws SQLException
    {
        Connection con = null;
	try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym","root","Admin");
			System.out.println("Connected With the database successfully");
        } 
        catch(ClassNotFoundException ex) 
        {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
	
/*import java.sql.*;
class MyConnection{
public static void main(String[] args) {
  try {
Connection connection = DriverManager.getConnection("jdbc.:mysql://localhost/gym","root","Admin");//Establishing connection
System.out.println("Connected With the database successfully");
} catch (SQLException e) {
System.out.println("Error while connecting to the database");
}
}
}*/