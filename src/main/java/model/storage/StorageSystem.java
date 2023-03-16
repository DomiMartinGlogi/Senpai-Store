package model.storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Storage System models a Larger group of Storages, like for example an entire Shelf or a group of Shelfs
 * @author Dominik Martin Glogowski
 */
public class StorageSystem implements Serializable {
    private List<Storage> containers;
    private Room room;
    private String name;

    public StorageSystem(Room room, String name){
        this.containers = new ArrayList<>();
        this.room = room;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }
}
