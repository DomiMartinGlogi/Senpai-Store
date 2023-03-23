package model.storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {

    @Test
    public void getName() {
        Place sut = new Place("Test");
        assertNotNull(sut);
        assertEquals("Test",sut.getName());
    }
}