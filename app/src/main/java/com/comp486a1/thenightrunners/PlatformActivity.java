//--------------------------------------------
//
// CLASS  : PlatformActivity
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A class that instantiates a PlatformView object.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class PlatformActivity extends Activity {

    // Our object to handle the View
    private PlatformView platformView;

    //--------------------------------------------
    // onCreate
    //
    // PURPOSE : Entry point to our game.
    // PARAMETERS:
    //     @param savedInstanceState - Bundle object used to create the Activity.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point resolution = new Point();
        display.getSize(resolution);

        // And finally set the view for our game
        platformView = new PlatformView(this, resolution.x, resolution.y);

        // Make our platformView the view for the Activity
        setContentView(platformView);

    }

    //--------------------------------------------
    // onPause
    //
    // PURPOSE : Pauses the game by terminating the thread.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    @Override
    protected void onPause() {
        super.onPause();
        platformView.pause();
    }

    //--------------------------------------------
    // onResume
    //
    // PURPOSE : "Resumes" the game by creating a new Thread.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    @Override
    protected void onResume() {
        super.onResume();
        platformView.resume();
    }
}
