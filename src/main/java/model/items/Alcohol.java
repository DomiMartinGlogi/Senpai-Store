package model.items;

import java.util.Date;

/**
 * Alcohol is an extension of Perishable used to model alcoholic beverages
 * @author Dominik Martin Glogowski
 */
public class Alcohol extends Perishable{
    private float abv;
    private String type;

    /**
     * Basic ctor
     * @param name
     * @param bestBy
     * @param abv Alcohol by Volume as a float, as written on a bottle/can without the % character, so if
     *            4.5% Alcohol by Volume use 4.5
     * @param type Type in a simple manner, so for example if "Single Malt Aislay Scotch - 10yrs" that String is useable
     *             but for searchability use a simple type, like "Scotch"
     */
    public Alcohol(String name, Date bestBy, float abv, String type) {
        super(name, bestBy);
        this.abv = abv;
        this.type = type;
    }

    public float getAbv() {
        return abv;
    }

    public String getType() {
        return type;
    }
}
