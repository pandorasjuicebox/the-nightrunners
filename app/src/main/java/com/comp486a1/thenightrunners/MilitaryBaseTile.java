//--------------------------------------------
//
// CLASS  : MilitaryBaseTile
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A game object used in level design. This tile is used in the MilitaryBase level.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

public class MilitaryBaseTile extends GameObject {

    //--------------------------------------------
    // MilitaryBaseTile
    //
    // PURPOSE : A constructor that creates a MilitaryBaseTile object.
    // PARAMETERS:
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    MilitaryBaseTile(float worldStartX, float worldStartY, char type) {

        setTraversable(true);

        final float HEIGHT = 1;
        final float WIDTH = 1;

        setHeight(HEIGHT); // 1 metre tall
        setWidth(WIDTH); // 1 metre wide

        setType(type);


        // Asset from "Warped Zone 202" by ansimuz
        // From https://ansimuz.itch.io/warped-zone-202
        setBitmapName("mbase_tile");

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
    public void update(long fps, float gravity) {
    }
}
