package com.example.nick.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.mybtn);
        final TextView textView = (TextView)findViewById(R.id.textView);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText("This is a string");
                        SetImage();
                    }
                }
        );
    }

    private void SetImage() {
        GifImageView imgView = (GifImageView)findViewById(R.id.imageView);

        /*Random rand = new Random();
        ArrayList urls = new ArrayList();
        urls.add("http://photos.francisfrith.com/frith/borehamwood-leeming-road-shopping-parade-c1965_b408040.jpg");
        urls.add("http://photos.francisfrith.com/frith/borehamwood-st-michael-s-church-c1965_b408035.jpg");
        urls.add("http://www.mariowiki.com/images/d/d9/MarioNSMBWii.PNG");
        urls.add("http://fc06.deviantart.net/fs70/f/2012/013/0/5/classic_sonic_the_hedgehog_by_advert_man-d4m94sf.jpg");
        urls.add("http://img1.wikia.nocookie.net/__cb20090911045127/sonic/images/a/ae/Robotnik_fat_fat_fat.png");
        urls.add("http://vignette2.wikia.nocookie.net/southpark/images/a/a4/NotWithoutMyAnus2.jpg/revision/latest?cb=20110124030413");

        int selection = rand.nextInt(urls.size());

        new RetrieveImageTask(imgView)
                .execute((String) urls.get(selection));*/

        String url = "http://www.gifbase.com/tag/smile?format=json";

        new RetrieveJsonTask(imgView).execute(url);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
