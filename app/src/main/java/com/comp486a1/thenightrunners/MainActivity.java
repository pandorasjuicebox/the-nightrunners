//--------------------------------------------
//
// CLASS  : MainActivity
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: The Java portion of activity_main.xml, which is the activity that
//          is responsible for the menu that the user sees during launch.
//          Playing and quitting the game are found here with their respective buttons.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
        implements View.OnClickListener{

    // This is the entry point to our game
    //--------------------------------------------
    // onCreate
    //
    // PURPOSE : Entry point to our game. Sets the view into activity_main.xml
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

        //Here we set our UI layout as the view
        setContentView(R.layout.activity_main);

        // Get a reference to the button in our layout
        final Button play = findViewById(R.id.playButton);
        final Button quit = findViewById(R.id.quitGame);
        // Listen for clicks
        play.setOnClickListener(this);
        quit.setOnClickListener(this);

    }

    //--------------------------------------------
    // onClick
    //
    // PURPOSE : Starts PlatformActivity when the play button is pressed, and quits game when
    //           quit button is pressed.
    // PARAMETERS:
    //     @param v - The View where these buttons exist in.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.playButton:
                Intent play = new Intent(this, PlatformActivity.class);
                // Start our GameActivity class via the Intent
                startActivity(play);
                finish();

            case R.id.quitGame:
                System.exit(0);
        }
    }


    }
