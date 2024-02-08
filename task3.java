
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
    private String std_name;
    private int std_rollNo;
    private String grade;

    Student(String std_name, int std_rollNo, String grade) {
        this.std_name = std_name;
        this.std_rollNo = std_rollNo;
        this.grade = grade;
    }

    String get_std_name() {
        return this.std_name;
    }

    void set_std_name(String std_name) {
        this.std_name = std_name;
    }

    int get_std_rollNO() {
        return this.std_rollNo;
    }

    void set_std_rollNo(int std_rollNo) {
        this.std_rollNo = std_rollNo;
    }

    String get_grade() {
        return this.grade;
    }

    void set_grade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + this.std_name + "\n" +
                "Roll Number: " + this.std_rollNo + "\n" +
                "Grade: " + this.grade + "\n";
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void stdDetails() {
        for (Student student : students) {
            System.out.println(
                    "Name: " + student.get_std_name() + "\n" +
                            "Roll Number: " + student.get_std_rollNO() + "\n" +
                            "Grade: " + student.get_grade() + "\n"
            );
        }
    }

    void remove(int std_rollNo) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.get_std_rollNO() == std_rollNo) {
                iterator.remove();
                System.out.println("\t\t\t *** ROLL NUMBER: " + std_rollNo + " REMOVED SUCCESSFULLY ***");
                break;
            }
        }
    }

    Student search(int std_rollNo) {
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if (student.get_std_rollNO() == std_rollNo) {
                return student;
            }
        }
        return null;
    }

    void displayAllStudents() {
        stdDetails();
    }

    void updateSetDetails(int std_rollNo) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        for (Student student : students) {
            if (student.get_std_rollNO() == std_rollNo) {
                while (flag) {
                    System.out.println("1. SET NAME");
                    System.out.println("2. SET ROLL NUMBER");
                    System.out.println("3. SET GRADE");
                    System.out.println("4. BACK TO MAIN MENU");
                    System.out.print("YOUR CHOICE : ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("ENTER THE NEW NAME : ");
                            String updated_name = sc.nextLine();
                            student.set_std_name(updated_name);
                            System.out.println("\t\t\t *** NAME UPDATED SUCCESSFULLY ***\n");
                            break;
                        case 2:
                            System.out.print("ENTER THE NEW ROLL NUMBER : ");
                            int updated_rollNo = sc.nextInt();
                            sc.nextLine();
                            student.set_std_rollNo(updated_rollNo);
                            System.out.println("\t\t\t *** ROLL NUMBER UPDATED SUCCESSFULLY ***\n");
                            break;
                        case 3:
                            System.out.print("ENTER THE NEW GRADE : ");
                            String updated_grade = sc.next();
                            sc.nextLine();
                            student.set_grade(updated_grade);
                            System.out.println("\t\t\t *** GRADE UPDATED SUCCESSFULLY ***\n");
                            break;
                        case 4:
                            flag = false;
                            break;
                        default:
                            System.out.println("\t\t\t *** ENTER A VALID CHOICE ***\n");
                            break;
                    }
                }
            }
        }
    }
}

class task3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        int flag = 1;

        while (flag != 0) {
            System.out.println("***********************************");
            System.out.println("*  Student Management System      *");
            System.out.println("***********************************");
            System.out.println("1. Add New Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Student Details");
            System.out.println("5. Update Existing Student Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String std_name = sc.next();
                    sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int std_rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.next();
                    sc.nextLine();

                    Student student = new Student(std_name, std_rollNo, grade);
                    sms.addStudent(student);
                    System.out.println("\t\t\t *** DETAILS ADDED SUCCESSFULLY ***\n");
                    break;

                case 2:
                    System.out.print("Enter the Roll Number of the Student to Remove: ");
                    std_rollNo = sc.nextInt();
                    sc.nextLine();
                    sms.remove(std_rollNo);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the Roll Number to Search for a Student: ");
                    std_rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println();

                    Student detail = sms.search(std_rollNo);

                    if (detail != null) {
                        System.out.println(detail.toString());
                    } else {
                        System.out.println("No details found for the Roll Number " + std_rollNo);
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    sms.displayAllStudents();
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Enter the Roll Number to Update Details of a Student");
                    std_rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    sms.updateSetDetails(std_rollNo);
                    break;

                case 6:
                    System.out.println("\t\t\t *** THANK YOU FOR USING THE APPLICATION ***\n");
                    flag = 0;
                    break;

                default:
                    System.out.println("\t\t\t *** INVALID CHOICE! PLEASE ENTER A VALID OPTION ***\n");
                    break;
            }
        }
    }
}
