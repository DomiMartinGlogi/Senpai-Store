package model.storage;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StorageSystemTest {
    Place p;
    Room r;
    StorageSystem s;
    ArrayList<Storage> al;

    @Before
    public void setUp(){
        p = new Place("Test");
        r = new Room(p,"Test");
        s = new StorageSystem(r,"Test");
        al = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Storage st = new Storage("t" + i,-1);
            s.addContainer(st);
            al.add(st);
        }
    }

    @Test
    public void getName() {
        assertEquals("Test",s.getName());
    }

    @Test
    public void getRoom() {
        assertEquals(r,s.getRoom());
    }

    @Test
    public void getContainers() {
        assertEquals(al,s.getContainers());
    }
}