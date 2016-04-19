package io.petproject.di;

import javax.inject.Singleton;

import dagger.Component;
import io.petproject.ui.main.MainActivity;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/18/16).
 */
@Singleton
@Component(modules = {
        AppModule.class,
        FlavourDependentModule.class,
        BuildTypeDependentModule.class
})
public interface AppComponent extends FlavorDependentComponent {
    void inject(MainActivity mainActivity);
}
