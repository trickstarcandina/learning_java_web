/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import dao.DaoStudentImpl;
import java.util.List;
import model.Student;

/**
 *
 * @author mdlaptop
 */
public class MainTest {

    public static void main(String[] args) {
        try {
            DaoStudentImpl daoStudent = new DaoStudentImpl();
            daoStudent.insert(new Student("2", "Binh", "2"));
            List ret = daoStudent.getAll();
            System.out.println(""+ret.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
