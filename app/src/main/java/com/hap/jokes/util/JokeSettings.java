package com.hap.jokes.util;

import com.hap.jokes.BuildConfig;

import java.util.Locale;

/**
 * Created by luis on 3/3/18.
 */

public class JokeSettings {
    private static final String JOKE_PATH = "_ah/api/";

    private static String getBaseUrl() {
        return String.format(Locale.US, "http://%s", BuildConfig.IP_ADDRESS);
    }

    public static String getJokeUrl() {
        return String.format(Locale.US, "%s/%s", getBaseUrl(), JOKE_PATH);
    }
}
