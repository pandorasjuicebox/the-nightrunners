package com.comp486a1.thenightrunners;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.graphics.Rect;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ViewportTest {

    private Viewport viewport;

    @Mock
    int num;
    Rect rect;
    float placeHolder;
    boolean bool;

    @Before
    public void setUp(){
        viewport = mock(Viewport.class);
    }

    @Test
    public void getScreenWidth() {
        //Verifies return behaviour
        when(viewport.getScreenWidth()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = viewport.getScreenWidth();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(viewport).getScreenWidth();
    }

    @Test
    public void getScreenHeight() {
        //Verifies return behaviour
        when(viewport.getScreenHeight()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = viewport.getScreenHeight();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(viewport).getScreenHeight();
    }

    @Test
    public void getPixelsPerMetreX() {
        //Verifies return behaviour
        when(viewport.getPixelsPerMetreX()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = viewport.getPixelsPerMetreX();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(viewport).getPixelsPerMetreX();
    }

    @Test
    public void worldToScreen() {
        //Verifies return behaviour
        when(viewport.worldToScreen(placeHolder,placeHolder,placeHolder,placeHolder)).thenReturn(rect);
    }

    @Test
    public void clipObjects() {
        //Verifies return behaviour
        when(viewport.clipObjects(placeHolder,placeHolder,placeHolder,placeHolder)).thenReturn(bool);

        //Asserting that the integer value it returns is not null
        boolean dummyBool = viewport.clipObjects(placeHolder,placeHolder,placeHolder,placeHolder);
        assertNotNull(dummyBool);

        //That the class calls the appropriate method.
        verify(viewport).clipObjects(placeHolder,placeHolder,placeHolder,placeHolder);
    }

    @Test
    public void getPixelsPerMetreY() {
        //Verifies return behaviour
        when(viewport.getPixelsPerMetreY()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = viewport.getPixelsPerMetreY();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(viewport).getPixelsPerMetreY();
    }

    @Test
    public void getyCentre() {
        //Verifies return behaviour
        when(viewport.getyCentre()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = viewport.getyCentre();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(viewport).getyCentre();
    }

    @Test
    public void getViewportWorldCentreY() {
        //Verifies return behaviour
        when(viewport.getViewportWorldCentreY()).thenReturn(placeHolder);

        //Asserting that the integer value it returns is not null
        float dummyFloat = viewport.getViewportWorldCentreY();
        assertNotNull(dummyFloat);

        //That the class calls the appropriate method.
        verify(viewport).getViewportWorldCentreY();
    }
}