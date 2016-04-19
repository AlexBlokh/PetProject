package io.petproject.misc;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class Preconditions {

    public static void preventAnyInstances() {
        throw new IllegalStateException("Prevent any instances");
    }
}
