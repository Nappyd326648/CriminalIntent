package com.eugenestewart.criminalintent;

import java.util.UUID;

/**
 * Created by nappy on 9/23/2016.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private boolean mSolved;


    public Crime(){
        mId=UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String title) {
        mTitle = title;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
