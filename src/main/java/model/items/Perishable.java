package model.items;

import java.time.Instant;
import java.util.Date;

public class Perishable extends Item{
    private Date bestBy;

    /**
     * Creates the Perishable Item
     * Sets checkedOut to false and checkOutDate to null.
     * Sets the bestBy date.
     * @param name
     * @param bestBy
     */
    public Perishable(String name, Date bestBy) {
        super(name);
        if (Date.from(Instant.now()).after(bestBy)){
            throw new IllegalArgumentException("bestBy cannot be before now");
        }
        this.bestBy = bestBy;
    }

    public boolean usable(){
        if (Date.from(Instant.now()).after(bestBy)){
            return false;
        }
        return true;
    }

}
