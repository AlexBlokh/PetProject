package io.petproject.di;

import dagger.Module;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
@Module(includes = {
        DebugDataModule.class,
        DebugUiModule.class
})
public class BuildTypeDependentModule {
}
