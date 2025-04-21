package models;

import services.Database;

import java.time.LocalDate;
import java.util.ArrayList;

public class Organizer extends User {
    private static int organizerCount = 0;
    private Wallet wallet;

    public Organizer() {    super();    }    // No-arg constructor

    // Constructor with parameters
    public Organizer(String userName, String password, LocalDate dateOfBirth) {
        super(userName, password, dateOfBirth);
        this.ID = 20000 + organizerCount ;
        this.wallet = new Wallet();
    }

    // Implement abstract method
    @Override
    public void showDashboard()
    {
        while (true)
        {
            System.out.println("========================================");
            System.out.println("             Dashboard");
            System.out.println("========================================");
            System.out.println("1: Show available rooms\n2: Show my events \n3: Show attendees for my event\n4: Remove attendee from my event");
            System.out.println("5: Create an event\n6: Read an event \n7: Update an event\n8: Delete an event\n9: models.Wallet");
            System.out.println("10: Check Profile\n11: Logout");

            short choice;
            while (true) // check if choice is an integer (1-5)
            {
                if (input.hasNextShort())
                {
                    choice = input.nextShort();
                
                    // Show available rooms
                    if (choice == 1) {    //showAvailableRooms();
                        }

                    // Show organizer's events
                    else if (choice == 2) { // showMyEvents();
                    }

                    else if (choice == 3) {    // Show attendees for organizer's event
                    }

                    else if (choice == 4) {   // Remove attendee from organizer's event
                    }

                    if (choice == 5) // Create an event
                    {
                        System.out.println("Enter title of event");
                        String eventTitle = input.nextLine();
                        System.out.println("Enter description of event");
                        String eventDescription = input.nextLine();
                        System.out.println("Enter category name of models.Event");
                        String eventCategoryName = input.nextLine();
                        System.out.println("Enter time slot of models.Event");
                        String eventTimeSlot = input.nextLine();
                        // models.Event newevent = new models.Event(eventTitle, eventDescription, eventCategoryName, eventTimeSlot);
                        // createEvent (newEvent);
                    }

                    else if (choice == 6) // Read an event
                    {
                        System.out.println("Enter ID of event");
                        int eventID = input.nextInt();
                        // if (readEvent(eventID) != null)
                        {
                            // readEvent(eventID).showEventDetails();
                        }
                        // else
                        {    System.out.println("models.Event not found");    }
                    }

                    else if (choice == 7){    // Update an event
                    }

                    else if (choice == 8) // Delete an event
                    {
                        System.out.println("Enter ID of event");
                        int eventIDtoDelete = input.nextInt();
                        // if (deleteEvent(eventIDtoDelete))
                        {    System.out.println("models.Event deleted");    }
                        // else
                        {    System.out.println("models.Event not found");    }
                    }

                    else if (choice == 9)
                    {
                        // System.out.println(wallet.getBalnce());  
                        System.out.println("Current balance");
                        System.out.println("1: Add money     2: Withdraw money     3: Exit");
                        while (true) 
                            {
                                if (input.hasNextShort()) 
                                {
                                    short inchoice = input.nextShort();
                                
                                    if (inchoice == 1 ) 
                                    {
                                        System.out.println("Enter amouunt: ");
                                        int amount = input.nextInt();
                                        // updateWallet(amount, inchoice);
                                        break; 
                                    } 

                                    else if (inchoice == 2) 
                                    {
                                        System.out.println("Enter amouunt: ");
                                        int amount = input.nextInt();
                                        // updateWallet(amount, inchoice);
                                        break;
                                    }
                                    
                                    else if (inchoice == 3) {    break;    }
                                    
                                    else 
                                    {
                                        System.out.println("Invalid input! Please choose between 1 and 3:");
                                    }
                                } 
                                
                                else 
                                {
                                    System.out.println("Invalid input! Please choose between 1 and 3:");
                                    input.next(); // Clear the invalid input
                                }
                            }
                    }

                    

                    else if (choice == 10)
                    {
                        short profchoice ;
                        while (true)
                        {
                            System.out.println("========================================");
                            System.out.println("Profile");
                            System.out.println("========================================");
                            System.out.println("Username            1: Change Username\n" + getUserName());
                            System.out.println("Password            2: change Password\n" + getPassword());
                            System.out.println("Date of birth       3: Change date of birth\n" + getDateOfBirth());
                            System.out.println("ID                  4: Exit Profile\n" + getId());

                            while (true) // check if choice is an integer (1-5)
                            {
                                if (input.hasNextShort()) 
                                {
                                    profchoice = input.nextShort();
                                
                                    if (profchoice == 1 ) 
                                    {
                                        System.out.println("Enter your new username ");
                                        // check if username is taken
                                        String newName = input.next();
                                        setUserName(newName);    
                                        break; 
                                    } 

                                    else if (profchoice == 2) 
                                    {
                                        System.out.println("Enter your new password ");
                                        String newPass = input.next();
                                        setPassword(newPass);
                                        break;
                                    } 

                                    else if (profchoice == 3) 
                                    {
                                        {
                                            System.out.println("Enter year of birth (e.g., 2000): ");
                                            int year = input.nextInt();
                                            while (year < 1 || year > 2024)
                                            {
                                                System.out.println("Invalid Year! Try again");
                                                year = input.nextInt();
                                            }
                                            System.out.println("Enter month of birth (1-12): ");
                                            int month = input.nextInt();
                                            while (month < 1 || month > 12)
                                            {
                                                System.out.println("Invalid Month! Try again(1-12)");
                                                month = input.nextInt();
                                            }
                                            System.out.println("Enter day of birth (1-31): ");
                                            int day = input.nextInt();
                                            while (day < 1 || day > 31)
                                            {
                                                System.out.println("Invalid Day! Try again(1-31)");
                                                day = input.nextInt();
                                            }
                                            setDateOfBirth(year,month,day);
                                        }
                                        break; 
                                    }

                                    else if (profchoice == 4)  {    break;   }
                                    
                                    else 
                                    {
                                        System.out.println("Invalid input! Please choose between 1 and 4:");
                                    }
                                } 
                                
                                else 
                                {
                                    System.out.println("Invalid input! Please choose between 1 and 4:");
                                    input.next(); // Clear the invalid input
                                }
                            }
                        }
                    }
            
                    else if (choice == 11) {    break;    }
                            
                    else{    System.out.println("Invalid input! Please choose between 1 and 11: ");    }
                }
                
                else
                {
                    System.out.println("Invalid input! Please choose between 1 and 11: ");
                    input.next(); // Clear the invalid input
                }
            }
        }
    }

