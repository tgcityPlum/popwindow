package com.eagersoft.youzy.popwindowdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void jumpPopActivity(View view) {
        startActivity(new Intent(IndexActivity.this,MainActivity.class));
    }

}
