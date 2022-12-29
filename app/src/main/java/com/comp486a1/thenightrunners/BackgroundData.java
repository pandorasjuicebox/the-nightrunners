//--------------------------------------------
//
// CLASS  : BackgroundData
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A data structure class for the Background class.
//
//--------------------------------------------


package com.comp486a1.thenightrunners;

public class BackgroundData {
    String bitmapName;
    boolean isParallax;
    int layer;
    float startY;
    float endY;
    float speed;
    int height;

    //--------------------------------------------
    // BackgroundData
    //
    // PURPOSE : A constructor that creates a BackgroundData object.
    // PARAMETERS:
    //     @param bitmap - String object the represents the name of the Background bitmap.
    //     @param isParallax - Tells the class if the Background has a parallax effect.
    //     @param layer - The layer in which where this part of the Background sits.
    //     @param startY - Starting y axis of the background.
    //     @param endY - Ending y axis of the background.
    //     @param speed - Speed in which the background moves (if parallax); scrolling speed.
    //     @param height - Height of the background.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    BackgroundData(String bitmap, boolean isParallax, int layer, float startY, float endY, float speed, int height){
        this.bitmapName = bitmap;
        this.isParallax = isParallax;
        this.layer = layer;
        this.startY = startY;
        this.endY = endY;
        this.speed = speed;
        this.height = height;
    }
}

