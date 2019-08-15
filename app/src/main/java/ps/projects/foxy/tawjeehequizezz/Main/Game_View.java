package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ps.projects.foxy.tawjeehequizezz.Objects.Data_Handle;
import ps.projects.foxy.tawjeehequizezz.Objects.DialogClass;
import ps.projects.foxy.tawjeehequizezz.Objects.Game_Question;
import ps.projects.foxy.tawjeehequizezz.R;

public class Game_View extends AppCompatActivity {

    Data_Handle handle;
    HashMap<String, Game_Question> question;
    TextView tx;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView po;
    TextView timer;
    TextView title;
    int count=0;
    int limit=0;
    int point=0;
    String part;
    String unit;
    ArrayList<String> listQuestionShuffled=new ArrayList<String>();
    ArrayList<String> listAnswerShuffled=new ArrayList<String>();
    ArrayList<String> list_question =new ArrayList<String>();
    ArrayList<String> list_answers =new ArrayList<String>();
    CountDownTimer MyTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__view);
        unit=getIntent().getStringExtra("unit");
        part=getIntent().getStringExtra("part");

        tx=findViewById(R.id.name);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        timer=findViewById(R.id.timer);
        po=findViewById(R.id.points);
        title=findViewById(R.id.lecture);

        handle=new Data_Handle();
        question=handle.getQuestion(part,unit,Game_View.this);

        title.setText(unit);
        Typeface typeface = ResourcesCompat.getFont(Game_View.this, R.font.aldhabi);
        title.setTypeface(typeface);

        listQuestionShuffled = handle.listQuestionShuffled(question);
        listAnswerShuffled = handle.AnswerShuffled(question,listQuestionShuffled,count);
        setButtons();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn1);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn2);

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn3);

            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn4);

            }
        });


      //setTimer(0,1);



    }
    public void setButtons(){
        tx.setText(question.get(listQuestionShuffled.get(count)).getName());
        btn1.setText(listAnswerShuffled.get(0));
        btn2.setText(listAnswerShuffled.get(1));
        btn3.setText(listAnswerShuffled.get(2));
        btn4.setText(listAnswerShuffled.get(3));
    }

    /*
    public void setTimer(final int miliscond, final int interval){
      MyTimer= new CountDownTimer(miliscond,interval){

            @Override
            public void onTick(long l) {
                int min=0;
                int second=0;
                if(l/60==1){
                    min=min+1;
                    l=0;
                    timer.setText(min+":"+second+(miliscond+interval)+"ث");
                }else if(l>9){
                    second=second+1;
                    l=0;
                    timer.setText(min+":"+second+(miliscond+interval)+"ث");
                }else
                {
                    timer.setText(min+":"+second+(miliscond+interval)+"ث");
                }

            }

            @Override
            public void onFinish() {
                /*
                if (count != listQuestionShuffled.size() - 1) {
                    imageView.setImageDrawable(null);
                    count++;
                    limit=0;
                    listAnswerShuffled = handle.AnswerShuffled(question, listQuestionShuffled, count);
                    setButtons();
                    this.cancel();
                    this.start();
                }else{
                    this.cancel();
                    questionFinished();
                }

            }
        }.start();


    }
 */

    public void checkAnswer(final Button button){


        if(!button.getText().toString().isEmpty() && button.getText().toString() != null) {

            if (count != listQuestionShuffled.size() - 1) {

                if (button.getText().toString() == question.get(listQuestionShuffled.get(count)).getCorrect().toString()) {
                    Toast(true);
                    count++;
                    point=point+6;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            po.setText(String.valueOf(point));
                            listAnswerShuffled = handle.AnswerShuffled(question,listQuestionShuffled,count);
                            setButtons();
                            limit=0;
                           // MyTimer.cancel();
                          //  setTimer(10000,1000);
                        }
                    },800);

                } else {
                    Toast(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(limit==0){
                           Toast toast= Toast.makeText(Game_View.this,"فكر مجددا",Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                                limit=1;
                            }else{
                                theCorrectAnswer();
                                limit=0;
                            }

                        }
                    },800);


                }
            } else if (button.getText().toString() == question.get(listQuestionShuffled.get(count)).getCorrect().toString()) {

                Toast(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        questionFinished();
                    }
                },800);

            } else {
                Toast(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(limit==0){
                            Toast toast= Toast.makeText(Game_View.this,"فكر مجددا",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            limit=1;
                        }else{
                            theCorrectAnswer();
                            limit=0;
                        }
                    }
                },800);

            }
        } else{
            Toast.makeText(Game_View.this,"انتظر لو سمحت", Toast.LENGTH_LONG).show();
        }
    }


    public void theCorrectAnswer(){

        final Dialog dialog=new Dialog(Game_View.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.correct_answer_dialog);


        TextView correct=dialog.findViewById(R.id.correct_text);
        Button done=dialog.findViewById(R.id.done_button);


        correct.setText("الاجابة الصحيحة هي : "+"\n"+question.get(listQuestionShuffled.get(count)).getCorrect());
        list_question.add(question.get(listQuestionShuffled.get(count)).getName());
        list_answers.add(question.get(listQuestionShuffled.get(count)).getCorrect());



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count != listQuestionShuffled.size() - 1){
                    count++;
                    listAnswerShuffled = handle.AnswerShuffled(question,listQuestionShuffled,count);
                    setButtons();
                    limit=0;
                    // MyTimer.cancel();
                    // setTimer(10000,1000);
                }else{
                    questionFinished();

                }

                dialog.dismiss();
            }
        });

        dialog.show();


    }



    public void questionFinished() {
        DialogClass dialogClass=new DialogClass();
        dialogClass.showDialog(Game_View.this,list_question,list_answers,part);


    }

    public void Toast(boolean flag){
        Toast toast = new Toast(Game_View.this);
        ImageView view = new ImageView(Game_View.this);
        if(flag == true){
            view.setImageResource(R.drawable.ic_check);
        }else{
            view.setImageResource(R.drawable.ic_remove);
        }
       // toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();

    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(Game_View.this,Units.class);
        intent.putExtra("part",part);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
