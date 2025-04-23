
package models;
import managers.RoomManager;
import services.Database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


import static managers.AttendeeManager.showAllAttendees;
import static managers.EventManager.showAllEvents;
import static managers.RoomManager.showAllRooms;



public class Admin extends User {
    private static int adminCount = 0;
    private String adminRole;
    private String workingHours;

    // No-arg constructor
    public Admin() {    super();    }

    // Parameterised Constructor
    public Admin(String userName, String password, LocalDate dateOfBirth, String adminRole, String workingHours) {
        super(userName, password, dateOfBirth);
        this.adminRole = adminRole;
        this.workingHours = workingHours;
        this.ID = 30000 + adminCount++;
    }

    // Implement abstract method: Dashboard
    @Override
    public void showDashboard() {
        Scanner input = new Scanner(System.in);
        boolean inDashboard = true;

        while (inDashboard) {
            System.out.println("========================================");
            System.out.println("Dashboard");
            System.out.println("========================================");
            System.out.println("""
        1:  Show all rooms
        2:  Show all events
        3:  Show all attendees
        4:  Create a category
        5:  Show all categories
        6:  Delete a Category
        7:  Create a room
        8:  Delete a room
        9:  Check Profile
        10: Logout
        """);

            System.out.print("Choose an option: ");

            if (input.hasNextShort()) 
            {
                short choice = input.nextShort();
                input.nextLine(); // consume leftover newline

                switch (choice) {
                    case 1 -> {
                        System.out.println("All Rooms:");
                        showAllRooms();
                    }
                    case 2 -> {
                        System.out.println("All Events:");
                        showAllEvents();
                    }
                    case 3 -> {
                        System.out.println("All Attendees:");
                        showAllAttendees();
                    }
                    case 4 -> {
                        try {
                            System.out.print("Enter name of Category: ");
                            String categoryName = input.nextLine();

                            if (categoryName == null || categoryName.trim().isEmpty()) {
                                throw new IllegalArgumentException("Category name cannot be null or empty.");
                            }
                    
                            if (categoryName.length() < 3 || categoryName.length() > 20) {
                                throw new IllegalArgumentException("Category name must be between 3 and 20 characters.");
                            }
                    
                            if (!categoryName.matches("^[a-zA-Z0-9_ ]+$"))
                            {
                                throw new IllegalArgumentException("Category name can only contain letters, digits, and underscores.");
                            }

                            myCategory newCategory = new myCategory(categoryName);
                            createCategory(newCategory);
                        }catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Category not created");
                        }
                    }
                    case 5 -> {
                        System.out.println("All Categories:");
                        showAllCategories();
                    }
                    case 6 -> {
                        System.out.print("Enter name of Category to delete: ");
                        String name = input.nextLine();
                        if (deleteCategory(name))
                            System.out.println("Category deleted.");
                        else
                            System.out.println("Category not found.");
                    }
                    case 7 -> {
                        System.out.print("Enter available hours of Room format HH-HH: ");
                        String roomHours = input.nextLine();
                        System.out.print("Enter capacity of Room: ");
                        int roomCapacity = input.nextInt();
                        input.nextLine(); // consume newline
                        try
                        {
                            if (!roomHours.matches("\\d{2}-\\d{2}"))
                            {
                                throw new IllegalArgumentException("Available hours must be in this format: HH-HH");
                            }
                            Room newRoom = new Room(roomHours, roomCapacity);
                            createRoom(newRoom);

                        }
                        catch(IllegalArgumentException ex)
                        {
                            System.out.println(ex);
                        }
                    }
                    case 8 -> {
                        System.out.println("Enter ID of Room to delete:");
                        int roomID = input.nextInt();
                        input.nextLine(); // consume newline
                        if (deleteRoom(roomID))
                            System.out.println("Room deleted.");
                        else
                            System.out.println("Room not found.");
                    }
                    case 9 -> showProfile();
                    case 10 -> {
                        System.out.println("Logging out...");
                        inDashboard = false;
                    }
                    default -> System.out.println("Invalid input! Please choose between 1 and 10.");

                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                input.next(); // clear the invalid input
            }
        }
    }

