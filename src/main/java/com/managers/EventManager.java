package com.managers;
import java.util.ArrayList;
import com.models.Event;
import com.models.Attendee;
import com.services.Database;


public class EventManager {

    public static void showAllEvents(){
        ArrayList <Event> events= Database.getEventList();
        for (Event ev:events){
            System.out.println("=========================================");
            ev.showEventDetails();
            System.out.println("=========================================");
        }
    }
    public static void showEventAttendees(Event e){
        e.showEventAttendees();
    }
    public static void removeEventAttendee(Event e,Attendee attendee){
        e.removeEventAttendee(attendee);
    }

}
