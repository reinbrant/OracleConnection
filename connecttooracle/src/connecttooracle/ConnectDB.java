package connecttooracle;
import java.sql.*;

public class ConnectDB {
 
    public static Connection connect(){
        
        Connection conn = null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            System.out.println("Successful connection!");
        }catch(Exception e){
            System.out.print(e);
        }
      
        return conn;
    }
    
    
    
    
}
