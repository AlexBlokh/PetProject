package io.petproject.base.mvp;

import android.support.v4.app.Fragment;

import io.petproject.runtime.Runtime;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class BaseFragment extends Fragment {

    // Safe way to post UI changes
    public void safeRunOnUi(final Runnable runnable) {
        if (isFragmentAlive() && Runtime.isMainThread()) {
            runnable.run();
        } else {
            Runtime.postToMainThread(new Runnable() {
                @Override
                public void run() {
                    if (isFragmentAlive()) {
                        runnable.run();
                    }
                }
            });
        }
    }

    // Robust way to determine if I can interact with UI
    private boolean isFragmentAlive() {
        return getActivity() != null && isAdded() && !isDetached() && getView() != null && !isRemoving();
    }
}
