package io.petproject.di;

import dagger.Module;

/**
 * Build type dependent module.
 * Provides all dependencies for 'Release' build.
 *
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
@Module(includes = {
        ReleaseDataModule.class,
        ReleaseUiModule.class
})
public class BuildTypeDependentModule {
}
