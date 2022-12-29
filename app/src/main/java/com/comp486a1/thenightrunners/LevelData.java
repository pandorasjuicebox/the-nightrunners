//--------------------------------------------
//
// CLASS  : LevelData
// REMARKS: A class in which each level extends from. Holds data relevant to the level such as
//          tiles, backgrounds, Teleport locations and such.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import java.util.ArrayList;

public class LevelData {
    ArrayList<String> tiles;
    ArrayList<BackgroundData> backgroundDataList;
    ArrayList<Location> locations;
    ArrayList<String> levelList = new ArrayList<String>();


    // This class will evolve along with the project
    // Tile types
    // . = no tile
    // 1 = Night City Tile
    // 2 = Military Base Tile
    // 3 = Synth Tile
    // 4 = Lab Tile

    //Active objects
    // g = Human Guard
    // d = Flying Drone
    // t = Teleporter
    // c = CD or Data Disc
    // e = extra life

    //Inactive objects
    // h = The Handler


}
