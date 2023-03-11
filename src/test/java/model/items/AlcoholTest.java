package model.items;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class AlcoholTest {
    Alcohol a;

    @Before
    public void setUp(){
        a = new Alcohol("Ardbeg", Date.from(Instant.now().plus(3, ChronoUnit.DAYS)),.45f,"Scotch");
    }

    @Test
    public void usable() {
        assertTrue(a.usable());
    }

    @Test
    public void getName() {
        assertEquals("Ardbeg",a.getName());
    }

    @Test
    public void checkOutStatus() {
        assertFalse(a.checkOutStatus());
    }

    @Test
    public void checkOut() {
        assertFalse(a.checkOutStatus());
        a.checkOut();
        assertTrue(a.checkOutStatus());
    }

    @Test
    public void returnIt() {
        a.checkOut();
        assertTrue(a.checkOutStatus());
        a.returnIt();
        assertFalse(a.checkOutStatus());
    }

    @Test
    public void getAbv() {
        assertEquals(.45f,a.getAbv(),0);
    }

    @Test
    public void getType() {
        assertEquals("Scotch", a.getType());
    }
}