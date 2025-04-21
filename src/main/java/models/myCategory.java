package models;

import java.util.ArrayList;
/**
 * The {@code Category} class represents a classification or type of events
 * (e.g., Music, Tech, Sports). Each category maintains a list of events that
 * fall under it.
 * <p>
 * It provides methods to add events and retrieve all events associated
 * with this category.
 *
 * Example usage:
 * <pre>
 *     Category musicCategory = new Category("Music");
 *     musicCategory.addEvent(concertEvent);
 * </pre>
 *
 * @author Nour
 */

public class myCategory {
    private String name;
    private ArrayList<Event>events;

    //constructor
    public myCategory(String name){
        this.name=name;
        events=new ArrayList<>();
    }
    //methods
    public void addEvent(Event e){
        events.add(e);
    }
    //getters
    public ArrayList<Event> getAllEvents(){
        return this.events;
    }

    public String getName(){ //notice i didn't add it to the UML diagram
        return name;
    }
}
