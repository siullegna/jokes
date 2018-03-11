package com.hap.jokes.service;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.hap.backend.myApi.MyApi;

import java.io.IOException;

import static com.hap.jokes.util.JokeSettings.getJokeUrl;

/**
 * Created by luis on 3/3/18.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private final OnTaskCompleteListener onTaskCompleteListener;

    public EndpointsAsyncTask(OnTaskCompleteListener onTaskCompleteListener) {
        this.onTaskCompleteListener = onTaskCompleteListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(getJokeUrl())
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e("", result);
        if (onTaskCompleteListener != null) {
            onTaskCompleteListener.onComplete(result);
        }
    }

    public interface OnTaskCompleteListener {
        void onComplete(final String result);
    }
}
