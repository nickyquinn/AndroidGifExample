package com.example.nick.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nick on 18/07/2015.
 */
public class RetrieveJsonTask extends AsyncTask<String, Void, GifTag> {
    private Exception exception;
    HttpURLConnection c = null;
    GifImageView bmImage;

    public RetrieveJsonTask(GifImageView retImg) {
        this.bmImage = retImg;
    }

    protected GifTag doInBackground(String... src) {
        try {
            URL url = new URL(src[0]);
            c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(2000);
            c.setReadTimeout(2000);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    GifTag msg = new Gson().fromJson(sb.toString(), GifTag.class);
                    return msg;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    protected void onPostExecute(GifTag result) {
        int count = result.getGifs().size();
        Random rand = new Random();
        int selection = rand.nextInt(count);
        String imageUrl = result.getGifs().get(selection).getUrl();

        //new RetrieveImageTask(bmImage).execute(imageUrl);

        new RetrieveGifTask() {
            protected void onPostExecute(final byte[] bytes) {
                bmImage.setBytes(bytes);
                bmImage.startAnimation();
            }
        }.execute(imageUrl);
    }
}
