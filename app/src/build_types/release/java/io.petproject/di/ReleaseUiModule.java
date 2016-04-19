package io.petproject.di;

import dagger.Module;
import dagger.Provides;
import io.petproject.base.ReleaseRootViewWrapper;
import io.petproject.base.RootViewWrapper;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/19/16).
 */
@Module
public class ReleaseUiModule {

    @Provides
    RootViewWrapper rootViewWrapper() {
        return new ReleaseRootViewWrapper();
    }
}
