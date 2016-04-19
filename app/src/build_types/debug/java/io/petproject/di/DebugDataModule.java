package io.petproject.di;

import dagger.Module;
import dagger.Provides;
import io.petproject.base.AppInitializer;
import io.petproject.base.DebugAppInitializer;
import timber.log.Timber;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
@Module
public class DebugDataModule {

    @Provides
    AppInitializer appInitializer() {
        return new DebugAppInitializer();
    }

    @Provides
    Timber.Tree tree() {
        return new Timber.DebugTree();
    }
}

