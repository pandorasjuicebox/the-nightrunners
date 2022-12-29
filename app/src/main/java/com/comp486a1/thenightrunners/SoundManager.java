//--------------------------------------------
//
// CLASS  : SoundManager
// REMARKS: A class that loads sound files many different sound files
//          that we can define and call by declaring a SoundManager object in
//          our PlatformView.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.content.Context;
import android.content.res.AssetFileDescriptor; import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import java.io.IOException;

public class SoundManager {
    private SoundPool soundPool;
    int shoot = -1;
    int jump = -1;
    int teleport = -1;
    int obtain_disc = -1;
    int hit_human_guard = -1;
    int drone_explode = -1;
    int extra_life = -1;
    int player_death = -1;

    //--------------------------------------------
    // loadSound
    //
    // PURPOSE : Loads all sound files into memory to be played.
    // PARAMETERS:
    //     @param context - State of the object provided by the LevelManager.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void loadSound(Context context) {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            //Create objects of the 2 required classes
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            //create our fx

            // Sound effects from "Sci-Fi Sound Effects Asset Pack" by mattflat
            // From https://mattflat.itch.io/sci-fi-space-sound-effects-asset-pack
            descriptor = assetManager.openFd("blaster_shoot.wav"); shoot = soundPool.load(descriptor, 0);
            descriptor = assetManager.openFd("jump.wav"); jump = soundPool.load(descriptor, 0);
            descriptor = assetManager.openFd("teleporter.wav"); teleport = soundPool.load(descriptor, 0);
            descriptor = assetManager.openFd("obtain_disc.wav"); obtain_disc = soundPool.load(descriptor, 0);
            descriptor = assetManager.openFd("hit_human_guard.wav"); hit_human_guard = soundPool.load(descriptor, 0);
            descriptor = assetManager.openFd("drone_explode.wav"); drone_explode = soundPool.load(descriptor, 0);
            descriptor = assetManager.openFd("extra_life.wav"); extra_life = soundPool.load(descriptor, 0);

            // Sound effects from "AI, Cyberdemon, & Alien Sound Effects" by BTLgames
            // From https://btl-games.itch.io/ai-cyberdemon-alien-sound-effects
            descriptor = assetManager.openFd("player_death.wav"); player_death = soundPool.load(descriptor, 0);
        }
        catch (IOException e){
            //Print an error message to the console
            Log.e("error", "failed to load sound files");
        }

    }

    //--------------------------------------------
    // playSound
    //
    // PURPOSE : Play sound by reading the String input.
    // PARAMETERS:
    //     @param sound - String object used to find the corresponding sound file to play.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void playSound(String sound) {
        switch (sound) {
            case "shoot":
                soundPool.play(shoot, 1, 1, 0, 0, 1);
                break;
            case "jump":
                soundPool.play(jump, 1, 1, 0, 0, 1);
                break;
            case "teleport":
                soundPool.play(teleport, 1, 1, 0, 0, 1);
                break;
            case "obtain_disc":
                soundPool.play(obtain_disc, 1, 1, 0, 0, 1);
                break;

            case "hit_human_guard":
                soundPool.play(hit_human_guard, 1, 1, 0, 0, 1);
                break;
            case "drone_explode":
                soundPool.play(drone_explode, 1, 1, 0, 0, 1);
                break;
            case "extra_life":
                soundPool.play(extra_life, 1, 1, 0, 0, 1);
                break;

            case "player_death":
                soundPool.play(player_death, 1, 1, 0, 0, 1);
                break;
        }
    }

}

