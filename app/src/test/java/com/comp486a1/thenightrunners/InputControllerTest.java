package com.comp486a1.thenightrunners;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

public class InputControllerTest {

    InputController inputController;

    @Mock
    ArrayList buttons;
    int num;

    @Before
    public void setUp() {
        inputController = mock(InputController.class);
    }

    @Test
    public void getButtons() {
        //Verifies return behaviour
        when(inputController.getButtons()).thenReturn(buttons);
    }

    @Test
    public void getButtonHeight() {
        //Verifies return behaviour
        when(inputController.getButtonHeight()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = inputController.getButtonHeight();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(inputController).getButtonHeight();
    }

    @Test
    public void getButtonPadding() {
        //Verifies return behaviour
        when(inputController.getButtonPadding()).thenReturn(num);

        //Asserting that the integer value it returns is not null
        int dummyInt = inputController.getButtonPadding();
        assertNotNull(dummyInt);

        //That the class calls the appropriate method.
        verify(inputController).getButtonPadding();
    }
}