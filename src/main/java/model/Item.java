package model;

import java.time.Instant;
import java.util.Date;

/**
 * Models the Basic Structure and utility of Items should not be instantiated
 * If generic class is needed just extend it.
 * @author Dominik Martin Glogowski
 */
public abstract class Item {
    private String name;
    private boolean checkedOut;
    private Date checkOutDate;

    /**
     * Creates the Item
     * Sets checkedOut to false and checkOutDate to null.
     * @param name
     */
    public Item(String name){
        this.name = name;
        checkedOut = false;
        checkOutDate = null;
    }

    public String getName() {
        return name;
    }

    /**
     * Checks whether the item is checked out or not, effectively a getter in all but name.
     * @return false when the item is present, true if it is checked out.
     */
    public boolean checkOutStatus() {
        return checkedOut;
    }

    /**
     * Checks out the item, sets checkedOut to true, and the checkOutDate to Instant.Now()
     */
    public void checkOut(){
        if (checkedOut){
            System.out.println(name + " is already checked out.");
        } else {
            checkedOut = true;
            checkOutDate = Date.from(Instant.now());
        }
    }

    /**
     * Returns the Item, checkedOut will be set to false, checkOutDate is set back to null.
     */
    public void returnIt() {
        if (checkOutDate == null || !checkedOut){
            System.out.println(name + " cannot be returned, it is already here.");
        } else {
            checkedOut = false;
            checkOutDate = null;
        }
    }
}
