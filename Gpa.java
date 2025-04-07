public class Gpa {

    // Method to get the grade point for a letter grade
    public static double getGradePoint(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            case "E":
                return 0.0;
            default:
                return -1; // Invalid grade
        }
    }

    // Method to get the bonus for a year-long course based on grade
    public static double getYearCourseBonus(double gradePoint) {
        if (gradePoint == 4.0 || gradePoint == 3.7) return 0.0488;
        if (gradePoint == 3.3 || gradePoint == 3.0 || gradePoint == 2.7) return 0.0366;
        if (gradePoint == 2.3 || gradePoint == 2.0 || gradePoint == 1.7) return 0.0244;
        if (gradePoint == 1.3 || gradePoint == 1.0) return 0.0122;
        return 0.0;
    }

    // Method to get the bonus for a semester course based on grade
    public static double getSemesterCourseBonus(double gradePoint) {
        if (gradePoint == 4.0 || gradePoint == 3.7) return 0.0244;
        if (gradePoint == 3.3 || gradePoint == 3.0 || gradePoint == 2.7) return 0.0183;
        if (gradePoint == 2.3 || gradePoint == 2.0 || gradePoint == 1.7) return 0.0122;
        if (gradePoint == 1.3 || gradePoint == 1.0) return 0.0061;
        return 0.0;
    }

    // Method to calculate the GPA
    public static double calculateGPA(int totalCourses, double totalGradePoints, double totalBonus) {
        return (totalGradePoints + totalBonus) / totalCourses;
    }
}