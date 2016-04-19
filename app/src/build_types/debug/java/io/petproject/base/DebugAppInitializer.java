package io.petproject.base;

import com.facebook.stetho.Stetho;

import io.petproject.PetProjectApplication;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
public class DebugAppInitializer implements AppInitializer {
    @Override
    public void init(PetProjectApplication application) {
        // Debug build dependent inits for application
        Stetho.initializeWithDefaults(application);
    }
}
