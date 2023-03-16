package model.storage;

import model.items.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Models the lowest level of Storage, ie a box or a level of a shelf
 * @author Dominik Martin Glogowski
 */
public class Storage implements Serializable {
    private List<Item> contents;
    private String name;
    int capacity;

    /**
     * Basic ctor
     * Generates an empty ArrayList for contents with set capacity.
     * @param name gives the name of the storage, like "Shelf A-1"
     * @param capacity Maximum NUMBER of items in the list. Use -1 for effectively infinite.
     */
    public Storage(String name, int capacity){
        if (capacity == -1){
            capacity = Integer.MAX_VALUE;
        }
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

    /**
     * Adds an Item to contents.
     * Checks for space in contents.
     * @param item
     * @return False if capacity at maximum, True if item successfully added.
     */
    public boolean addItem(Item item){
        if (contents.size() == capacity) {
            return false;
        }
        contents.add(item);
        return true;
    }

    /**
     * Attempts to remove the given item.
     * @param item
     * @return False if item not in contents, false if successfully removed.
     */
    public boolean removeItem(Item item){
        if (!contents.contains(item)){
            return false;
        }
        contents.remove(item);
        return true;
    }

    /**
     * Searches for any Item where the name contains the given String filter.
     * @param filter
     * @return ArrayList of Item
     */
    public List<Item> searchForItem(String filter){
        List<Item> returnList = new ArrayList<>();
        for (Item i:contents){
            if (i.getName().contains(filter)){
                returnList.add(i);
            }
        }
        return returnList;
    }

    /**
     * Checks out the given item.
     * @param item
     * @return False if the item is already checked out or not in contents. True if successfully checked out.
     */
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

    /**
     * Attempts to return a given Item
     * @param item
     * @return False if item not in list or not checked out, True if successfully returned.
     */
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
