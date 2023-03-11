package model.items;

import static org.junit.Assert.*;

public class BookTest {
    Book bT;
    @org.junit.Before
    public void setUp() throws Exception {
        bT = new Book("The Hobbit","J.R.R. Tolkien","Fantasy");
    }

    @org.junit.Test
    public void getName() {
        assertEquals("The Hobbit",bT.getName());
    }

    @org.junit.Test
    public void checkOutStatus() {
        assertFalse(bT.checkOutStatus());
    }

    @org.junit.Test
    public void checkOut() {
        bT.checkOut();
        assertTrue(bT.checkOutStatus());
    }

    @org.junit.Test
    public void returnIt() {
        bT.checkOut();
        assertTrue(bT.checkOutStatus());
        bT.returnIt();
        assertFalse(bT.checkOutStatus());
    }

    @org.junit.Test
    public void getAuthor() {
        assertEquals("J.R.R. Tolkien", bT.getAuthor());
    }

    @org.junit.Test
    public void getTopic() {
        assertEquals("Fantasy", bT.getTopic());
    }
}