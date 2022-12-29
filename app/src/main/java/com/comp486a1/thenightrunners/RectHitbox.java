//--------------------------------------------
//
// CLASS  : RectHitbox
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A class that handles hitboxes for an Object.
//
//--------------------------------------------
package com.comp486a1.thenightrunners;

public class RectHitbox {

    float top;
    float left;
    float bottom;
    float right;
    float height;

    //--------------------------------------------
    // intersects
    //
    // PURPOSE : Checks if a hitbox collides with another object's hitbox.
    // PARAMETERS:
    //      @param rectHitbox - The hitbox to compare the caller with.
    //
    // Returns:
    //      true/false
    // --------------------------------------------
    boolean intersects(RectHitbox rectHitbox){

        boolean hit = false;
        if(this.right > rectHitbox.left && this.left < rectHitbox.right ){
            // Intersecting on x axis
            if(this.top < rectHitbox.bottom && this.bottom > rectHitbox.top ){
                // Intersecting on y as well
                // Collision
                hit = true;
            }
        }
        return hit;
    }

    //Getters

    //--------------------------------------------
    // getLeft
    //
    // PURPOSE : Getter for the value of the endY variable.
    // PARAMETERS: None.
    //
    // Returns:
    //      endY
    // --------------------------------------------
    public float getLeft() {
        return left;
    }

    //--------------------------------------------
    // getHeight
    //
    // PURPOSE : Getter for the value of the endY variable.
    // PARAMETERS: None.
    //
    // Returns:
    //      endY
    // --------------------------------------------
    public float getHeight() {
        return height;
    }

    //Setters

    //--------------------------------------------
    // setTop
    //
    // PURPOSE : Setter for the value of top variable.
    // PARAMETERS:
    //      @params top - Accepts a floating point value that is then used to set
    //                the value of the top variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setTop(float top) {
        this.top = top;
    }

    //--------------------------------------------
    // setLeft
    //
    // PURPOSE : Setter for the value of the left variable.
    // PARAMETERS:
    //      @params left - Accepts a floating point value that is then used to set
    //                the value of the left variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setLeft(float left) {
        this.left = left;
    }

    //--------------------------------------------
    // setBottom
    //
    // PURPOSE : Setter for the value of the bottom variable.
    // PARAMETERS:
    //      @params bottom - Accepts a floating point value that is then used to set
    //                the value of the bottom variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setBottom(float bottom) {
        this.bottom = bottom;
    }

    //--------------------------------------------
    // setY
    //
    // PURPOSE : Setter for the value of the y variable.
    // PARAMETERS:
    //      @params right - Accepts a floating point value that is then used to set
    //                the value of the y variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setRight(float right) {
        this.right = right;
    }

    //--------------------------------------------
    // setY
    //
    // PURPOSE : Setter for the value of the height variable.
    // PARAMETERS:
    //      @params height - Accepts a floating point value that is then used to set
    //                the value of the height variable.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setHeight(float height) {
        this.height = height;
    }

}
