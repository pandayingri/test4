package com.example.star_.test3;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;


/**
 * Created by star_ on 2016-11-07.
 */

public class NewgameActivity extends AppCompatActivity {

    int nowText = -1;
    int a=0;
    String myText[]={"--- 거리근처 ---","[ 병 사1] : 꼬맹이 놈이 어디갔지?","[ 병 사2] : 내가 저쪽을 찾아보지! 넌 저쪽을 찾아봐","(아텐은 숨죽인 채 술통 속에 숨어있다.)","[ 고 문 관 ] : (술통을 열며) 요 쥐새끼 같은 놈!" };
    int textNow = myText.length;    // 텍스트갯수





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.prison);


        ImageButton swordbt = (ImageButton)findViewById(R.id.swordBt);
        final TextSwitcher text = (TextSwitcher) findViewById(R.id.textSwitcher);


        text.setFactory(new ViewSwitcher.ViewFactory()  {

            public View makeView()  {
                TextView myText = new TextView(NewgameActivity.this);
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
                if(a== textNow){
                    //setContentView(R.layout.auto_text);
                    Intent nxt = new Intent(NewgameActivity.this,TutorialActivity.class);

                    startActivity(nxt);
                }


                text.setText(myText[nowText]);
            }
        });


    }

    @Override
    public void onBackPressed() {


        Dialog dev = new Dialog(NewgameActivity.this);
        dev.setContentView(R.layout.backoption);
        dev.show();


    }
}
