package com.example.nick.myapplication;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Nick on 18/07/2015.
 */
public class RetrieveGifTask extends AsyncTask<String, Void, byte[]> {
    private static final String TAG = "GifDataDownloader";

    public RetrieveGifTask() {
    }

    protected byte[] doInBackground(final String... params) {
        final String gifUrl = params[0];

        if (gifUrl == null)
            return null;

        byte[] gif = null;
        try {
            gif = ByteArrayHttpClient.get(gifUrl);
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "GifDecode OOM: " + gifUrl, e);
        }

        return gif;
    }
}
