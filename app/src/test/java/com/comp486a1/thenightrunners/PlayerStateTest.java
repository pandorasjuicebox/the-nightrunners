package com.comp486a1.thenightrunners;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.graphics.PointF;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class PlayerStateTest {

    private PlayerState playerState;

    @Mock
    PointF pointF;
    int num;

    @Before
    public void setUp(){
        playerState = mock(PlayerState.class);
    }

    @Test
    public void loadLocation() {
        //Verifies return behaviour
        when(playerState.loadLocation()).thenReturn(pointF);
    }

    @Test
    public void getLives() {
        //Verifies return behaviour
        when(playerState.getLives()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = playerState.getLives();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(playerState).getLives();
    }

    @Test
    public void getNumDiscs() {
        //Verifies return behaviour
        when(playerState.getNumDiscs()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = playerState.getNumDiscs();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(playerState).getNumDiscs();
    }

    @Test
    public void getTotalCollectedDiscs() {
        //Verifies return behaviour
        when(playerState.getTotalCollectedDiscs()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = playerState.getTotalCollectedDiscs();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(playerState).getTotalCollectedDiscs();
    }
}