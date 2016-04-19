package io.petproject.runtime;

import android.os.Handler;
import android.os.Looper;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class AndroidMainThreadRuntime implements MainThreadRuntime {

    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @Override
    public void postOnMainThread(Runnable runnable) {
        mainThreadHandler.post(runnable);
    }

    @Override
    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
