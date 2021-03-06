package com.hap.jokeui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by luis on 2/23/18.
 */

public class JokeActivity extends AppCompatActivity {
    private static final String TAG = JokeActivity.class.getName();
    public static final String JOKE_ARG_KEY = TAG + ".JOKE_ARG_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        final TextView jokeView = findViewById(R.id.joke);
        final Bundle args = getIntent().getExtras();
        if (args != null) {
            final String joke = args.getString(JOKE_ARG_KEY);
            jokeView.setText(joke);
        } else {
            jokeView.setText(R.string.error);
        }
    }
}
