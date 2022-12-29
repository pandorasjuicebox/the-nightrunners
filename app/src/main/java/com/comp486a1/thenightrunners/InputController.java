package com.comp486a1.thenightrunners;
import android.graphics.Rect;
import android.view.MotionEvent;
import java.util.ArrayList;

//--------------------------------------------
//
// CLASS  : InputController
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: Contains code for PlatformView, including navigational buttons.
//
//--------------------------------------------
public class InputController {

    Rect left;
    Rect right;
    Rect jump;
    Rect shoot;
    Rect pause;

    int buttonWidth;
    int buttonHeight;
    int buttonPadding;

    //--------------------------------------------
    // InputController
    //
    // PURPOSE : A constructor takes the width and height of the device screen
    //           to use it as a reference for the game's button positions.
    // PARAMETERS:
    //     @param screenWidth - The width of the device screen.
    //     @param screenHeight - The height of the device screen.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    InputController(int screenWidth, int screenHeight) {
        //Configure the player buttons
        buttonWidth = screenWidth / 8;
        buttonHeight = screenHeight / 7;
        buttonPadding = screenWidth / 80;

        left = new Rect(buttonPadding, screenHeight - buttonHeight - buttonPadding, buttonWidth, screenHeight - buttonPadding);
        right = new Rect(buttonWidth + buttonPadding, screenHeight - buttonHeight - buttonPadding, buttonWidth + buttonPadding + buttonWidth, screenHeight - buttonPadding);
        jump = new Rect(screenWidth - buttonWidth - buttonPadding, screenHeight - buttonHeight - buttonPadding - buttonHeight - buttonPadding, screenWidth - buttonPadding, screenHeight - buttonPadding - buttonHeight - buttonPadding);
        shoot = new Rect(screenWidth - buttonWidth - buttonPadding, screenHeight - buttonHeight - buttonPadding, screenWidth - buttonPadding, screenHeight - buttonPadding);
        pause = new Rect(screenWidth - buttonPadding - buttonWidth, buttonPadding, screenWidth - buttonPadding, buttonPadding + buttonHeight);
    }

    //--------------------------------------------
    // getButtons
    //
    // PURPOSE : Creates an array of buttons and returns the list.
    // PARAMETERS: None.
    //
    // Returns:
    //      currentButtonList
    //
    // --------------------------------------------
    public ArrayList getButtons() {
        //create an array of buttons for the draw method
        ArrayList<Rect> currentButtonList = new ArrayList<>();
        currentButtonList.add(left);
        currentButtonList.add(right);
        currentButtonList.add(jump);
        currentButtonList.add(shoot);
        currentButtonList.add(pause);
        return currentButtonList;
    }

    //--------------------------------------------
    // handleInput
    //
    // PURPOSE : Takes in events in the current level, and executes a motion or sound event based
    //           on the given parameters.
    // PARAMETERS:
    //     @param motionEvent - The action that was made the player.
    //     @param l - The list of objects and elements that exist in the levels.
    //     @param sound - Supplies event-dependent sound effects
    //     @param vp - What the player is seeing on the device.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void handleInput(MotionEvent motionEvent, LevelManager l, SoundManager sound, Viewport vp) {
        int pointerCount = motionEvent.getPointerCount();

        for (int i = 0; i < pointerCount; i++) {
            int x = (int) motionEvent.getX(i);
            int y = (int) motionEvent.getY(i);
            if (l.isPlaying()) {
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        if (right.contains(x, y)) {
                            l.player.setPressingRight(true);
                            l.player.setPressingLeft(false);
                        } else if (left.contains(x, y)) {
                            l.player.setPressingLeft(true);
                            l.player.setPressingRight(false);
                        } else if (jump.contains(x, y)) {
                            l.player.startJump(sound);
                        } else if (shoot.contains(x, y)) {
                            if (l.player.pullTrigger()) {
                            }
                        } else if (pause.contains(x, y)) {
                            l.switchPlayingStatus();
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                        if (right.contains(x, y)) {
                            l.player.setPressingRight(false);
                        } else if (left.contains(x, y)) {
                            l.player.setPressingLeft(false);
                        }
                        break;

                    case MotionEvent.ACTION_POINTER_DOWN:
                        if (right.contains(x, y)) {
                            l.player.setPressingRight(true);
                            l.player.setPressingLeft(false);
                        } else if (left.contains(x, y)) {
                            l.player.setPressingLeft(true);
                            l.player.setPressingRight(false);
                        } else if (jump.contains(x, y)) {
                            l.player.startJump(sound);
                        } else if (shoot.contains(x, y)) {
                            if (l.player.pullTrigger()) {
                                sound.playSound("shoot");
                            }
                        } else if (pause.contains(x, y)) {
                            l.switchPlayingStatus();
                        }
                        break;

                    case MotionEvent.ACTION_POINTER_UP:
                        if (right.contains(x, y)) {
                            l.player.setPressingRight(false);
                            //Log.w("rightP:", "up" );
                        } else if (left.contains(x, y)) {
                            l.player.setPressingLeft(false);
                            //Log.w("leftP:", "up" );
                        } else if (shoot.contains(x, y)) {
                            //Handle shooting here
                        } else if (jump.contains(x, y)) {
                            //Handle more jumping stuff here later
                        }
                        break;
                }
                // End if(l.playing)
            } else {// Not playing
                // Move the viewport around to explore the map
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        if (pause.contains(x, y)) {
                            l.switchPlayingStatus();
                            //Log.w("pause:", "DOWN" );
                        }

                        break;
                    }
                }
            }
        }

    //--------------------------------------------
    // getButtonHeight
    //
    // PURPOSE : Getter the height of a Button object.
    // PARAMETERS: None.
    //
    // Returns:
    //      buttonHeight
    //
    // --------------------------------------------
    public int getButtonHeight() {
        return buttonHeight;
    }

    //--------------------------------------------
    // getButtonPadding
    //
    // PURPOSE : Getter for the value of button padding.
    // PARAMETERS: None.
    //
    // Returns:
    //      buttonPadding
    //
    // --------------------------------------------
    public int getButtonPadding() {
        return buttonPadding;
    }
}


