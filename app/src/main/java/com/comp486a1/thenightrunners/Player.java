//--------------------------------------------
//
// CLASS  : Player
// REMARKS: The class that controls and holds information about the Player object.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.content.Context;

public class Player extends GameObject {

    RectHitbox rectHitboxFeet;
    RectHitbox rectHitboxHead;
    RectHitbox rectHitboxLeft;
    RectHitbox rectHitboxRight;

    final float MAX_X_VELOCITY = 10;
    boolean isPressingRight = true;
    boolean isPressingLeft = false;

    public boolean isFalling;
    private boolean isJumping;
    private long jumpTime;
    private long maxJumpTime = 700;// jump 7 10ths of second
    public Blaster blaster;

    //--------------------------------------------
    // Player
    //
    // PURPOSE : A constructor that creates a Player object.
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
    Player(Context context, float worldStartX, float worldStartY, int pixelsPerMetre) {

        blaster = new Blaster();

        final float HEIGHT = 2;
        final float WIDTH = 4;

        setHeight(HEIGHT); // 2 metre tall
        setWidth(WIDTH); // 1 metre wide

        // Standing still to start with
        setxVelocity(0);
        setyVelocity(0);
        setFacing(LEFT);
        isFalling = false;

        // Now for the player's other attributes
        // Our game engine will use these
        setMoves(true);
        setActive(true);
        setVisible(true);
        //...

        setType('p');

        // Asset from "Cyberpunk Character Pack 2" by OcO
        // From https://oco.itch.io/cyberpunk-character-pack-2
        setBitmapName("striker_player_run");

        final int ANIMATION_FPS = 15;
        final int ANIMATION_FRAME_COUNT = 10;
        // Set this object up to be animated
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setAnimated(context, pixelsPerMetre, true);

        // X and y locations from constructor parameters
        setWorldLocation(worldStartX, worldStartY, 0);

        rectHitboxFeet = new RectHitbox();
        rectHitboxHead = new RectHitbox();
        rectHitboxLeft = new RectHitbox();
        rectHitboxRight = new RectHitbox();
    }

    //--------------------------------------------
    // update
    //
    // PURPOSE : A method the updates the state of the GameObject when needed.
    //           An implementation of the abstract method in GameObject. The method updates
    //           this object based on other events like direction/velocity of travel based on the
    //           button pressed, if the Player object is jumping, and continuous updating of
    //           hitboxes as the Player object moves around the level.
    // PARAMETERS:
    //     @param fps - Frames per second of this GameObject.
    //     @param gravity - For the gravity variable of the GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void update(long fps, float gravity) {
        if (isPressingRight) {
            this.setxVelocity(MAX_X_VELOCITY);
        } else if (isPressingLeft) {
            this.setxVelocity(-MAX_X_VELOCITY);
        } else {
            this.setxVelocity(0);
            //this.setWorldLocationY(getWorldLocation().y);
        }

        //which way is player facing?
        if (this.getxVelocity() > 0) {
            //facing right
            setFacing(RIGHT);
        }
        else if (this.getxVelocity() < 0) {
            //facing left
            setFacing(LEFT);
        }   //if 0 then unchanged

        if (isJumping) {
            long timeJumping = System.currentTimeMillis() - jumpTime;
            if (timeJumping < maxJumpTime) {
                if (timeJumping < maxJumpTime / 2) {
                    this.setyVelocity(-gravity);//on the way up
                } else if (timeJumping > maxJumpTime / 2) {
                    //setWorldLocationX(this.getWorldLocation().y + getyVelocity());
                    this.setyVelocity(-this.getxVelocity());//going down
                }
            }
            else {
                isJumping = false;
            }
        } else {
            this.setyVelocity(gravity);
        }

        blaster.update(fps, gravity);

        //Let's go!
        this.move(fps);

        // Update all the hitboxes to the new location
        // Get the current world location of the player
        // and save them as local variables we will use next
        Vector2Point5D location = getWorldLocation();
        float lx = location.x;
        float ly = location.y;

        //update the player feet hitbox
        rectHitboxFeet.top = ly + getHeight() * .95f;
        rectHitboxFeet.left = lx + getWidth() * .2f;
        rectHitboxFeet.bottom = ly + getHeight() * .98f;
        rectHitboxFeet.right = lx + getWidth() * .8f;

