//--------------------------------------------
//
// CLASS  : Teleport
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A class that controls the Teleport object.
//
//--------------------------------------------
package com.comp486a1.thenightrunners;

public class Teleport extends GameObject{

    Location target;

    //--------------------------------------------
    // Teleport
    //
    // PURPOSE : A constructor that creates a Teleport object.
    // PARAMETERS:
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //     @param target - The new location the Teleport will take you to.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    Teleport(float worldStartX, float worldStartY, char type, Location target) {
        final float HEIGHT = 5;
        final float WIDTH = 4;
        setHeight(HEIGHT); // 2 metres tall
        setWidth(WIDTH); // 1 metre wide
        setType(type);

        // Asset from "WARPED Props Pack 1" by ansimuz
        // From https://ansimuz.itch.io/warped-props
        setBitmapName("portal");
        this.target = new Location(target.level, target.x, target.y);

        // Where does the tile start
        // X and y locations from constructor parameters

        setWorldLocation(worldStartX, worldStartY, 0);
        setRectHitbox();
    }

    //--------------------------------------------
    // getTarget
    //
    // PURPOSE : Getter for the Location variable target.
    // PARAMETERS: None.
    //
    // Returns:
    //      target
    //
    // --------------------------------------------
    public Location getTarget(){
        return target;
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
