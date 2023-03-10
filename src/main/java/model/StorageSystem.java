package model;

import java.util.ArrayList;
import java.util.List;

public class StorageSystem {
    private List<Storage> containers;
    private Room room;
    private String name;

    public StorageSystem(Room room, String name){
        this.containers = new ArrayList<>();
        this.room = room;
        this.name = name;
    }
}
