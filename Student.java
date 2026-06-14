public class Student {
    int id;
    String name;
    String course;
    double marks;
    double attendance;
    String grade;

    public Student(int id, String name, String course,
                   double marks, double attendance) {

        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.attendance = attendance;

        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90)
            grade = "A+";
        else if (marks >= 80)
            grade = "A";
        else if (marks >= 70)
            grade = "B";
        else if (marks >= 60)
            grade = "C";
        else if (marks >= 50)
            grade = "D";
        else
            grade = "Fail";
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }
}