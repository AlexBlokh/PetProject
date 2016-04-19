package io.petproject.base;

import io.petproject.base.mvp.BaseActivity;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/19/16).
 */
public class ReleaseRootViewWrapper implements RootViewWrapper {
    @Override
    public void wrap(BaseActivity activity) {
        // no-op for release build type
    }
}
