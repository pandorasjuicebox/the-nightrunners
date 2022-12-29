//--------------------------------------------
//
// CLASS  : BlasterAmmo
// REMARKS: A game object that manages the ammunition of the Blaster object.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

public class BlasterAmmo {
    private float x;
    private float y;
    private float xVelocity;
    private int direction;

    //--------------------------------------------
    // BlasterAmmo
    //
    // PURPOSE : A constructor that creates a BlasterAmmo object.
    // PARAMETERS:
    //     @param x - x-coordinate of the bullet.
    //     @param y - y-coordinate of the bullet.
    //     @param speed - Speed in which the bullet travels; used to calculate
    //                    bullet velocity.
    //     @param direction - The direction in which the bullet travels; used to
    //                        calculate bullet velocity.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    BlasterAmmo(float x, float y, int speed, int direction){
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.xVelocity = speed * direction;
    }

    //--------------------------------------------
    // getDirection
    //
    // PURPOSE : Getter for the direction variable.
    // PARAMETERS: None.
    //
    // Returns:
    //      direction
    //
    // --------------------------------------------
    public int getDirection(){
        return direction;
    }

    //--------------------------------------------
    // update
    //
    // PURPOSE : Updates the value of the x-coordnate by using the bullet's
    //           velocity along the x axis, and the frames per second provided
    //           via method input.
    // PARAMETERS:
    //           @param fps - Frames per second.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void update(long fps, float gravity){
        x += xVelocity / fps;
    }

    //--------------------------------------------
    // hideBullet
    //
    // PURPOSE : Getter for the number of bullets in the Blaster.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void hideBullet(){ this.x = -100;
        this.xVelocity = 0; }

    //--------------------------------------------
    // getX
    //
    // PURPOSE : Getter for the x-coordinate of the bullet.
    // PARAMETERS: None.
    //
    // Returns:
    //      x
    //
    // --------------------------------------------
    public float getX(){
        return x;
    }

    //--------------------------------------------
    // getY
    //
    // PURPOSE : Getter for the y-coordinate of the bullet.
    // PARAMETERS: None.
    //
    // Returns:
    //      y
    //
    // --------------------------------------------
    public float getY(){
        return y;
    }
}

