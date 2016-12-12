 package com.example.star_.test3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
   ViewPager viewPager;

    final int MAX_BUTTON = 3;
    private GoogleApiClient client;

    public void init() {

        viewPager = (ViewPager)findViewById(R.id.viewPager);


        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bgmsound);
        mediaPlayer.start();


        init();
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {

        Builder builder = new Builder(MainActivity.this);
        builder.setTitle(R.string.quit_dlg_confirmation_title);
        builder.setMessage(R.string.quit_dlg_confirmation_msg);
        builder.setNegativeButton(android.R.string.yes, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();

            }
        });
        builder.setPositiveButton(android.R.string.no, null);
        builder.show();

    }


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class MainViewPagerAdapter extends FragmentPagerAdapter {
        public MainViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if(position<0 || MAX_BUTTON<=position)
                return null;
            else {
                ButtonFragment buttonFragment = new ButtonFragment();
                Bundle bundle = new Bundle();
                switch (position){
                    case 0:
                        bundle.putString("buttonText","GAME START");
                        break;
                    case 1:
                        bundle.putString("buttonText","개발자 옵션");
                        break;
                    case 2:
                        bundle.putString("buttonText","끝내기");
                        break;
                }
                buttonFragment.setArguments(bundle);
                return buttonFragment;
            }
        }

        @Override
        public int getCount() {
            return MAX_BUTTON;
        }
    }

}
