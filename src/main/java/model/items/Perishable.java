package model.items;

import java.time.Instant;
import java.util.Date;

/**
 * Perishable manages any Item that is potentially perishable, can be extended
 * For more specialised classes if needed but can also be used as a generic class, for example for
 * radioactive Materials, "decaying" chemicals and so on.
 * @author Dominik Martin Glogowski
 */
public class Perishable extends Item{
    private Date bestBy;

    /**
     * Creates the Perishable Item
     * Sets checkedOut to false and checkOutDate to null.
     * Sets the bestBy date.
     * Throws an IllegalArgumentException if bestBy date is before the current Date.
     * @param name
     * @param bestBy
     */
    public Perishable(String name, Date bestBy) throws IllegalArgumentException {
        super(name);
        if (Date.from(Instant.now()).after(bestBy)){
            throw new IllegalArgumentException("bestBy cannot be before now");
        }
        this.bestBy = bestBy;
    }

    /**
     * @return True if bestBy has not yet past, False if it has.
     */
    public boolean usable(){
        if (Date.from(Instant.now()).after(bestBy)){
            return false;
        }
        return true;
    }

}
