//--------------------------------------------
//
// CLASS  : HumanGuard
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A game object that serves as an enemy unit in the game.
//          In this case, HumanGuard is a unit that travels from two different waypoints.
//
//--------------------------------------------
package com.comp486a1.thenightrunners;
import android.content.Context;

public class HumanGuard extends GameObject {

    // Guards just move on x axis between 2 waypoints
    private float waypointX1; // always on left
    private float waypointX2; // always on right
    private int currentWaypoint;
    final float MAX_X_VELOCITY = 3;

    //--------------------------------------------
    // HumanGuard
    //
    // PURPOSE : A constructor that creates a HumanGuard object.
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
    HumanGuard(Context context, float worldStartX, float worldStartY, char type, int pixelsPerMetre) {

        setHealth(2);

        final int ANIMATION_FPS = 15;
        final int ANIMATION_FRAME_COUNT = 9;
        final String BITMAP_NAME = "human_guard";
        final float HEIGHT = 2;
        final float WIDTH = 4;
        setHeight(HEIGHT); // 2 metre tall
        setWidth(WIDTH); // 1 metres wide
        setType(type);

        // Assets from "Pixel Art Sci-Fi Cyberpunk Police" asset pack by Evgeniy Luch
        // https://evgeniy-luch.itch.io/pixel-art-sci-fi-cyberpunk-police
        setBitmapName(BITMAP_NAME);

        // Now for the player's other attributes
        // Our game engine will use these
        setMoves(true);
        setActive(true);
        setVisible(true);

        // Set this object up to be animated
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setBitmapName(BITMAP_NAME);
        setAnimated(context, pixelsPerMetre, true);

        // Where does the tile start
        // X and y locations from constructor parameters
        setWorldLocation(worldStartX, worldStartY, 0);
        setxVelocity(-MAX_X_VELOCITY);
        currentWaypoint = 1;
    }

    //--------------------------------------------
    // setWaypoints
    //
    // PURPOSE : A method that sets the two Waypoints that the HumanGuard will walk towards.
    //           This is done by feeding this method two different x-values.
    // PARAMETERS:
    //     @param x1 - x-coordinate of one of the waypoints. The left side.
    //     @param x2 - x-coordinate of one of the waypoints. The right side (reverse velocity).
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    //Lets Guards know what its two Waypoints are
    public void setWaypoints(float x1, float x2){
        waypointX1 = x1;
        waypointX2 = x2;
    }

    //--------------------------------------------
    // update
    //
    // PURPOSE : A method the updates the state of the GameObject when needed.
    //           An implementation of the abstract method in GameObject.
    // PARAMETERS:
    //     @param fps - Frames per second for the move() function, which determines the
    //                  the xVelocity and yVelocity of the object based on this value.
    //     @param gravity - For the gravity variable of the GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void update(long fps, float gravity) {
        if (currentWaypoint == 1) {// Heading left
            if (getWorldLocation().x <= waypointX1) { // Arrived at waypoint 1
                currentWaypoint = 2;
                setxVelocity(MAX_X_VELOCITY);
                setFacing(RIGHT);

            }
        }

        if(currentWaypoint == 2){
            if (getWorldLocation().x >= waypointX2) { // Arrived at waypoint 2
                currentWaypoint = 1;
                setxVelocity(-MAX_X_VELOCITY);
                setFacing(LEFT);
            }
        }
        move(fps);
        // update the guards hitbox
        setRectHitbox();

    }
}
