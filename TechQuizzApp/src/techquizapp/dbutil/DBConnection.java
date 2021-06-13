
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//NiharDubey:1521/XE","onlineexam","student");                        
            JOptionPane.showMessageDialog(null,"Connected successfully to the Database","Success!",JOptionPane.INFORMATION_MESSAGE);            
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Connecting to the Database"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "DB Successfully Disconnected");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Connot disconnect with the DB");
            ex.printStackTrace();
        }
    }
}
