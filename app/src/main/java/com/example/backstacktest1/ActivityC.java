package com.example.backstacktest1;

import android.content.Intent;
import android.view.View;

/**
 * ActivityC
 */
public class ActivityC extends MainActivity {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ActivityD.class));
    }
}
