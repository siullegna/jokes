package com.hap.jokes.free;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by luis on 3/10/18.
 */

public class Config {
    public static void setupAd(final AppCompatActivity activity) {
        Log.d(Config.class.getName(), "paid version, ad not available");
    }
}
