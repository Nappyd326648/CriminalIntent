package com.eugenestewart.criminalintent;

import android.app.Fragment;

/**
 * Created by nappy on 9/24/2016.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
