package model;

import java.time.Instant;
import java.util.Date;

public abstract class Item {
    private String name;
    private boolean checkedOut;
    private Date checkOutDate;

    public Item(String name){
        this.name = name;
        checkedOut = false;
        checkOutDate = null;
    }

    public String getName() {
        return name;
    }

    public boolean checkOutStatus() {
        return checkedOut;
    }

    public void checkOut(){
        if (checkedOut){
            System.out.println(name + " is already checked out.");
        } else {
            checkedOut = true;
            checkOutDate = Date.from(Instant.now());
        }
    }

    public void returnIt() {
        if (checkOutDate == null || !checkedOut){
            System.out.println(name + " cannot be returned, it is already here.");
        } else {
            checkedOut = false;
            checkOutDate = null;
        }
    }
}
