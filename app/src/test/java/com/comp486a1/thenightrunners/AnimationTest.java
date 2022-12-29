package com.comp486a1.thenightrunners;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.graphics.Rect;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AnimationTest {
    private Animation animation;

    @Mock
    Rect rectVar;

    long time = 1;
    float flNum = 12f;
    boolean bool = false;

    @Before
    public void setup() throws Exception {
        animation = mock(Animation.class);
    }

    @Test
    public void getCurrentFrame() {
        //Check the return behaviour of the method.
        when(animation.getCurrentFrame(time,flNum,bool)).thenReturn(rectVar);
    }
}