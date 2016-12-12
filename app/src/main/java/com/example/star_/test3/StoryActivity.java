package com.example.star_.test3;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;

import static com.example.star_.test3.R.id.optionbt;


/**
 * Created by star_ on 2016-11-07.
 */

public class StoryActivity extends AppCompatActivity {

     int nowText = -1;
     int a=0;
     String myText[]={"[ 경비대장 ] : 반드시 잡아야 한다. 반드시! ","[ 병 사 ] : 넵! ","( 우르르르르르르르 )","[ 엄 마 ] : 아텐! 엄마가 시간을 끌테니 어서 도망쳐","[ 아 텐 ] : 안돼! 같이 도망치면 붙잡힐 거야. 빠져나가면 리온을 꼭 찾아가!",
             " [ 아 텐] : 리온?? ","[ 엄 마 ] : 이걸 꼭 건네줘.","(엄마가 열쇠를 건넨다........)",
             "[ 아 텐 ] : 엄마 ㅠㅠㅠㅠㅠ"," [ 엄 마 ] : 그리고 우리가 자주 가던 평지에...",
             "[ 병 사1 ] : 찾았다! 저기 있다! 잡아!","(엄마는 아텐을 밀치고 병사에게 뛰어든다. 병사에게 찔려서 죽어가는 엄마. 죽어가는 몸으로 병사를 막아선다.","[ 아 텐 ] : 엄마!!!!","(아텐은 병사에게 분노하지만 이미 늦었다는 걸 깨닫고 전력으로 도망친다." };
     int textNow = myText.length;    // 텍스트갯수





     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
         setContentView(R.layout.story);


         ImageButton swordbt = (ImageButton)findViewById(R.id.swordBt);
         final TextSwitcher text = (TextSwitcher) findViewById(R.id.textSwitcher);


         text.setFactory(new ViewSwitcher.ViewFactory()  {

             public View makeView()  {
                 TextView myText = new TextView(StoryActivity.this);
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
                     Intent nxt2 = new Intent(StoryActivity.this,NewgameActivity.class);

                     startActivity(nxt2);
                 }


                 text.setText(myText[nowText]);
             }
         });


     }

    @Override
    public void onBackPressed() {

        Dialog dev = new Dialog(StoryActivity.this);
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
                Toast.makeText(StoryActivity.this, "fuck you", Toast.LENGTH_SHORT).show();

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


            }

        });

        Button btn4 = (Button) dev.findViewById(R.id.exitbt);
        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.e("","hjhjhjhjh");
                AlertDialog.Builder builder = new AlertDialog.Builder(StoryActivity.this);
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
