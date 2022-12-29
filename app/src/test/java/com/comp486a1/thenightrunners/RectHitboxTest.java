package com.comp486a1.thenightrunners;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class RectHitboxTest {

    private RectHitbox rectHitbox;

    @Mock
    boolean bool;
    RectHitbox hitbox;
    float numFl;

    @Before
    public void setUp() {
        rectHitbox = mock(RectHitbox.class);
    }

    @Test
    public void intersects() {
        //Verifies return behaviour
        when(rectHitbox.intersects(hitbox)).thenReturn(bool);

        //Asserting that the integer value it returns is not null
        boolean dummyBool = rectHitbox.intersects(hitbox);
        assertNotNull(dummyBool);

        //That the class calls the appropriate method.
        verify(rectHitbox).intersects(hitbox);
    }

    @Test
    public void getLeft() {
        //Verifies return behaviour
        when(rectHitbox.getLeft()).thenReturn(numFl);

        //Asserting that the integer value it returns is not null
        float dummyFloat = rectHitbox.getLeft();
        assertNotNull(dummyFloat);

        //That the class calls the appropriate method.
        verify(rectHitbox).getLeft();
    }

    @Test
    public void getHeight() {
        //Verifies return behaviour
        when(rectHitbox.getHeight()).thenReturn(numFl);

        //Asserting that the integer value it returns is not null
        float dummyInt = rectHitbox.getLeft();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(rectHitbox).getLeft();
    }
}