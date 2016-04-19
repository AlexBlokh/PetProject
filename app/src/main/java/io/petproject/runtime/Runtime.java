package io.petproject.runtime;

/**
 * Facade class for threading purposes
 *
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class Runtime {

    private static final MainThreadRuntime mainThreadRuntime = new AndroidMainThreadRuntime();

    private Runtime() {

    }

    public static void postToMainThread(Runnable runnable) {
        mainThreadRuntime.postOnMainThread(runnable);
    }

    public static boolean isMainThread() {
        return mainThreadRuntime.isMainThread();
    }
}
