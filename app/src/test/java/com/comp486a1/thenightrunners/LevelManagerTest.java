package com.comp486a1.thenightrunners;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.graphics.Bitmap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class LevelManagerTest {

    LevelManager levelManager;

    @Mock
    Bitmap bitmap;
    char c;
    int num;
    String str;

    @Before
    public void setUp(){
        levelManager = mock(LevelManager.class);
    }

    @Test
    public void isPlaying() {
    }

    @Test
    public void getBitmap() {
        //Verifies return behaviour
        when(levelManager.getBitmap(c)).thenReturn(bitmap);
    }

    @Test
    public void getBitmapIndex() {
        //Verifies return behaviour
        when(levelManager.getBitmapIndex(c)).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = levelManager.getBitmapIndex(c);
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(levelManager).getBitmapIndex(c);
    }

    @Test
    public void getTotalDiscs() {
        //Verifies return behaviour
        when(levelManager.getTotalDiscs()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = levelManager.getTotalDiscs();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(levelManager).getTotalDiscs();
    }

    @Test
    public void getLevel() {
        //Verifies return behaviour
        when(levelManager.getLevel()).thenReturn(str);
    }
}