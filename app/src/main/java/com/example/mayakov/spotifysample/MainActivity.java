package com.example.mayakov.spotifysample;

import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static MainActivity instance;

    public static MainActivity  getInstance()
    {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;
        TextView tv = (TextView) findViewById(R.id.txt);
        tv.setText("Hello");
    }

    public void updatePhoneNumberTextView(final String phoneNumber) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView phone = (TextView) findViewById(R.id.txt);
                phone.setText(phoneNumber);
            }
        });
    }

    public void updateSpotifyData(final String trackId, final String artistName, final String  albumName, final String trackName) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView trackid = (TextView) findViewById(R.id.trackId);
                TextView artist = (TextView) findViewById(R.id.artistName);
                TextView albom = (TextView) findViewById(R.id.albumName);
                TextView track = (TextView) findViewById(R.id.trackName);

                trackid.setText(trackId);
                artist.setText(artistName);
                albom.setText(albumName);
                track.setText(trackName);
            }
        });
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
