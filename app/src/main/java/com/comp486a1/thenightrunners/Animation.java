//--------------------------------------------
//
// CLASS  : Animation
// REMARKS: Responsible for managing the animation aspects of a
//          sprite sheet, including frame counts and FPS.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;
import android.content.Context;
import android.graphics.Rect;

public class Animation {
    String bitmapName;
    private Rect sourceRect;
    private int frameCount;
    private int currentFrame;
    private long frameTicker;
    private int framePeriod;
    private int frameWidth;
    private int frameHeight;
    int pixelsPerMetre;

    //--------------------------------------------
    // Animation
    //
    // PURPOSE : A constructor that creates an Animation object.
    // PARAMETERS:
    //     @param context - State of the object provided by the GameObject.
    //     @param bitmapName - Name of the drawable image file inside res/drawable.
    //     @param frameHeight - Height of the frame of animation.
    //     @param frameWidth - Width of the frame animation.
    //     @param animFPS - FPS of the animation.
    //     @param frameCount - How many frames are there on the sheet?
    //     @param pixelsPerMetre - Varies by device, helps to scale the bitmap image so that
    //                             the game looks consistent across platforms.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    Animation(Context context, String bitmapName, float frameHeight, float frameWidth, int animFps, int frameCount, int pixelsPerMetre) {
        this.currentFrame = 0;
        this.frameCount = frameCount;
        this.frameWidth = (int) frameWidth * pixelsPerMetre;
        this.frameHeight = (int) frameHeight * pixelsPerMetre;
        sourceRect = new Rect(0, 0, this.frameWidth, this.frameHeight);
        framePeriod = 1000 / animFps;
        frameTicker = 0l;
        this.bitmapName = "" + bitmapName;
        this.pixelsPerMetre = pixelsPerMetre;
    }

    //--------------------------------------------
    // getCurrentFrame
    //
    // PURPOSE : A method that checks if a GameObject needs to be animated or not, and if animated, if it needs
    //           to switch to a new frame.
    // PARAMETERS:
    //     @param time - State of the object provided by the GameObject.
    //     @param xVelocity - Calculates the distance needed to get to the next frame on the sheet.
    //     @param moves - Checks if an GameObject is to be animated.
    //
    // Returns: Returns a frame from the sprite sheet as a Rect object.
    //
    // --------------------------------------------
    public Rect getCurrentFrame(long time, float xVelocity, boolean moves) {
        if (xVelocity != 0 || moves == false) {
            // Only animate if the object is moving
            // or it is an object which doesn't move
            // but is still animated (like fire)
            if (time > frameTicker + framePeriod) {
                frameTicker = time;
                currentFrame++;

                if (currentFrame >= frameCount) {
                    currentFrame = 0;
                }
            }
        }
        //update the left and right values of the source of
        // the next frame on the spritesheet
        this.sourceRect.left = currentFrame * frameWidth;

        this.sourceRect.right = this.sourceRect.left + frameWidth;
        return sourceRect;
    }
}// End of Animation class
