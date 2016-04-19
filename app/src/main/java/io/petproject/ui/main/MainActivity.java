package io.petproject.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import io.petproject.PetProjectApplication;
import io.petproject.R;
import io.petproject.base.RootViewWrapper;
import io.petproject.base.mvp.BaseActivity;

public class MainActivity extends BaseActivity {

    @Inject RootViewWrapper rootViewWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PetProjectApplication.with(this).getAppComponent().inject(this);

        rootViewWrapper.wrap(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.content, MainFragment.newInstance())
                                       .commit();
        }
    }
}
