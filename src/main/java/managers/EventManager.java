package managers;
import java.util.ArrayList;
import models.Event;
import services.Database;


public class EventManager {

    public static void showAllEvents(){
        ArrayList <Event> events= Database.getEventList();
        for (Event ev:events){
            System.out.println("=========================================");
            ev.showEventDetails();
            System.out.println("=========================================");
        }
    }
}
