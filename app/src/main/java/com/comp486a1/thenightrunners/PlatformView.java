//--------------------------------------------
//
// CLASS  : PlatformView
// REMARKS: The class that holds the View for the game. This class is also responsible for event handling
//          like object clipping, sound effects, player navigation, drawing the Canvas, and so on.
//
//--------------------------------------------

package com.comp486a1.thenightrunners;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class PlatformView extends SurfaceView implements Runnable {

    private boolean diedLastTime = false;
    private boolean debugging = true;
    private volatile boolean running;
    private Thread gameThread = null;

    // For drawing
    private Paint paint;
    // Canvas could initially be local.
    // But later we will use it outside of the draw() method
    private Canvas canvas;
    private SurfaceHolder ourHolder;


    Context context;

    // Our new engine classes
    private LevelManager lm;
    private Viewport vp;
    InputController ic;
    SoundManager sm;
    private PlayerState ps;

    long startFrameTime;
    long timeThisFrame;
    long fps;

    private int scrWidth;
    private int scrHeight;
    private boolean defeatBoss = false;

    //--------------------------------------------
    // PlatformView
    //
    // PURPOSE : A constructor that creates a PlatformView object.
    // PARAMETERS:
    //     @param context - Context provided by PlatformActivity.
    //     @param screenWidth - Width of the device screen.
    //     @param screenHeight - Height of the device screen.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    PlatformView(Context context, int screenWidth, int screenHeight) {
        super(context);
        this.context = context;

        // Initialize our drawing objects
        ourHolder = getHolder();
        paint = new Paint();

        // Initialize the viewport
        vp = new Viewport(screenWidth, screenHeight);

        sm = new SoundManager();
        sm.loadSound(context);
        ps = new PlayerState();

        scrWidth = screenWidth;
        scrHeight = screenHeight;


        loadLevel("ResearchLab",10,2);
        loadLevel("SynthCity",10,2);
        loadLevel("MilitaryBase", 10, 2);
        loadLevel("NightCity", 10, 2);

    }

    //--------------------------------------------
    // loadLevel
    //
    // PURPOSE : Loads a level with the String object as reference.
    // PARAMETERS:
    //     @param level - Name of the level.
    //     @param px - Starting x coordinates of the level.
    //     @param py - Starting y coordinates of the level.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void loadLevel(String level, float px, float py) {
        
        lm = null;

        // Create a new LevelManager
        // Passing in a Context, screen details, level name and player location
        lm = new LevelManager(context, vp.getPixelsPerMetreX(), vp.getScreenWidth(), ic, level, px, py);
        ic = new InputController(vp.getScreenWidth(), vp.getScreenHeight());

        //when the player dies, they respawn here
        PointF location = new PointF(px, py); ps.saveLocation(location);


        //set the players location as the world centre of the viewport
        vp.setWorldCentre(lm.gameObjects.get(lm.playerIndex)
                        .getWorldLocation().x,
                        lm.gameObjects.get(lm.playerIndex)
                        .getWorldLocation().y);
    }

    //--------------------------------------------
    // run
    //
    // PURPOSE : Runs the game and updates + draws new states while true.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    @Override
    public void run() {

        while (running) {
            startFrameTime = System.currentTimeMillis();

            update();

            draw();

            // Calculate the fps this frame
            // We can then use the result to
            // time animations and more.
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
            }
        }
    }

    //--------------------------------------------
    // update
    //
    // PURPOSE : A method that clips anything offscreen, check collisions with the Player object
    //           and react accordingly depending on the type. Checks if the game is over and what do
    //           when it does, as well as the kinds of things the Player can do while the game is
    //           unpaused/playing in real time.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    private void update() {

        for (GameObject go : lm.gameObjects) {
            if (go.isActive()) {
                // Clip anything off-screen
                if (!vp.clipObjects(go.getWorldLocation().x, go.getWorldLocation().y, go.getWidth(), go.getHeight())) {

                    // Set visible flag to true
                    go.setVisible(true);

                    // check collisions with player
                    int hit = lm.player.checkCollisions(go.getHitbox());
                    if (hit > 0) {
                    //collision! Now deal with different types
                        switch (go.getType()) {
                            case 'c':
                                sm.playSound("obtain_disc");
                                go.setActive(false);
                                go.setVisible(false);
                                ps.addDiscs();

                                // Now restore state that was
                                // removed by collision detection

                                if (hit != 2) {// Any hit except feet
                                    lm.player.restorePreviousVelocity();
                                }
                                break;

//                            case 'u':
//                                sm.playSound("blaster_upgrade");
//                                go.setActive(false);
//                                go.setVisible(false);
//                                lm.player.blaster.upgradeRateOfFire();
//                                ps.increaseFireRate();
//
//                                if (hit != 2) {// Any hit except feet
//                                    lm.player.restorePreviousVelocity();
//                                }
//                                break;

                            case 'e':
                                //extra life
                                go.setActive(false);
                                go.setVisible(false);
                                sm.playSound("extra_life");
                                ps.addLife();
                                if (hit != 2) {
                                    lm.player.restorePreviousVelocity();
                                }
                                break;

                            case 'd':
                                PointF location;
                                //hit by drone
                                sm.playSound("player_death");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x, ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 'g':
                                // Hit by guard
                                sm.playSound("player_death");
                                ps.loseLife();
                                location = new PointF(ps.loadLocation().x, ps.loadLocation().y);
                                lm.player.setWorldLocationX(location.x);
                                lm.player.setWorldLocationY(location.y);
                                lm.player.setxVelocity(0);
                                break;

                            case 't':
                                //You can only teleport after collecting all discs
                                //if(ps.getNumDiscs() == lm.getTotalDiscs()){
                                Teleport teleport = (Teleport) go;
                                Location t = teleport.getTarget();
                                loadLevel(t.level, t.x, t.y);

                                    if(t.level.matches("ResearchLab")){
                                        ps.addDiscs(ps.getTotalCollectedDiscs());
                                    }
                                    else{
                                        ps.updateTotalDiscs();
                                        ps.resetDisks();
                                    }
                                    sm.playSound("teleport");
                                break;


                            default:// Probably a regular tile
                                if (hit == 1) {
                                    // Left or right
                                    lm.player.setxVelocity(0);
                                    lm.player.setPressingRight(false);
                                    //lm.player.setPressingLeft(false);
                                }
                                if (hit == 2) {
                                    // Feet
                                    lm.player.isFalling = false;
                                }
                                break;
                        }
                    }

                    //Check bullet collisions
                    for (int i = 0; i < lm.player.blaster.getNumBullets(); i++) {
                        //Make a hitbox out of the the current bullet
                        RectHitbox r = new RectHitbox();
                        r.setLeft(lm.player.blaster.getBulletX(i));
                        r.setTop(lm.player.blaster.getBulletY(i));
                        r.setRight(lm.player.blaster.getBulletX(i) + .1f);
                        r.setBottom(lm.player.blaster.getBulletY(i) + .1f);

                        if (go.getHitbox().intersects(r)) { // Collision detected
                            // make bullet disappear until it
                            // is respawned as a new bullet
                            lm.player.blaster.hideBullet(i);
                            //Now respond depending upon the type of object hit

                            if (go.getType() != 'g' && go.getType() != 'd' && go.getType() != 'b') {
                                sm.playSound("shoot");
                            }
                            else if (go.getType() == 'g') {
                                // Knock the guard back
                                go.setWorldLocationX(go.getWorldLocation().x + 2 * (lm.player.blaster.getDirection(i)));
                                sm.playSound("hit_human_guard");
                                go.loseHealth(1);

                                if(go.getHealth()==0){
                                    //permanently clip this drone
                                    go.setWorldLocation(-100, -100, 0);
                                }
                            }
                            else if (go.getType() == 'd') {
                                sm.playSound("drone_explode");
                                //permanently clip this drone
                                go.setWorldLocation(-100, -100, 0);
                            }
                            else if(go.getType() == 'b'){ //boss
                                sm.playSound("hit_human_guard");
                                go.loseHealth(1);

                                if(go.getHealth()==0){
                                    //permanently clip the boss
                                    go.setWorldLocation(-100, -100, 0);
                                    sm.playSound("drone_explode");
                                    defeatBoss = true; //success
                                    lm.switchPlayingStatus();
                                }
                            }

                            if(lm.getLevel().matches("ResearchLab")){
                                ps.removeDiscs();
                            }
                        }
                    }


                    if (lm.isPlaying()) {
                        // Run any un-clipped updates
                        go.update(fps, lm.gravity);
                    }

                    if (go.getType() == 'd') {
                        // Let any near by drones know where the player is
                        FlyingDrone d = (FlyingDrone) go;
                        d.setWaypoint(lm.player.getWorldLocation());
                        }
                }


                else {
                    // Set visible flag to false
                    go.setVisible(false);
                    // Now draw() can ignore them
                }
            }
        }

        if (lm.isPlaying()) {
            //Reset the players location as the centre of the viewport
            vp.setWorldCentre(lm.gameObjects.get(lm.playerIndex).getWorldLocation().x, lm.gameObjects.get(lm.playerIndex).getWorldLocation().y);

            //Has player fallen out of the map?
            if (lm.player.getWorldLocation().x < 0 ||
                    lm.player.getWorldLocation().x > lm.mapWidth || lm.player.getWorldLocation().y > lm.mapHeight) {
                sm.playSound("player_death");
                ps.loseLife();
                PointF location = new PointF(ps.loadLocation().x,
                        ps.loadLocation().y);
                lm.player.setWorldLocationX(location.x); lm.player.setWorldLocationY(location.y);
                lm.player.setxVelocity(0);
            }

            //Check if game is over
            if (ps.getLives() == 0 || ((ps.getNumDiscs() < 0) && (lm.getLevel().matches("ResearchLab")) && !defeatBoss)) {
                ps = new PlayerState();
                diedLastTime = true;
                loadLevel("NightCity",10,2);
            }
            else if(defeatBoss){
                ps = new PlayerState();
                loadLevel("NightCity",10,2);
                defeatBoss = false;
            }
            else{
                diedLastTime = false;
            }
        }

    }

    //--------------------------------------------
    // draw
    //
    // PURPOSE : Drawing the objects in the level one layer at a time, while checking if the object
    //           is permitted to move around (animation) or not.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    private void draw() {

        if (ourHolder.getSurface().isValid()) {
            //First we lock the area of memory we will be drawing to
            canvas = ourHolder.lockCanvas();

            // Rub out the last frame with arbitrary color
            paint.setColor(Color.argb(255, 0, 0, 255));
            canvas.drawColor(Color.argb(255, 0, 0, 255));

            // Draw parallax backgrounds from -1 to -3
            drawBackground(0, -3);
            // Draw all the GameObjects
            Rect toScreen2d = new Rect();

            // Draw a layer at a time
            for (int layer = -1; layer <= 1; layer++)

                for (GameObject go : lm.gameObjects) {
                    if (go.isVisible() && go.getWorldLocation().z == layer) { //Only draw if visible and this layer

                        toScreen2d.set(vp.worldToScreen
                                (go.getWorldLocation().x,
                                        go.getWorldLocation().y,
                                        go.getWidth(),
                                        go.getHeight()));

                        if (go.isAnimated()) {
                            // Get the next frame of the bitmap // Rotate if necessary
                            if (go.getFacing() == 1) {
                                // Rotate
                                Matrix flipper = new Matrix();
                                flipper.preScale(-1, 1);
                                Rect r = go.getRectToDraw(System.currentTimeMillis());
                                Bitmap b = Bitmap.createBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())], r.left, r.top, r.width(), r.height(), flipper, true);
                                canvas.drawBitmap(b, toScreen2d.left, toScreen2d.top, paint);
                            } else {
                                // draw it the regular way round
                                canvas.drawBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())], go.getRectToDraw(System.currentTimeMillis()), toScreen2d, paint);
                            }
                        } else { // Just draw the whole bitmap
                            canvas.drawBitmap(lm.bitmapsArray[lm.getBitmapIndex(go.getType())], toScreen2d.left, toScreen2d.top, paint);
                        }
                    }
                }

            //draw the bullets
            paint.setColor(Color.argb(255, 255, 255, 255));
            for (int i = 0; i < lm.player.blaster.getNumBullets(); i++) {
                // Pass in the x and y coords as usual
                // then .25 and .05 for the bullet width and height
                toScreen2d.set(vp.worldToScreen(lm.player.blaster.getBulletX(i), lm.player.blaster.getBulletY(i), .25f,
                        .05f));
                canvas.drawRect(toScreen2d, paint);
            }

            // Draw parallax backgrounds
            drawBackground(5, 0);

            // Draw the HUD
            // This code needs bitmaps: extra life, upgrade and coin
            // Therefore there must be at least one of each in the level
            int topSpace = vp.getPixelsPerMetreY() / 4;
            int iconSize = vp.getPixelsPerMetreX();
            int centring = vp.getPixelsPerMetreY() / 6;
            paint.setTextSize(vp.getPixelsPerMetreY()/2);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.argb(100, 0, 0, 0));
            //canvas.drawRect(scrWidth/2,scrHeight/2,iconSize * 7.0f, topSpace*2 + iconSize,paint);
            paint.setColor(Color.argb(255, 255, 255, 0));
            canvas.drawBitmap(lm.getBitmap('e'), scrWidth/2, topSpace, paint);
            canvas.drawText("" + ps.getLives(), scrWidth/2 + 100, (iconSize) - centring, paint);
            canvas.drawBitmap(lm.getBitmap('c'), (scrWidth/2)/2 -30, topSpace, paint);
            //canvas.drawText("" + ps.getNumDiscs() + " / " + lm.getTotalDiscs(),(scrWidth/2)/2 + 100, (iconSize) - centring,paint);

            if(lm.getLevel().matches("ResearchLab")){
                canvas.drawText("" + ps.getNumDiscs() + " / " + 16,(scrWidth/2)/2 + 100, (iconSize) - centring,paint);
                canvas.drawText("You will need all data discs to defeat the boss and complete your transport!",(scrWidth/2)/2 + 110, (iconSize) + 200,paint);

            }
            else{
                canvas.drawText("" + ps.getNumDiscs() + " / " + lm.getTotalDiscs(),(scrWidth/2)/2 + 100, (iconSize) - centring,paint);
                ps.setTotalDiscsInGame(lm.getTotalDiscs());
            }


