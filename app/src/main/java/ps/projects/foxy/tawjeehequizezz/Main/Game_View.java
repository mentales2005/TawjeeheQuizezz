package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ps.projects.foxy.tawjeehequizezz.Objects.Data_Handle;
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
    TextView timer;
    int count=0;
    int limit=0;
    ArrayList<String> listQuestionShuffled=new ArrayList<String>();
    ArrayList<String> listAnswerShuffled=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__view);
        String unit=getIntent().getStringExtra("unit");
        String part=getIntent().getStringExtra("part");

        tx=findViewById(R.id.name);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        timer=findViewById(R.id.timer);

        handle=new Data_Handle();
        question=handle.getQuestion(part,unit,Game_View.this);

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

        //Toast.makeText(Game_View.this,question.get("Q1").getName(),Toast.LENGTH_SHORT).show();

       setTimer(10000,1000);



    }
    public void setButtons(){
        tx.setText(question.get(listQuestionShuffled.get(count)).getName());
        btn1.setText(listAnswerShuffled.get(0));
        btn2.setText(listAnswerShuffled.get(1));
        btn3.setText(listAnswerShuffled.get(2));
        btn4.setText(listAnswerShuffled.get(3));
    }

    public void setTimer(int miliscond, final int interval){
        new CountDownTimer(miliscond,interval){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/interval));
            }

            @Override
            public void onFinish() {
                if (count != listQuestionShuffled.size() - 1) {
                    count++;
                    listAnswerShuffled = handle.AnswerShuffled(question, listQuestionShuffled, count);
                    setButtons();
                    this.start();
                }else{
                    questionFinished();
                }
            }
        }.start();


    }


    public void checkAnswer(Button button){


        if(!button.getText().toString().isEmpty() && button.getText().toString() != null) {

            if (count != listQuestionShuffled.size() - 1) {

                if (button.getText().toString() == question.get(listQuestionShuffled.get(count)).getCorrect().toString()) {
                    count++;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            listAnswerShuffled = handle.AnswerShuffled(question,listQuestionShuffled,count);
                            setButtons();
                        }
                    },500);

                } else {
                    if(limit==0){
                        Toast.makeText(Game_View.this,"فكر مجددا",Toast.LENGTH_SHORT).show();
                        limit=1;
                    }else{
                        theCorrectAnswer();
                        limit=0;
                    }

                }
            } else if (button.getText().toString() == question.get(listQuestionShuffled.get(count)).getCorrect().toString()) {
                if(limit==0){
                    Toast.makeText(Game_View.this,"فكر مجددا",Toast.LENGTH_SHORT).show();
                    limit=1;
                }else{
                    questionFinished();
                    limit=0;
                }

            } else {

                if(limit==0){
                    Toast.makeText(Game_View.this,"فكر مجددا",Toast.LENGTH_SHORT).show();
                    limit=1;
                }else{
                    theCorrectAnswer();
                    limit=0;
                }

            }
        } else{
            Toast.makeText(Game_View.this,"انتظر لو سمحت", Toast.LENGTH_LONG).show();
        }
    }


    public void theCorrectAnswer(){
        AlertDialog.Builder builder=new AlertDialog.Builder(Game_View.this).setMessage(question.get(listQuestionShuffled.get(count)).getCorrect().toString()).setTitle("الاجابة الصحيحة هي :  ")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (count != listQuestionShuffled.size() - 1){
                            count++;
                        listAnswerShuffled = handle.AnswerShuffled(question,listQuestionShuffled,count);
                        setButtons();
                        }else{
                            questionFinished();

                        }
                    }
                });
        builder.create().show();


    }

    public void questionFinished() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Game_View.this).setMessage("انتهت اللعبة").setTitle(R.string.finish)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new Intent(Game_View.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        builder.create().show();

    }



}