    // models.Organizer's Methods

    // Update wallet (add - withdraw)
//    public void updateWallet(double amount, short choice)
//    {
//        if (choice == 1) {    wallet.addFunds(amount);    }
//        else if (choice == 2) {    wallet.deductFunds(amount);    }
//    }


    // EVENT CRUD
    public void createEvent (Event newEvent) {    Database.getEventList().add(newEvent);    }
                    
    public Event readEvent (String eventId)
    {
        for (Event event : Database.getEventList())
        {
        if (event.getEventID().equals(eventId))
        {
            return event;
        }
        }
        return null;
    }

    public boolean deleteEvent(String eventId) {
        if (readEvent(eventId) != null) {
            Database.getEventList().remove(readEvent(eventId));
            return true;
        }
        return false;
    }

    public boolean update(Event updatedEvent)
    {
        ArrayList<Event> events = Database.getEventList();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventID().equals(updatedEvent.getEventID()) ) {
                events.set(i, updatedEvent);
                return true;
            }
        }
        return false; // not found
    }

    public void showMyEvents()
    {
        ArrayList<Event> events = Database.getEventList();

        int i = 0;
        for (; i < events.size(); i++) {
            if (getUserName().equals(this.userName)) {
                System.out.println("My Events");
                events.get(i).showEventDetails();
            }
            if (i == 0) {
                System.out.println("You have no events");
            }
        }
    }

//    public void showAttendeesForMyEvent(models.Event e) {
//        System.out.println("Showing attendees for event ID: ");
//
//    }

    public void removeAttendee(Attendee attendee, Event event) {
        if (event.getAttendees().contains(attendee)) {
            event.getAttendees().remove(attendee);
            System.out.println("models.Attendee removed successfully from event: " + event.getEventID());
        } else {
            System.out.println("models.Attendee not found in this event.");
        }
    }

    public Wallet getWallet(){return wallet;}
}







