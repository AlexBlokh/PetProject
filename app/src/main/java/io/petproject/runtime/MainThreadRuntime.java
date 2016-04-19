package io.petproject.runtime;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public interface MainThreadRuntime {

    void postOnMainThread(Runnable runnable);

    boolean isMainThread();
}
