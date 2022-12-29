//--------------------------------------------
//
// CLASS  : PlayerState
// REMARKS: Holds information about the Player, like collected discs,
//          remaining lives, and position.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;
import android.graphics.PointF;

public class PlayerState {
    private int numDiscs;
    private int lives;
    private float restartX;
    private float restartY;
    private int totalCollectedDiscs;
    private int totalDiscsInGame;


    //--------------------------------------------
    // PlayerState
    //
    // PURPOSE : A constructor that creates a PlayerState object.
    // PARAMETERS: None.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    PlayerState() {
        lives = 3;
        //blasterFireRate = 1;
        numDiscs = 0;
        totalCollectedDiscs = 0;
        totalDiscsInGame = 0;
    }

    //--------------------------------------------
    // saveLocation
    //
    // PURPOSE : Saves a location that will be used to respawn the player when they die.
    // PARAMETERS:
    //     @param location - Allows you to access the x,y coordinates.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void saveLocation(PointF location) {
        // The location saves each time the player uses a teleport
        restartX = location.x;
        restartY = location.y;
    }

    //--------------------------------------------
    // loadLocation
    //
    // PURPOSE : Loads the location saved from saveLocation.
    // PARAMETERS: None.
    //
    // Returns:
    //      x,y coordinates used to respawn the player.
    //
    // --------------------------------------------
    public PointF loadLocation() {
        // Used every time the player loses a life
        return new PointF(restartX, restartY);
    }

    //Getters

    //--------------------------------------------
    // getLives
    //
    // PURPOSE : Getter for number of lives the player has.
    // PARAMETERS: None.
    //
    // Returns:
    //      lives
    //
    // --------------------------------------------
    public int getLives(){
        return lives;
    }

    //--------------------------------------------
    // getNumDiscs
    //
    // PURPOSE : Getter for number of discs the player has collected.
    // PARAMETERS: None.
    //
    // Returns:
    //      numDiscs
    //
    // --------------------------------------------
    public int getNumDiscs(){
        return numDiscs;
    }

    //--------------------------------------------
    // getTotalCollectedDiscs
    //
    // PURPOSE : Getter for the total amount of collected discs the player has
    //           collected throughout the levels.
    // PARAMETERS: None.
    //
    // Returns:
    //      totalCollectedDiscs
    //
    // --------------------------------------------
    public int getTotalCollectedDiscs(){
        return totalCollectedDiscs;
    }

    //Setters-Other Methods

    //--------------------------------------------
    // addDiscs
    //
    // PURPOSE : Increase number of discs collected by 1.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void addDiscs(){
        numDiscs++;
    }

    //--------------------------------------------
    // addDiscs
    //
    // PURPOSE : Adds a custom amount of discs to the number of discs collected.
    // PARAMETERS:
    //      @param num - the amount to increase numDiscs by.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void addDiscs(int num){
        numDiscs += num;
    }

    //--------------------------------------------
    // removeDiscs
    //
    // PURPOSE : Removes discs collected by 1.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void removeDiscs(){
        numDiscs--;
    }

    //--------------------------------------------
    // loseLife
    //
    // PURPOSE : Decreases player's lives by 1.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void loseLife(){
        lives--;
    }

    //--------------------------------------------
    // addLife
    //
    // PURPOSE : Add the number of player's lives by 1.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void addLife(){
        lives++;
    }

    //--------------------------------------------
    // resetDisks
    //
    // PURPOSE : Sets number of discs collected during the level by 0.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void resetDisks(){
        numDiscs = 0;
    }

    //--------------------------------------------
    // setTotalDiscsInGame
    //
    // PURPOSE : Used to count all discs that exist in the game.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void setTotalDiscsInGame(int n) {
        totalDiscsInGame = totalDiscsInGame + n;
    }

    //--------------------------------------------
    // updateTotalDiscs
    //
    // PURPOSE : Adds the discs collected during the level to the total amount of discs the
    //           player has collected in the game for this session.
    // PARAMETERS: None.
    //
    // Returns:
    //      None.
    //
    // --------------------------------------------
    public void updateTotalDiscs(){
        totalCollectedDiscs += numDiscs;
    }


}
