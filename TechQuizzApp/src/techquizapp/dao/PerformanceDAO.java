
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

public class PerformanceDAO {
    public static void addPerformances(Performance p) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into performance values (?,?,?,?,?,?,?)");
        ps.setString(1, p.getUserId());
        ps.setString(2, p.getExamId());
        ps.setInt(3, p.getRight());
        ps.setInt(4, p.getWrong());
        ps.setInt(5, p.getUnattempted());
        ps.setDouble(6, p.getPer());
        ps.setString(7, p.getLanguage());           
        ps.executeUpdate();
    }
    
    public static ArrayList<String> getAllExamId(String userId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select examid from performance where userid=?");
        ps.setString(1,userId);
        ArrayList<String> examList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            examList.add(rs.getString(1));
        }
        return examList;
    } 
    
    public static StudentScore getScore(String examId,String userId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select per, language from performance where userid=? and examid=?");
        ps.setString(1,userId);
        ps.setString(2,examId);
        StudentScore stuScore=new StudentScore();
        ResultSet rs=ps.executeQuery();
        rs.next();
        stuScore.setPerc(rs.getDouble(1));
        stuScore.setLanguage(rs.getString(2));
        return stuScore;
    }
    
    public static ArrayList<String> getAllStudentId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        String query="Select distinct userid from performance";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        ArrayList<String>studentIdList=new ArrayList<>();
        while(rs.next()){
            studentIdList.add(rs.getString(1));
        }
        return studentIdList;
    }
    
    public static ArrayList<Performance> getAllData() throws SQLException{
        Connection conn=DBConnection.getConnection();
        String query="Select * from performance";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        ArrayList<Performance>performanceList=new ArrayList<>();
        while(rs.next()){
            String userid=rs.getString(1);
            String examid=rs.getString(2);
            int right=rs.getInt(3);
            int wrong=rs.getInt(4);
            int unattm=rs.getInt(5);
            double per=rs.getDouble(6);
            String lang=rs.getString(7);
            
            Performance p=new Performance(examid,lang,userid,right,wrong,unattm,per);
            performanceList.add(p);
        }
        return performanceList;
    }
}
