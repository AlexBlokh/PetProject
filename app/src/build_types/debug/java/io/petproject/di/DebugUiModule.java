package io.petproject.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.petproject.base.DebugRootViewWrapper;
import io.petproject.base.RootViewWrapper;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
@Module
public class DebugUiModule {

    @Provides
    @Singleton
    RootViewWrapper rootViewWrapper(){
        return new DebugRootViewWrapper();
    }

}
