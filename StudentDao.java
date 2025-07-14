import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentDao {

    public static List<student> getAll() {
        List<student> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "1234");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String course = rs.getString("course");
                student s1 = new student(id, name, age, course);
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

    public static void add(JTextField txtId, JTextField txtName, JTextField txtAge, JTextField txtCourse) {
        try {
            student s1 = new student();
            s1.setId(txtId.getText());
            s1.setName(txtName.getText());
            s1.setAge(txtAge.getText());
            s1.setCourse(txtCourse.getText());

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "1234");
            String sql = "INSERT INTO students(id, name, age, course) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s1.getId());
            ps.setString(2, s1.getName());
            ps.setString(3, s1.getAge());
            ps.setString(4, s1.getCourse());
            ps.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
           
        
    public static void Update(JTextField txtId){
       
         try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "1234");
            String sql="UPDATE students SET name='?',age='?',course='?' WHERE id='?'";


         }catch(SQLException e){
            e.getErrorCode();
             
         }
       
    }
    
}
