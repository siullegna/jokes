package com.hap.jokes.util;

import java.util.Locale;

/**
 * Created by luis on 3/3/18.
 */

public class JokeSettings {
    private static final String BASE_URL = "http://10.0.2.2:8080";
//    private static final String BASE_URL = "http://192.168.0.26:8080";
    private static final String JOKE_PATH = "_ah/api/";

    public static String getJokeUrl() {
        return String.format(Locale.US, "%s/%s", BASE_URL, JOKE_PATH);
    }
}
