
import java.util.Scanner;

public class cgpaPoint {
    
    private static final int SEMESTERS = 8; // 4 years x 2 semesters
    private static final int[] COURSES_PER_SEMESTER = {12, 11, 11, 10, 8, 4, 8, 7};
    // private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPoints = 0;
        int totalUnits = 0;

        for (int i = 0; i < SEMESTERS; i++) {
            int courses = COURSES_PER_SEMESTER[i];
            double semesterPoints = 0;
            int semesterUnits = 0;

            System.out.printf("Enter data fro semster %d%n", i + 1);
            for (int j = 0; j < courses; j++) {
                System.out.printf("Course %d of %d in Semester %d%n", j + 1, courses, i + 1);
                System.out.print("Enter units (1 to 4): ");
                int units = scanner.nextInt(); // Generates 1 to 4
                while (units < 1 || units > 4) {
                    System.out.println("Invalid units, please enter a value between 1 and 4.");
                    units = scanner.nextInt();
                }

                System.out.print("Enter grade (1.0 to 5.0): ");
                double grade = scanner.nextDouble();
                while (grade < 1.0 || grade > 5.0) {
                    System.out.println("Invalid grade, please     enter a value between 1.0 and 5.0");
                    grade = scanner.nextDouble();
                }

                semesterPoints += grade * units;
                semesterUnits += units;
            }

            double semesterGPA = semesterPoints / semesterUnits;
            System.out.printf("Semester %d GPA: %.2f%n", i + 1, semesterGPA);

            totalPoints += semesterPoints;
            totalUnits += semesterUnits;
        }

        double cgpaPoint = totalPoints / totalUnits;
        System.out.printf("Cumulative GPAL: %.2f%n", cgpaPoint);

        scanner.close();
    }
}
