package com.hap.jokes;

import android.support.test.runner.AndroidJUnit4;

import com.hap.jokes.service.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.OnTaskCompleteListener() {
            @Override
            public void onComplete(String result) {
                assertNotNull(result);
            }
        });
        endpointsAsyncTask.execute();
    }
}