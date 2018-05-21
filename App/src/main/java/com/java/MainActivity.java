package com.java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.java.javadesignpatterns.JavaDesignPatternsActivity;
import com.java.javasynchronized.JavaSynchronizedActivity;

import me.logg.Logg;
import me.logg.config.LoggConfiguration;

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

        LoggConfiguration configuration = new LoggConfiguration.Buidler()
                .setDebug(true)
                .build();
        Logg.init(configuration);

        init();
    }

    private void init() {
        findViewById(R.id.btn_DesignPatterns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, JavaDesignPatternsActivity.class));
            }
        });
        findViewById(R.id.btn_Synchronized).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, JavaSynchronizedActivity.class));
            }
        });

    }
}
