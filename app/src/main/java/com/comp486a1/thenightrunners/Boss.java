//--------------------------------------------
//
// CLASS  : Boss
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A game object that serves as an enemy unit in the game.
//          In this case, Boss is the last enemy the player will face in the game.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.content.Context;

    public class Boss  extends GameObject{

        //--------------------------------------------
        // Boss
        //
        // PURPOSE : A constructor that creates a Boss object.
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
        Boss(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre) {


            setHealth(16);

            final int ANIMATION_FPS = 10;
            final int ANIMATION_FRAME_COUNT = 6;
            final String BITMAP_NAME = "boss";
            final float HEIGHT = 4;
            final float WIDTH = 6;

            setHeight(HEIGHT); // 1 metre tall
            setWidth(WIDTH); // 1 metre wide
            setType(type);

            // Now for the player's other attributes
            // Our game engine will use these
            setMoves(false);
            setActive(true);
            setVisible(true);

            // Choose a Bitmap
            // Assets from "Pixel Art Sci-Fi Cyberpunk Police" asset pack by Evgeniy Luch
            // https://evgeniy-luch.itch.io/pixel-art-sci-fi-cyberpunk-police
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

