package model.items;

import java.util.Date;

public class Alcohol extends Perishable{
    private float abv;
    private String type;

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
