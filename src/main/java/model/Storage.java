package model;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Item> contents;
    private String name;
    int capacity;

    public Storage(Item item, String name, int capacity){
        contents = new ArrayList<>(capacity);
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public List<Item> getContents() {
        return contents;
    }

    public boolean addItem(Item item){
        if (contents.size() == capacity) {
            return false;
        }
        contents.add(item);
        return true;
    }

    public boolean removeItem(Item item){
        if (!contents.contains(item)){
            return false;
        }
        contents.remove(item);
        return true;
    }

    public List<Item> searchForItem(String name){
        List<Item> returnList = new ArrayList<>();
        for (Item i:contents){
            returnList.add(i);
        }
        return returnList;
    }

    public boolean checkOutItem(Item item){
        if (!contents.contains(item)){
            return false;
        } else {
            Item inList = contents.get(contents.indexOf(item));
            if (!inList.checkOutStatus()){
                return false;
            }
            inList.checkOut();
            return true;
        }
    }

    public boolean returnItem(Item item){
        if (!contents.contains(item)){
            return false;
        } else {
            Item inList = contents.get(contents.indexOf(item));
            if (inList.checkOutStatus()){
                inList.returnIt();
                return true;
            }
            return false;
        }
    }
}