    private void showProfile() {
        boolean inProfile = true;

        while (inProfile) {
            System.out.println("========================================");
            System.out.println("Profile");
            System.out.println("========================================");
            System.out.println("Username              1: Change Username\n" + getUserName() + "\n");
            System.out.println("Password              2: Change Password\n" + getPassword() + "\n");
            System.out.println("Date of birth         3: Change date of birth\n" + getDateOfBirth() + "\n");
            System.out.println("Role                  4: Change Role\n" + getAdminRole() + "\n");
            System.out.println("Working hours         5: Change working hours\n" + getWorkingHours() + "\n");
            System.out.println("ID                    6: Exit Profile\n" + getId() + "\n");

            short profChoice = getValidMenuChoice(1, 6);

            switch (profChoice) {
                case 1:
                    changeUsername();
                    break;

                case 2:
                    changePassword();
                    break;

                case 3:
                    changeDateOfBirth();
                    break;

                case 4:
                    changeRole();
                    break;

                case 5:
                    changeWorkingHours();
                    break;

                case 6:
                    inProfile = false;
                    break;
            }
        }
    }

    private void changeRole() {
        try {
            System.out.print("Enter your new role: ");
            String newRole = input.next();
            setAdminRole(newRole);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Username not changed");
        }
    }

    // Utility methods
    private short getValidMenuChoice(int min, int max) {
        while (true) {
            if (input.hasNextShort()) {
                short choice = input.nextShort();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                input.next(); // Clear invalid input
            }
            System.out.printf("Invalid input! Please choose between %d and %d:%n", min, max);
        }
    }

    // Getters and Setters
    public String getAdminRole() {    return adminRole;    }

    public void setAdminRole(String newAdminRole)throws IllegalArgumentException {
        if (newAdminRole == null || newAdminRole.trim().isEmpty()) {
            throw new IllegalArgumentException("Admin role cannot be null or empty.");
        }

        if (newAdminRole.length() < 3 || newAdminRole.length() > 20) {
            throw new IllegalArgumentException("Admin role must be between 3 and 20 characters.");
        }

        if (!newAdminRole.matches("^[a-zA-Z0-9_]+$"))
        {
            throw new IllegalArgumentException("Admin role can only contain letters, digits, and underscores.");
        }
        this.userName = newAdminRole;
    }

    public String getWorkingHours() {    return workingHours;    }

    private void changeWorkingHours() {
        try {
            System.out.println("Enter your new working hours ");
        String newWorkingHours = input.next();
        setWorkingHours(newWorkingHours);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Working hours not changed");
        }
    }
    
    public void setWorkingHours(String newWorkingHours)
    {
        if (newWorkingHours == null || newWorkingHours.trim().isEmpty()) {
            throw new IllegalArgumentException("Working hours cannot be null or empty.");
        }

        if (!newWorkingHours.matches("\\d{2}-\\d{2}"))
        {//
            throw new IllegalArgumentException("Working hours must be in this format: HH-HH");
        }
        this.workingHours = newWorkingHours;
    }

    public void createCategory (myCategory newCategory) {  Database.getCategoryList().add(newCategory);    }

    public myCategory readCategory (String name)
    {
        for (myCategory category : Database.getCategoryList()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public boolean deleteCategory(String name)
    {
        if (readCategory(name) != null) {
            Database.getCategoryList().remove(readCategory(name));
            return true;
        }
        return false;
    }

    public void createRoom (Room newRoom) {   Database.getRoomList().add(newRoom);    }

    public Room readRoom (int roomId)
    {
        for (Room room : Database.getRoomList())
        {
        if (room.getRoomID() == roomId)
        {
            return room;
        }
        }
        return null;
    }

    public boolean deleteRoom(int Id)
    {
        ArrayList<Room> rooms = Database.getRoomList();
        for(int i =0; i<rooms.size();i++)
        {
            if(rooms.get(i).getRoomID() == Id) {
                Database.getRoomList().remove(i);
                return true;
            }
        }
        return false;
    }

    public void showAllCategories() {
        for (myCategory c : Database.getCategoryList()) {
            System.out.println(c);
        }
    }
}

