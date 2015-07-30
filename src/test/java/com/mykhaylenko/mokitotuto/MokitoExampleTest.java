package com.mykhaylenko.mokitotuto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by pavlo.mykhaylenko on 7/30/2015.
 */
public class MokitoExampleTest {

    private TestObject instance;

    private static final String PRINT_EXPECTED = "Hello";
    private static final String PRINT_STRING_EXPECTED = "Hello word";
    private static final String PRINT_ANY_STRING_EXPECTED = "Any string";


    @Before
    public void setUp() throws Exception {
        instance = mock(TestObject.class);

    }

    @Test
    public void testPrint() {
        when(instance.print()).thenReturn("Hello");

        String result = instance.print();

        assertEquals(PRINT_EXPECTED, result);
    }

    @Test
    public void testPrintString() {
        when(instance.print("Hello word")).thenReturn("Hello word");

        String result = instance.print("Hello word");

        assertEquals(PRINT_STRING_EXPECTED, result);
    }

    @Test
    public void testCreate() {
        when(instance.create(1, "first")).thenReturn(new ReturnObject(1, "first"));

        ReturnObject result = instance.create(1, "first");

        assertEquals(new ReturnObject(1, "first"), result);
    }

    @Test
    public void testPrintAny() {
        when(instance.print(anyString())).thenReturn("Any string");

        String result = instance.print("Any input string");

        assertEquals(PRINT_ANY_STRING_EXPECTED, result);
    }

    @Test
    public void testSum() {
        when(instance.sum(3,3)).thenReturn(6);

        int result = instance.sum(3, 3);

        assertEquals(6, result);
    }
}
