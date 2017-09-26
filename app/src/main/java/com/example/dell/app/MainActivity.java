package com.example.dell.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private Button btn_broadcast;
    private Button btn_version;
    private Button btn_feedback;
    private Button btn_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_broadcast = (Button)findViewById(R.id.broadcast);
        btn_broadcast.setOnClickListener(this);
        btn_version = (Button)findViewById(R.id.query_version);
        btn_version.setOnClickListener(this);
        btn_history = (Button)findViewById(R.id.history);
        btn_history.setOnClickListener(this);
        btn_feedback = (Button)findViewById(R.id.feedback);
        btn_feedback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.broadcast:
                intent = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent);
                break;
            case R.id.feedback:
                intent = new Intent(MainActivity.this, FeedbackActivity.class);
                startActivity(intent);
                break;
            case  R.id.history:
                break;
            case R.id.query_version:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
