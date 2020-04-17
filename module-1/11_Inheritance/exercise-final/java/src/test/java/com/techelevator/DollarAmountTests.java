package com.techelevator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DollarAmountTests {
    @Test
    public void ToStringTest() {
        assertEquals("$1.50", new DollarAmount(150).toString());
        assertEquals("$1.00", new DollarAmount(100).toString());
        assertEquals("$1.05", new DollarAmount(105).toString());

    }
}
