package org.sescandell.galleryproject.app;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import org.sescandell.galleryproject.Cache.BitmapLruCache;

public class Application extends android.app.Application {

    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        initVolley();
    }

    @Override
    public void onTerminate() {
        requestQueue.stop();
        super.onTerminate();
    }

    private void initVolley() {
        requestQueue = Volley.newRequestQueue(this);
        int memClass = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();

        int cacheSize = 1024 * 1024 * memClass / 8;
        imageLoader = new ImageLoader(requestQueue, new BitmapLruCache(cacheSize));
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
