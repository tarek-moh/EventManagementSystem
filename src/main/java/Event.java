/*
 *add parameters for the room constructor
 * implement showEventDetails()
 **/
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * The {@code Event} class represents an event that can be booked and attended.
 * It includes attributes such as title, description, category, time slot, and associated room.
 * <p>
 * Each event generates a unique event ID following a patterned format and manages
 * its own tickets and attendees.
 * <p>
 * The class also handles availability checking, ticket generation, and basic attendee management.
 * GUI-specific logic (e.g., event detail display) can be added later.
 *
 * Example usage:
 * <pre>
 *     Event e = new Event("Tech Talk", "A talk on AI", "Nour", "Tech", "10:00AM-12:00PM");
 *     if (e.isAvailable()) {
 *         Ticket t = e.generateTicket();
 *     }
 * </pre>
 *
 * @author Nour
 */
public class Event {
    //attributes
    private static int evCounter = 1000;
    private String eventID;
    private double price;
    private String title;
    private String description;
    private final String organizer;
    private final String category;
    private String timeslot;
    private Room room;
    private ArrayList <Ticket> soldTickets;
    private ArrayList<Attendee> attendees;

    //constructor
    public Event( String title, String description,String organizer,String category,String timeslot){
        this.eventID =generateEventID();//patterned id ex: EVT202504201000
        this.title = title;
        this.description = description;
        this.organizer = organizer;
        this.category = category;
        this.timeslot = timeslot;
        room =new Room(); //add parameters here (if there is even any )!!
        soldTickets=new ArrayList<>();
        attendees=new ArrayList<>();
    }

    //methods
    public boolean isAvailable(){  //checks for available tickets
        if(room.capacity==soldTickets.size()){return false;}
        else {return true;}
    }

    public void addAtendee(Attendee a){
        attendees.add(a);
    }

     //as for each event there is a ticket price
    private double calculatePrice(){
        return price;  // pricing logic maybe implemented here later!!
    }


    public Ticket generateTicket(){   //add payment logic here ig !!
        int newTicketId=soldTickets.size()+1;
        Ticket ticket=new Ticket(newTicketId,calculatePrice(),this.title);
        soldTickets.add(ticket);
        return ticket;
    }

    private String generateEventID(){ //didn't add it to the UML diagram!!
        String prefix = "EVT";
        String datePart = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return prefix + datePart + evCounter++;
    }

    public void showEventDetails(){
       //ig it's gonna change when implementing the GUI!!
    }

}
