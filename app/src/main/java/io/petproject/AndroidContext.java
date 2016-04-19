package io.petproject;

import android.content.Context;
import android.support.annotation.NonNull;

import static io.petproject.misc.Preconditions.preventAnyInstances;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class AndroidContext {

    private static Context sContext;

    private AndroidContext() {
        preventAnyInstances();
    }

    public static void attach(@NonNull Context context) {
        sContext = context;
    }

    public static Context getContext() {
        return sContext;
    }
}
