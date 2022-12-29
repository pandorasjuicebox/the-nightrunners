//--------------------------------------------
//
// CLASS  : NightCity
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A playable game level in The Nightrunners.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import java.util.ArrayList;

public class NightCity extends LevelData{

    //--------------------------------------------
    // NightCity
    //
    // PURPOSE : Loads the level by adding String objects into the tiles array, that is then processed
    //           by LevelManager via loadMapData.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    NightCity() {
        levelList.add("NightCity");
        tiles = new ArrayList<String>();

        this.tiles.add(".1...................................................................................................................................................................................................................................................................................................................................................................................");
        this.tiles.add(".1...................................................................................................................................................................................................................................................................................................................................................................................");
        this.tiles.add(".1...................................................................................................................................................................................................................................................................................................................................................................................");
        this.tiles.add(".1.............................................................................................................................................................................c...............................................................................................................................gc...................................................................");
        this.tiles.add(".1.............................................................................................................................................................................111...................................................................................................................................................................................................");
        this.tiles.add(".1.................................................................................................................................................................................................................................................................................................111.......111111..................................................................");
        this.tiles.add(".1.....................................................................................................................................c..........................................111111..g.................................................................................................................................................................................t........");
        this.tiles.add(".1......................................................c.............................................................................1111.........................................................................................................c...................e.................................................11.................................1111......................");
        this.tiles.add(".1....................................................111..................................................................1111.............1111.........................................1111...................................11.....11.....................................................11........................................................1111111......................");
        this.tiles.add(".1..p.............................g................111...111.........g..............g.................................111111111.eg..........111111.........d................g............................................11.....11.....11.....11.....................................g..............................................................11111111111..........h.........."); //add detective contact here
        this.tiles.add(".1...............................................111.......111..................................................111111111111111.............11111111.....................................................................11.....11.....11.......................................................................................................111111111111111....................");
        this.tiles.add("111111111111111111111111111111111111111111111111111111111111111111111111111.......111111111111111111111111111111111111111111111111111111111111111111111111111111111.......1111111111111111111111111111111.......11111111111.....11.....11.............11111111111111111111111111111111111111111111111111111111111111111111111111111.......111111111111111111111111111111111111111111");

        // Declare the values for the teleports in order of appearance
        locations = new ArrayList<Location>();
        this.locations.add(new Location("MilitaryBase", 0f, 4f));

        // Background from "Cyberpunk Street Environment" by ansimuz
        // Heavily modified!
        // From https://ansimuz.itch.io/cyberpunk-street-environment
        backgroundDataList = new ArrayList<BackgroundData>(); // note that speeds less than 2 cause problems
        this.backgroundDataList.add(new BackgroundData("lowtown_background", true, -2, -10, 25, 10, 20));
        this.backgroundDataList.add(new BackgroundData("lowtown_midground", true, -1, 0, 25, 20, 20 ));
        //this.backgroundDataList.add(new BackgroundData("lowtown_foreground", true, -1, 0, 25, 34, 20 ));
    }
}


