package com.java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.java.java20170910.Java20170910Activity;

/**
 * Java学习日记
 */
public class MainActivity extends AppCompatActivity {

    // Java设计模式
    AppCompatButton btn20170910;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        findViewById(R.id.btn_20170910).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Java20170910Activity.class));
            }
        });


    }
}
