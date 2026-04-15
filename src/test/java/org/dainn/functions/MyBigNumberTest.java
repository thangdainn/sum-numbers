package org.dainn.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBigNumberTest {
    private final MyBigNumber mbn =  new MyBigNumber();

    @Test
    void testBasicSum() {
        assertEquals("2131", mbn.sum("1234", "897"));
    }

    @Test
    void testWithCarry() {
        assertEquals("1000", mbn.sum("999", "1"));
        assertEquals("772", mbn.sum("154", "618"));
    }

    @Test
    void testZero() {
        assertEquals("123", mbn.sum("123", "0"));
        assertEquals("456", mbn.sum("0", "456"));
        assertEquals("123", mbn.sum("000123", "0"));
    }
}
