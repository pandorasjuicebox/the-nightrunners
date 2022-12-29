package com.comp486a1.thenightrunners;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BlasterTest {

    private Blaster blaster;

    @Mock
    int num;
    float input;
    float output;
    float x; float y; float h;
    boolean bool;

    @Before
    public void setUp() {
        blaster = mock(Blaster.class);
    }

    @Test
    public void getNumBullets() {

        //Verifies return behaviour
        when(blaster.getNumBullets()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = blaster.getNumBullets();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(blaster).getNumBullets();
    }

    @Test
    public void getBulletX() {
        //Verifies return behaviour
        when(blaster.getBulletX(num)).thenReturn(output);

        //Asserting that the integer value it returns is not null
        float dummyFlt = blaster.getBulletX(num);
        assertNotNull(dummyFlt);

        //That the class calls the appropriate method.
        verify(blaster).getBulletX(num);
    }

    @Test
    public void getBulletY() {
        //Verifies return behaviour
        when(blaster.getBulletY(num)).thenReturn(output);

        //Asserting that the integer value it returns is not null
        float dummyFlt = blaster.getBulletY(num);
        assertNotNull(dummyFlt);

        //That the class calls the appropriate method.
        verify(blaster).getBulletY(num);
    }

    @Test
    public void getDirection() {
        //Verifies return behaviour
        when(blaster.getDirection(num)).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = blaster.getDirection(num);
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(blaster).getDirection(num);
    }

    @Test
    public void shoot() {
        //Verifies return behaviour
        when(blaster.shoot(x,y,num,h)).thenReturn(bool);

        //Asserting that the integer value it returns is not null
        boolean dummyShoot = blaster.shoot(x,y,num,h);
        assertNotNull(dummyShoot);

        //That the class calls the appropriate method.
        verify(blaster).shoot(x,y,num,h);
    }
}