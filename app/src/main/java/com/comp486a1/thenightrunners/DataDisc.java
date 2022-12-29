//--------------------------------------------
//
// CLASS  : DataDisc
// REMARKS: A game object that serves as a collectible item in the game.
//          In this case, a data disc is one of the things that a Runner can collect
//          as they complete a level. The importance of finding and collecting
//          these discs comes later in the last level, where you must use all of them
//          to defeat the Boss.
//
//--------------------------------------------
package com.comp486a1.thenightrunners;

public class DataDisc extends GameObject{

    //--------------------------------------------
    // DataDisc
    //
    // PURPOSE : A constructor that creates a DataDisc object.
    // PARAMETERS:
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    DataDisc(float worldStartX, float worldStartY, char type) {

        final float HEIGHT = 1f;
        final float WIDTH = 1f;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);

        // Choose a Bitmap
        // Asset from "User Interface Icon Pack" by Kazzter
        // From https://kazzter-k.itch.io/interface-icons
        setBitmapName("data_disc");

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
    public void update(long fps, float gravity){

    }
}
