import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class stuManagement {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "1234");
            Statement stm=conn.createStatement();
            String sql="SELECT * FROM students";
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
                System.out.println(rs.getString("course"));
            }
            rs.close();
            stm.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());

        }

    }

}
