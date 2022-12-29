//--------------------------------------------
//
// CLASS  : TheHandler
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A game object that serves as an unit in the game.
//          In this case, the Handler is an NPC whose presence represent how,
//          in the game's lore, each Runner (the player) has a Handler that
//          ensures their missions go well.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;
import android.content.Context;

public class TheHandler  extends GameObject{

    //--------------------------------------------
    // TheHandler
    //
    // PURPOSE : A constructor that creates a TheHandler object.
    // PARAMETERS:
    //     @param context - Context provided by LevelManager.
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //     @param pixelsPerMetre - Pixels per metre, which varies per device.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    TheHandler(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre) {

        final int ANIMATION_FPS = 15;
        final int ANIMATION_FRAME_COUNT = 10;
        final String BITMAP_NAME = "the_handler";
        final float HEIGHT = 2;
        final float WIDTH = 4;

        setHeight(HEIGHT); // 1 metre tall
        setWidth(WIDTH); // 1 metre wide
        setType(type);

        // Now for the player's other attributes
        // Our game engine will use these
        setMoves(false);
        setActive(false);
        setVisible(true);

        // Choose a Bitmap
        // Asset from "Cyberpunk Character Pack 2" by OcO
        // From https://oco.itch.io/cyberpunk-character-pack-2
        setBitmapName(BITMAP_NAME);

        // Set this object up to be animated
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setBitmapName(BITMAP_NAME);
        setAnimated(context, pixelsPerMetre, true);

        // Where does the tile start
        // X and y locations from constructor parameters
        setWorldLocation(worldStartX, worldStartY, 0);
        setRectHitbox();
    }

    //--------------------------------------------
    // update
    //
    // PURPOSE : A method the updates the state of the GameObject when needed.
    //           An implementation of the abstract method in GameObject.
    // PARAMETERS:
    //     @param fps - Frames per second of this GameObject.
    //     @param gravity - For the gravity variable of the GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void update(long fps, float gravity){ }
}

