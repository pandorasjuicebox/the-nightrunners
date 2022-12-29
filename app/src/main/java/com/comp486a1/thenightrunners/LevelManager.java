
//--------------------------------------------
//
// CLASS  : LevelManager
// AUTHOR : Charina Duenas, 3568014
//
// REMARKS: A class that manages our levels in the game and what exists in them. This
//          includes having a list of game objects, backgrounds, bitmaps, map sizes,
//          as well as the player itself.
//
//--------------------------------------------
package com.comp486a1.thenightrunners;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class LevelManager {


    private String level;
    int mapWidth;
    int mapHeight;

    Player player;
    int playerIndex;

    private boolean playing;
    float gravity;

    LevelData levelData;
    ArrayList<GameObject> gameObjects;
    ArrayList<Background> backgrounds;
    Bitmap[] bitmapsArray;

    private int totalDiscs;

    //--------------------------------------------
    // LevelManager
    //
    // PURPOSE : A constructor that create a LevelManager object, which then manages the several
    //           levels as well as elements that exist in the game.
    // PARAMETERS:
    //     @param context - State of the object provided by the LevelManager.
    //     @param PixelsPerMetre - Pixels per metre for the y-axis.
    //     @param screenWidth - Width of the screen of the device.
    //     @param ic - Controls that allow us to move around the levels.
    //     @param level - Name of the level.
    //     @param px - starting x coordinates.
    //     @param py - starting y coordinates.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public LevelManager(Context context, int pixelsPerMetre, int screenWidth, InputController ic, String level, float px, float py) {
        this.level = level;

        switch (level) {

            //LEVEL 1; easy, helps get the mechanics down
            case "NightCity":
                levelData = new NightCity();
                totalDiscs = 0;
                break;

            // We can add extra levels here

            //LEVEL 2: Secret Military Base
            case "MilitaryBase":
                levelData = new MilitaryBase();
                totalDiscs = 0;
                break;

            //LEVEL 3:
            case "SynthCity":
                levelData = new SynthCity();
                totalDiscs = 0;
                break;

            //LEVEL 4:
            case "ResearchLab":
                levelData = new ResearchLab();
                break;
        }

        // To hold all our GameObjects
        gameObjects = new ArrayList<>();

        // To hold 1 of every Bitmap
        bitmapsArray = new Bitmap[35];

        // Load all the GameObjects and Bitmaps
        loadMapData(context, pixelsPerMetre, px, py);
        loadBackgrounds(context, pixelsPerMetre, screenWidth);
        // Set waypoints for our guards
        setWaypoints();


        // Ready to play
        //playing = true;
    }

    //--------------------------------------------
    // isPlaying
    //
    // PURPOSE : A boolean method that checks if the game paused or not.
    // PARAMETERS: None.
    //
    // Returns:
    //      true or false
    //
    // --------------------------------------------
    public boolean isPlaying() {
        return playing;
    }

    //--------------------------------------------
    // getBitmap
    //
    // PURPOSE : Getter for the index to use for the bitmapArray using the char type
    //           that corresponds to it.
    // PARAMETERS:
    //      @param blockType - char character that is used to determine GameObject's type.
    //
    // Returns:
    //     A Bitmap object.
    //
    // --------------------------------------------
    public Bitmap getBitmap(char blockType) {

        int index;
        switch (blockType) {
            case '.':
                index = 0;
                break;

            case '1': //NightCity Tile
                index = 1;
                break;

            case 'p': //player
                index = 2;
                break;

            case 'c': //cd or data disc
                index = 3;
                break;

            case 'e': //extra life
                index = 4;
                break;

            case 'd':
                index = 5;
                break;

            case 'g':
                index = 6;
                break;

            case 't':
                index = 7;
                break;

            case '2': // military base tile
                index = 8;
                break;

            case 'h': // the handler
                index = 9;
                break;

            case '3': // synth tile
                index = 10;
                break;

            case '4': // lab tile
                index = 11;
                break;

            case 'b': // final level tile
                index = 12;
                break;

            default:
                index = 0;
                break;
        }

        return bitmapsArray[index];
    }

    //--------------------------------------------
    // getBitmapIndex
    //
    // PURPOSE : Getter for the GameObject to know what char it correlates with.
    // PARAMETERS:
    //      @param blockType - char character that is used to determine GameObject's type.
    //
    // Returns:
    //     index
    //
    // --------------------------------------------
    public int getBitmapIndex(char blockType) {

        int index;
        switch (blockType) {
            case '.':
                index = 0;
                break;

            case '1': //NightCity Tile
                index = 1;
                break;

            case 'p': //player
                index = 2;
                break;

            case 'c': //cd or data disc
                index = 3;
                break;

            case 'e': //extra life
                index = 4;
                break;

            case 'd':
                index = 5;
                break;

            case 'g':
                index = 6;
                break;

            case 't':
                index = 7;
                break;

            case '2': // military base tile
                index = 8;
                break;

            case 'h': //the handler
                index = 9;
                break;

            case '3': //synth tile
                index = 10;
                break;

            case '4': // lab tile
                index = 11;
                break;

            case 'b': // final level tile
                index = 12;
                break;

            default:
                index = 0;
                break;
        }

        return index;
    }

    //--------------------------------------------
    // loadMapData
    //
    // PURPOSE : A method that loads the GameObjects as it was designated per String object
    //           entry in the tiles array, that is then parsed by char.
    // PARAMETERS:
    //     @param context - State of the object provided by the LevelManager.
    //     @param yPixelsPerMetre - Pixels per metre for the y-axis.
    //     @param px - Starting x coordinates.
    //     @param py - Starting y coordinates.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    void loadMapData(Context context, int pixelsPerMetre, float px, float py) {

        char c;

        //Keep track of where we load our game objects
        int currentIndex = -1;
        int teleportIndex = -1;

        // how wide and high is the map? Viewport needs to know
        mapHeight = levelData.tiles.size();
        mapWidth = levelData.tiles.get(0).length();

        for (int i = 0; i < levelData.tiles.size(); i++) {
            for (int j = 0; j < levelData.tiles.get(i).length(); j++) {

                c = levelData.tiles.get(i).charAt(j);
                if (c != '.') {// Don't want to load the empty spaces
                    currentIndex++;
                    switch (c) {

                        case '1':
                            // Add a tile to the gameObjects
                            gameObjects.add(new NightCityTile(j, i, c));
                            break;

                        case 'p':// a player
                            // Add a player to the gameObjects
                            gameObjects.add(new Player
                                    (context, px, py, pixelsPerMetre));

                            // We want the index of the player
                            playerIndex = currentIndex;
                            // We want a reference to the player object
                            player = (Player) gameObjects.get(playerIndex);
                            break;

                        case 'c': // Add a coin to the gameObjects
                            gameObjects.add(new DataDisc(j, i, c));
                            totalDiscs++;
                            break;

                        case 'e': // Add an extra life to the gameObjects
                            gameObjects.add(new ExtraLife(j, i, c));
                            break;

                        case 'd':// Add a drone to the gameObjects
                            gameObjects.add(new FlyingDrone(j, i, c));
                            break;

                        case 'g':// Add a guard to the gameObjects
                            gameObjects.add(new HumanGuard(context, j, i, c, pixelsPerMetre));
                            break;

                        case 't':
                            // Add a teleport to the gameObjects
                            teleportIndex++;
                            gameObjects.add(new Teleport(j, i, c, levelData.locations.get(teleportIndex)));
                            break;

                        case '2':
                            // Add a tile to the gameObjects
                            gameObjects.add(new MilitaryBaseTile(j, i, c));
                            break;

                        case 'h':
                            // Add the handler character
                            gameObjects.add(new TheHandler(context, j, i, c, pixelsPerMetre));
                            break;

                        case '3':
                            // Add a tile to the gameObjects
                            gameObjects.add(new SynthTile(j, i, c));
                            break;

                        case '4':
                            // Add a tile to the gameObjects
                            gameObjects.add(new LabTile(j, i, c));
                            break;

                        case 'b':
                            // Add the handler character
                            gameObjects.add(new Boss(context, j, i, c, pixelsPerMetre));
                            break;
                    }

                    // If the bitmap isn't prepared yet
                    if (bitmapsArray[getBitmapIndex(c)] == null) {
                        // Prepare it now and put it in the bitmapsArrayList
                        bitmapsArray[getBitmapIndex(c)] =
                                gameObjects.get(currentIndex).prepareBitmap(context, gameObjects.get(currentIndex).getBitmapName(), pixelsPerMetre);

                    }
                }
            }
        }
    }

    //--------------------------------------------
    // switchPlayingStatus
    //
    // PURPOSE : Toggles between playing/not playing states that determine whether
    //           or not there is gravity.
    // PARAMETERS: None.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void switchPlayingStatus() {
        playing = !playing;
        if (playing) { gravity = 6;
        } else {
            gravity = 0;
        }
    }

    //--------------------------------------------
    // setWaypoints
    //
    // PURPOSE : Sets the waypoints of GameObjects that have designated waypoints.
    // PARAMETERS: None.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    public void setWaypoints(){
        // Loop through all game objects looking for Guards
        for (GameObject guard : this.gameObjects) {
            if (guard.getType() == 'g') {
                // Set waypoints for this guard
                // find the tile beneath the guard
                // this relies on the designer putting
                // the guard in sensible location
                int startTileIndex = -1;
                float waypointX1 = -1;
                float waypointX2 = -1;
                for (GameObject tile : this.gameObjects) { startTileIndex++;
                    if (tile.getWorldLocation().y == guard.getWorldLocation().y + 2) {
                            // Tile is two spaces below current guard
                            // Now see if has same x coordinate
                        if (tile.getWorldLocation().x ==
                                guard.getWorldLocation().x) {
                                // Found the tile the guard is "standing" on
                                // Now go left as far as possible
                                // before non travers-able tile is found
                                // Either on guards row or tile row
                                // up to a maximum of 5 tiles.
                                // 5 is an arbitrary value you can
                                // change it to suit
                            for (int i = 0; i < 5; i++) {// left for loop
                                if (!gameObjects.get(startTileIndex - i).isTraversable()) {//set the left waypoint
                                    waypointX1 = gameObjects.get(startTileIndex - (i + 1)).getWorldLocation().x;
                                    break;// Leave left for loop
                                } else {// Set to max 5 tiles as
                                    // no non traversible tile found
                                    waypointX1 = gameObjects.get(startTileIndex - 1).getWorldLocation().x;
                                }
                            }// end get left waypoint

                            for (int i = 0; i < 5; i++) {// right for loop
                                    if (!gameObjects.get(startTileIndex + i).isTraversable()) {//set the right waypoint
                                        waypointX2 = gameObjects.get(startTileIndex + (i - 1)).getWorldLocation().x;
                                        break;// Leave right for loop
                                    }
                                    else {//set to max 5 tiles away
                                        waypointX2 = gameObjects.get(startTileIndex + 1).getWorldLocation().x;
                                    }
                            }// end get right waypoint

                            HumanGuard g= (HumanGuard) guard;
                            g.setWaypoints(waypointX1, waypointX2);
                        }
                    }
                }
            }
        }
    }

    //--------------------------------------------
    // loadBackgrounds
    //
    // PURPOSE : Loads background data and objects and storing them into a list.
    // PARAMETERS:
    //     @param context - State of the object provided by the LevelManager.
    //     @param PixelsPerMetre - Pixels per metre that vary per device.
    //     @param screenWidth - Screen width of the device.
    //
    // Returns: Nothing.
    //
    // --------------------------------------------
    private void loadBackgrounds(Context context, int pixelsPerMetre, int screenWidth) {
        backgrounds = new ArrayList<Background>();
        //load the background data into the Background objects and
        // place them in our GameObject arraylist
        for (BackgroundData bgData : levelData.backgroundDataList) {
            backgrounds.add(new Background(context, pixelsPerMetre, screenWidth, bgData));
        }
    }

    //--------------------------------------------
    // getTotalDiscs
    //
    // PURPOSE : Getter that returns the total discs in the current level.
    // PARAMETERS: None.
    //
    // Returns:
    //     totalDiscs
    //
    // --------------------------------------------
    public int getTotalDiscs() {
        return totalDiscs;
    }

    //--------------------------------------------
    // getLevel
    //
    // PURPOSE : Getter that returns level name.
    // PARAMETERS: None.
    //
    // Returns:
    //     level
    //
    // --------------------------------------------
    public String getLevel() {
        return level;
    }

}

