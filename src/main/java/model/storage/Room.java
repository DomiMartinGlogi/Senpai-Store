package model.storage;

/**
 * Room models a Room, even the outdoors part of a place, Outdoors is a room not a Place.
 * @author Dominik Martin Glogowski
 */
public class Room {
    private Place place;
    private String name;

    public Room(Place place, String name){
        this.place = place;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Place getPlace() {
        return place;
    }
}
