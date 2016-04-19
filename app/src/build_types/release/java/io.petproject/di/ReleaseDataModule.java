package io.petproject.di;

import dagger.Module;
import dagger.Provides;
import io.petproject.base.AppInitializer;
import io.petproject.base.ReleaseAppInitializer;
import timber.log.Timber;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
@Module
public class ReleaseDataModule {

    @Provides
    AppInitializer appInitializer(){
        return new ReleaseAppInitializer();
    }

    @Provides
    Timber.Tree tree(){
        return new Timber.Tree() {
            @Override
            protected void log(int priority, String tag, String message, Throwable t) {
                // no-op production log flow
                // Crashlytics.log/exceptions stuff here
            }
        };
    }
}

