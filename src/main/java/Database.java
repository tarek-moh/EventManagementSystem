import java.util.ArrayList;
/**
 * @author Tarek Mohamed
 *
 * This class holds static dummy data to simulate a real database.
 * It also acts as a CRUD manager for the user hierarchy: Attendee, Organizer, and Admin.
 *
 * Note: Room is managed by Admin. Event and Category are managed separately by Organizer and Admin respectively.
 *
 */
public class Database implements CrudManager<Attendee>, CrudManager<Admin>, CrudManager<Organizer>{
    private static ArrayList<Attendee> attendeeList = new ArrayList<Attendee>();
    private static ArrayList<Organizer> organizerList = new ArrayList<Organizer>();
    private static ArrayList<Admin> adminList = new ArrayList<Admin>();
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    private static ArrayList<Room> roomList = new ArrayList<Room>();
    private static ArrayList<Category> categoryList = new ArrayList<Category>();


    static {
        attendeeList.add(new Attendee("Ali", "ali@gmail.com", "1234", 100));
        attendeeList.add(new Attendee("Sara", "sara@yahoo.com", "5678", 200));
        attendeeList.add(new Attendee("Omar", "omar@gmail.com", "abcd", 300));
    }

    // Getters
    public static ArrayList<Attendee> getAttendeeList() {
        return attendeeList;
    }
    public static ArrayList<Organizer> getOrganizerList() {
        return organizerList;
    }
    public static ArrayList<Admin> getAdminList() {
        return adminList;
    }
    public static ArrayList<Event> getEventList() {
        return eventList;
    }
    public static ArrayList<Room> getRoomList() {
        return roomList;
    }
    public static ArrayList<Category> getCategoryList() {
        return categoryList;
    }


    ////////////////////////// CRUD operations for *ATTENDEE* //////////////////////
    // CREATE
    public static void addAttendee(Attendee attendee)
    {
        attendeeList.add(attendee);
    }

    // READ
    public static Attendee getAttendee(int id)
    {
        for(Attendee attendee : attendeeList)
        {
            if(attendee.getId() == id)
                return attendee;
        }
        return null;
    }

    // UPDATE
    public static boolean updateAttendee(Attendee updated)
    {
        for (int i = 0; i < attendeeList.size(); i++) {
            if (attendeeList.get(i).getId() == updated.getId())
            {
                Database.attendeeList.set(i, updated);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public static boolean deleteAttendee(int id)
    {
        return attendeeList.removeIf(a -> a.getId() == id);
    }

    ////////////////////////// end of CRUD operations for *ATTENDEE* ///////////////
    ///
    ////////////////////////// CRUD operations for *ORGANIZER* //////////////////////
    // CREATE
    public static void addOrganizer(Organizer organizer)
    {
        organizerList.add(organizer);
    }

    // READ
    public static Organizer getOrganizer(int id)
    {
        for(Organizer organizer : organizerList)
        {
            if(organizer.getId() == id)
                return organizer;
        }
        return null;
    }

    // UPDATE
    public static boolean updateOrganizer(Organizer updated){
        for (int i = 0; i < organizerList.size(); i++) {
            if (organizerList.get(i).getId() == updated.getId()) {
                Database.organizerList.set(i, updated);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public static boolean deleteOrganizer(int id)
    {
        return organizerList.removeIf(a -> a.getId() == id);
    }

    ////////////////////////// end of CRUD operations for *ORGANIZER* ///////////////
    ///
    ////////////////////////// CRUD operations for *ORGANIZER* //////////////////////
    // CREATE
    public static void addAdmin(Admin admin)
    {
        adminList.add(admin);
    }

    // READ
    public static Admin getAdmin(int id)
    {
        for(Admin admin : adminList)
        {
            if(admin.getId() == id)
                return admin;
        }
        return null;
    }

    // UPDATE
    public static boolean updateAdmin(Admin updated)
    {
        for (int i = 0; i < adminList.size(); i++) {
            if(adminList.get(i).getId() == updated.getId())
            {
                Database.adminList.set(i, updated);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public static boolean deleteAdmin(int id)
    {
        return adminList.removeIf(a -> a.getId() == id);
    }

    ////////////////////////// end of CRUD operations for *ORGANIZER* //////////////////////

}
