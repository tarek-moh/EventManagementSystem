package com;

//import com.models.Admin;
//import com.models.Attendee;
//import com.models.Organizer;
//import com.services.Database;
//
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("=== com.managers.Login System ===");
//        System.out.print("Enter Username: ");
//        String username = input.nextLine();
//
//        System.out.print("Enter Password: ");
//        String password = input.nextLine();
//
//        // Check Admin login
//        for (Admin admin : Database.getAdminList()) {
//            if (admin.getUserName().equals(username) && admin.getPassword().equals(password)) {
//                System.out.println("\nLogin successful! Welcome Admin: " + admin.getUserName());
//                admin.showDashboard(); // Call admin-specific menu
//                input.close();
//                return;
//            }
//        }
//
//        // Check Organizer login
//        for (Organizer organizer : Database.getOrganizerList()) {
//            if (organizer.getUserName().equals(username) && organizer.getPassword().equals(password)) {
//                System.out.println("\nLogin successful! Welcome Organizer: " + organizer.getUserName());
//                organizer.showDashboard(); // Call admin-specific menu
//                input.close();
//                return;
//            }
//        }
//
//        // Check Attendee login
//        for (Attendee attendee : Database.getAttendeeList()) {
//            if (attendee.getUserName().equals(username) && attendee.getPassword().equals(password)) {
//                System.out.println("\nLogin successful! Welcome Attendee: " + attendee.getUserName());
//                attendee.showDashboard(); // Call admin-specific menu
//                input.close();
//                return;
//            }
//        }
//
//        // If no match found
//        System.out.println("\nLogin failed! Invalid username or password.");
//        input.close();
//    }
//}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setTitle("Event Management System");
        // Get screen dimensions
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Create scene with screen size
        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}