        // Update player head hitbox
        rectHitboxHead.top = ly;
        rectHitboxHead.left = lx + getWidth() * .4f;
        rectHitboxHead.bottom = ly + getHeight() * .2f;
        rectHitboxHead.right = lx + getWidth() * .6f;

        // Update player left hitbox
        rectHitboxLeft.top = ly + getHeight() * .2f;
        rectHitboxLeft.left = lx + getWidth() * .2f;
        rectHitboxLeft.bottom = ly + getHeight() * .8f;
        rectHitboxLeft.right = lx + getWidth() * .3f;

        // Update player right hitbox
        rectHitboxRight.top = ly + getHeight() * .2f;
        rectHitboxRight.left = lx + getWidth() * .8f;
        rectHitboxRight.bottom = ly + getHeight() * .8f;
        rectHitboxRight.right = lx + getWidth() * .7f;

    }

    //--------------------------------------------
    // checkCollisions
    //
    // PURPOSE : A method that checks if the PLayer object's hitbox as collided/intersected with
    //           another object's hitbox.
    // PARAMETERS:
    //     @param rectHitBox - The hitbox that the caller is checking if they have
    //                         collided into.
    //
    // Returns:
    //      collided, which tells the called what collision type we are dealing with.
    //      1 --> Regular type of tile, can't move left or right
    //      2 --> Player is on a tile
    //
    // --------------------------------------------
    public int checkCollisions(RectHitbox rectHitbox) {
        int collided = 0;// No collision
        // The left
        if (this.rectHitboxLeft.intersects(rectHitbox)) {
            // Left has collided
            // Move player just to right of current hitbox
            this.setWorldLocationX(rectHitbox.right - getWidth() * .2f);
            collided = 1;
        }

        // The right
        if (this.rectHitboxRight.intersects(rectHitbox)) {
            // Right has collided
            // Move player just to left of current hitbox
            this.setWorldLocationX(rectHitbox.left - getWidth() * .8f);
            collided = 1;
        }

        // The feet
        if (this.rectHitboxFeet.intersects(rectHitbox)) {
            // Feet have collided
            // Move feet to just above current hitbox
            this.setWorldLocationY(rectHitbox.top - getHeight());
            collided = 2;
        }

        // Now the head
        if (this.rectHitboxHead.intersects(rectHitbox)) {
            // Head has collided. Ouch!
            // Move head to just below current hitbox bottom
            this.setWorldLocationY(rectHitbox.bottom);
            collided = 3;
        }
        return collided;
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
    public void setPressingRight(boolean isPressingRight) {
        this.isPressingRight = isPressingRight;
    }

    //--------------------------------------------
    // setPressingLeft
    //
    // PURPOSE : A method that sets true/false values for isPressingLeft variable.
    // PARAMETERS:
    //     @param isPressingLeft - Toggles true/false for isPressingLeft.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setPressingLeft(boolean isPressingLeft) {
        this.isPressingLeft = isPressingLeft;
    }

    //--------------------------------------------
    // startJump
    //
    // PURPOSE : A method that takes in a SoundManager object in order to access the sound file
    //           for the jumping sound effect.
    // PARAMETERS:
    //     @param sm - SoundManager object from InputController.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void startJump(SoundManager sm) {
        if (!isFalling) {//can't jump if falling
            if (!isJumping) {
                //not already jumping
                isJumping = true;
                jumpTime = System.currentTimeMillis();
                sm.playSound("jump");
            }
        }
    }

    //--------------------------------------------
    // setWaypoints
    //
    // PURPOSE : A method that sets true/false values for isPressingLeft variable.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public boolean pullTrigger() {
        //Try and fire a shot
        return blaster.shoot(this.getWorldLocation().x, this.getWorldLocation().y,
                getFacing(), getHeight());
    }

    //--------------------------------------------
    // restorePreviousVelocity
    //
    // PURPOSE : A method that restores a previous value of velocity after a jumping
    //           or falling action.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void restorePreviousVelocity() {
        if (!isJumping && !isFalling) {
            if (getFacing() == LEFT) {
                isPressingLeft = true;
                setxVelocity(-MAX_X_VELOCITY);
            } else {
                isPressingRight = true;
                setxVelocity(MAX_X_VELOCITY);
            }
        }
    }
}