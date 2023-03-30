package view;

import model.storage.*;

import java.util.ArrayList;

public class demoDataGen {

    public static ArrayList<Place> genPlaces(int numPlaces){
        ArrayList<Place> data = new ArrayList<>();
        for (int i = 0; i < numPlaces; i++) {
            data.add(new Place("Example Building Nr. " +(i + 1)));
        }
        return data;
    }

    public static ArrayList<Room> genRooms(ArrayList<Place> places){
        ArrayList<Room> data = new ArrayList<>();
        for (Place p: places){
            data.add(new Room(p, "Living Room"));
            data.add(new Room(p, "Corridor"));
            data.add(new Room(p, "Kitchen"));
            data.add(new Room(p, "Office"));
            data.add(new Room(p, "Bathroom"));
            data.add(new Room(p, "Bedroom"));
            data.add(new Room(p, "Garden"));
        }
        return data;
    }

    public static ArrayList<StorageSystem> genStorageSystems(ArrayList<Room> rooms){
        ArrayList<StorageSystem> data = new ArrayList<>();
        for (Room r: rooms){
            if (r.getName() == "Living Room"){
                data.add(new StorageSystem(r,"Liquor Cabinet"));
                data.add(new StorageSystem(r, "The Table"));
            }
            if (r.getName() == "Corridor"){
                data.add(new StorageSystem(r, "Shoe Rack"));
                data.add(new StorageSystem(r, "Wardrobe"));
            }
            if (r.getName() == "Kitchen"){
                data.add(new StorageSystem(r, "Fridge"));
                data.add(new StorageSystem(r, "Oven"));
                data.add(new StorageSystem(r, "Cupboard"));
                data.add(new StorageSystem(r, "Freezer"));
            }
            if (r.getName() == "Office"){
                data.add(new StorageSystem(r, "Toolbox"));
                data.add(new StorageSystem(r, "Filing cabinet"));
            }
            if (r.getName() == "Bathroom"){
                data.add(new StorageSystem(r, "Medicine Cabinet"));
            }
            if (r.getName() == "Bedroom"){
                data.add(new StorageSystem(r, "Under the Bed"));
                data.add(new StorageSystem(r, "Bedside Table"));
                data.add(new StorageSystem(r, "Wardrobe"));
            }
            if (r.getName() == "Gardenn"){
                data.add(new StorageSystem(r, "The Shed"));
                data.add(new StorageSystem(r, "The hollowed out Rock"));
            }
        }
        return data;
    }
}
