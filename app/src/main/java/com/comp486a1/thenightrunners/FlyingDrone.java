//--------------------------------------------
//
// CLASS  : FlyingDrone
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A game object that serves as an enemy unit in the game.
//          In this case, FlyingDrone is a flying drone that starts to
//          follow the player around once they get into a certain distance
//          from the drone.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.graphics.PointF;

public class FlyingDrone extends GameObject{

    long lastWaypointSetTime;
    PointF currentWaypoint;
    final float MAX_X_VELOCITY = 3;
    final float MAX_Y_VELOCITY = 3;

    //--------------------------------------------
    // FlyingDrone
    //
    // PURPOSE : A constructor that creates a FlyingDrone object.
    // PARAMETERS:
    //     @param worldStartX - Starting x coordinates.
    //     @param worldStartY - Starting y coordinates.
    //     @param type - Char character used the identifier for the this GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    FlyingDrone(float worldStartX, float worldStartY, char type) {
        final float HEIGHT = 0.9f;
        final float WIDTH = 1.3f;
        setHeight(HEIGHT); // 1 metre tall
        setWidth(WIDTH); // 1 metres wide
        setType(type);

        // Assets from "Pixel Art Sci-Fi Cyberpunk Police" asset pack by Evgeniy Luch
        // https://evgeniy-luch.itch.io/pixel-art-sci-fi-cyberpunk-police
        setBitmapName("drone_police");

        setMoves(true);
        setActive(true);
        setVisible(true);
        currentWaypoint = new PointF();
        // Where does the drone start
        // X and y locations from constructor parameters
        setWorldLocation(worldStartX, worldStartY, 0);
        setRectHitbox();
        setFacing(RIGHT);
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
        if (currentWaypoint.x > getWorldLocation().x) {
            setxVelocity(MAX_X_VELOCITY);
            setFacing(RIGHT);
        } else if (currentWaypoint.x < getWorldLocation().x) {
            setxVelocity(-MAX_X_VELOCITY);
            setFacing(LEFT);
        }
        else {
            setxVelocity(0);
        }
        if (currentWaypoint.y >= getWorldLocation().y) {
            setyVelocity(MAX_Y_VELOCITY);
        } else if (currentWaypoint.y < getWorldLocation().y) {
            setyVelocity(-MAX_Y_VELOCITY);
        } else {
            setyVelocity(0);
        }

        move(fps);
        // update the drone hitbox
        setRectHitbox();
    }

    //--------------------------------------------
    // setWaypoint
    //
    // PURPOSE : Changes the waypoint of the drone to the current
    //           location of the Player.
    // PARAMETERS:
    //      @param playerLocation - The coordinates of the Player object.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void setWaypoint(Vector2Point5D playerLocation) {
        if (System.currentTimeMillis() > lastWaypointSetTime + 2000) {
            //Has 2 seconds passed
            lastWaypointSetTime = System.currentTimeMillis();
            currentWaypoint.x = playerLocation.x;
            currentWaypoint.y = playerLocation.y;
        }
    }

}
