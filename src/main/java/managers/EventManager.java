package managers;
import java.util.ArrayList;
import models.Event;
import services.Database;


public class EventManager {

    public static void showEvent(){
        ArrayList <Event> events= Database.getEventList();
        for (Event ev:events){
            ev.showEventDetails();
            System.out.println("=========================================");
        }
    }
}
