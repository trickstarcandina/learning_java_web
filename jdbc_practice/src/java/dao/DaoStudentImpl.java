package dao;

import base.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class DaoStudentImpl{

    public boolean insert(Student itm) {
        boolean result = false;
        final String sql = "INSERT INTO student "
                + "(id, name, age) "
                + "VALUES(?, ?, ?)";
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, itm.getId());
            ps.setString(2, itm.getName());
            ps.setString(3, itm.getAge());
            System.out.println(ps.toString());
            int iInsert = ps.executeUpdate();
            if (iInsert > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySQLConnection.close(ps, conn);
        }
        return result;
    }
    

    public List getAll() {
        List<Student> result = new ArrayList<>();
        final String sql = "SELECT * FROM student";
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);

            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Student std = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("age"));
                result.add(std);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySQLConnection.close(rs, ps, conn);
        }
        return result;
    }

}
