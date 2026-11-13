
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseManagement {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    // Display menu
    static void showMenu() {
        System.out.println("""
            ===== STUDENT COURSE MANAGEMENT =====
            1. Add Course
            2. View All Courses
            3. Search Course
            4. Compute Total Units
            5. Save Courses
            6. Load Courses
            7. Exit
            """);

        System.out.print("Choose an option: ");

        try {
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> viewCourses();
                case 3 -> searchCourse();
                case 4 -> computeTotalUnits();
                case 5 -> saveCourses();
                case 6 -> loadCourses();
                case 7 -> {
                    System.out.println("Thank you for using the system!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }

        showMenu();
    }

    // Add course
    static void addCourse() {
        System.out.print("Enter course code: ");
        String code = input.nextLine().trim();

        System.out.print("Enter course title: ");
        String title = input.nextLine().trim();

        if (code.isEmpty() || title.isEmpty() || title.contains("|")) {
            System.out.println("Invalid course details.");
            return;
        }

        for (Course c : courses) {
            if (c.code.equalsIgnoreCase(code)) {
                System.out.println("Course already exists.");
                return;
            }
        }

        try {
            System.out.print("Enter credit units: ");
            int units = Integer.parseInt(input.nextLine());

            if (units <= 0) {
                System.out.println("Units must be positive.");
                return;
            }

            courses.add(new Course(code, title, units));
            System.out.println("Course added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number of units.");
        }
    }

    // Display courses
    static void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println(c);
        }
    }

    // Search course recursively
    static Course findCourse(String code, int index) {
        if (index >= courses.size()) return null;

        if (courses.get(index).code.equalsIgnoreCase(code)) {
            return courses.get(index);
        }

        return findCourse(code, index + 1);
    }

    static void searchCourse() {
        System.out.print("Enter course code: ");
        String code = input.nextLine();

        Course result = findCourse(code, 0);

        System.out.println(result == null
                ? "Course not found."
                : "Course found: " + result);
    }

    // Calculate total units
    static void computeTotalUnits() {
        int total = 0;

        for (Course c : courses) {
            total += c.units;
        }

        System.out.println("Total credit units: " + total);
    }

    // Save courses to file
    static void saveCourses() {
        try (PrintWriter writer = new PrintWriter("courses.txt")) {
            for (Course c : courses) {
                writer.println(c.code + "|" + c.title + "|" + c.units);
            }

            System.out.println("Courses saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }

    // Load courses from file
    static void loadCourses() {
        ArrayList<Course> loaded = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader("courses.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length != 3) continue;

                try {
                    int units = Integer.parseInt(data[2].trim());

                    if (data[0].isBlank() || data[1].isBlank()
                            || units <= 0) continue;

                    boolean duplicate = false;

                    for (Course c : loaded) {
                        if (c.code.equalsIgnoreCase(data[0].trim())) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (!duplicate) {
                        loaded.add(new Course(
                                data[0].trim(),
                                data[1].trim(),
                                units));
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid record.");
                }
            }

            courses = loaded;
            System.out.println("Courses loaded successfully!");

        } catch (IOException e) {
            System.out.println("Unable to load courses: " + e.getMessage());
        }
    }
}