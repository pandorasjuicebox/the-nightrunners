//--------------------------------------------
//
// CLASS  : Location
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: Holds the location of the Teleporters each level.
//
//--------------------------------------------
package com.comp486a1.thenightrunners;

//--------------------------------------------
// Location
//
// PURPOSE : A constructor that creates a Location object.
// PARAMETERS:
//     @param level - Name of the level.
//     @param x - x value of the location.
//     @param y - y value of the location.
//
// Returns: Nothing.
//
// --------------------------------------------
public class Location {
    String level;
    float x;
    float y;
    Location(String level, float x, float y){
        this.level = level;
        this.x = x;
        this.y = y;
    }
}

