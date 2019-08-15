package ps.projects.foxy.tawjeehequizezz.Objects;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.HashMap;

import ps.projects.foxy.tawjeehequizezz.Main.Game_View;
import ps.projects.foxy.tawjeehequizezz.Main.MainActivity;
import ps.projects.foxy.tawjeehequizezz.Main.QuestionHistory;
import ps.projects.foxy.tawjeehequizezz.Main.Units;
import ps.projects.foxy.tawjeehequizezz.R;

public class DialogClass {


    public void showDialog(final Activity activity, final ArrayList<String> list_question, final ArrayList<String> list_answers, final String part){
             Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog);

            Button restart=dialog.findViewById(R.id.again);
            final Button history=dialog.findViewById(R.id.history);
            Button  main=dialog.findViewById(R.id.main_menu);

            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(activity, Units.class);
                    intent.putExtra("part",part);
                    activity.startActivity(intent);
                    activity.finish();

                }
            });


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, QuestionHistory.class);
                intent.putExtra("his_ques",list_question);
                intent.putExtra("his_answ",list_answers);
                activity.startActivity(intent);
                activity.finish();

            }
        });


        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        });


            dialog.show();

        }

    }



