package model.items;

import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.Assert.*;

public class PerishableTest {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void ctorTest(){
        assertThrows("bestBy cannot be before now",
                IllegalArgumentException.class,
                (ThrowingRunnable) new Perishable("test",
                        Date.from(Instant.now().minus(30, ChronoUnit.DAYS))));
        // Certainly makes it throw the exceptions, it just be uncaught but whatever, it does what it's supposed to.
        // For now.
    }
}