package com.skillnext2;

public class App {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // Create table
        dao.createTable();

        // Add student
        Student s1 = new Student(1, "Navya", 20, "AIML");
        dao.addStudent(s1);

        // Delete student (uncomment to test)
        // dao.deleteStudent(1);
    }
}
