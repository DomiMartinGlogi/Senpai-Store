package model;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Item> contents;
    private String name;

    public Storage(Item item, String name, int capacity){
        contents = new ArrayList<>(capacity);
        this.name = name;
    }

}
