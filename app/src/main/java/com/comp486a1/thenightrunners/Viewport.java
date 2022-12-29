//--------------------------------------------
//
// CLASS  : Viewport
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A class that defines what the player sees on their device, and in the case of
//          this game, it also determines what the player sees in-game (as the game is in fullscreen).
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.graphics.Rect;

public class Viewport {

    private Vector2Point5D currentViewportWorldCentre;
    private Rect convertedRect;
    private int pixelsPerMetreX;
    private int pixelsPerMetreY;
    private int screenXResolution;
    private int screenYResolution;
    private int screenCentreX;
    private int screenCentreY;
    private int metresToShowX;
    private int metresToShowY;
    private int numClipped;

    //--------------------------------------------
    // Viewport
    //
    // PURPOSE : A constructor that creates a Viewport object.
    // PARAMETERS:
    //      @param x - x resolution of the device screen.
    //      @param y - y resolution of the device screen.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    Viewport(int x, int y){

        screenXResolution = x;
        screenYResolution = y;

        screenCentreX = screenXResolution / 2;
        screenCentreY = screenYResolution / 2;

        pixelsPerMetreX = screenXResolution / 32;
        pixelsPerMetreY = screenYResolution / 18;

        metresToShowX = 34;
        metresToShowY = 20;

        convertedRect = new Rect();
        currentViewportWorldCentre = new Vector2Point5D();

    }

    //--------------------------------------------
    // setWorldCentre
    //
    // PURPOSE : Used to set the Player object as the centre of the Viewport.
    // PARAMETERS:
    //      @param x - Player's x location in the world.
    //      @param y - Player's y location in the world.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    void setWorldCentre(float x, float y){
        currentViewportWorldCentre.x  = x;
        currentViewportWorldCentre.y  = y;

    }

    //--------------------------------------------
    // getScreenWidth
    //
    // PURPOSE : Returns the x resolution of the Viewport.
    // PARAMETERS: None.
    //
    // Returns:
    //      screenXResolution
    //
    // --------------------------------------------
    public int getScreenWidth(){

        return  screenXResolution;
    }

    //--------------------------------------------
    // getScreenHeight
    //
    // PURPOSE : Returns the y resolution of the Viewport.
    // PARAMETERS: None.
    //
    // Returns:
    //      screenYResolution
    //
    // --------------------------------------------
    public int getScreenHeight(){

        return  screenYResolution;
    }

    //--------------------------------------------
    // getPixelsPerMetreX
    //
    // PURPOSE : Returns the x-value of pixels per metre to be used by the LevelManager
    //           in the PlatformView class.
    // PARAMETERS: None.
    //
    // Returns:
    //      pixelsPerMetreX
    //
    // --------------------------------------------
    public int getPixelsPerMetreX(){

        return  pixelsPerMetreX;
    }

    //--------------------------------------------
    // worldToScreen
    //
    // PURPOSE : Used by the draw() method in PlatformView to set up the worldLocations so that it can
    //           draw the GameObjects in needs to draw.
    // PARAMETERS:
    //     @param objectX - Rect left value.
    //     @param objectY - Rect top value.
    //     @param objectWidth - Rect right value.
    //     @param objectHeight - Rect bottom value.
    //
    // Returns:
    //      pixelsPerMetreX
    //
    // --------------------------------------------
    public Rect worldToScreen(float objectX, float objectY, float objectWidth, float objectHeight){
        int left = (int) (screenCentreX - ((currentViewportWorldCentre.x - objectX) * pixelsPerMetreX));
        int top =  (int) (screenCentreY - ((currentViewportWorldCentre.y - objectY) * pixelsPerMetreY));
        int right = (int) (left + (objectWidth * pixelsPerMetreX));
        int bottom = (int) (top + (objectHeight * pixelsPerMetreY));
        convertedRect.set(left, top, right, bottom);
        return convertedRect;
    }

    //--------------------------------------------
    // clipObjects
    //
    // PURPOSE : Checks if an object is clipped from the game's world after it
    //           is placed off-screen.
    //
    // PARAMETERS:
    //     @param objectX - Object's left value.
    //     @param objectY - Object's top value.
    //     @param objectWidth - Object's right value.
    //     @param objectHeight - Object's bottom value.
    //
    // Returns:
    //      pixelsPerMetreX
    //
    // --------------------------------------------
    public boolean clipObjects(float objectX, float objectY, float objectWidth, float objectHeight) {
        boolean clipped = true;

        if (objectX - objectWidth < currentViewportWorldCentre.x + (metresToShowX / 2)) {
            if (objectX + objectWidth> currentViewportWorldCentre.x - (metresToShowX / 2)) {
                if (objectY - objectHeight< currentViewportWorldCentre.y + (metresToShowY / 2)) {
                    if (objectY + objectHeight > currentViewportWorldCentre.y - (metresToShowY / 2)){
                        clipped = false;
                    }

                }
            }
        }

        //for debugging
        if(clipped){
            numClipped++;
        }

        return clipped;
    }

    //--------------------------------------------
    // getPixelsPerMetreY
    //
    // PURPOSE : Returns the y-value of pixels per metre to be used by the LevelManager
    //           in the PlatformView class.
    // PARAMETERS: None.
    //
    // Returns:
    //      pixelsPerMetreY
    //
    // --------------------------------------------
    public int getPixelsPerMetreY(){
        return  pixelsPerMetreY;
    }

    //--------------------------------------------
    // getyCentre
    //
    // PURPOSE : Gets the y value of the centre of the screen.
    // PARAMETERS: None.
    //
    // Returns:
    //      screenCentreY
    //
    // --------------------------------------------
    public int getyCentre(){
        return screenCentreY;
    }

    //--------------------------------------------
    // getViewportWorldCentreY
    //
    // PURPOSE : Returns the current centre y value of the Viewport based on the visible
    //           part of the world on the player's screen.
    // PARAMETERS: None.
    //
    // Returns:
    //      currentViewportWorldCentre.y
    //
    // --------------------------------------------
    public float getViewportWorldCentreY(){
        return currentViewportWorldCentre.y;
    }


}

