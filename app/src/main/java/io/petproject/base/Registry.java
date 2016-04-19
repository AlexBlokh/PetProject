package io.petproject.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import io.petproject.base.mvp.BaseActivity;
import io.petproject.base.mvp.BasePresenter;


/**
 * //TODO: Unit test
 * @author aleksandrblokh@gmail.com (Alex Blokh, 3/29/16).
 */
public class Registry {
  private static final Map<String, Entry> registers = new HashMap<>();
  public static final Application.ActivityLifecycleCallbacks SERVER = new Application.ActivityLifecycleCallbacks() {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
      String key = getKey(activity);
      Entry entry = registers.get(key);
      if (entry != null) {
        if (savedInstanceState != null) {
          for (BasePresenter presenter : entry.presentersMap.values()) {
            presenter.onRestore(savedInstanceState);
          }
        }
      }
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
      //Use instead of onActivityStarted()
      //onActivityStarted() gets called before Fragment.onStart()
      String key = getKey(activity);
      Entry entry = registers.get(key);
      if (entry != null) {
        for (BasePresenter presenter : entry.presentersMap.values()) {
          presenter.onStart();
        }
      }
    }

    @Override
    public void onActivityPaused(Activity activity) {
      //Use instead of onActivityStopped()
      //onActivityStopped() gets called after Fragment.onStop()
      String key = getKey(activity);
      Entry entry = registers.get(key);
      if (entry != null) {
        for (BasePresenter presenter : entry.presentersMap.values()) {
          presenter.onStop();
        }
      }
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
      String key = getKey(activity);
      Entry entry = registers.get(key);
      if (entry != null) {
        for (BasePresenter presenter : entry.presentersMap.values()) {
          presenter.onSave(outState);
        }
      }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
      String key = getKey(activity);
      Entry entry = registers.get(key);
      if (entry != null) {
        for (BasePresenter presenter : entry.presentersMap.values()) {
          presenter.onDestroy();
        }
      }
      registers.remove(key);
    }
  };

  public static void add(BaseActivity activity, BasePresenter presenter) {
    Entry entry = registers.get(getKey(activity));
    if (entry == null) {
      entry = new Entry();
      registers.put(getKey(activity), entry);
    }
    entry.addPresenter(presenter);
  }

  private static String getKey(Activity activity) {
    if (activity instanceof BaseActivity) {
      return ((BaseActivity) activity).getKey();
    } else {
      return "";
    }
  }

  public static class Entry {
    public final Map<Integer, BasePresenter> presentersMap = new HashMap<>();

    public void addPresenter(BasePresenter presenter) {
      this.presentersMap.put(presenter.hashCode(), presenter);
    }

  }
}
