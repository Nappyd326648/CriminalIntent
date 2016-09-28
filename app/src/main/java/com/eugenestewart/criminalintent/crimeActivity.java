package com.eugenestewart.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;


import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    public static final  String EXTRA_Crime_ID= "com";

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_Crime_ID,crimeId);
        return intent;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//        FragmentManager fm = getSupportFragmentManager();
//
//        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//        if (fragment == null){
//            fragment = new CrimeFragment();
//            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
//        }
//    }
    @Override
    protected Fragment createFragment(){
        UUID crimeID=(UUID) getIntent().getSerializableExtra(EXTRA_Crime_ID);
        return CrimeFragment.newInstance(crimeID);
    }
}
