package com.hap.jokes.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hap.jokes.R;
import com.hap.jokes.free.Config;
import com.hap.jokes.service.EndpointsAsyncTask;
import com.hap.jokeui.JokeActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.OnTaskCompleteListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Config.setupAd(this);
    }

    public void onClick(View view) {
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onComplete(String result) {
        final Intent intent = new Intent(this, JokeActivity.class);
        final Bundle args = new Bundle();
        args.putString(JokeActivity.JOKE_ARG_KEY, result);
        intent.putExtras(args);
        startActivity(intent);
    }
}
