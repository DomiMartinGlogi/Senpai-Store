package model.storage;

import controller.Searchable;

import java.io.Serializable;

/**
 * Place Models a place, use it to address things, should be few.
 * @author Dominik Martin Glogowski
 */
public class Place implements Serializable, Searchable {
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
