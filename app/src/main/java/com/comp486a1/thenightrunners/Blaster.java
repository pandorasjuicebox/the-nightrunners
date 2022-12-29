//--------------------------------------------
//
// CLASS  : Blaster
// REMARKS: A game object that manages the player's weapons.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;
import java.util.concurrent.CopyOnWriteArrayList;

public class Blaster extends GameObject {
    private int nextBullet;
    private int rateOfFire = 1;//bullets per second
    private long lastShotTime;
    private CopyOnWriteArrayList<BlasterAmmo> bullets;
    int speed = 25;

    //Last Level Stuff
    private int numBullets;


    //--------------------------------------------
    // Blaster
    //
    // PURPOSE : A constructor that creates a Blaster object.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    Blaster(){
        bullets = new CopyOnWriteArrayList<BlasterAmmo>();
        lastShotTime = -1;
        nextBullet = -1;
    }

    //--------------------------------------------
    // update
    //
    // PURPOSE : Method that updates the bullets
    // PARAMETERS:
    //     @param fps - Frames per second.
    //     @param gravity - Gravity value.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void update(long fps, float gravity){ //update all the bullets
        for(BlasterAmmo bullet: bullets){ bullet.update(fps, gravity);
        }
    }

    //--------------------------------------------
    // getNumBullets
    //
    // PURPOSE : Getter for the number of bullets in the Blaster.
    // PARAMETERS: None.
    //
    // Returns:
    //      numBullets
    //
    // --------------------------------------------
    public int getNumBullets(){
        //tell the view how many bullets there are
        return numBullets;
    }

    //--------------------------------------------
    // getBulletX
    //
    // PURPOSE : Getter of a specific bullet's x value.
    // PARAMETERS:
    //      @param bulletIndex - Index of a specific bullet in the bullets array.
    //
    // Returns:
    //      bullet x-coordinate or -1f
    //
    // --------------------------------------------
    public float getBulletX(int bulletIndex){
        if(bullets != null && bulletIndex < numBullets) {
        return bullets.get(bulletIndex).getX();
        }
        return -1f;
    }

    //--------------------------------------------
    // getBulletY
    //
    // PURPOSE : Getter of a specific bullet's y value.
    // PARAMETERS:
    //      @param bulletIndex - Index of a specific bullet in the bullets array.
    //
    // Returns:
    //      bullet y-coordinate or -1f
    //
    // --------------------------------------------
    public float getBulletY(int bulletIndex){
        if(bullets != null) {
        return bullets.get(bulletIndex).getY();
        }
        return -1f;
    }

    //--------------------------------------------
    // getDirection
    //
    // PURPOSE : Returns the direction of a bullet with a specified index.
    // PARAMETERS:
    //      @param index - Index of a specific bullet in the bullets array.
    //
    // Returns:
    //      direction of the bullet[index]
    //
    // --------------------------------------------
    public int getDirection(int index){
        return bullets.get(index).getDirection();
    }

    //Other Methods

    //--------------------------------------------
    // hideBullet
    //
    // PURPOSE : Getter the direction a specific bullet is going by calling the
    //           BlasterAmmo's hideBullet method.
    // PARAMETERS:
    //      @param index - Index of a specific bullet in the bullets array.
    //
    // Returns:
    //      Calls hideBullet on bullet[index].
    //
    // --------------------------------------------
    public void hideBullet(int index){
        bullets.get(index).hideBullet();
    }

    //--------------------------------------------
    // shoot
    //
    // PURPOSE : Shoots a bullet at the direction the player/unit is facing, with a cool down between
    //           bullets that uses the device's time, the time the last bullet was shot, and the rate of fire of the Blaster.
    // PARAMETERS:
    //      @param ownerX - x-coordinate of the player/unit's position.
    //      @param ownerY - y-coordinate of the player/unit's position.
    //      @param ownerFacing - The direction in which where the owner is facing.
    //      @param ownerHeight - How tall the unit is.
    //
    // Returns:
    //      true/false if a shot was fired by the Blaster.
    //
    // --------------------------------------------
    public boolean shoot(float ownerX, float ownerY, int ownerFacing, float ownerHeight){
        boolean shotFired = false; if(System.currentTimeMillis() - lastShotTime >
                1000/rateOfFire){
            //spawn another bullet;
            nextBullet ++;
            lastShotTime = System.currentTimeMillis(); bullets.add(nextBullet,
                    new BlasterAmmo(ownerX,
                            (ownerY+ ownerHeight/3), speed, ownerFacing));
            shotFired = true;
            numBullets++;
        }
        return shotFired;
    }

}
