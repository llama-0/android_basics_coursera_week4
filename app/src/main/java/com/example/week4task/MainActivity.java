package com.example.week4task;

import androidx.fragment.app.Fragment;

public class MainActivity extends FragmentContainerActivity {
    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}