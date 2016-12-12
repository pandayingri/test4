package com.example.star_.test3;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;

import static com.example.star_.test3.R.id.optionbt;


public class GameStartActivity extends AppCompatActivity {

    //add text here!

    int nowText = -1;
    int a=0;
    String myText[]={"[ 엄 마 ] : 아텐! 어디 있니? 아텐! ","[ 아 텐 ] : 엄마?! 무슨 일이에요? ","[ 엄 마 ] : 지금 설명할 시간이 없어! 빨리 도망치자","[ 아 텐 ] : 엄마! 그게 무슨 소리에요?? 아빠는요?","[ 엄 마 ] : 시간 없어! 빨리"};
    int textNow = myText.length;    // 텍스트갯수

    private SeekBar volumeSeekBar;
    private AudioManager audioManager;
    FrameLayout container;
    ImageView disp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_start);

        container = (FrameLayout)findViewById(R.id.container);
           setVolumeControlStream(AudioManager.STREAM_MUSIC);

        ImageButton swordbt = (ImageButton)findViewById(R.id.swordBt);
        final TextSwitcher text = (TextSwitcher) findViewById(R.id.textSwitcher);

        disp = (ImageView) findViewById(R.id.imageView2);


        text.setFactory(new ViewSwitcher.ViewFactory()  {

            public View makeView()  {
                TextView myText = new TextView(GameStartActivity.this);
                myText.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(34);
                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

        // 버튼 누를시 텍스트 바뀜

            swordbt.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    nowText++;
                    a++;    // you can add separate button for previous also just use nowPrevi--;
                    if(a== 7){

                        disp.setImageResource(R.drawable.main1);
                        disp.setVisibility(View.INVISIBLE);
                        text.setText(myText[nowText]);

                   }
                   else if(a==textNow) {
                        Intent nxt = new Intent(GameStartActivity.this,StoryActivity.class);
                        startActivity(nxt);
                        GameStartActivity.this.overridePendingTransition(R.anim.fade_in,R.anim.fade_in);
                    }
                   else {
                        text.setText(myText[nowText]);
                    }
                }
        });


    }

    private void initControls(View view) {

            try {
                volumeSeekBar = (SeekBar)view.findViewById(R.id.sb);
                audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                volumeSeekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }   catch (Exception e) {


            }

    }

    @Override
    public void onBackPressed() {

        Dialog dev = new Dialog(GameStartActivity.this);
        dev.setContentView(R.layout.backoption);

        Button btn1 = (Button) dev.findViewById(R.id.continue1);
        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {


                finish();
            }

        });





        Button btn2 = (Button) dev.findViewById(R.id.savefile);
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Toast.makeText(GameStartActivity.this, "fuck you", Toast.LENGTH_SHORT).show();

               /* final Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.savespace);
                dialog.setTitle("저장목록");

                Button dialogButton = (Button) dialog.findViewById(R.id.bbtt);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            */}

        });


        Button btn3 = (Button) dev.findViewById(optionbt);
        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //수행할 기능소스

                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.volume,null);
                container.addView(view);
                initControls(view);

            }

        });

        Button btn4 = (Button) dev.findViewById(R.id.exitbt);
        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.e("","hjhjhjhjh");
                AlertDialog.Builder builder = new AlertDialog.Builder(GameStartActivity.this);
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

        });

        dev.show();

    }
}
