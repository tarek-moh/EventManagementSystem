import models.Admin;
import models.Attendee;
import models.Organizer;
import services.Database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Login System ===");
        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        // Check Admin login
        for (Admin admin : Database.getAdminList()) {
            if (admin.getUserName().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("\nLogin successful! Welcome Admin: " + admin.getUserName());
                admin.showDashboard(); // Call admin-specific menu
                input.close();
                return;
            }
        }

        // Check Organizer login
        for (Organizer organizer : Database.getOrganizerList()) {
            if (organizer.getUserName().equals(username) && organizer.getPassword().equals(password)) {
                System.out.println("\nLogin successful! Welcome Organizer: " + organizer.getUserName());
                organizer.showDashboard(); // Call admin-specific menu
                input.close();
                return;
            }
        }

        // Check Attendee login
        for (Attendee attendee : Database.getAttendeeList()) {
            if (attendee.getUserName().equals(username) && attendee.getPassword().equals(password)) {
                System.out.println("\nLogin successful! Welcome Attendee: " + attendee.getUserName());
                attendee.showDashboard(); // Call admin-specific menu
                input.close();
                return;
            }
        }

        // If no match found
        System.out.println("\nLogin failed! Invalid username or password.");
        input.close();
    }
}