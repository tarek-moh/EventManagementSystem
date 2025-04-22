package models;

import managers.EventManager;
import managers.RoomManager;
import services.Database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

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

    @Override
    public void showDashboard() {
        while (true) {
            displayDashboardMenu();
            short choice = getValidMenuChoice(1, 11);

            switch (choice) {
                case 1 -> RoomManager.showAvailableRooms();


                case 2 -> showMyEvents();


                case 3 -> showEventAttendees();


                case 4 -> removeEventAttendee();


                case 5 -> createEvent();


                case 6 ->  updateEvent();

                case 7 -> {
                    while (true) {
                        System.out.println("Enter The Event ID: ");
                        try {
                            String Id = input.nextLine();
                            deleteEvent(Id);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Event ID is a String");
                        }
                    }
                }

                case 8 -> manageWallet();

                case 9 -> showProfile();

                case 10 -> {
                    return;
                } // Exit dashboard

                default->
                    System.out.println("Invalid input! Please choose between 1 and 11:");
            }
        }
    }

    // Helper methods
    private void displayDashboardMenu() {
        System.out.println("========================================");
        System.out.println("             Dashboard");
        System.out.println("========================================");
        System.out.println("1: Show available rooms\n2: Show my events \n3: Show attendees for my event\n4: Remove attendee from my event");
        System.out.println("5: Create an event\n6: Read an event \n7: Update an event\n8: Delete an event\n9: Wallet");
        System.out.println("10: Check Profile\n11: Logout");
    }

    private short getValidMenuChoice(int min, int max) {
        while (true) {
            if (input.hasNextShort()) {
                short choice = input.nextShort();
                input.nextLine(); // Consume newline
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                input.next(); // Clear invalid input
            }
            System.out.printf("Invalid input! Please choose between %d and %d:%n", min, max);
        }
    }

    public void createEvent() {

        while (true) {
            System.out.println("Enter title of event");
            String eventTitle = input.nextLine();
            System.out.println("Enter description of event");
            String eventDescription = input.nextLine();
            System.out.println("Enter category name of Event");
            String eventCategoryName = input.nextLine();
            System.out.println("Enter time slot of Event");
            String eventTimeSlot = input.nextLine();
            System.out.println("Enter ticket price of the Event");
            double ticketPrice = input.nextDouble();
            try {
                Event newEvent = new Event(eventTitle, eventDescription, this, eventCategoryName, eventTimeSlot, ticketPrice);
                createEvent(newEvent);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }

        }

    }

//    private Event readEvent(int eventID) {
//        input.nextLine(); // Consume newline
//         Event event = readEvent(eventID);
//         if (event != null) {
//             event.showEventDetails();
//         } else {
//             System.out.println("Event not found");
//         }
//    }

    private void manageWallet() {
        System.out.println("Current balance");
        // System.out.println(wallet.getBalance());
        System.out.println("1: Add money     2: Withdraw money     3: Exit");

        short walletChoice = getValidMenuChoice(1, 3);
        if (walletChoice == 3) return;

        System.out.println("Enter amount: ");
        int amount = input.nextInt();
        input.nextLine(); // Consume newline
        // updateWallet(amount, walletChoice);
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
        // Input validation
        if (eventId.isEmpty()) {
            System.out.println("Error: Invalid event ID");
            return false;
        }

        // Find the event by ID
        for (int i = 0; i < Database.getEventList().size(); i++) {
            if (Database.getEventList().get(i).getEventID().equals(eventId)) {
                Database.getEventList().remove(i);
                System.out.println("Event with ID " + eventId + " deleted successfully");
                return true;
            }
        }

        System.out.println("Error: Event with ID " + eventId + " not found");
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

    /// TODO: Override toString()
//    @Override
//    public String toString()
//    {
//        return
//    }
}







