
import java.sql.*;


public class DbeaverTaskJavaSql {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver's fuck up");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employees_db", "alekseygrin", "");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT department, SUM(salary) AS salary_sum FROM employees GROUP BY department ORDER BY salary_sum");

            while(rs.next()){
                System.out.println(rs.getString("department") + ": "+ rs.getString("salary_sum"));
            }

            stmnt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
