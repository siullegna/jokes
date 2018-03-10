package com.hap.jokes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.hap.jokes.service.EndpointsAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AdView mAdView = findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    public void onClick(View view) {
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

//        final Intent intent = new Intent(this, JokeActivity.class);
//        final Bundle args = new Bundle();
//        args.putString(JokeActivity.JOKE_ARG_KEY, JokesApiProvider.someJoke());
//        intent.putExtras(args);
//        startActivity(intent);
    }
}
