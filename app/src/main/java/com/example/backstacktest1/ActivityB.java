package com.example.backstacktest1;

import android.content.Intent;
import android.view.View;

/**
 * ActivityB
 */
public class ActivityB extends MainActivity {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ActivityC.class));
    }
}
