
//--------------------------------------------
//
// CLASS  : Background
// REMARKS: A class with functionalities needed for controlling the dimensions of
//          a background, as well as for parallax effects.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;
import android.graphics.Bitmap;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class Background {
    Bitmap bitmap;
    Bitmap bitmapReversed;
    int width;
    int height;
    boolean reversedFirst;
    int xClip;// controls where we clip the bitmaps each frame
    float y;
    float endY;
    int z;
    float speed;
    boolean isParallax;//Not currently used

    //--------------------------------------------
    // Background
    //
    // PURPOSE : A constructor that creates a Background object.
    // PARAMETERS:
    //     @param context - State of the object provided by the LevelManager.
    //     @param yPixelsPerMetre - Pixels per metre for the y-axis.
    //     @param screenWidth - Width of the screen of the device.
    //     @param data - A BackgroundData object that is to be loaded in the current level.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    Background(Context context, int yPixelsPerMetre, int screenWidth, BackgroundData data){
        int resID = context.getResources().getIdentifier (data.bitmapName, "drawable", context.getPackageName());
        bitmap = BitmapFactory.decodeResource (context.getResources(), resID);
        // Which version of background (reversed or regular) is
        // currently drawn first (on left)
        reversedFirst = false;
        //Initialize animation variables.
        xClip = 0; //always start at zero
        y = data.startY;
        endY = data.endY;
        z = data.layer;
        isParallax = data.isParallax;
        speed = data.speed; //Scrolling background speed
        // Scale background to fit the screen.
        bitmap = Bitmap.createScaledBitmap(bitmap, screenWidth, data.height * yPixelsPerMetre , true);
        width = bitmap.getWidth(); height = bitmap.getHeight();
        // Create a mirror image of the background
        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1); //Horizontal mirror effect.
        bitmapReversed = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}

