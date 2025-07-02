import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
    public static List<student> getAll(){
         List<student> list = new ArrayList<>(); 
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "1234");
            Statement stm=conn.createStatement();
            String sql="SELECT * FROM students";
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                String age=rs.getString("age");
                String course=rs.getString("course");
                student s1=new student(id,name,age,course);
                list.add(s1);
                
                
            }
            rs.close();
            stm.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());

        }
        return list;

    }
    
        
    

    

    
}
