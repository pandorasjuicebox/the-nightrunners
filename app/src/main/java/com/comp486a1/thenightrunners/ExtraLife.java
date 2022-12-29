//--------------------------------------------
//
// CLASS  : ExtraLife
// REMARKS: A game object that serves as a collectible item in the game.
//          In this case, an ExtraLIfe is one of the things that a Runner can collect
//          as they complete a level. It replenishes the amount of "lives" they
//          have left should they have spent on some in-game deaths.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

public class ExtraLife extends GameObject{

    //--------------------------------------------
    // ExtraLife
    //
    // PURPOSE : A constructor that creates a ExtraLife object.
    // PARAMETERS:
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    ExtraLife(float worldStartX, float worldStartY, char type) {

        final float HEIGHT = 1f;
        final float WIDTH = 1f;
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        // Choose a Bitmap
        // Asset from "User Interface Icon Pack" by Kazzter
        // From https://kazzter-k.itch.io/interface-icons
        setBitmapName("heart");

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
    public void update(long fps, float gravity){}

}

