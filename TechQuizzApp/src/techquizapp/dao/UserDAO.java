
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

public class UserDAO {
    public static boolean validateUser(User user) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select* from users where userid=? and password=? and usertype=?");
        
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
 
    public static boolean addStudent(User user) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?)");
        
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        
        return ps.executeUpdate()==1;    
    }
    
    public static boolean updateStudent(User user) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update users set password=? where userid=? and usertype=?");
        
        ps.setString(1,user.getPassword());
        ps.setString(2,user.getUserId());
        ps.setString(3,user.getUserType());
        
        return ps.executeUpdate()==1;
    }
}
