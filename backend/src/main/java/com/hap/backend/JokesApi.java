package com.hap.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.hap.jokes_provider.JokesGenerator;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.hap.com",
                ownerName = "backend.hap.com",
                packagePath = ""
        )
)
public class JokesApi {
    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "tellAJoke")
    public MyJoke tellAJoke() {
        final MyJoke response = new MyJoke();
        response.setData(JokesGenerator.getJoke().toString());
        return response;
    }
}