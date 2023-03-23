package model.storage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    Place p;
    Room r;

    @Before
    public void setUp(){
        p = new Place("Test");
        r = new Room(p,"Test");
    }

    @Test
    public void testCtor(){
        assertNotNull(r);
    }
    @Test
    public void getName() {
        assertEquals("Test",r.getName());
    }

    @Test
    public void getPlace() {
        assertEquals(p,r.getPlace());
    }
}