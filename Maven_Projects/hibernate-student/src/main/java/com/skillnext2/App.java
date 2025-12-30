package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertStudent(sc);
                    break;

                case 2:
                    updateStudent(sc);
                    break;

                case 3:
                    deleteStudent(sc);
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    HibernateUtil.getSessionFactory().close();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // INSERT
    static void insertStudent(Scanner sc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        Student s = new Student(id, name, course, marks);
        session.save(s);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }

    // UPDATE
    static void updateStudent(Scanner sc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = session.get(Student.class, id);

        if (s != null) {
            System.out.print("Enter New Name: ");
            s.setName(sc.nextLine());

            System.out.print("Enter New Course: ");
            s.setCourse(sc.nextLine());

            System.out.print("Enter New Marks: ");
            s.setMarks(sc.nextInt());

            session.update(s);
            System.out.println("Student updated!");
        } else {
            System.out.println("Student not found!");
        }

        tx.commit();
        session.close();
    }

    // DELETE
    static void deleteStudent(Scanner sc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        Student s = session.get(Student.class, id);

        if (s != null) {
            session.delete(s);
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found!");
        }

        tx.commit();
        session.close();
    }

    // DISPLAY
    static void displayStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> list = session.createQuery("from Student", Student.class).list();

        System.out.println("\nID | Name | Course | Marks");
        System.out.println("----------------------------");
        for (Student s : list) {
            System.out.println(s);
        }

        session.close();
    }
}
