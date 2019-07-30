package com.mf.pradeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class thread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);

                } catch (Exception e) {

                } finally {

                    startActivity(new Intent(thread.this,
                            MainActivity.class));
                    finish();
                }
            };
        };
        splashTread.start();

    }

}
