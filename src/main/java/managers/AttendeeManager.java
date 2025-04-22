package managers;

import models.Attendee;
import services.Database;

public class AttendeeManager {
    public static void showAllAttendees()
    {
        for(Attendee attendee : Database.getAttendeeList())
        {
            System.out.println("====================");
            attendee.showAttendeeDetails();
            System.out.println("====================");

        }
    }
}
