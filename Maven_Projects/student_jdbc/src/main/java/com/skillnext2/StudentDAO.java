package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Navya@1705"; // change if needed

    // Create Table
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS student (" +
                     "id INT PRIMARY KEY," +
                     "name VARCHAR(100)," +
                     "age INT," +
                     "course VARCHAR(100))";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            stmt.execute(sql);
            System.out.println("Student table created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert Student
    public void addStudent(Student s) {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCourse());

            ps.executeUpdate();
            System.out.println("Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
