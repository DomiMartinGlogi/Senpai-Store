package model.storage;

import model.items.Book;
import model.items.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StorageTest {
    Storage st;
    int cap;
    ArrayList<Item> contents;

    @Before
    public void setUp(){
        cap = 7;
        st = new Storage("Test",cap);
        contents = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Item item = new Book("The Hobbit", "JRR Tolkien","Fantasy");
            contents.add(item);
            st.addItem(item);
        }
    }

    @Test
    public void getName() {
        assertEquals("Test",st.getName());
    }

    @Test
    public void getContents() {
        assertEquals(contents, st.getContents());
    }

    @Test
    public void addItem() {
        Item item = new Book("The C Programming Language","K+R","Theology");
        st.addItem(item);
        assertEquals(4, st.getContents().size());
    }

    @Test
    public void removeItem() {
        Item item = new Book("The C Programming Language","K+R","Theology");
        st.addItem(item);
        assertEquals(4, st.getContents().size());
        st.removeItem(item);
        assertEquals(3, st.getContents().size());
    }

    @Test
    public void searchForItem() {
        Item item = new Book("The C Programming Language","K+R","Theology");
        st.addItem(item);
        List l = st.searchForItem("The C Programming Language");
        if (l.contains(item)) {
            assertEquals(item,l.get(0));
        } else {
            fail();
        }
    }
}