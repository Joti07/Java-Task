package studentmanager;

import java.util.*;

public class StudentRecordManager {
    // function to find student with lowest CGPA
    public static Student findLowestCgpa(List<Student> students) {
        Student lowest = students.get(0);
        for (Student s : students) {
            if (s.getCgpa() < lowest.getCgpa()) {
                lowest = s;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();

        // input student info
        for (int i = 0; i < n; i++) {
            System.out.println("Enter info for student " + (i + 1));

            System.out.print("ID: ");
            long id = sc.nextLong();
            sc.nextLine(); // consume newline

            System.out.print("Full Name: ");
            String name = sc.nextLine();

            System.out.print("Blood Group: ");
            String blood = sc.nextLine();

            System.out.print("CGPA: ");
            float cgpa = sc.nextFloat();
            sc.nextLine(); // consume newline

            students.add(new Student(id, name, blood, cgpa));
        }

        // input query
        System.out.print("Enter query (last name or blood group): ");
        String query = sc.nextLine();

        // find and print matching students
        System.out.println("\n--- Matching Students ---");
        boolean found = false;
        for (Student s : students) {
            if (s.matches(query)) {
                s.printInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found matching the query.");
        }

        // find student with lowest CGPA
        System.out.println("\n--- Student with Lowest CGPA ---");
        Student lowest = findLowestCgpa(students);
        lowest.printInfo();

        sc.close();
    }
}
