package io.petproject.base;

import io.palaima.debugdrawer.DebugDrawer;
import io.palaima.debugdrawer.commons.BuildModule;
import io.palaima.debugdrawer.commons.DeviceModule;
import io.palaima.debugdrawer.commons.SettingsModule;
import io.palaima.debugdrawer.timber.TimberModule;
import io.petproject.base.mvp.BaseActivity;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/17/16).
 */
public class DebugRootViewWrapper implements RootViewWrapper {

    @Override
    public void wrap(BaseActivity activity) {
        DebugDrawer debugDrawer = new DebugDrawer.Builder(activity)
                .modules(
                        new BuildModule(activity),
                        new SettingsModule(activity),
                        new TimberModule(),
                        new DeviceModule(activity)
                )
                .build();
    }
}
