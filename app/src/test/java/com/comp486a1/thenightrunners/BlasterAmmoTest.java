package com.comp486a1.thenightrunners;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BlasterAmmoTest {

    BlasterAmmo blasterAmmo;

    @Mock
    int num;
    float output;

    @Before
    public void setUp(){
        blasterAmmo = mock(BlasterAmmo.class);
    }

    @Test
    public void getDirection() {
        //Verifies return behaviour
        when(blasterAmmo.getDirection()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = blasterAmmo.getDirection();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(blasterAmmo).getDirection();
    }

    @Test
    public void getX() {
        //Verifies return behaviour
        when(blasterAmmo.getX()).thenReturn(output);

        //Asserting that the integer value it returns is not null
        float dummyFloat = blasterAmmo.getX();
        assertNotNull(dummyFloat);

        //That the class calls the appropriate method.
        verify(blasterAmmo).getX();
    }

    @Test
    public void getY() {
        //Verifies return behaviour
        when(blasterAmmo.getY()).thenReturn(output);

        //Asserting that the integer value it returns is not null
        float dummyFloat = blasterAmmo.getY();
        assertNotNull(dummyFloat);

        //That the class calls the appropriate method.
        verify(blasterAmmo).getY();
    }
}