package com.example.star_.test3;

 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.WindowManager;
 import android.widget.ListView;
 import java.util.ArrayList;


public class ListviewActivity extends AppCompatActivity {

         @Override
         protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
                 setContentView(R.layout.activity_list);

                 ListView listView=(ListView)findViewById(R.id.listview);

                 ArrayList<Listviewitem> data=new ArrayList<>();
                 Listviewitem lhs=new Listviewitem(R.drawable.person1,"임형석 010-7689-9949");
                 Listviewitem koj=new Listviewitem(R.drawable.person2,"권오준 010-4139-2293");
                 Listviewitem lwj=new Listviewitem(R.drawable.person3,"이원준 010-3376-7534");
                 Listviewitem smh=new Listviewitem(R.drawable.person4,"송명호 010-2016-2689");

                 data.add(lhs);
                 data.add(koj);
                 data.add(lwj);
                 data.add(smh);

                 ListviewAdapter adapter=new ListviewAdapter(this,R.layout.item,data);
                 listView.setAdapter(adapter);
             }
         }
