package io.petproject.base.mvp;

import android.os.Bundle;

import rx.subscriptions.CompositeSubscription;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class BasePresenter<V> {

    private volatile V view;

    private final CompositeSubscription unsubscribeOnStopSubscriptions
            = new CompositeSubscription();

    private final CompositeSubscription unsubscribeOnDestroySubscriptions
            = new CompositeSubscription();

    public BasePresenter(V view) {
        this.view = view;
    }

    public void onSave(Bundle out) {

    }

    public void onRestore(Bundle in) {

    }

    public void onStart() {

    }

    public void onStop() {
        //unsubscribe everything tight to onStop()
        unsubscribeOnStopSubscriptions.clear();
    }

    public void onDestroy() {
        //unsubscribe everything tight to onDestroy()
        unsubscribeOnDestroySubscriptions.clear();
        view = null;
    }
}
