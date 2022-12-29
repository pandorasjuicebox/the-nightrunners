package com.comp486a1.thenightrunners;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TeleportTest {

    @Mock
    Teleport teleport;
    Location location;

    @Before
    public void setUp(){
        teleport = mock(Teleport.class);
    }

    @Test
    public void getTarget() {
        //Verifies return behaviour
        when(teleport.getTarget()).thenReturn(location);
    }
}