import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort By Marks");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.print("Enter Attendance: ");
                    double attendance = sc.nextDouble();

                    students.add(
                        new Student(id, name, course, marks, attendance)
                    );

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == searchId) {
                            System.out.println("\nStudent Found:");
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    found = false;

                    for (Student s : students) {

                        if (s.id == updateId) {

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextDouble();

                            s.calculateGrade();

                            System.out.println("Marks Updated!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();

                    Student removeStudent = null;

                    for (Student s : students) {
                        if (s.id == deleteId) {
                            removeStudent = s;
                            break;
                        }
                    }

                    if (removeStudent != null) {
                        students.remove(removeStudent);
                        System.out.println("Student Deleted!");
                    } else {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No Students Available!");
                    } else {

                        System.out.println("\n===== ALL STUDENTS =====");

                        for (Student s : students) {
                            s.display();
                            System.out.println();
                        }
                    }

                    break;

                case 6:

                    Collections.sort(
                        students,
                        (a, b) -> Double.compare(b.marks, a.marks)
                    );

                    System.out.println("Sorted By Marks!");

                    for (Student s : students) {
                        s.display();
                        System.out.println();
                    }

                    break;

                case 7:
                    System.out.println("Program Closed.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}