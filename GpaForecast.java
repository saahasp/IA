import java.util.Scanner;

public class GpaForecast {

    private static Scanner sc = new Scanner(System.in); // Create scanner to get user input

    // Method to forecast the GPA after adding new classes and grades
    public static double forecastGpa(double currentGpa, int currentCourses) {
        // Calculate current total grade points (without bonus)
        double totalGradePoints = currentGpa * currentCourses;
        double totalBonus = 0;

        // Ask if the student wants to add any future courses
        System.out.print("Do you want to add future classes? (yes/no): ");
        String addClasses = sc.nextLine().toLowerCase();

        int futureCourses = 0;

        // Process future classes if the user says yes
        if (addClasses.equals("yes")) {
            System.out.print("Enter the number of future courses: ");
            futureCourses = sc.nextInt();
            sc.nextLine(); // Consume newline

            // Process each future course
            for (int i = 1; i <= futureCourses; i++) {
                System.out.print("Enter the type of the future course (year/semester): ");
                String courseType = sc.nextLine().toLowerCase();

                System.out.print("Enter the grade (A, A-, B+, etc.) you believe you will get: ");
                String grade = sc.nextLine().toUpperCase();

                // Ask if the course is weighted
                System.out.print("Is this course weighted? (yes/no): ");
                String isWeighted = sc.nextLine().toLowerCase();

                double gradePoint = Gpa.getGradePoint(grade);
                if (gradePoint == -1) {
                    System.out.println("Invalid grade entered. Exiting...");
                    return -1;
                }

                // Only add bonus for weighted courses
                if (isWeighted.equals("yes")) {
                    if (courseType.equals("year")) {
                        totalGradePoints += 2 * gradePoint; // Year courses are recorded twice
                        totalBonus += 2 * Gpa.getYearCourseBonus(gradePoint); // Bonus for year course is recorded twice
                    } else if (courseType.equals("semester")) {
                        totalGradePoints += gradePoint; // Semester courses are recorded once
                        totalBonus += Gpa.getSemesterCourseBonus(gradePoint); // Bonus for semester course is recorded once
                    } else {
                        System.out.println("Invalid course type entered. Exiting...");
                        return -1;
                    }
                } else {
                    // If not weighted, just add grade points without bonus
                    if (courseType.equals("year")) {
                        totalGradePoints += 2 * gradePoint;
                    } else if (courseType.equals("semester")) {
                        totalGradePoints += gradePoint;
                    } else {
                        System.out.println("Invalid course type entered. Exiting...");
                        return -1;
                    }
                }
            }
        }

        // Calculate the new GPA
        double newGpa = Gpa.calculateGPA(currentCourses + futureCourses, totalGradePoints, totalBonus);
        return newGpa;
    }
}