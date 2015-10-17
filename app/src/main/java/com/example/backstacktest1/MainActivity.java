package com.example.backstacktest1;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public abstract class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";
    List<ActivityManager.RunningTaskInfo> list;
    ActivityManager am;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());
    }

    @Override
    protected void onResume() {
        super.onResume();

        mTextView.setText("");
    }

    public void onInfoClick(View v) {
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        list = am.getRunningTasks(10);
        String msg = "";
        for (ActivityManager.RunningTaskInfo task : list) {
            if (task.baseActivity.flattenToShortString().startsWith("com.example.backstacktest1")) {
                msg += "---backstacktest1---" + "\n" +
                        "Count: " + task.numActivities + "\n" +
                        "Root: " + task.baseActivity.flattenToShortString() + "\n" +
                        "Top: " + task.topActivity.flattenToShortString() + "\n\n";
            }
            if (task.baseActivity.flattenToShortString().startsWith("com.example.backstacktest2")) {
                msg += "---backstacktest2---" + "\n" +
                        "Count: " + task.numActivities + "\n" +
                        "Root: " + task.baseActivity.flattenToShortString() + "\n" +
                        "Top: " + task.topActivity.flattenToShortString() + "\n\n";
            }
        }
        mTextView.setText(msg);
    }

    abstract public void onClick(View v);
}
