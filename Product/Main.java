import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a Scanner to get user input
        Scanner sc = new Scanner(System.in);

        // Ask the user for current GPA and number of current courses
        System.out.print("Enter your current GPA: ");
        double currentGpa = sc.nextDouble();
        System.out.print("Enter the number of current courses: ");
        int currentCourses = sc.nextInt();
        sc.nextLine(); // Consume newline character

        // Call the method from GpaForecast to forecast the new GPA
        double newGpa = GpaForecast.forecastGpa(currentGpa, currentCourses);

        // Print out the new GPA
        if (newGpa != -1) {
            System.out.printf("Your new projected GPA will be: %.4f\n", newGpa);
        } else {
            System.out.println("An error occurred. GPA forecast could not be completed.");
        }

        // Close the scanner
        sc.close();
    }
}