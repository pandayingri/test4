package com.example.star_.test3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


/**
 * Created by star_ on 2016-11-15.
 */
public class ButtonFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parents, final Bundle savedInstanceState) {
        FrameLayout container = (FrameLayout)inflater.inflate(R.layout.fragment_button,parents,false);
        Button button = (Button)container.findViewById(R.id.bt);

        button.setText(getArguments().getString("buttonText"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (getArguments().getString("buttonText")){
                    case "GAME START":

/*                        Dialog dev = new Dialog(getActivity());
                        dev.setContentView(R.layout.newgame);
                        dev.show();

                        Button nwb = (Button) dev.findViewById(R.id.newbt);
                        nwb.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View arg0) {
                        //Toast.makeText(GameStartActivity.this, "fuck you", Toast.LENGTH_SHORT).show();
                        final Dialog dialog = new Dialog(getActivity());
                        dialog.setContentView(R.layout.auto_text);

                        Button dialogButton = (Button) dialog.findViewById(R.id.newbt2);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }

                        });*/

                        Intent toy = new Intent(getActivity(), GameStartActivity.class);

                        startActivity(toy);
                        getActivity().overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
                        break;
                    case "개발자 옵션":

                        Intent tt = new Intent(getActivity(), ListviewActivity.class);
                        startActivity(tt);

                        //Dialog dev1 = new Dialog(getActivity());
                        //dev1.setTitle("개발자들 ㅎ");
                        //dev1.setContentView(R.layout.practice);
                        //dev1.show();
                        break;
                    case "끝내기":
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle(R.string.quit_dlg_confirmation_title);
                        builder.setMessage(R.string.quit_dlg_confirmation_msg);
                        builder.setNegativeButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                getActivity().finish();

                            }
                        });
                        builder.setPositiveButton(android.R.string.no, null);
                        builder.show();
                        break;
                }
            }
        });
        return container;
    }
}
