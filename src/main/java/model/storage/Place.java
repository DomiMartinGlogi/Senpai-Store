package model.storage;

import java.io.Serializable;

/**
 * Place Models a place, use it to address things, should be few.
 * @author Dominik Martin Glogowski
 */
public class Place implements Serializable {
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
