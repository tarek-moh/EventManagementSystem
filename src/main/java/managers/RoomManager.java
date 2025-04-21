package managers;

import models.Room;
import services.Database;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    public static Room bookAvailableRoom(String timeslot)
    {
        for(Room room : Database.getRoomList())
        {
            if(room.isAvailable(timeslot))
            {
                room.bookRoom(timeslot);
                return room;
            }
        }
        return null;
    }

    public static void showAvailableRooms()
    {
        ArrayList<Room> roomList = Database.getRoomList();

        for (Room room : roomList)
        {
            System.out.println("Available Rooms\n");
            ArrayList<String> slots = new ArrayList<>(List.of(room.getScheduleSlots().split(",")));
            for(String slot : slots)
            {
                if (room.isAvailable(slot))
                {
                    System.out.println("models.Room ID: " + room.getRoomID());
                    System.out.println("schedule hours: " + room.getScheduleSlots());
                    System.out.println("Capacity: " + room.getCapacity() + "\n");
                }
            }

        }
        if (roomList.isEmpty()) {    System.out.println("No available rooms");}
    }
}
