//--------------------------------------------
//
// CLASS  : GameObject
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A managing system that all other objects that exist in the world can extend from.
//          Makes managing GameObjects cleaner and easier, as well as less code duplication.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public abstract class GameObject {

    private int health;
    private boolean traversable = false;

    private Animation anim = null;
    private boolean animated;
    private int animFps = 1;

    protected RectHitbox rectGameObjHitbox = new RectHitbox();
    private Vector2Point5D worldLocation;
    private float width;
    private float height;

    private boolean active = true;
    private boolean visible = true;
    private int animFrameCount = 1;
    private char type;

    private String bitmapName;

    public abstract void update(long fps, float gravity);

    private float xVelocity;
    private float yVelocity;
    final int LEFT = -1;
    final int RIGHT = 1;
    private int facing;
    private boolean moves = false;


    //--------------------------------------------
    // move
    //
    // PURPOSE : Determines xVelocity and yVelocity values by the FPS value it is provided with.
    // PARAMETERS:
    //      @params fps - framer per second
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    void move(long fps){

        if(xVelocity != 0) {
        this.worldLocation.x += xVelocity / fps;
        }

        if(yVelocity != 0) {
            this.worldLocation.y += yVelocity / fps;
        }
    }

    //--------------------------------------------
    // getBitmapName
    //
    // PURPOSE : Getter for the String bitmapName.
    // PARAMETERS: None.
    //
    // Returns:
    //     bitmapName
    //
    // --------------------------------------------
    public String getBitmapName() {
        return bitmapName;
    }

    public Bitmap prepareBitmap(Context context, String bitmapName, int pixelsPerMetre) {

        // Make a resource id from a String that is the same name as the .png
        int resID = context.getResources().getIdentifier(bitmapName,
                "drawable", context.getPackageName());

        // Create the bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                resID);

        // Scale the bitmapSheet based on the number of pixels per metre
        // Multiply by the number of frames contained in the image file
        // Default 1 frame
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (width * animFrameCount * pixelsPerMetre),
                (int) (height * pixelsPerMetre),
                false);

        return bitmap;
    }

    //--------------------------------------------
    // gwtWorldLocation
    //
    // PURPOSE : Returns worldLocation value.
    // PARAMETERS: Nothing.
    // Returns:
    //      worldLocation
    //
    // --------------------------------------------
    public Vector2Point5D getWorldLocation() {
        return worldLocation;
    }

    //--------------------------------------------
    // setWorldLocation
    //
    // PURPOSE : Setter that accepts values for the x,y,z variables for worldLocation
    // PARAMETERS:
    //      @params x - Floating point x value.
    //      @params y - Floating point y value.
    //      @params z - Floating point z value.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setWorldLocation(float x, float y, int z) {
        this.worldLocation = new Vector2Point5D();
        this.worldLocation.x = x;
        this.worldLocation.y = y;
        this.worldLocation.z = z;
    }

    //--------------------------------------------
    // setAnimFps
    //
    // PURPOSE : Setter that accepts an integer value to be used as the FPS for a
    //           GameObject's Animation.
    // PARAMETERS:
    //      @params animFps - Integer value that sets the FPS for the GameObject Animation.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setAnimFps(int animFps) {
        this.animFps = animFps;
    }

    //--------------------------------------------
    // setAnimFrameCount
    //
    // PURPOSE : Setter the value for the frame count for sprite Animation.
    // PARAMETERS:
    //      @params animFrameCounter - accepts an integer value that is set to be the frame count
    //                                 for the GameObject.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setAnimFrameCount(int animFrameCount) {
        this.animFrameCount = animFrameCount;
    }

    //--------------------------------------------
    // isAnimated
    //
    // PURPOSE : A boolean method that checks if the bitmap is supposed to be move/moving.
    // PARAMETERS: None.
    //
    // Returns:
    //      true or false
    //
    // --------------------------------------------
    public boolean isAnimated() {
        return animated;
    }

    //--------------------------------------------
    // setAnimated
    //
    // PURPOSE : Setter that sets a GameObject to be animated.
    // PARAMETERS:
    //      @params context - State of the GameObject.
    //      @params pixelsPerMetre - Pixels per metre, which varies by device.
    //      @params animated - true/false if the GameObject is animated.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setAnimated(Context context, int pixelsPerMetre, boolean animated){
        this.animated = animated;
        this.anim = new Animation(context, bitmapName, height, width, animFps, animFrameCount, pixelsPerMetre );
    }

    //--------------------------------------------
    // getRectToDraw
    //
    // PURPOSE : Getter for the next Rect object from the sprite sheet of the GameObject that is calling the method.
    // PARAMETERS:
    //      @params deltaTime - the appearance next frame that is then requested will depend on the time that is
    //                          provided by the deltaTime parameter.
    //
    // Returns:
    //     Rect object containing a frame from the spirte sheet.
    //
    // --------------------------------------------
    public Rect getRectToDraw(long deltaTime){
        return anim.getCurrentFrame(deltaTime, xVelocity, isMoves());
    }


    //Getters

    //--------------------------------------------
    // getWidth
    //
    // PURPOSE : Getter for the floating point width.
    // PARAMETERS: None.
    //
    // Returns:
    //     width
    //
    // --------------------------------------------
    public float getWidth() {
        return width;
    }

    //--------------------------------------------
    // getHeight
    //
    // PURPOSE : Getter for the floating point height
    // PARAMETERS: None.
    //
    // Returns:
    //     height
    //
    // --------------------------------------------
    public float getHeight() {
        return height;
    }

    //--------------------------------------------
    // getType
    //
    // PURPOSE : Getter for char variable type.
    // PARAMETERS: None.
    //
    // Returns:
    //     type
    //
    // --------------------------------------------
    public char getType() {
        return type;
    }

    //--------------------------------------------
    // getFacing
    //
    // PURPOSE : Getter for the value that represents the direction the GameObject is facing.
    // PARAMETERS: None.
    //
    // Returns:
    //     facing
    //
    // --------------------------------------------
    public int getFacing() {
        return facing;
    }

    //--------------------------------------------
    // getxVelocity
    //
    // PURPOSE : Getter for the xVelocity variable.
    // PARAMETERS: None.
    //
    // Returns:
    //     xVelocity
    //
    // --------------------------------------------
    public float getxVelocity() {
        return xVelocity;
    }

    //--------------------------------------------
    // getyVelocity
    //
    // PURPOSE : Getter for the yVelocity variable.
    // PARAMETERS: None.
    //
    // Returns:
    //     yVelocity
    //
    // --------------------------------------------
    public float getyVelocity() {
        return yVelocity;
    }

    //--------------------------------------------
    // getHitbox
    //
    // PURPOSE : Getter for hitbox for this GameObject.
    // PARAMETERS: None.
    //
    // Returns:
    //     rectGameObjHitbox
    //
    // --------------------------------------------
    RectHitbox getHitbox(){
        return rectGameObjHitbox;
    }

    //---------------

    //--------------------------------------------
    // isActive
    //
    // PURPOSE : A boolean method that verifies whether or not
    //           a GameObject is interactable in a level.
    // PARAMETERS: None.
    //
    // Returns:
    //      true/false
    //
    // --------------------------------------------
    public boolean isActive() {
        return active;
    }

    //--------------------------------------------
    // isVisible
    //
    // PURPOSE : A boolean method that verifies whether or not
    //           a particular GameObject should be visible on a game level.
    // PARAMETERS: None.
    //
    // Returns:
    //      true/false
    //
    // --------------------------------------------
    public boolean isVisible() {
        return visible;
    }

    //--------------------------------------------
    // isMoves
    //
    // PURPOSE : A boolean method that verifies whether or not
    //           a particular GameObject is to be animated.
    // PARAMETERS: None
    //
    // Returns:
    //      true/false
    //
    // --------------------------------------------
    public boolean isMoves() {
        return moves;
    }

    //---------------

    //Setters

    //--------------------------------------------
    // setWidth
    //
    // PURPOSE : Setter for the isParallax variable.
    // PARAMETERS:
    //      @params parallax - accepts a boolean value that will either be true or false.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setWidth(float width) {
        this.width = width;
    }

    //--------------------------------------------
    // setHeight
    //
    // PURPOSE : Setter for the height variable.
    // PARAMETERS:
    //      @params height - accepts a float value that will set the height variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setHeight(float height) {
        this.height = height;
    }

    //--------------------------------------------
    // setBitmapName
    //
    // PURPOSE : Assigns a String object to the bitmapName variable.
    // PARAMETERS:
    //      @params bitmapName - The String object that will be linked to bitmapName.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setBitmapName(String bitmapName){
        this.bitmapName = bitmapName;
    }

    //--------------------------------------------
    // setVisible
    //
    // PURPOSE : Setter for the visible variable.
    // PARAMETERS:
    //      @params visible - toggles true/false values for visible variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    //--------------------------------------------
    // setType
    //
    // PURPOSE : Setter for the type variable.
    // PARAMETERS:
    //      @params type - Accepts a char variable to be assigned to the type varaible.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setType(char type) {
        this.type = type;
    }

    //--------------------------------------------
    // setFacing
    //
    // PURPOSE : Setter for the faving variable.
    // PARAMETERS:
    //      @params facing - accepts an integer value to be assigned to the facing varaible.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setFacing(int facing) { this.facing = facing; }

    //--------------------------------------------
    // setxVelocity
    //
    // PURPOSE : Accepts a float value for the velocity along the x-axis direction.
    // PARAMETERS:
    //      @params xVelocity - float value to be assigned to xVelocity.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setxVelocity(float xVelocity) {
        // Only allow for objects that can move
        if(moves) {
            this.xVelocity = xVelocity; }
    }

    //--------------------------------------------
    // setyVelocity
    //
    // PURPOSE : Accepts a float value for the velocity along the y-axis direction.
    // PARAMETERS:
    //      @params xVelocity - float value to be assigned to yVelocity.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setyVelocity(float yVelocity) {
        // Only allow for objects that can move
        if(moves) {
            this.yVelocity = yVelocity; }
    }

    //--------------------------------------------
    // setMoves
    //
    // PURPOSE : Toggles true/false states for moves variable.
    // PARAMETERS:
    //      @params moves - true/false values
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setMoves(boolean moves) { this.moves = moves;
    }

    //--------------------------------------------
    // setActive
    //
    // PURPOSE : Toggles true/false values for active variable.
    // PARAMETERS:
    //      @params active - true/false
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setActive(boolean active) { this.active = active;
    }

    //--------------------------------------------
    // setRectHitBox
    //
    // PURPOSE : Updates the hitbox of the object based on their current world location.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setRectHitbox() {
        rectGameObjHitbox.setTop(worldLocation.y); //worldLocation.y
        rectGameObjHitbox.setLeft(worldLocation.x); //worldLocation.x
        rectGameObjHitbox.setBottom(worldLocation.y + height); //worldLocation.y + height
        rectGameObjHitbox.setRight(worldLocation.x + width); //worldLocation.x + width
    }

    //--------------------------------------------
    // setWorldLocationY
    //
    // PURPOSE : Accepts a float value for world location in the y-axis direction.
    // PARAMETERS:
    //      @params y - float value to be assigned to this.worldLocation.y.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setWorldLocationY(float y) {
        this.worldLocation.y = y;
    }

    //--------------------------------------------
    // setWorldLocationX
    //
    // PURPOSE : Accepts a float value for world location in the x-axis direction.
    // PARAMETERS:
    //      @params x - float value to be assigned to this.worldLocation.x.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setWorldLocationX(float x) {
        this.worldLocation.x = x;
    }


    //Controls for the traversable variable

    //--------------------------------------------
    // setTraversable
    //
    // PURPOSE : Toggles true/false values for traversable variable.
    // PARAMETERS:
    //      @params state - true/false
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setTraversable(boolean state){
        traversable = state;
    }

    //--------------------------------------------
    // isTraversable
    //
    // PURPOSE : Checks if traversable is true/false.
    // PARAMETERS: Nothing.
    //
    // Returns:
    //      true/false
    //
    // --------------------------------------------
    public boolean isTraversable(){
        return traversable;
    }

    //--------------------------------------------
    // setHealth
    //
    // PURPOSE : Setter for the health variable.
    // PARAMETERS:
    //      @params health - Accepts an integer value that is then assigned to the
    //                       health variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setHealth(int health) {
        this.health = health;
    }

    //--------------------------------------------
    // loseHealth
    //
    // PURPOSE : Setter that modifies the health points of the GameObject.
    // PARAMETERS:
    //      @params healthPointsLost - Accepts the integer value that the GameObject's HP
    //                                 will be decreased by.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void loseHealth(int healthPointsLost){
        this.health -= healthPointsLost;
    }

    //--------------------------------------------
    // getHealth
    //
    // PURPOSE : Returns the value of the health variable.
    // PARAMETERS: Nothing.
    //
    // Returns:
    //      health
    //
    // --------------------------------------------
    public int getHealth() {
        return health;
    }

}
