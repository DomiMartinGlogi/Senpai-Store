package controller;

import junit.framework.TestCase;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearcherTest extends TestCase {
    ArrayList<Searchable> testList;
    Searcher s;

    public void setUp() {
        //Prepare the testList for testing and fill it with mocked Searchables
        testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Searchable s = mock(Searchable.class);
            when(s.getName()).thenReturn(String.valueOf(i));
            testList.add(s);
        }
    }

    public void testSearch() {
        // Ensure no return for non matching string
        s = new Searcher("Name", testList);
        assertEquals(0,s.search().size());

        // Ensure proper return for a matching String, both List Size and it's contents
        s = new Searcher("1", testList);
        assertEquals(1,s.search().size());
        assertEquals("1",s.search().get(0).getName());
    }
}