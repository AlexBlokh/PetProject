package io.petproject.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * @author aleksandrblokh@gmail.com (Alex Blokh, 4/16/16).
 */
public class BaseActivity extends AppCompatActivity {

    public static final String REGISTRY_KEY = "registry_key";
    private String uniqueKey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            uniqueKey = UUID.randomUUID().toString();
        } else {
            uniqueKey = savedInstanceState.getString(REGISTRY_KEY);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(REGISTRY_KEY, uniqueKey);
    }

    public String getKey() {
        return uniqueKey;
    }
}
