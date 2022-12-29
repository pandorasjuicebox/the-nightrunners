package com.comp486a1.thenightrunners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//33 tests
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AnimationTest.class,
        BlasterAmmoTest.class,
        BlasterTest.class,
        InputControllerTest.class,
        LevelManagerTest.class,
        PlayerStateTest.class,
        RectHitboxTest.class,
        TeleportTest.class,
        ViewportTest.class
})

//Run this class to execute all 33 tests. They should all pass.
public class AllTests {
}
