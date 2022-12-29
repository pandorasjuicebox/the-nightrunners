//--------------------------------------------
//
// CLASS  : SynthTile
// REMARKS: A game object used in level design. This tile is used in the SynthCity level.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

public class SynthTile extends GameObject{

    //--------------------------------------------
    // SynthTile
    //
    // PURPOSE : A constructor that creates a SynthTile object.
    // PARAMETERS:
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    SynthTile(float worldStartX, float worldStartY, char type) {

        setTraversable(true);

        final float HEIGHT = 1;
        final float WIDTH = 1;

        setHeight(HEIGHT); // 1 metre tall
        setWidth(WIDTH); // 1 metre wide

        setType(type);


        // Asset from "Free Pixel Art Tiles" by TotusLotus
        // From https://totuslotus.itch.io/free-pixel-art-tiles
        setBitmapName("synth_tile");

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