//            // Text for debugging
//            if (debugging) {
//                paint.setTextSize(16);
//                paint.setTextAlign(Paint.Align.LEFT);
//                paint.setColor(Color.argb(255, 255, 255, 255));
//                canvas.drawText("fps:" + fps, 10, 60, paint);
//                canvas.drawText("num objects:" + lm.gameObjects.size(), 10, 80, paint);
//                canvas.drawText("num clipped:" + vp.getNumClipped(), 10, 100, paint);
//                canvas.drawText("playerX:" + lm.gameObjects.get(lm.playerIndex).getWorldLocation().x, 10, 120, paint);
//                canvas.drawText("playerY:" + lm.gameObjects.get(lm.playerIndex).getWorldLocation().y, 10, 140, paint);
//
//                canvas.drawText("Gravity:" + lm.gravity, 10, 160, paint);
//                canvas.drawText("X velocity:" + lm.gameObjects.get(lm.playerIndex).getxVelocity(), 10, 180, paint);
//                canvas.drawText("Y velocity:" + lm.gameObjects.get(lm.playerIndex).getyVelocity(), 10, 200, paint);
//
//                //for reset the number of clipped objects each frame
//                vp.resetNumClipped();
//
//            }

            //draw buttons
            paint.setColor(Color.argb(80, 255, 255, 255));
            ArrayList<Rect> buttonsToDraw;
            buttonsToDraw = ic.getButtons();

            for (Rect rect : buttonsToDraw) {
                RectF rf = new RectF(rect.left, rect.top,rect.right, rect.bottom);
                canvas.drawRoundRect(rf, 15f, 15f, paint);
            }

            //Draw text labels for buttons
            paint.setTextSize(vp.getPixelsPerMetreY());
            paint.setColor(Color.argb(255, 255, 255, 0));


            canvas.drawText("LEFT", ic.getButtonPadding() + 100, ic.getButtonHeight()*6 + 80,paint);
            canvas.drawText("RIGHT", ic.getButtonPadding() + 330, ic.getButtonHeight()*6 + 80,paint);
            canvas.drawText("JUMP", ic.getButtonPadding() + 1620, ic.getButtonHeight()*5+50,paint);
            canvas.drawText("SHOOT", ic.getButtonPadding() + 1620, ic.getButtonHeight()*6 + 80,paint);
            canvas.drawText("PAUSE", ic.getButtonPadding() + 1620, ic.getButtonHeight()/2+50,paint);

            //draw paused text
            if (!this.lm.isPlaying()) {

                paint.setTextAlign(Paint.Align.CENTER);
                paint.setColor(Color.argb(255, 255, 255, 255));
                paint.setTextSize(320);

                if(defeatBoss){
                    canvas.drawText("YOU WIN!", vp.getScreenWidth() / 2, vp.getScreenHeight() /2 + 60, paint);
                }
                else if(diedLastTime){
                    canvas.drawText("GAME OVER", vp.getScreenWidth() / 2, vp.getScreenHeight() /2 + 60, paint);
                }
                else{
                    canvas.drawText("PAUSED", vp.getScreenWidth() / 2, vp.getScreenHeight() / 2, paint);
                }


            }

            // Unlock and draw the scene
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    //--------------------------------------------
    // pause
    //
    // PURPOSE : Pauses the thread by toggling the running variable into pause, which really means
    //           waiting for the thread to terminate -- acting the "pause" mechanism for this class.
    // PARAMETERS:
    //     @param fps - Frames per second of this GameObject.
    //     @param gravity - For the gravity variable of the GameObject.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void pause() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("error", "failed to pause thread");
        }
    }

    //--------------------------------------------
    // resume
    //
    // PURPOSE : When the game resumes, a new thread is created and the run() method
    //           is executed.
    // PARAMETERS: None.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    //--------------------------------------------
    // onTouchEvent
    //
    // PURPOSE : A method that passes a MotionEvent object to the InputController's
    //           handleInput method so that it can respond appropriately to the event.
    //
    // PARAMETERS:
    //     @param motionEvent - A MotionEvent object.
    //
    // Returns:
    //      true/false
    //
    // --------------------------------------------
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (lm != null) {
            ic.handleInput(motionEvent, lm, sm, vp);
        }
        //invalidate();
        return true;
    }

    //--------------------------------------------
    // drawBackground
    //
    // PURPOSE : Draw the Background as it should look like in the user's screen at that
    //           that position. Clip anything that is beyond the dimensions of the Viewport.
    //
    // PARAMETERS:
    //     @param start - Used to check if a background has a z layer to be drawn.
    //     @param stop - Used to check if a background has a z layer to be drawn.
    //
    // Returns:
    //      Nothing.
    //
    // --------------------------------------------
    private void drawBackground(int start, int stop) {
        Rect fromRect1 = new Rect();
        Rect toRect1 = new Rect();
        Rect fromRect2 = new Rect();
        Rect toRect2 = new Rect();

        for (Background bg : lm.backgrounds) {
            if (bg.z < start && bg.z > stop) {
                // Is this layer in the viewport?
                // Clip anything off-screen
                if (!vp.clipObjects(-1, bg.y, 1000, bg.height)) {
                    float floatstartY = ((vp.getyCentre() - ((vp.getViewportWorldCentreY() - bg.y) * vp.getPixelsPerMetreY())));
                    int startY = (int) floatstartY;
                    float floatendY = ((vp.getyCentre() - ((vp.getViewportWorldCentreY() - bg.endY) * vp.getPixelsPerMetreY())));
                    int endY = (int) floatendY;
                    // Define what portion of bitmaps to capture
                    // and what coordinates to draw them at
                    fromRect1 = new Rect(0, 0, bg.width - bg.xClip, bg.height);
                    toRect1 = new Rect(bg.xClip, startY, bg.width, endY);
                    fromRect2 = new Rect(bg.width - bg.xClip, 0, bg.width, bg.height);
                    toRect2 = new Rect(0, startY, bg.xClip, endY);
                }// End if (!vp.clipObjects...

                //draw backgrounds
                if (!bg.reversedFirst) {
                    canvas.drawBitmap(bg.bitmap, fromRect1, toRect1, paint);
                    canvas.drawBitmap(bg.bitmapReversed, fromRect2, toRect2, paint);
                } else { canvas.drawBitmap(bg.bitmap,
                        fromRect2, toRect2, paint);
                    canvas.drawBitmap(bg.bitmapReversed, fromRect1, toRect1, paint);
                }

                // Calculate the next value for the background's
                // clipping position by modifying xClip
                // and switching which background is drawn first,
                // if necessary.
                bg.xClip -= lm.player.getxVelocity() / (20 / bg.speed);
                if (bg.xClip >= bg.width) {
                    bg.xClip = 0;
                    bg.reversedFirst = !bg.reversedFirst;
                }
                else if (bg.xClip <= 0) {
                    bg.xClip = bg.width;
                    bg.reversedFirst = !bg.reversedFirst;
                }
            }
        }
    }

}// End of PlatformView
