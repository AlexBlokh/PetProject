package io.petproject;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import io.petproject.base.AppInitializer;
import io.petproject.base.Registry;
import io.petproject.di.AppComponent;
import io.petproject.di.AppModule;
import io.petproject.di.DaggerAppComponent;
import timber.log.Timber;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class PetProjectApplication extends Application {

    private AppComponent appComponent;

    @Inject Timber.Tree    logTree;
    @Inject AppInitializer appInitializer;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AndroidContext.attach(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                                         .appModule(new AppModule(this))
                                         .build();
        appComponent.inject(this);

        Timber.plant(logTree);
        appInitializer.init(this);

        registerActivityLifecycleCallbacks(Registry.SERVER);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static PetProjectApplication with(Context context) {
        return (PetProjectApplication) context.getApplicationContext();
    }
}
