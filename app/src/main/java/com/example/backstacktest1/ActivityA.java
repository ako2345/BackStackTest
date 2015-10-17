package com.example.backstacktest1;

import android.content.Intent;
import android.view.View;

/**
 * ActivityA
 */
public class ActivityA extends MainActivity {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ActivityB.class));
    }
}
